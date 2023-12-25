package ca.sheridancollege.heidarik.controllers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ca.sheridancollege.heidarik.beans.Furnace;
import ca.sheridancollege.heidarik.database.DatabaseAccess;

@Controller
public class HomeController {
//	@GetMapping("/")
//	public String index() {
//	return "index";
//	}
	//final boolean user = true; 
	List<Furnace> appointmentList = new CopyOnWriteArrayList<Furnace>();
	
	@Autowired
	private DatabaseAccess da;
	
	@GetMapping("/secure/index")
	public String secureIndex() {
	return "secure/index";
	}
	@GetMapping("/login")
	public String login() {
	return "login";
	}
	@GetMapping("/permission-denied")
	public String permissionDenied() {
	return "/error/permission-denied";
	}
	@GetMapping("/secure/viewFurnace/{id}")
	public String viewFernace(@PathVariable Long id) {
	    
	    String viewName = "secure/viewFurnace" + id;
	    return viewName;
	}



	
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute Furnace furnace ) {
		model.addAttribute("furnace" , new Furnace());
		da.insertFurnace(furnace);
//		model.addAttribute("user",user);
		model.addAttribute("furnaceList", da.getFurnaceList());
		return "secure/index";
	}

	
	@GetMapping("/secure/deleteFurnaceById/{id}")
	public String deleteFurnaceById(Model model, @PathVariable Long id) {
	da.deleteFurnaceById(id);
	model.addAttribute("furnace" , new Furnace());
	model.addAttribute("furnaceList", da.getFurnaceList());
	return "secure/index";
	}
	
	
	@GetMapping("/secure/editFurnaceById/{id}")
	public String editFurnaceById(Model model, @PathVariable Long id) {
	// Retrieve the book by ID
	Furnace furnace = da.getFurnaceListById(id).get(0);
	// Add the book to the model
	model.addAttribute("furnace", furnace);
	return "secure/index";
	}
	
	


	@PostMapping("/secure/insertFurnace")
	public String insertFurnace(Model model, @ModelAttribute Furnace furnace) {
		
		
		List<Furnace> existingFurnace = da.getFurnaceListById(furnace.getId());
		
		if (existingFurnace.isEmpty()) {
	        // If the book doesn't exist (based on ID), insert a new appointment
	        da.insertFurnace(furnace);
	    } else {
	        // If the book exists, update the existing appointment
	        da.updateFurnace(furnace);
	    }
		
		model.addAttribute("furnace", new Furnace());
		model.addAttribute("furnaceList", da.getFurnaceList());
		
		
		return "secure/index";
	}
	
	@GetMapping("/secure/updateFurnace")
	public String updateBooksById(Model model, @PathVariable Long id) {
		
		Furnace furnace = da.getFurnaceListById(id).get(0);
		
		da.updateFurnace(furnace);
		
		model.addAttribute("furnace", furnace);
		model.addAttribute("furnaceList", da.getFurnaceList());
		
		return "secure/index";
	}
	
	@GetMapping("/book/{id}")
	public String showFurnaceById(Model model, @PathVariable Long id) {
	return "secure/index";
	}
	
}