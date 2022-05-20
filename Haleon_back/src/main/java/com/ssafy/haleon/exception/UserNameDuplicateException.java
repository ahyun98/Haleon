package com.ssafy.haleon.exception;

public class UserNameDuplicateException extends Exception {
	public UserNameDuplicateException() {
		super("이미 사용중인 닉네임입니다.");
	}
}	
