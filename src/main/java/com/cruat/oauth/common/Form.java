package com.cruat.oauth.common;

import com.cruat.oauth.common.exceptions.AggregationException;

public interface Form {

	/**
	 * Validates the arguments of this object. If any problems occur, an
	 * {@Link AggregationException} is thrown with a collection of
	 * {@link ValidationException}
	 * 
	 * @throws AggregationException
	 *             If a validation exception occurs
	 */
	void validate() throws AggregationException;

	public static class ValidationException extends Exception {
		private static final long serialVersionUID = 1L;

		public ValidationException() {
			super();
		}

		public ValidationException(String message) {
			super(message);
		}

		public ValidationException(String message, Throwable cause) {
			super(message, cause);
		}

		public ValidationException(Throwable cause) {
			super(cause);
		}
	}
}
