package com.md.car.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.md.car.accounts.repositories.TransactionRepository;
import com.md.car.hr.repositories.EmployeeRepository;

@Controller
public class ReportsController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/reports/vehicles")
    public String vehicles() {
        return "/reports/vehicles";
    }

    @GetMapping("/reports/accounts")
    public String accounts(Model model) {
        model.addAttribute("transactions", transactionRepository.findAll());
        model.addAttribute("employeeCount", employeeRepository.getCountByCountry());
        return "/reports/accounts";
    }

    @GetMapping("/reports/hires")
    public String hires(){
        return "/reports/hires";
    }

    @GetMapping("/reports/helpdesk")
    public String helpdesk(){
        return "/reports/helpdesk";
    }

    @GetMapping("/reports/maintenance")
    public String maintenance(){
        return "/reports/maintenance";
    }
}
