package com.tns.placment_management_system.Exceptions;


public class NoUserException extends Exception{
	public String getMessage() {
		return "wrong username";
	}

}
