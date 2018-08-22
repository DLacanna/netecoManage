package org.neteco.repository;


import org.neteco.entities.Utenti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



/**
	* @author DLacanna
	*
	*/
	
@Repository("userRepository")
public interface UserRepository extends JpaRepository<Utenti, Integer> {

	Utenti findByEmail(String email);
	
	
}

	




