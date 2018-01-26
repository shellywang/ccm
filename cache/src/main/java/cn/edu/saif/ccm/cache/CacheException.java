package cn.edu.saif.ccm.cache;

import cn.edu.saif.shared.common.ErrorDTO;

public class CacheException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private ErrorDTO errorDto;

	public CacheException() {

	}

	public CacheException(ErrorDTO errorDto) {
		this.errorDto = errorDto;
	}

	public ErrorDTO getErrorDto() {
		return errorDto;
	}

	public void setErrorDto(ErrorDTO errorDto) {
		this.errorDto = errorDto;
	}
}
