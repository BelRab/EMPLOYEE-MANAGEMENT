package com.management.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.management.dao.InterfaceEmployer;
import com.management.dao.InterfaceService;
import com.management.entity.Employer;
import com.management.entity.Service;

@Controller
public class AppController {
	@Autowired
	private InterfaceService interfaceService;
	@Autowired
	private InterfaceEmployer interfaceEmployer;
	private Service service;

	// GESTION DES EMPLOYÉS
	@RequestMapping("/gestion_employe")
	public String afficherEmployer(Model model) {

		List<Employer> employers = interfaceEmployer.listAllEmployer();
		List<Service> services = interfaceService.listAllService();

		model.addAttribute("employers", employers);
		if (services != null) {
			model.addAttribute("services", services);
		}

		return "employe";
	}

	// AJOUTER UN NOUVEAU EMPLOYÉ

	@RequestMapping(value = { "/gestion_employe" }, method = RequestMethod.POST)

	public String AjouterEmployer(Model model, @RequestParam(name = "name") String name,
			@RequestParam(name = "lastName") String lastName, @RequestParam(name = "salary") double salary,
			@RequestParam(name = "libelleService") String libelleService,
			@RequestParam(name = "dateEmbauche") String dateEmbauche, @RequestParam(name = "login") String login,
			@RequestParam(name = "password") String password) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");

		Date dateConverted = null;
		try {
			dateConverted = simpleDateFormat.parse(dateEmbauche);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Service service = interfaceService.findByServiceLibelle(libelleService);
		Employer employer = new Employer(login, password, name, lastName, dateConverted, salary, service);

		interfaceEmployer.addEmployer(employer);
		List<Employer> employers = interfaceEmployer.listAllEmployer();

		model.addAttribute("employers", employers);
		return "employe";
	}

	// DELETE EMPLOYER

	@RequestMapping(value = { "/delete_employe" }, method = RequestMethod.GET)

	public String deleteEmployer(Model model, @RequestParam(name = "firstName") String firstName) {

		interfaceEmployer.deleteEmployer(firstName);

		return "redirect:/gestion_employe";
	}

	// AFFICHAGE DE LA FORMULAIRE UPDATE EMPLOYER
	@RequestMapping(value = { "/form_update_employer" }, method = RequestMethod.GET)

	public String form_update_employer(Model model, @RequestParam(name = "idUser") int idUser) {

		Employer employer = interfaceEmployer.findEmployerById(idUser);
		List<Service> services = interfaceService.listAllService();

		model.addAttribute("employer", employer);
		model.addAttribute("services", services);

		return "updateEmploye";

	}

	// UPDATE EMPLOYER
	@RequestMapping(value = { "/update_employe" }, method = RequestMethod.POST)

	public String updateEmployer(Model model, @RequestParam(name = "idUser") int idUser,
			@RequestParam(name = "name") String name, @RequestParam(name = "lastname") String lastname,
			@RequestParam(name = "salary") double salary, @RequestParam(name = "libelleService") String libelleService,
			@RequestParam(name = "dateEmbauche") String dateEmbauche, @RequestParam(name = "login") String login,
			@RequestParam(name = "password") String password) {

		Employer employer = interfaceEmployer.findEmployerById(idUser);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");

		Date dateConverted = null;
		try {
			dateConverted = simpleDateFormat.parse(dateEmbauche);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		employer.setName(name);
		employer.setLastName(lastname);
		employer.setSalary(salary);
		Service service = interfaceService.findByServiceLibelle(libelleService);
		employer.setService(service);
		employer.setDateEmbauche(dateConverted);
		employer.setLogin(login);
		employer.setPassword(password);

		interfaceEmployer.updateEmployer(employer);

		return "redirect:/gestion_employe";
	}

	// AFFICHAGE DE SERVICE
	@RequestMapping("/gestion_service")
	public String afficherService(Model model) {

		List<Service> services = interfaceService.listAllService();

		model.addAttribute("services", services);
		return "service";
	}

	// AJOUTER UN NOUVEAU SERVICE
	@RequestMapping(value = { "/gestion_service" }, method = RequestMethod.POST)

	public String AjouterService(Model model, @ModelAttribute(value="formService") Service service,BindingResult result) {

//		service = new Service(service.getCode(), s);

		
		
		interfaceService.addService(service);

		List<Service> services = interfaceService.listAllService();

		model.addAttribute("services", services);

		return "service";

	}

	// AFFICHAGE LA PAGE UPDATE SERVICE
	@RequestMapping(value = { "/afficher_service" }, method = RequestMethod.GET)
	public String afficher_service(Model model, @RequestParam(name = "idService") int idService) {

		Service service = interfaceService.findServiceById(idService);
		model.addAttribute("service", service);

		return "updateService";
	}

	// FAIRE L'UPDATE DE SERVICE
	@RequestMapping(value = { "/update_service" }, method = RequestMethod.POST)
	public String update_service(Model model, @RequestParam(name = "libelle") String libelle,
			@RequestParam(name = "code") String code, @RequestParam(name = "idService") int idService) {

		service = interfaceService.findServiceById(idService);
		service.setCode(code);
		service.setLibelle(libelle);
		interfaceService.updateService(service);

		return "redirect:/gestion_service";
	}

	// DELETE UN SERVICE
	@RequestMapping(value = { "/delete_service" }, method = RequestMethod.GET)

	public String deleteService(Model model, @RequestParam(name = "idService") int idService) {

		service = interfaceService.findServiceById(idService);
		interfaceService.deleteService(service);

		return "redirect:/gestion_service";
	}

	// AFFICHER PAGE DE RECHERCHE DE SERVICE

	@RequestMapping(value = { "/recherche_service" }, method = RequestMethod.GET)
	public String afficherPageRechercheServcie(Model model) {

		List<Service> services = interfaceService.listAllService();
		model.addAttribute("services", services);

		return "recherche_service";
	}

	// RECHERCHER UN SERVICE

	@RequestMapping(value = { "/recherche_Employer_par_service" }, method = RequestMethod.GET)
	public String rechercheEmployeAvecLibelleEntreEnParametre(Model model,
			@RequestParam(name = "valService", required = false) String valService) {

		List<Employer> employers = interfaceService.findEmployersWithService(valService);
		List<Service> services = interfaceService.listAllService();
		model.addAttribute("services", services);

		model.addAttribute("employers", employers);

		return "recherche_service";
	}

	// AFFICHAGE DE LA PAGE DEUX DATES
	@RequestMapping("/deux_dates")
	public String afficherDeuxDates() {

		return "deuxdates";

	}

	// RECHERCHER LES EMPLOYÉS ENTRE DEUX

	@RequestMapping(value = { "/deux_dates" }, method = RequestMethod.POST)
	public String rechercherEmployerEntre2Dates(Model model, @RequestParam(name = "dateStart") String dateStart,
			@RequestParam(name = "dateEnd") String dateEnd) {
		// conversion de deux dates
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");

		Date dateConverted1 = null;
		Date dateConverted2 = null;
		try {
			dateConverted1 = simpleDateFormat.parse(dateStart);
			dateConverted2 = simpleDateFormat.parse(dateEnd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<Employer> employers = interfaceEmployer.employersBetweenTwoDate(dateConverted1,dateConverted2);

		if(employers.isEmpty()) {
			model.addAttribute("erreur", "Il n'existe aucun employer entre ces deux dates, merci de reessayer!");
		}else {
			model.addAttribute("employers", employers);
		}
		return "deuxdates";
	}

	// AFFICHAGE DE LA PAGE STATISTIQUES
	@RequestMapping("/statistiques")
	public String afficherStatistiques() {

		return "stats";

	}

}
