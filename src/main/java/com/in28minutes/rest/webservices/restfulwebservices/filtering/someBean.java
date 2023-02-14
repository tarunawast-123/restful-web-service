package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//work at class level
//@JsonIgnoreProperties({"value1","value2"})
@JsonFilter("someBeanFilter")
public class someBean {
    
	private String value1;
	//@JsonIgnore
	private String value2;
	private String value3;
	public someBean(String value1, String value2, String value3) {
		super();
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
	}
	public String getValue1() {
		return value1;
	}
	public String getValue2() {
		return value2;
	}
	public String getValue3() {
		return value3;
	}
	@Override
	public String toString() {
		return "someBean [value1=" + value1 + ", value2=" + value2 + ", value3=" + value3 + "]";
	}
	
	
}
