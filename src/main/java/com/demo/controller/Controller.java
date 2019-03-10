package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.User;
import com.demo.service.UserService;


@RestController
@RequestMapping("user")
public class Controller {

	@Autowired
	UserService userService;

	@GetMapping
	public ResponseEntity<User> getMapping(@RequestParam("id") long id) {
		User userCreated = userService.findById(id);
		if(null!=userCreated) {
			return ResponseEntity.ok(userCreated);
		}else {
			return ResponseEntity.ok(null);
		}
		
	}

	@PostMapping
	public ResponseEntity<Long> postMapping(@RequestBody User user) {
		User userCreated = userService.add(user);
		if(null != userCreated) {
			return ResponseEntity.ok(userCreated.getId());
		}else {
			return ResponseEntity.ok(null);
		}
	}

	@PutMapping
	public ResponseEntity<Long> putMapping(@RequestBody User user) {
		//return ResponseEntity.ok(userService.add(user).getId());
		User userCreated = userService.add(user);
		if(null != userCreated) {
			return ResponseEntity.ok(userCreated.getId());
		}else {
			return ResponseEntity.ok(null);
		}
	}

	@DeleteMapping
	public void deleteMapping(@RequestParam("id") long id) {
		userService.delete(id);
	}

}
