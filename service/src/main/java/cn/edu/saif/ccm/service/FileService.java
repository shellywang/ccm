package cn.edu.saif.ccm.service;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.saif.shared.common.ExportDTO;
import cn.edu.saif.shared.query.QueryMeta;
  
public interface FileService {  
	
	public String getCodeByFile(MultipartFile codeFile);  
	
	public String uploadData(MultipartFile[] files) throws Exception;
	
	public void dataFileScan(String folder) throws Exception;
	
    public ExportDTO exportToFile(final QueryMeta meta,Class<?> clazz);  
    
}  