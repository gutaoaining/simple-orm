package com.gt.simple.orm.exception;

import java.io.IOException;

public class XmlException extends RuntimeException{

	public XmlException() {}
	
	public XmlException(String message) {
		super(message);
	}

	public XmlException(IOException e) {
		super(e);
	}
}
