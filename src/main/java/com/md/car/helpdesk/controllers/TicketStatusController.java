package com.md.car.helpdesk.controllers;

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

import com.md.car.helpdesk.models.TicketStatus;
import com.md.car.helpdesk.services.TicketStatusService;

@Controller
public class TicketStatusController {

	@Autowired private TicketStatusService ticketStatusService;
	
	//Get All TicketStatuss
	@GetMapping("/helpdesk/ticketStatuses")
	public String findAll(Model model){		
		model.addAttribute("ticketStatuses", ticketStatusService.findAll());
		return "/helpdesk/ticketStatuses";
	}	
	
	@RequestMapping("/helpdesk/ticketStatus/{id}")
	@ResponseBody
	public Optional<TicketStatus> findById(@PathVariable Integer id)
	{
		return ticketStatusService.findById(id);
	}
	
	//Add TicketStatus
	@PostMapping(value="/helpdesk/ticketStatuses")
	public String addNew(TicketStatus ticketStatus) {
		ticketStatusService.save(ticketStatus);
		return "redirect:/helpdesk/ticketStatuses";
	}
	
	@RequestMapping(value="helpdesk/ticketStatus/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		ticketStatusService.delete(id);
		return "redirect:/helpdesk/ticketStatuses";
	}
}
