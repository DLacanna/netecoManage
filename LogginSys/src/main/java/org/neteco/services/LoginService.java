package org.neteco.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.neteco.entities.Utenti;
import org.neteco.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class LoginService implements UserDetailsService {
	
	private static final Logger logger = Logger.getLogger(LoginService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		logger.info("LoginService.loadUserByUsername - START - email: " + email);
		
		Optional<Utenti> optUser = userRepository.findByEmail(email);
		
		if(!optUser.isPresent()) {
			throw new UsernameNotFoundException("Oops! User not found with username: " + email);
			
			}
		return new org.springframework.security.core.userdetails.User(optUser.get().getName(),optUser.get().getPassword(),getAuthorities(optUser.get()));	
	}
	
	
	private Collection<GrantedAuthority> getAuthorities(Utenti user) {
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities = AuthorityUtils.createAuthorityList("USER");
		return authorities;
				
		
	}
	

}
