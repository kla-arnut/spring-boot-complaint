package com.ssw.ssw_complaint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ssw.ssw_complaint.config.UserAuthentication;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(path = "/admin")
public class WorkerController {
    
    @GetMapping(value = "dashboard") 
    public String dashboard(Model model){
        // to get user is loged in in method
        // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // User userObj = (User)authentication.getPrincipal();
        // System.out.println(authentication.getPrincipal());
        // System.out.println(userObj.getAccess_token());
        // System.out.println(userObj.getUser().getName_th());
        UserAuthentication userAuthen = new UserAuthentication();
        model.addAttribute("nameTH", userAuthen.getUserAuthenticated().getUser().getName_th());
        model.addAttribute("nameEN", userAuthen.getUserAuthenticated().getUser().getName_en());
        model.addAttribute("empID", userAuthen.getUserAuthenticated().getUser().getEmployee_id());
        model.addAttribute("branchCode", userAuthen.getUserAuthenticated().getUser().getBranch_code());
        return "admin/dashboard";
    }

    @GetMapping(value = "addnewcomplaint") 
    public String addComplaint(){
        return "admin/addnewcomplaint";
    }

    @PostMapping(value = "addnewcomplaint") 
    public String doAddComplaint(){
        return "admin/addnewcomplaint";
    }

    @GetMapping(value = "complainttable") 
    public String complaintTable(){
        return "admin/complainttable";
    }
}