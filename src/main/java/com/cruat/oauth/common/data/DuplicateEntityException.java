package com.cruat.oauth.common.data;

import com.cruat.oauth.common.AppRuntimeException;

public class DuplicateEntityException extends AppRuntimeException {
	private static final long serialVersionUID = 1L;
	
    public DuplicateEntityException(String message) {
        super(message);
    }
}
