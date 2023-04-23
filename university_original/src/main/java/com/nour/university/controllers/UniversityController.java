package com.nour.university.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.nour.university.entities.University;
import com.nour.university.service.UniversityService;

import java.util.List;



@Controller
public class UniversityController {
	@Autowired
	UniversityService universityService;
	
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
		return "createUniversity";
	}
	
	
	
	@RequestMapping("/saveUniversity")
	public String saveUniversity(@ModelAttribute("University") University university, 
	 @RequestParam("date") String date,
	 ModelMap modelMap) throws
	ParseException 
	{
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 university.setCreationDate(dateCreation);
	 
	 University saveUniversity = universityService.saveUniversity(university);
	String msg ="produit enregistré avec Id "+saveUniversity.getIdUniversity();
	modelMap.addAttribute("msg", msg);
	return "createUniversity";
	}
	



	@RequestMapping("/listeUniversities")
	public String listeUniversities(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size)
	{
		Page<University> universities = universityService.getAllUniversityParPage(page, size);
		modelMap.addAttribute("universities", universities);		
		modelMap.addAttribute("pages", new int[universities.getTotalPages()]);	
		modelMap.addAttribute("currentPage", page);	
		return "listeUniversities";	
	}
	

	@RequestMapping("/supprimerUniversity")
	public String supprimerUniversity(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "3") int size)
	{
		universityService.deleteUniversityById(id);
	Page<University> Universities = universityService.getAllUniversityParPage(page, size);
	modelMap.addAttribute("University", Universities);
	modelMap.addAttribute("pages", new int[Universities.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeUniversities";
	}
	

	@RequestMapping("/modifierUniversity")
	public String editerUniversity(@RequestParam("id") Long id,ModelMap modelMap)
	{
		University u=universityService.getUniversity(id);
		modelMap.addAttribute("university", u);	
		return "editerProduit";	
	}

	@RequestMapping("/updateUniversity")
	public String updateProduit(@ModelAttribute("university") University university,ModelMap modelMap) 
	{
		universityService.updateUniversity(university);
		  List<University> Universities = universityService.getAllUniversity();
		  modelMap.addAttribute("University", Universities);	
		
		return "listeUniversities";
	}

	
	
	
}