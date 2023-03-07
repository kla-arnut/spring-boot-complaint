package com.ssw.ssw_complaint.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
    
    @GetMapping(value = {"", "/", "index.html", "index", "home", "home.html", "dashboard", "dashboard.html"})
    public String home(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute("token") != null) {
            return "/dashboard";             
        }
        
        return "redirect:/auth/login";
    }

    @GetMapping(value = "add-complaint") 
    public String addComplaint(){
        return "add-complaint";
    }
}