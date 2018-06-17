package com.management.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.management.entity.Employer;
import com.management.entity.Service;

@Repository
@Transactional
public class ServiceImplement implements InterfaceService {

	@PersistenceContext

	private EntityManager entityManager;

	@Override
	public void addService(Service service) {

		entityManager.persist(service);
	}

	@Override
	public Service findService(Service service) { // il va retourner null s'il ne va pas trouver

		service = entityManager.find(Service.class, service.getIdService());

		return service;
	}

	@Override
	public Service findServiceOfEmployer(Employer employer) {// :employer.service.idService

		Query query = entityManager.createQuery("from Service services where services like :employer.service")
				.setParameter("employer", employer);

		Service service = (Service) query.getSingleResult();

		return service;
	}

	@Override
	public Service updateService(Service service) {

		service = entityManager.merge(service);

		return service;
	}

	@Override
	public List<Service> listAllService() {

		Query query = entityManager.createQuery("from Service s");

		List<Service> services = query.getResultList();

		return services;
	}

	@Override
	public void deleteService(Service service) {

		int idService = service.getIdService();

		service = entityManager.find(Service.class, idService);

		entityManager.remove(service);

	}

	@Override
	public Service findByServiceLibelle(String libelle) {

		Service service;

		Query query = entityManager.createQuery("from Service service where service.libelle like :libelle")
				.setParameter("libelle", libelle);
		service = (Service) query.getSingleResult();
		return service;
	}

	@Override
	public Service findServiceById(int idService) {

		Service service;

		Query query = entityManager.createQuery("from Service service where service.idService like :idService")
				.setParameter("idService", idService);
		service = (Service) query.getSingleResult();
		return service;
	}

	@Override
	public List<Employer> findEmployersWithService(String libelle) {		// VALIDE

		Query query = entityManager.createQuery("from Employer employers where employers.service.libelle like :libelle")
				.setParameter("libelle", libelle);
		List<Employer> employers = query.getResultList();

		return employers;
	}

}
