package com.md.car.accounts.controller;

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

import com.md.car.accounts.models.InvoiceStatus;
import com.md.car.accounts.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {

	@Autowired private InvoiceStatusService invoiceStatusService;
	
	//Get All InvoiceStatuss
	@GetMapping("/accounts/invoiceStatuses")
	public String findAll(Model model){		
		model.addAttribute("invoiceStatuses", invoiceStatusService.findAll());
		return "accounts/invoiceStatuses";
	}	
	
	@RequestMapping("/accounts/invoiceStatus/{id}")
	@ResponseBody
	public Optional<InvoiceStatus> findById(@PathVariable Integer id)
	{
		return invoiceStatusService.findById(id);
	}
	
	//Add InvoiceStatus
	@PostMapping(value="/accounts/invoiceStatuses")
	public String addNew(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/accounts/invoiceStatuses";
	}	

	@RequestMapping(value="accounts/invoiceStatus/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		invoiceStatusService.delete(id);
		return "redirect:/invoiceStatuses";
	}
}
