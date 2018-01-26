package cn.edu.saif.ccm.service.impl;

import java.io.BufferedReader;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStreamReader;
import java.io.OutputStream;  
import java.lang.reflect.Field;
import java.sql.ResultSet;  
import java.sql.ResultSetMetaData;
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.Arrays;  
import java.util.Collection;  
import java.util.Collections;  
import java.util.HashMap;
import java.util.List;  
import java.util.Map;
import java.util.zip.ZipEntry;  
import java.util.zip.ZipOutputStream;  

import javax.persistence.Column;
import javax.persistence.Table;

import org.apache.commons.io.FileUtils;  
import org.apache.commons.io.IOUtils;  
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.ResultSetExtractor;  
import org.springframework.jdbc.support.JdbcUtils;  
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import cn.edu.saif.ccm.domain.stock.DailyInfo;
import cn.edu.saif.ccm.service.FileService;
import cn.edu.saif.shared.query.Condition;
import cn.edu.saif.shared.query.DataField;
import cn.edu.saif.shared.query.QueryMeta;
import cn.edu.saif.shared.utils.StringUtils;

/** 
 * 大数据量导出 抽象类 
 *  
 * 
 */  
public abstract class AbstractFileService{  
	
	
	StringBuffer headXml = new StringBuffer(  
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n")  
            .append("<?mso-application progid=\"Excel.Sheet\"?>\r\n")  
            .append("<Workbook xmlns=\"urn:schemas-microsoft-com:office:spreadsheet\"\r\n")  
            .append(" xmlns:o=\"urn:schemas-microsoft-com:office:office\"\r\n")  
            .append(" xmlns:x=\"urn:schemas-microsoft-com:office:excel\"\r\n")
            .append(" xmlns:ss=\"urn:schemas-microsoft-com:office:spreadsheet\"\r\n")
            .append(" xmlns:html=\"http://www.w3.org/TR/REC-html40\">\r\n")
            .append("<Styles>\r\n<Style ss:ID=\"1\">\r\n<Font ss:Bold=\"1\"/>\r\n</Style>\r\n</Styles>")
            .append("<Worksheet ss:Name=\"Table1\">\r\n")
            .append("<Table>\r\n");  
  
    StringBuffer footXml = new StringBuffer("</Table>\r\n</Worksheet>\r\n</Workbook>"); 
    
    protected File createTempFile(String prefix,String suffix) throws IOException {  
        return File.createTempFile(prefix, suffix);
    }
    
    protected void cleanTempFile(List<File> fileList) {  
    	for (File file : fileList) {  
            System.out.println("-----Delete temp file," + file.getPath());  
            file.delete();
        }  
    }
  
    protected void writeToOutputStream(String data, FileOutputStream fos)  
            throws IOException {  
        IOUtils.write(data, fos, "UTF-8");  
    }
    
    protected void writeHeaderXml(FileOutputStream fos)  
            throws IOException {  
        writeToOutputStream(headXml.toString(), fos);  
    }

    protected void writeFooterXml(FileOutputStream fos)  
            throws IOException {  
        writeToOutputStream(footXml.toString(), fos);  
    } 
    
    protected void writeHeaderExcel(FileOutputStream fos)  
            throws IOException {  
        writeToOutputStream(headXml.toString(), fos);  
    }

    protected void writeFooterExcel(FileOutputStream fos)  
            throws IOException {  
        writeToOutputStream(footXml.toString(), fos);  
    }
    
    protected void doZip(OutputStream os,List<File> fileList)  
            throws IOException {  
    	if (fileList != null && fileList.size() > 0) {  
    		String fileName="";
    		String fileType="";
            byte[] buf = new byte[1024];  
            ZipOutputStream out = new ZipOutputStream(os);  
            for (File file : fileList) {
            	fileName=file.getName();
            	fileType=fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
            	System.out.println(fileType);
                FileInputStream in = new FileInputStream(file);  
                out.putNextEntry(new ZipEntry(file.getName()));  
                int len;  
                while ((len = in.read(buf)) > 0) {  
                    out.write(buf, 0, len);  
                }  
                out.closeEntry();  
                in.close();  
            }  
            System.out.println(os == null);  
            out.close();  
            System.out.println(os == null);  
        }
    }
  
    protected String getColumnKey(String columnName) {  
        return columnName;  
    }  
  
    protected Object getColumnValue(ResultSet rs, int index)  
            throws SQLException {  
        return JdbcUtils.getResultSetValue(rs, index);  
    }
  
    protected void writeTitleCsv(List<DataField> fields,  
            FileOutputStream fos) throws IOException {  
        if (fields != null && fields.size() > 0) { 
        	String titleStr="";
        	for(int i=0,len=fields.size();i<len;i++){
        		if(i!=len-1)
        			titleStr+=fields.get(i).getTitle()+",";
        		else{
        			titleStr+=fields.get(i).getTitle();
        		}
        	}
            writeToOutputStream(titleStr+"\r\n", fos);   
        }
    }
    
    protected void writeTitleTxt(List<DataField> fields,  
            FileOutputStream fos) throws IOException {  
        if (fields != null && fields.size() > 0) { 
        	String titleStr="";
        	for(int i=0,len=fields.size();i<len;i++){
        		if(i!=len-1)
        			titleStr+=fields.get(i).getTitle()+"\t";
        		else{
        			titleStr+=fields.get(i).getTitle();
        		}
        	}
            writeToOutputStream(titleStr+"\r\n", fos);  
        }
    }
    
    protected void writeTitleExcel(Collection<DataField> fields,  
            FileOutputStream fos) throws IOException {  
    	if (fields != null && fields.size() > 0) {  
            writeToOutputStream("<Row ss:StyleID=\"1\">\r\n", fos);  
            for (DataField field : fields) {  
                writeToOutputStream("<Cell><Data ss:Type=\"String\">"  
                        + HtmlUtils.htmlEscape(field.getTitle() == null ? "" : field.getTitle())  
                        + "</Data></Cell>\r\n", fos);  
            }
            writeToOutputStream("</Row>\r\n", fos);  
        } 
    }
    
}  
