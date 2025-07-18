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

import com.md.car.fleet.models.VehicleStatus;
import com.md.car.fleet.services.VehicleStatusService;

@Controller
public class VehicleStatusController {
	
	@Autowired private VehicleStatusService vehicleStatusService;
	
	//Get All VehicleStatuss
	@GetMapping("/fleet/vehicleStatuses")
	public String findAll(Model model){		
		model.addAttribute("vehicleStatuses", vehicleStatusService.findAll());
		return "/fleet/vehicleStatuses";
	}	
	
	@RequestMapping("/fleet/vehicleStatus/{id}")
	@ResponseBody
	public Optional<VehicleStatus> findById(@PathVariable Integer id)
	{
		return vehicleStatusService.findById(id);
	}
	
	//Add VehicleStatus
	@PostMapping(value="/fleet/vehicleStatuses")
	public String addNew(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/fleet/vehicleStatuses";
	}	

	@RequestMapping(value="fleet/vehicleStatus/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		vehicleStatusService.delete(id);
		return "redirect:/fleet/vehicleStatuses";
	}
}
