package com.md.car.hr.controllers;

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

import com.md.car.hr.models.JobTitle;
import com.md.car.hr.services.JobTitleService;

@Controller
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping("/hr/jobTitles")
    public String parameters(Model model){
        List<JobTitle> jobTitles = jobTitleService.findAll();
        model.addAttribute("jobTitles", jobTitles);
        return "hr/jobTitles";
    }

    //Get Job Title by id
    @GetMapping("/hr/jobTitle/{id}")
    @ResponseBody
    public JobTitle getById(@PathVariable Integer id){
        return jobTitleService.findById(id).orElse(null);
    }

    @PostMapping("/hr/jobTitles")
    public String save(JobTitle jobTitle){
        jobTitleService.save(jobTitle);
        return "redirect:/hr/jobTitles";
    }

    @RequestMapping(value="/hr/jobTitle/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        jobTitleService.delete(id);
        return "redirect:/hr/jobTitles";
    }
}
