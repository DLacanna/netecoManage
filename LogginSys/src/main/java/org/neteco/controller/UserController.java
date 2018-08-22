package org.neteco.controller;

import java.util.List;
import java.util.Optional;

import org.neteco.entities.Utenti;
import org.neteco.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<Utenti> getUsers() {
		return userService.getAllUsers();
	}

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public Optional<Utenti> getUser(@PathVariable("id") int id) {
		return userService.getUserById(id);
	}
}
