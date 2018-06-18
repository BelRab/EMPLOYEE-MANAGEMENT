package com.management.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Employer extends User implements Serializable {

	@Size(min=3,max=15,message = "Name field must have max 15 characters and min 3 characters.")
	private String name;
	@Size(min=3,max=15,message = "Lastname field must have max 15 characters and min 3 characters.")
	private String lastName;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@NotNull(message="Date must not be Null.")
	private Date dateEmbauche;
	@NotNull(message="You must put a salary.")
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
	 * @param service the service to set
	 */
	public void setService(Service service) {
		this.service = service;
	}

	

}
