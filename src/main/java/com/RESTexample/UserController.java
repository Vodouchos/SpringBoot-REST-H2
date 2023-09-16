package com.RESTexample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserService usersevice;

	@PostMapping("/adduser")
	public User addUser (@RequestBody User user) {
		return usersevice.CreateUser(user);
	}
	
	@PostMapping("/addusers")
	public List<User> addUsers (@RequestBody List<User> users) {
		return usersevice.CreateUsers(users);
	}
	
	@GetMapping("/user/{id}")
	public User getUserById (@PathVariable int id) {
		return usersevice.GetUserById(id);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers () {
		return usersevice.GetUsers();
	}
	
	@PutMapping("/updateuser")
	public User updateUser (@RequestBody User user) {
		return usersevice.UpdateUser(user);
	}
	
	@DeleteMapping("/user/{id}")
	public String AddUser (@PathVariable int id) {
		return usersevice.RemoveUserById(id);
	}
	
}
