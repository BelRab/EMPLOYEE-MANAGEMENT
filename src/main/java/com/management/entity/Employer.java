package com.management.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Employer extends User implements Serializable {

	private String name;
	private String lastName;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateEmbauche;
	private double salary;
	@ManyToOne // Toujours ManyToOne c'est une clé etrangere
	@JoinColumn(name="idService")
	private Service service; // Clé etrangere

	public Employer() {
		super();
	}

	public Employer( String login, String password, String name, String lastName, Date dateEmbauche,
			double salary, Service service) {
		super(login, password);
		this.name = name;
		this.lastName = lastName;
		this.dateEmbauche = dateEmbauche;
		this.salary = salary;
		this.service = service;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dateEmbauche
	 */
	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	/**
	 * @param dateEmbauche
	 *            the dateEmbauche to set
	 */
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the service
	 */
	public Service getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(Service service) {
		this.service = service;
	}

}
