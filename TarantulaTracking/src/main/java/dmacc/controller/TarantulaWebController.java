package dmacc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Molt;
import dmacc.beans.Tarantula;
import dmacc.repository.MoltRepository;
import dmacc.repository.TarantulaRepository;



@Controller
public class TarantulaWebController {

	@Autowired
	TarantulaRepository tRepo;
	MoltRepository mRepo;
	
	
	//@GetMapping("/viewAll")
	@GetMapping({"/", "viewAll"})
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
	public String viewMoltsByTId(@PathVariable("id") long id, Model model) 
	{
		//use molt repository to list molt based on tarantula ids
		//pass list to html as attribute
		List<Molt> allMoltsbytId = mRepo.findBytId(id);
		model.addAttribute("moltbytId", allMoltsbytId);
		return "ListMolts";
	/*	
	Tarantula t = tRepo.findById(id).orElse(null);
	List<Molt> listByT=new ArrayList<Molt>();
	for (Molt m : mRepo.findAll())
	{
		if(t.getId() == m.getTarantula().getId())
		{
		listByT.add(m);
		}
	} 
	
	
	//MoltAttribute mAttribute = new MoltAttribute(id, listByApp);
	//create a new object with appID(type long), and lisyByApp array (type list)
	//passobject as attribute
	
	//on html, attribute.appID will be the app id
	//attricubute.listByApp for each will be the iteration
	
	

	model.addAttribute("moltsByT", listByT);
	
	*/
	
	
	}
	
	@GetMapping ("/inputAMolt/{id}")
	public String addNewManeuver (@PathVariable("id") long id, Model model) 
	{
	Tarantula t = tRepo.findById(id).orElse(null);
	Molt m = new Molt(t);
	model.addAttribute("newMolt", m);
	return "inputMolt";  //earlier, this said "index" and it was not working
	}
	

}
