package com.ssw.ssw_complaint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PathVariable;

import com.ssw.ssw_complaint.model.ComplaintModel;
import com.ssw.ssw_complaint.service.ComplaintService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/complaint")
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;

    @RequestMapping(value = {"","/"}, produces = "application/json")
    @ResponseBody
    public String getGreetingWhileReturnTypeIsString() {
        return "{\"success\": true}";
    }

    @PostMapping(value = "/create")
    public ComplaintModel create(@RequestBody ComplaintModel complaint) {
        return complaintService.create(complaint);
    }

    @GetMapping(value = "/get/all")
    public List<ComplaintModel> get() {
        return complaintService.get();
    }

    @GetMapping(value = "/get/{complaintId:\\d+}")
    public Optional<ComplaintModel> find(@PathVariable(value = "complaintId") Integer id) {
        return complaintService.find(id);
    }

    @PutMapping(value = "/update/{complaintId:\\d+}")
    public ComplaintModel read(@PathVariable(value = "complaintId") Integer id,@RequestBody ComplaintModel complaintDetails) {
        return complaintService.update(id, complaintDetails);
    }

    @DeleteMapping(value = "/delete/{complaintId:\\d+}")
    public void delete(@PathVariable(value = "complaintId") Integer id) {
        complaintService.delete(id);
    }

    @DeleteMapping(value = "/test")
    public void test(@PathVariable(value = "complaintId") Integer id) {
        complaintService.delete(id);
    }


}
