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

import com.md.car.fleet.models.VehicleType;
import com.md.car.fleet.services.VehicleTypeService;

@Controller
public class VehicleTypeController {

	@Autowired private VehicleTypeService vehicleTypeService;

	//Get All VehicleTypes
	@GetMapping("/fleet/vehicleTypes")
	public String findAll(Model model){
		model.addAttribute("vehicleTypes", vehicleTypeService.findAll());
		return "fleet/vehicleTypes";
	}

	@RequestMapping("/fleet/vehicleType/{id}")
	@ResponseBody
	public Optional<VehicleType> findById(@PathVariable Integer id)
	{
		return vehicleTypeService.findById(id);
	}

	//Add VehicleType
	@PostMapping(value="/fleet/vehicleTypes")
	public String addNew(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/fleet/vehicleTypes";
	}

	@RequestMapping(value="fleet/vehicleType/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		vehicleTypeService.delete(id);
		return "redirect:/fleet/vehicleTypes";
	}

}
