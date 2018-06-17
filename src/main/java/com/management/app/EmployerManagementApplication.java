package com.management.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.management.dao.InterfaceEmployer;
import com.management.dao.InterfaceService;
import com.management.entity.Employer;
import com.management.entity.Service;

@SpringBootApplication
@EntityScan(basePackages = { "com.management.entity" })
@ComponentScan(basePackages = { "com.management.dao" })
@ComponentScan(basePackages = { "com.management.web" })

public class EmployerManagementApplication implements CommandLineRunner {
	@Autowired
	private InterfaceEmployer interfaceEmployer;
	@Autowired
	private InterfaceService interfaceService;

	public static void main(String[] args) {
		SpringApplication.run(EmployerManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Service service1 = new Service("a21kdl", "Informatique");
		Service service2 = new Service("bf56pd", "Vente");
		Service service3 = new Service("55sdop", "Conseil");
		Service serviceTest = new Service("dop55sop", "Depot");

		interfaceService.addService(service1);
		interfaceService.addService(service2);
		interfaceService.addService(service3);
		interfaceService.addService(serviceTest);

		List<Service> services = interfaceService.listAllService();

		System.out.println("SERVICE" + services);

		// je vais rechercher la liste des employers entre deux dates ici

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
		// je vais rechercher entre la date 2008-11-05 et 2008-11-08
		String date1 = "2008-11-09";
		String date2 = "2008-11-06";
		String date3 = "2008-11-05";
		Date dateConverted1 = null;
		Date dateConverted2 = null;
		Date dateConverted3 = null;
		try {
			dateConverted1 = simpleDateFormat.parse(date1);
			dateConverted2 = simpleDateFormat.parse(date2);
			dateConverted3 = simpleDateFormat.parse(date3);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Employer employer1 = new Employer("546", "ali546", "ali", "belhadj", dateConverted1, 280, service1);
		interfaceEmployer.addEmployer(employer1);
		Employer employer2 = new Employer("789", "rabii789", "rabii", "belhadj", dateConverted2, 208, service2);
		interfaceEmployer.addEmployer(employer2);
		Employer employer3 = new Employer("101", "abdessalem101", "abdessalem", "belhadj", dateConverted3, 900, service3);
		interfaceEmployer.addEmployer(employer3);
		
		List<Employer> employers = interfaceEmployer.employersBetweenTwoDate(dateConverted2, dateConverted1);
		System.out.println(employers);
		for (Employer employer : employers) {
			System.out.println(employer.getName());
		}
		
	}
}





