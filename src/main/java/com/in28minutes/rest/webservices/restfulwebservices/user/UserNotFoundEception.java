package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundEception extends RuntimeException {

	
	 public UserNotFoundEception(String msg) {
		 super(msg);
	 }
}
