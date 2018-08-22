package org.neteco.services;

import java.util.List;
import java.util.Optional;

import org.neteco.entities.Utenti;
import org.springframework.stereotype.Service;




@Service
public interface UserService {
	Optional<Utenti> getUserById(int id);
	List<Utenti> getAllUsers();
    Utenti findUserByEmail(String email);
}
