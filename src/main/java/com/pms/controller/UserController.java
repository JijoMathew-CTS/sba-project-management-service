package com.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.entity.User;
import com.pms.service.IUserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/user/saveorupdate")
	public Integer createOrUpdate(@RequestBody User user) {
		return userService.saveOrUpdate(user);
	}
	
	@GetMapping("/user/getUser/{id}")
	public User getUser(@PathVariable String id) {
		return userService.getUser(Integer.parseInt(id));
		
		
	}
	
	@GetMapping("/user/getAllUsers")
	public List<User> getAllUsers(){
		return userService.view();
		
	}
	
	@DeleteMapping("/user/delete/{id}")
	public Integer deleteUser(@PathVariable String id) {
		return userService.delete(Integer.parseInt(id));
	}
	

}
