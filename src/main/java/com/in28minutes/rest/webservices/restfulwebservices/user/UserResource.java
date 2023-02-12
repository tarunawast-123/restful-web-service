package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
     
	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service = service; 
	}
	
	@GetMapping("/users")
	public List<User> retreiveAllUsers() {
		return service.findAll();
	}
	
	
	@GetMapping("/users/{id}")
	public User retreiveUser(@PathVariable int id) {
		User user =  service.findOne(id);
		
		if(user == null) {
			throw new UserNotFoundEception("id:"+id);
		}
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		// /users/4 ==> /users/{id} ==> users.getId()
		URI location = ServletUriComponentsBuilder.
				       fromCurrentRequest().path("/{id}").
				       buildAndExpand(savedUser.getId()).
				       toUri();
		return ResponseEntity.created(location).build();
	}
	
}
