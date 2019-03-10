package com.demo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.beans.User;
import com.demo.repository.UserRepository;

@Component
public class UserDao {
	@Autowired
	UserRepository userRepository;
	
	public User findById(long id){
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}
	
	public User add(User u) {
		return userRepository.save(u);
	}
	
	public void delete(long id) {
		userRepository.deleteById(id);
	}
	
	public void merge() {
	}
}
