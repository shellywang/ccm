package cn.edu.saif.shared.common;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ExportDTO {
	
	private String code;
	
	@JsonIgnore
	private Class<?> clazz;
	
	private Long recodCount;
	
	private Date time;
	
	private Long runTime;
	
	private String fileName;
	
	private Long fileSize;
	
	private String msg;
	
	public ExportDTO(){
	}
	
	public ExportDTO(String code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public ExportDTO(String code,Long runTime,String msg){
		this.code=code;
		this.runTime=runTime;
		this.msg=msg;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getRunTime() {
		return runTime;
	}

	public void setRunTime(Long runTime) {
		this.runTime = runTime;
	}

	public Long getRecodCount() {
		return recodCount;
	}

	public void setRecodCount(Long recodCount) {
		this.recodCount = recodCount;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
}
