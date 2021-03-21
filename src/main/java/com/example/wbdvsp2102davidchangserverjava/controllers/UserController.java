package com.example.wbdvsp2102davidchangserverjava.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbdvsp2102davidchangserverjava.models.User;

import java.util.ArrayList;

@RestController
public class UserController {
	static List<User> users = new ArrayList<User>();
	static {
		users.add(new User(123, "alice", "Alice", "Park", "ADMIN"));
		users.add(new User(234, "bob", "Bob", "Costas", "FACULTY"));
		users.add(new User(345, "charlie", "Charlie", "Conway", "STUDENT"));
		users.add(new User(456, "dan", "Dan", "Orlovsky", "STUDENT"));
	}
	
    // CRUD
    
    // POST - Creating 
    @PostMapping("/users")
    public List<User> createUser(@RequestBody User user) {
        users.add(user);
        return users;
    }
    
    // GET - Reading
    @GetMapping("/users")
    public List<User> findAllUsers() {
        return users;
    }


    // UPDATE - Updating
    // DELETE - Deleting
}