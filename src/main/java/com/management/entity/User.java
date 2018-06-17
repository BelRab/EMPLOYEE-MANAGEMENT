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

@Inheritance(strategy=InheritanceType.JOINED)			//		Je vais la voir aprés 
@Entity
@Table(name="userTable")
public abstract class User implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int idUser;
	@Column(length=20)
	private String login;
	@Column(length=20)
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
