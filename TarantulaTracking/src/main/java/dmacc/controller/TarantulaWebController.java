package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Tarantula;
import dmacc.repository.TarantulaRepository;



@Controller
public class TarantulaWebController {

	@Autowired
	TarantulaRepository tRepo;
	
	
	@GetMapping("/viewAll")
	public String viewAllTarantulas(Model model) {
	model.addAttribute("tarantulas", tRepo.findAll());
	return "ListTarantulas";   //ListTarantulas.html

	}
	
	@GetMapping("/inputTarantula")
	public String addNewContact(Model model) {
	Tarantula t = new Tarantula();
	model.addAttribute("newTarantula", t);
	return "inputTarantula";
	}
	
	@PostMapping("/inputTarantula")
	public String addNewContact(@ModelAttribute Tarantula t,Model model) {
	tRepo.save(t);
	return viewAllTarantulas(model);
	}

}
