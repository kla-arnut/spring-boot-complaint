package com.ssw.ssw_complaint.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.buf.Utf8Encoder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import io.micrometer.core.instrument.util.StringEscapeUtils;



@Controller
public class AuthController {
    
    @GetMapping(value = {"/auth/login"})
    public String home(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession(false); //we instantiate the interface HttpSession first and check if session is not already tokenized.
        if(session != null && session.getAttribute("token") != null) { //if token already assigned to session
            return "redirect:/dashboard"; //go to dashboard
        }
        return "/auth/login"; //else go to login
    }

    @PostMapping(value = {"/auth/login"})
    public String checkLogin(HttpServletRequest request, HttpServletResponse response, @RequestParam String username, @RequestParam String password, Model model) {
        
        // request url
        String reqUrl = "http://10.1.27.24:8090/ssw_arunsawad_api/api/login";
        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        // request body parameters
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("username", username);
        paramMap.put("password", password);
        // send POST request
        ResponseEntity<String> result = restTemplate.postForEntity(reqUrl, paramMap , String.class);
        // check response
        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

        if (result.getStatusCode().toString().equals("200 OK")) {
            HttpSession session = request.getSession();
            session.setAttribute("token", "mySession");
            
            Cookie cookie = new Cookie("sessionId", session.getId());
            /*cookie.setMaxAge(30 * 60); //---> Set cookie expiry time to 30 minutes */
            cookie.setSecure(true);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            response.addCookie(cookie);

            return "redirect:/dashboard";
        }
        
        model.addAttribute("loginError", "Credential not match");
        return "/auth/login";
    }
    
    @GetMapping(value = "/auth/logout")
    public String logout(HttpSession session,HttpServletResponse response) {
        session.invalidate(); // close session

        Cookie cookie = new Cookie("token", "mySession");
        cookie.setMaxAge(0); // set expire now
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);

        return "redirect:/auth/login"; //redirect to login 
    }    

}