package com.ssw.ssw_complaint.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssw.ssw_complaint.service.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(path = "/admin")
public class WorkerController {

    @GetMapping(value = "dashboard") 
    public String dashboard(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userObj = (User)authentication.getPrincipal();
        System.out.println(authentication.getPrincipal());
        System.out.println(userObj.getAccess_token());
        System.out.println(userObj.getUser().getName_th());
        
        return "admin/dashboard";

    }

    @GetMapping(value = "addnewcomplaint") 
    public String addComplaint(){
        return "admin/addnewcomplaint";
    }

    @GetMapping(value = "complainttable") 
    public String complaintTable(){
        return "admin/complainttable";
    }
}