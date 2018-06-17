package com.management.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.management.entity.Employer;
@Repository
@Transactional
public class UserImplement implements InterfaceUser {
	@PersistenceContext

	private EntityManager entityManager;
	@Override
	public String getUserLogin(Employer empolyer) {
//		empolyer= new Employer();
//		String employerName= empolyer.getLastName();// name
//		// je dois rechercher user passé en parametre
//		Query query = entityManager.createQuery("select idUser from User where user1.idUser like :"
//				+ "(select idUser from Employer employer1 where employer1.name like : employerName)")
//				.setParameter("employerName", empolyer.getName());
		// je dois retourner son login
		
		// TODO Auto-generated method stub
		return empolyer.getName();
	}

	@Override
	public String getUserPassword(Employer empolyer) {
		// TODO Auto-generated method stub
		return null;
	}

}
