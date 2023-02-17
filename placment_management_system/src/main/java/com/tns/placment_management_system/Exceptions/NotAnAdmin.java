package com.tns.placment_management_system.Exceptions;

public class NotAnAdmin extends Exception{
	public String getMessage() {
		return "either wrong user name or not an admin";
	}
}
