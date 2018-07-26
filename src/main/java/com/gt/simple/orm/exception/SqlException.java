package com.gt.simple.orm.exception;

import java.io.IOException;

public class SqlException extends RuntimeException{

	public SqlException() {}
	
	public SqlException(String message) {
		super(message);
	}

	public SqlException(IOException e) {
		super(e);
	}
}
