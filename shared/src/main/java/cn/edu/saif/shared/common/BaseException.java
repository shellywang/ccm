/*
 * Copyright (c) 2015, Shanghai SAIF. All rights reserved.
 */
package cn.edu.saif.shared.common;

/**
 * Base Exception
 *
 * @author Xiao GuangLei
 * @since 1.0
 * @see Exception
 */
public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Throwable cause;
	private ErrorDTO errorDto;

	public BaseException() {
		super();
	}

	public BaseException(String message) {
		super(message);
	}
	
	public BaseException(Throwable cause) {
		super(cause);
	}

	public BaseException(ErrorDTO errorDto, Throwable cause) {
		super(cause);
		this.errorDto = errorDto;
	}

	public BaseException(ErrorDTO errorDto) {
		this.errorDto = errorDto;
	}

	public ErrorDTO getErrorDto() {
		if(cause!=null) cause.printStackTrace();
		
		return errorDto;
	}

	public void setErrorDto(ErrorDTO errorDto) {
		this.errorDto = errorDto;
	}

}
