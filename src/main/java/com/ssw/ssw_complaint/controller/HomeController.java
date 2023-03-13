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
    
    @GetMapping(value = { "/", "home", "home.html", "index", "index.html"})
    public String home(HttpServletRequest request) throws ServletException, IOException {
        return "/homepage"; 
    }
}