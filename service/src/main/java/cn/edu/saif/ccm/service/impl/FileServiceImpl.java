package cn.edu.saif.ccm.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.ResultSet;  
import java.sql.ResultSetMetaData;  
import java.sql.SQLException;  
import java.util.ArrayList;
import java.util.Date;
import java.util.List;  
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;  

import cn.edu.saif.ccm.service.FileService;
import cn.edu.saif.shared.common.BaseException;
import cn.edu.saif.shared.common.Constants;
import cn.edu.saif.shared.common.ExportDTO;
import cn.edu.saif.shared.query.DataField;
import cn.edu.saif.shared.query.QueryMeta;
import cn.edu.saif.shared.utils.DataUpdateUtils;
import cn.edu.saif.shared.utils.HqlUitls;
import cn.edu.saif.shared.utils.StringUtils;

/** 
 * 用于excel大数据量导出 
 *  
 * @author lisen 
 * @date 2013-10-30 上午10:41:36 
 */  
@Service
public class FileServiceImpl extends AbstractFileService implements FileService {  
	
	@Autowired
	private JdbcTemplate jdbcTemplate;  
	
	@Override
	public String getCodeByFile(MultipartFile codeFile) {
		String contentType=codeFile.getContentType();
		String code="";
		try {
			if("text/plain".equals(contentType)){
				code=getCodeByTxt(codeFile.getInputStream());
			}else if("application/vnd.ms-excel".equals(contentType)){
				code=getCodeByExcel(codeFile.getInputStream());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{\"codeList\":\""+code+"\"}";
	}
	
	@Override  
    public ExportDTO exportToFile(final QueryMeta meta,Class<?> clazz) {  
		ExportDTO result=new ExportDTO();
		result.setClazz(clazz);
		result.setTime(new Date());
		Long start=System.currentTimeMillis();
		File home=new File(Constants.HOME_PATH);
		if(!home.exists()){
			home.mkdirs();
		}
		String fileType=meta.getFileType();
		try{
			switch(fileType){
			case "excel":
				exportToExcel(meta,clazz,result);
				break;
			case "txt":
				exportToTxt(meta,clazz,result);
				break;
			case "csv":
				exportToCsv(meta,clazz,result);
				break;
			}
			result.setCode("success");
		}catch(Exception e){
			result.setCode("fail");
			result.setMsg(e.getMessage());
		}
		Long end=System.currentTimeMillis();
		result.setRunTime(end-start);
		return result;
    }  
 
    protected void writeOneRowXml(ResultSet rs, FileOutputStream fos)  
            throws SQLException, IOException {  
        // 获取metaData;  
        ResultSetMetaData rsmd = rs.getMetaData();  
        int columnCount = rsmd.getColumnCount();  
        writeToOutputStream("<Row>\r\n", fos);  
        for (int i = 1; i <= columnCount; i++) {  
            // String key = getColumnKey(rsmd.getColumnName(i));  
            Object obj = getColumnValue(rs, i);  
            writeToOutputStream("<Cell><Data ss:Type=\"String\">"  
                    + HtmlUtils.htmlEscape(obj == null ? "" : obj.toString())  
                    + "</Data></Cell>\r\n", fos);  
        }  
        writeToOutputStream("</Row>\r\n", fos);  
    }
    
    protected void writeOneRowExcel(ResultSet rs, FileOutputStream fos)  
            throws SQLException, IOException {  
        // 获取metaData;  
        ResultSetMetaData rsmd = rs.getMetaData();  
        int columnCount = rsmd.getColumnCount();  
        writeToOutputStream("<Row>\r\n", fos);  
        for (int i = 1; i <= columnCount; i++) {  
            // String key = getColumnKey(rsmd.getColumnName(i));  
            Object obj = getColumnValue(rs, i);
            String value="";
            if(obj != null){
	            if(obj instanceof BigDecimal){
	            	BigDecimal big=(BigDecimal)obj;
	            	if(big.compareTo(BigDecimal.ZERO)==0){
	            		value="0";
	            	}else{
	            		value=big.toString();
	            	}
	            }else{
	            	value=obj.toString();
	            }
            }
            writeToOutputStream("<Cell><Data ss:Type=\"String\">"  
                    + HtmlUtils.htmlEscape(value)  
                    + "</Data></Cell>\r\n", fos);  
        }  
        writeToOutputStream("</Row>\r\n", fos);  
    }  
    
    protected void writeOneRowCsv(ResultSet rs, FileOutputStream fos)  
            throws SQLException, IOException {  
        // 获取metaData;  
        ResultSetMetaData rsmd = rs.getMetaData();  
        StringBuffer row=new StringBuffer("");
        int columnCount = rsmd.getColumnCount();  
        for (int i = 1; i <= columnCount; i++) {  
            // String key = getColumnKey(rsmd.getColumnName(i));  
            Object obj = getColumnValue(rs, i);  
            String value="";
            if(obj != null){
	            if(obj instanceof BigDecimal){
	            	BigDecimal big=(BigDecimal)obj;
	            	if(big.compareTo(BigDecimal.ZERO)==0){
	            		value="0";
	            	}else{
	            		value=big.toString();
	            	}
	            }else{
	            	value=obj.toString();
	            }
            }
            row.append(HtmlUtils.htmlEscape(value)+ ",");  
        }
        row.deleteCharAt(row.length()-1).append("\r\n");
        writeToOutputStream(row.toString(), fos); 
    } 
    
    protected void writeOneRowTxt(ResultSet rs, FileOutputStream fos)  
            throws SQLException, IOException {  
        // 获取metaData;  
        ResultSetMetaData rsmd = rs.getMetaData();  
        StringBuffer row=new StringBuffer("");
        int columnCount = rsmd.getColumnCount();  
        for (int i = 1; i <= columnCount; i++) {  
            Object obj = getColumnValue(rs, i);  
            String value="";
            if(obj != null){
	            if(obj instanceof BigDecimal){
	            	BigDecimal big=(BigDecimal)obj;
	            	if(big.compareTo(BigDecimal.ZERO)==0){
	            		value="0";
	            	}else{
	            		value=big.toString();
	            	}
	            }else{
	            	value=obj.toString();
	            }
            }
            row.append(HtmlUtils.htmlEscape(value)+ "\t");  
        }
        row.deleteCharAt(row.length()-1).append("\r\n");
        writeToOutputStream(row.toString(), fos); 
    } 
    
    private String getCodeByTxt(InputStream input) throws Exception{
    	StringBuffer buffer = new StringBuffer("");
		String line = "";
		boolean notfirst=false;
    	BufferedReader in = new BufferedReader(new InputStreamReader(input));
		while ((line = in.readLine()) != null){
			if(!line.matches("^[a-z0-9A-Z.]+$"))
				continue;
			if(notfirst){
				buffer.append(","+line);
			}else{
				notfirst=true;
				buffer.append(line);
			}
		}
		in.close();
		return buffer.toString();
    }
    
    private String getCodeByExcel(InputStream input) throws Exception{
    	StringBuffer buffer = new StringBuffer("");
		boolean notfirst=false;
    	HSSFWorkbook hssfWorkbook = new HSSFWorkbook(input);
		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
		for (int rowNum = 0,len=hssfSheet.getLastRowNum(); rowNum <= len; rowNum++) {
			String value=hssfSheet.getRow(rowNum).getCell(0).getStringCellValue();
			if(!value.matches("^[a-z0-9A-Z.]+$"))
				continue;
			if (StringUtils.isBlank(value))
                continue;
			if(notfirst){
				buffer.append(","+value);
			}else{
				notfirst=true;
				buffer.append(value);
			}
		}
		hssfWorkbook.close();
		return buffer.toString();
    }
    
    private void exportToCsv(final QueryMeta meta,Class<?> clazz,ExportDTO result) throws BaseException{
    	checkSize(meta,clazz,result);
    	String sql=HqlUitls.getQuerySql(meta,clazz);
    	String fileName=UUID.randomUUID().toString()+"."+meta.getFileType();
		String path=Constants.HOME_PATH+fileName;
		final List<DataField> fields=meta.getFields();
    	final FileOutputStream os;
		try {
			os = FileUtils.openOutputStream(new File(path));
	    	jdbcTemplate.query(sql, new ResultSetExtractor<Object>() {  
	            @Override
	            public Object extractData(ResultSet rs) throws SQLException,  
	                    DataAccessException {
	            	Boolean isNew=true;
	                try {  
	                    while (rs.next()) {  
	                        if (isNew) {  
	                        	writeTitleCsv(fields, os);
	                            isNew  = false;
	                        }
	                        writeOneRowCsv(rs, os);  
	                    }
	                } catch (IOException e) {  
	                	e.printStackTrace();
	                } finally {  
	                    IOUtils.closeQuietly(os);  
	                }
	                return null;  
	            }  
	        });
	    	result.setFileName(fileName);
	        result.setFileSize(new File(path).length());
		} catch (IOException e1) {
			throw new BaseException("IOException") ;
		}
    }
    
    private void exportToTxt(final QueryMeta meta,Class<?> clazz,ExportDTO result) throws BaseException{
    	checkSize(meta,clazz,result);
    	String sql=HqlUitls.getQuerySql(meta,clazz);
    	String fileName=UUID.randomUUID().toString()+"."+meta.getFileType();
		String path=Constants.HOME_PATH+fileName;
		final List<DataField> fields=meta.getFields();
    	final FileOutputStream os;
		try {
			os = FileUtils.openOutputStream(new File(path));
			jdbcTemplate.query(sql, new ResultSetExtractor<Object>() {  
	            @Override
	            public Object extractData(ResultSet rs) throws SQLException,  
	                    DataAccessException {
	            	Boolean isNew=true;
	                try {  
	                    while (rs.next()) {  
	                        if (isNew) {  
	                        	writeTitleTxt(fields, os);
	                            isNew  = false;
	                        }
	                        writeOneRowTxt(rs, os);  
	                    }
	                } catch (IOException e) {  
	                	e.printStackTrace();
	                } finally {  
	                    IOUtils.closeQuietly(os);  
	                }
	                return null;  
	            }  
	        }); 
			result.setFileName(fileName);
	        result.setFileSize(new File(path).length());
		} catch (IOException e) {
			throw new BaseException("IOException") ;
		}
    }
    
    private void exportToExcel(final QueryMeta meta,Class<?> clazz,ExportDTO result) throws BaseException{
    	checkSize(meta,clazz,result);
    	String sql=HqlUitls.getQuerySql(meta,clazz);
    	String fileName=UUID.randomUUID().toString()+".zip";
		String path=Constants.HOME_PATH+fileName;//UUID.randomUUID().toString()+meta.getFileType();
		final List<DataField> fields=meta.getFields();
    	final FileOutputStream os;
    	final int max = 65000;
		try {
			os = FileUtils.openOutputStream(new File(path));
	        jdbcTemplate.query(sql,  new ResultSetExtractor<Object>() {  
	            @Override  
	            public Object extractData(ResultSet rs) throws SQLException,  
	                    DataAccessException {  
	                List<File> fileList = new ArrayList<File>();  
	                int i = 0;  
	                File file = null;  
	                FileOutputStream fos = null;  
	                try {
	                    while (rs.next()) {  
	                        if (i == max || i == 0) {  
	                            if (file != null) {  
	                                writeFooterExcel(fos);  
	                                IOUtils.closeQuietly(fos);  
	                            }  
	                            file = createTempFile("excel",".xls");  
	                            fos = FileUtils.openOutputStream(file);  
	                            fileList.add(file);  
	                            writeHeaderExcel(fos);  
	                            writeTitleExcel(fields, fos);  
	                            i = 0;  
	                        }  
	                        i++;  
	                        writeOneRowExcel(rs, fos);  
	                    }
	  
	                    if (file != null) {  
	                        writeFooterExcel(fos);  
	                        IOUtils.closeQuietly(fos);  
	                    }  
	                    // 打包  
	                    doZip(os, fileList);  
	                } catch (IOException e) {  
	                    // io异常  
	                } finally {  
	                    IOUtils.closeQuietly(fos);  
	                    // 清空临时文件  
	                    cleanTempFile(fileList);  
	                    fileList.clear();  
	                    fileList = null;  
	                }  
	                return null;  
	            }  
	        });
	        result.setFileName(fileName);
	        result.setFileSize(new File(path).length());
		} catch (IOException e1) {
			throw new BaseException("IOException") ;
		}
    }
    
	@Override
	public String uploadData(MultipartFile[] files) throws Exception {
		File home=new File(Constants.HOME_PATH);
		if(!home.exists()){
			home.mkdirs();
		}
		String path=Constants.HOME_PATH+"\\dataUpload\\"+UUID.randomUUID().toString()+"\\";
		if(files!=null&&files.length>0){  
			for(int i = 0;i<files.length;i++){  
                MultipartFile file = files[i]; 
                File datafile=new File(path+file.getOriginalFilename());
                datafile.mkdirs();
                file.transferTo(datafile);
            }
		}
		return path;
	}
    
	@Async
	public void dataFileScan(String folder) throws Exception{
		File dir=new File(folder);
		File[] files=dir.listFiles();
		for(File file:files){
			try{
				if(file.isFile()){
					DataUpdateUtils.insertData(file, jdbcTemplate);
				}
				System.out.println("------Import success,delete data file:"+file.getAbsolutePath());
				file.delete();
			}catch(Exception e){
				System.out.println("------Import fail:"+file.getAbsolutePath());
				e.printStackTrace();
			}
			
		}
		dir.delete();
		System.out.println("------Delete data file folder:"+dir.getAbsolutePath());
	}
	
	private void checkSize(QueryMeta meta,Class<?> clazz,ExportDTO result) throws BaseException{
		String countSql=HqlUitls.getCountSql(meta,clazz);
		Long count=jdbcTemplate.queryForObject(countSql, Long.class);
		if(count>Constants.RECORD_MAX){
			throw new BaseException("Record number can not be more than "+Constants.RECORD_MAX
					+",You can:"
					+"<br>1.Shorten the date range in 'Time select'"
					+"<br>2.Reduce the number of codes in 'Code Select'"
					+"<br>3.Add some conditions in 'Condition Set'");
		}
		result.setRecodCount(count);
	}
}


