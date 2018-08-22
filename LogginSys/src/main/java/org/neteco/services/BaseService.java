package org.neteco.services;

import org.neteco.entities.Utenti;

public interface BaseService {
	 public boolean login(String username, String password);

	 public String registration(Utenti user);
	}