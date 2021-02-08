package com.example.wbdvsp2102davidchangserverjava.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbdvsp2102davidchangserverjava.models.User;

import java.util.ArrayList;

@RestController
public class UserController {
	static List<User> users = new ArrayList<User>();
	static {
		users.add(new User(123, "alice", "Alice", "Park"));
		users.add(new User(234, "bob", "Bob", "Costas"));
		users.add(new User(345, "charlie", "Charlie", "Conway"));
		users.add(new User(456, "dan", "Dan", "Orlovsky"));
	}
	
	
	@GetMapping("/users")
	public List<User> findAllUsers() {
		return users;
	}
}
