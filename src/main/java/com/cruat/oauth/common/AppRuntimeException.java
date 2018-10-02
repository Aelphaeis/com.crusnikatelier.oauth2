package com.cruat.oauth.common;

public class AppRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AppRuntimeException() {
        super();
    }
    public AppRuntimeException(String message) {
        super(message);
    }

    public AppRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppRuntimeException(Throwable cause) {
        super(cause);
    }
}
