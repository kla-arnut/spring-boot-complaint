package com.ssw.ssw_complaint.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class User {
    private String status;
    private String message;
    private String access_token;
    private String token_type;
    private UserProp user;
}
