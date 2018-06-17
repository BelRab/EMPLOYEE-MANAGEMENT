package com.management.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Service implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Je vais la voir aprés
	private int idService;
	@Column
	private String code;
	@Column
	private String libelle;
	@OneToMany(mappedBy = "service")
	private List<Employer> employers;

	public Service() {
	}

	public Service(String code, String libelle) {
		this.code = code;
		this.libelle = libelle;
	}

	/**
	 * @return the idSerive
	 */
	public int getIdService() {
		return idService;
	}

	/**
	 * @param idSerive
	 *            the idSerive to set
	 */
	public void setIdService(int idService) {
		this.idService = idService;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle
	 *            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the employers
	 */
	public List<Employer> getEmployers() {
		return employers;
	}

	/**
	 * @param employers
	 *            the employers to set
	 */
	public void setEmployers(List<Employer> employers) {
		this.employers = employers;
	}

}
