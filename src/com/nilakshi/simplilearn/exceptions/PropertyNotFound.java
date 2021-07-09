package com.nilakshi.simplilearn.exceptions;

public class PropertyNotFound extends RuntimeException {

	public PropertyNotFound(String message) {
		super("PROPERTY NOT FOUND:: "+message);
	}
}
