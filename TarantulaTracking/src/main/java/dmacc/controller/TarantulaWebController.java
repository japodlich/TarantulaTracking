package dmacc.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Tarantula;
import dmacc.repository.TarantulaRepository;



@Controller
public class TarantulaWebController {

	@Autowired
	TarantulaRepository tRepo;
	
	
	@GetMapping("/viewAll")
	public String viewAllTarantulas(Model model) {
		
	if(tRepo.findAll().isEmpty()) 
		{
		return addNewTarantula(model);
		}
	model.addAttribute("tarantulas", tRepo.findAll());
	return "ListTarantulas";   //ListTarantulas.html

	}
	
	@GetMapping("/inputTarantula")
	//new tarantula is created before it is validated in HTML
	public String addNewTarantula(Model model) {
	Tarantula t = new Tarantula();
	model.addAttribute("newTarantula", t);
	return "inputTarantula";
	}
	
	@PostMapping("/inputTarantula")
	public String addNewContact(@ModelAttribute Tarantula t,Model model) {
	tRepo.save(t);
	return viewAllTarantulas(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateContact(@PathVariable("id") long id,Model model) {
	Tarantula t = tRepo.findById(id).orElse(null);
	model.addAttribute("newTarantula", t);
	return "inputTarantula";
	}
	
	@PostMapping("/update/{id}")
	public String reviseTarantula(Tarantula t, Model model) {
	tRepo.save(t);
	return viewAllTarantulas(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTarantula(@PathVariable("id") long id, Model model) 
	{
	Tarantula t = tRepo.findById(id).orElse(null);
	tRepo.delete(t);
	return viewAllTarantulas(model);
	
	}
	
	@GetMapping("/listMoltsByTId/{id}")
	public String viewManeuversByAppId(@PathVariable("id") long id, Model model) 
	{
		
		/*
	Tarantula t = tRepo.findById(id).orElse(null);
	List<Tarantula> listByApp=new ArrayList<Maneuver>();
	for (Maneuver m : mRepo.findAll())
	{
		if(t.getId() == m.getTarantula().getId())
		{
		listByApp.add(m);
		}
	} 
	
	
	ManeuverAttribute mAttribute = new ManeuverAttribute(id, listByApp);
	//create a new object with appID(type long), and lisyByApp array (type list)
	//passobject as attribute
	
	//on html, attribute.appID will be the app id
	//attricubute.listByApp for each will be the iteration
	*/
	

	//model.addAttribute("MoltAttribute", mAttribute);
	return "ListMolts";
	
	}
	

}
