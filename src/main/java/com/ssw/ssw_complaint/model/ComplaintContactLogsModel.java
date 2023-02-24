package com.ssw.ssw_complaint.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "complaint_contact_logs")
public class ComplaintContactLogsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private Integer complaint_id;
    private String description;
    private String cus_response_code; 
    private java.sql.Date contact_time;
    private String contact_type;
    private String contact_emp_id;
   
    public Integer get_id() {
        return id;
    }

    public void set_id(Integer id) {
        this.id = id;
    }

    public Integer get_complaint_id() {
        return complaint_id;
    }

    public void set_complaint_id(Integer complaint_id) {
        this.complaint_id = complaint_id;
    }  

    public String get_description() {
        return description;
    }

    public void set_description(String description) {
        this.description = description;
    }

    public String get_cus_response_code() {
        return cus_response_code;
    }

    public void set_cus_response_code(String cus_response_code) {
        this.cus_response_code = cus_response_code;
    }

    public java.sql.Date get_contact_time() {
        return contact_time;
    }

    public void set_contact_time(java.sql.Date contact_time) {
        this.contact_time = contact_time;
    }

    public String get_contact_type() {
        return contact_type;
    }

    public void set_contact_type(String contact_type) {
        this.contact_type = contact_type;
    }

    public String get_contact_emp_id() {
        return contact_emp_id;
    }

    public void set_contact_emp_id(String contact_emp_id) {
        this.contact_emp_id = contact_emp_id;
    }

    
}
