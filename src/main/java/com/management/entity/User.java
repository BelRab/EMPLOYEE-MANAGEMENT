package com.management.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Inheritance(strategy=InheritanceType.JOINED)			//		Je vais la voir aprés 
@Entity
@Table(name="userTable")
public abstract class User implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int idUser;
	@Column(length=20)
	@NotEmpty(message="Login field must have not be empty.")
	@Size(min=3,max=10,message="Invalid Login , must be between 3 and 10 characters")
	private String login;
	@Column(length=20)
	@NotEmpty(message="Password field must have not be empty.")
	@Size(min=3,max=10,message="Invalid Password , must be between 3 and 10 characters")
	private String password;

	public User() {
	}

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	

}
