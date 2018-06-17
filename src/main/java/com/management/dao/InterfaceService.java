package com.management.dao;

import java.util.List;

import com.management.entity.Employer;
import com.management.entity.Service;

public interface InterfaceService {

	public void addService(Service service); // On peut avoir un boolean en retour si l'employé est supprimé

	public void deleteService(Service service);

	public Service updateService(Service service); // mis a jour et retourner sa valeur

	public List<Service> listAllService();

	public Service findService(Service service);

	public Service findByServiceLibelle(String libelle);

	public Service findServiceOfEmployer(Employer employer);

	public Service findServiceById(int idService);
	
	// RECHERCHER LA LISTE DES EMPLOYERS QUI ONT UN SERVICE ENTRÉ EN PARAMETRE

	public List<Employer> findEmployersWithService(String libelle);
}
