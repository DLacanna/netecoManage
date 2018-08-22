package org.neteco.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.Length;


/**
 * The persistent class for the utenti database table.
 * 
 */
@Entity
@NamedQuery(name="Utenti.findAll", query="SELECT u FROM Utenti u")
public class Utenti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	@Column(name = "email")
	private String email;
     
	@Column(name = "lastName")
	private String lastName;

	@Column (name = "name")	
	private String name;
     
	@Column (name = "password")
	@Length(min = 8, message = "*Your password must have at least 5 characters")
	private String password;

	public Utenti() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}