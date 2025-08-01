package com.md.car.fleet.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.car.fleet.models.VehicleModel;
import com.md.car.fleet.services.VehicleModelService;

@Controller
public class VehicleModelController {

	@Autowired private VehicleModelService vehicleModelService;
	
	//Get All VehicleModels
	@GetMapping("fleet/vehicleModels")
	public String findAll(Model model){		
		model.addAttribute("vehicleModels", vehicleModelService.findAll());
		return "fleet/vehicleModels";
	}	
	
	@RequestMapping("/fleet/vehicleModel/{id}")
	@ResponseBody
	public Optional<VehicleModel> findById(@PathVariable Integer id)
	{
		return vehicleModelService.findById(id);
	}
	
	//Add VehicleModel
	@PostMapping(value="/fleet/vehicleModels")
	public String addNew(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/fleet/vehicleModels";
	}
	
	@RequestMapping(value="vehicleModel/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		vehicleModelService.delete(id);
		return "redirect:/fleet/vehicleModels";
	}
}
