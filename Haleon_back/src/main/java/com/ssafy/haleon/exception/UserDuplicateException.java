package com.ssafy.haleon.exception;

public class UserDuplicateException extends Exception {
	public UserDuplicateException() {
		super("이미 사용중인 아이디입니다.");
	}
}	
