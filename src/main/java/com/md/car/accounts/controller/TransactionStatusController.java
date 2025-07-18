package com.md.car.accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.car.accounts.models.TransactionStatus;
import com.md.car.accounts.services.TransactionStatusService;

@Controller
public class TransactionStatusController {

    @Autowired
    private TransactionStatusService transactionStatusService;

    @GetMapping("/accounts/transactionStatuses")
    public String parameters(Model model){
        List<TransactionStatus> transactionStatuses = transactionStatusService.findAll();
        model.addAttribute("transactionStatuses", transactionStatuses);
        return "/accounts/transactionStatuses";
    }

    //Get Job Title by id
    @GetMapping("/accounts/transactionStatus/{id}")
    @ResponseBody
    public TransactionStatus getById(@PathVariable Integer id){
        return transactionStatusService.findById(id).orElse(null);
    }

    @PostMapping("/accounts/transactionStatuses")
    public String save(TransactionStatus transactionStatus){
        transactionStatusService.save(transactionStatus);
        return "redirect:/accounts/transactionStatuses";
    }

    @RequestMapping(value="/accounts/transactionStatus/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        transactionStatusService.delete(id);
        return "redirect:/accounts/transactionStatus";
    }
}
