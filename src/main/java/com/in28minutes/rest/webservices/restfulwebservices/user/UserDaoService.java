package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    
	private static List<User> users = new ArrayList<>();
	
	private static Integer userCount = 0;
	
	static {
		
		users.add(new User(++userCount,"Adam",LocalDate.now().minusYears(30)));
		users.add(new User(++userCount,"Eve",LocalDate.now().minusYears(30)));
		users.add(new User(++userCount,"Jim",LocalDate.now().minusYears(30)));
		
	}
	
	
	public List<User> findAll() {
		return users;
	}
	
	
	public User findOne(int id) {
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getId() == id) {
				return users.get(i);
			}
		}
		return null;
	}
	
	public void deleteOne(int id) {
		User toDelete = null;
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getId() == id) {
				toDelete = users.get(i);
			}
		}
		if(toDelete != null) {
			users.remove(toDelete);
		}
		
	}
	
	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
}
