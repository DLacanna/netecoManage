package org.neteco.services;

import java.util.List;
import java.util.Optional;

import org.neteco.entities.Utenti;
import org.neteco.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




	
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository; 

	@Override
	public Optional<Utenti> getUserById(int id) {
		return userRepository.findById(id);
	}

	@Override
	public List<Utenti> getAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public Utenti findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	

}


