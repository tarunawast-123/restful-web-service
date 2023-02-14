package com.in28minutes.rest.webservices.restfulwebservices.versioning;

public class PersonV1 {

	private String person;
	
	public PersonV1(String person) {
		this.person = person;
	}

	public String getPerson() {
		return person;
	}

	@Override
	public String toString() {
		return "PersonV1 [person=" + person + "]";
	}
	
}
