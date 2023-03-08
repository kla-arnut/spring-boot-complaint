package com.ssw.ssw_complaint.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class UserProp {
    private Integer id;
    private String name_th;
    private String name_en;
    private String email;
    private String email_verified_at;
    private String register_id;
    private String username;
    private String employee_id;
    private String access_token;
    private String mobile_phone;
    private String position;
    private String level;
    private String branch_code;
    private String start_date;
    private String status;
    private String deleted;
    private String jwt_token;
    private String insurance_plan;
}
