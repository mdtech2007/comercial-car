package com.md.car.fleet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.md.car.fleet.models.VehicleHire;
import com.md.car.fleet.services.VehicleHireService;
import com.md.car.fleet.services.VehicleService;
import com.md.car.parameters.services.ClientService;
import com.md.car.parameters.services.LocationService;

@Controller
public class VehicleHireController {
	
	@Autowired private VehicleHireService vehicleHireService;
	@Autowired private ClientService clientService;
	@Autowired private LocationService locationService;
	@Autowired private VehicleService vehicleService;

	public Model addModelAttributes(Model model){
		model.addAttribute("clients", clientService.findAll());
		model.addAttribute("locations", locationService.findAll());
		model.addAttribute("vehicles", vehicleService.findAll());
		return model;
	}

	//Get All VehicleHires
	@GetMapping("/fleet/hires")
	public String findAll(Model model){		
		model.addAttribute("hires", vehicleHireService.findAll());
		return "fleet/hires";
	}

	@GetMapping("/fleet/hireAdd")
	public String addHire(Model model){
		addModelAttributes(model);
		return "fleet/hireAdd";
	}

	@GetMapping("/fleet/hire/{op}/{id}")
	public String editHire(Model model, @PathVariable Integer id, @PathVariable String op){
		VehicleHire hire = vehicleHireService.findById(id);
		model.addAttribute("hire", hire);
		addModelAttributes(model);
		return "/fleet/hire"+op;
	}

	//Add VehicleHire
	@PostMapping("/fleet/hires")
	public String addNew(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/fleet/hires";
	}
	
	@RequestMapping(value="fleet/hire/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		vehicleHireService.delete(id);
		return "redirect:/fleet/hires";
	}

}
