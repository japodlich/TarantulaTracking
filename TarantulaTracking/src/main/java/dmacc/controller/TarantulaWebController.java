package dmacc.controller;

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
	public String reviseContact(Tarantula t, Model model) {
	tRepo.save(t);
	return viewAllTarantulas(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
	Tarantula t = tRepo.findById(id).orElse(null);
	tRepo.delete(t);
	return viewAllTarantulas(model);
	
	}
	

}
