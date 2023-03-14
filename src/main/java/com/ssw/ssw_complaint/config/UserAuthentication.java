package com.ssw.ssw_complaint.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.ssw.ssw_complaint.service.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserAuthentication {
    
    public User getUserAuthenticated(){
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userAuthenObj = null;

        if (authentication != null && authentication.isAuthenticated() == true) {
            userAuthenObj = (User)authentication.getPrincipal();
        }

        log.debug(userAuthenObj.toString());
        log.debug(userAuthenObj.getAccess_token());
        log.debug(userAuthenObj.getUser().getName_th());

        return userAuthenObj;
    }
}
