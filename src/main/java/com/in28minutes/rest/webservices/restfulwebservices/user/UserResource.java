package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

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
	
	//localhost:8080/users
	
	//EntityModel
	//WebMvcLinkBuilder for hateoas
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retreiveUser(@PathVariable int id) {
		User user =  service.findOne(id);
		
		if(user == null) {
			throw new UserNotFoundEception("id:"+id);
		}
		EntityModel<User> entityModel = EntityModel.of(user);
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retreiveAllUsers());  
		entityModel.add(link.withRel("all-user"));
		return entityModel;
	}
	
	
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		  service.deleteOne(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		// /users/4 ==> /users/{id} ==> users.getId()
		URI location = ServletUriComponentsBuilder.
				       fromCurrentRequest().path("/{id}").
				       buildAndExpand(savedUser.getId()).
				       toUri();
		return ResponseEntity.created(location).build();
	}
	
}
