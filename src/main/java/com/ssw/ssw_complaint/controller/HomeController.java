package com.ssw.ssw_complaint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;

@Slf4j
@Controller
public class HomeController {

    @Autowired

    @GetMapping(value = {"/","home","index","index.html"})
    public String home() {
        return "dashboard";
    }

    @GetMapping(value = "add-complaint") 
    public String addComplaint(){
        return "add-complaint";
    }
}