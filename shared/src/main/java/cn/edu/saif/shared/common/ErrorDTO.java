package cn.edu.saif.shared.common;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ErrorDTO {
	private String errorCode;	
	private String errorMsg;
	@JsonIgnore
	private HttpStatus httpStatus;

	public ErrorDTO() {
		super();
	}
	
	public ErrorDTO(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	public ErrorDTO(String errorCode, String errorMsg, HttpStatus httpStatus) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.httpStatus = httpStatus;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public HttpStatus getHttpStatus() {
		if(httpStatus==null){
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
		
}
