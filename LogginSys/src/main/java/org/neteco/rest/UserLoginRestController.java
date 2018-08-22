package org.neteco.rest;


import java.util.HashMap;

import org.neteco.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("api/user")
public class UserLoginRestController {

	private static final Logger logger = LoggerFactory.getLogger(UserLoginRestController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping (value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity loginUser (@RequestBody final HashMap<String, String> loginData) {
		
		System.out.println(loginData.get("email"));
		System.out.println(loginData.get("password"));
		
		    return new ResponseEntity<>(HttpStatus.OK);
		
		
	}
	
	
}
