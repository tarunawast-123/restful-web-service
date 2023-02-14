package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping("V1/Person")
	public PersonV1 getFirstVersionOfPerson() {
		
		return new PersonV1("Tarun Awasthi");
	}
	
	@GetMapping("V2/Person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Tarun","Awasthi"));
	}
	
	@GetMapping(path = "/Person", params = "version=1")
	public PersonV1 getFirstVersionOfPersonRequestParameter() {
		
		return new PersonV1("Tarun Awasthi");
	}
	
	@GetMapping(path = "/Person" , params = "version=2")
	public PersonV2 getSecondVersionOfPersonRequestParameter() {
		return new PersonV2(new Name("Tarun","Awasthi"));
	}
	
	@GetMapping(path = "/Person/header", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonRequestHeader() {
		
		return new PersonV1("Tarun Awasthi");
	}
	
	@GetMapping(path = "/Person/header", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonRequestHeader() {
		
		return new PersonV2(new Name("Tarun","Awasthi"));
	}
	
	@GetMapping(path = "/Person/header", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonAcceptHeader() {
		
		return new PersonV1("Tarun Awasthi");
	}
	
	@GetMapping(path = "/Person/header", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonAcceptHeader() {
		
		return new PersonV2(new Name("Tarun","Awasthi"));
	}
}
