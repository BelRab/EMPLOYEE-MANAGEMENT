package com.management.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.management.entity.Employer;
import com.management.entity.User;

@Repository
@Transactional
public class EmployerImplement implements InterfaceEmployer {

	@PersistenceContext

	private EntityManager entityManager;

	@Override
	public void addEmployer(Employer employer) { // Insert into

		entityManager.persist(employer);

	}

	@Override
	public void deleteEmployer(int id) {

		User user = entityManager.find(User.class, id);

		entityManager.remove(user);
	}

	@Override
	public void deleteEmployer(String employerName) {

		Query query = entityManager.createQuery("delete from Employer employer where employer.name like :employerName")
				.setParameter("employerName", employerName);
		query.executeUpdate();
	}

	@Override
	public Employer updateEmployer(Employer employer) {

		employer = entityManager.merge(employer);
		return employer;
	}

	@Override
	public List<Employer> listAllEmployer() {

		Query query = entityManager.createQuery("from Employer employer"); // Requete select

		List<Employer> employers = query.getResultList();

		return employers;
	}

	@Override
	public Employer findEmployerByName(String nameUser) {

		Query query = entityManager
				.createQuery("select employer from Employer employer where employer.name like :nameUser")
				.setParameter("nameUser", nameUser);

		Employer employer = (Employer) query.getSingleResult();

		return employer;
	}

	@Override
	public List<Employer> employersBetweenTwoDate(Date dateOne, Date dateTwo) {

		Query query = entityManager
				.createQuery("from Employer AS employer where employer.dateEmbauche BETWEEN :dateOne AND :dateTwo" )
				.setParameter("dateOne", dateOne)
				.setParameter("dateTwo", dateTwo);
						
		List<Employer> employers = query.getResultList();

		return employers;
	}

	@Override
	public Employer findEmployerById(int id) {
		Query query = entityManager
				.createQuery("select employer from Employer employer where employer.idUser like :id")
				.setParameter("id", id);

		Employer employer = (Employer) query.getSingleResult();

		return employer;
	}

}
