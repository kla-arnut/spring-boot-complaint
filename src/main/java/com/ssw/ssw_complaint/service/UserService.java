package com.ssw.ssw_complaint.service;

import com.ssw.ssw_complaint.model.User;

import java.util.List;

public interface UserService {
    public void saveUser(User user);
    public List<Object> isUserPresent(User user);
}