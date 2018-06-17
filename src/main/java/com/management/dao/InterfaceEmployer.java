package com.management.dao;

import java.util.Date;
import java.util.List;

import com.management.entity.Employer;

public interface InterfaceEmployer {

	public void addEmployer(Employer employer);

	public void deleteEmployer(int id);

	public void deleteEmployer(String employerName);

	public Employer updateEmployer(Employer employer);

	public List<Employer> listAllEmployer();

	public Employer findEmployerByName(String name);
	
	public Employer findEmployerById(int id);
	
	public List<Employer> employersBetweenTwoDate(Date dateOne, Date dateTwo);

}
