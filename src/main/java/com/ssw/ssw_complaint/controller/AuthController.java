package com.ssw.ssw_complaint.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import com.ssw.ssw_complaint.service.User;



@Controller
public class AuthController {
    
    @GetMapping("/auth/login")
    public String home(HttpServletRequest request) throws ServletException, IOException {
        return "/auth/login";
    }

    // @PostMapping(value = {"/auth/login"})
    // public String checkLogin(HttpServletRequest request, HttpServletResponse response, @RequestParam String username, @RequestParam String password, Model model) {

    //     // request url
    //     String reqUrl = "http://10.1.27.24:8090/ssw_arunsawad_api/api/login";
        
    //     // create an instance of RestTemplate
    //     RestTemplate restTemplate = new RestTemplate();

    //     //setting up the request headers
    //     HttpHeaders requestHeaders = new HttpHeaders();
    //     requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

    //     // request body parameters
    //     Map<String, String> paramMap = new HashMap<>();
    //     paramMap.put("username", username);
    //     paramMap.put("password", password);
    //     paramMap.put("check", "Y");
    //     paramMap.put("fcm_token", "");
    //     paramMap.put("uid", "");

    //     //request entity is created with request body and headers
    //     HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(paramMap, requestHeaders);

    //     // send POST request to login
    //     ResponseEntity<User> responseEntity = restTemplate.exchange(
    //             reqUrl,
    //             HttpMethod.POST,
    //             requestEntity,
    //             User.class
    //     );

    //     // if login success 200 OK
    //     if(responseEntity.getStatusCode() == HttpStatus.OK){
    //         System.out.println(HttpStatus.OK);
    //         User userObj = responseEntity.getBody();
    //         System.out.println(userObj.getMessage());
    //         System.out.println(userObj.getStatus());
    //         System.out.println(userObj.getAccess_token());
    //         System.out.println(userObj.getToken_type());
    //         System.out.println(userObj.getUser().getId());
    //         System.out.println(userObj.getUser().getName_th());

    //         HttpSession session = request.getSession();
    //         session.setAttribute("token", "mySession");
    //         Cookie cookie = new Cookie("sessionId", session.getId());
    //         /*cookie.setMaxAge(30 * 60); //---> Set cookie expiry time to 30 minutes */
    //         cookie.setSecure(true);
    //         cookie.setHttpOnly(true);
    //         cookie.setPath("/");
    //         response.addCookie(cookie);

    //         return "redirect:/dashboard";
    //     }

       


    //     model.addAttribute("loginError", "Credential not match");
    //     return "/auth/login";
    // }
    
    // @GetMapping(value = "/auth/logout")
    // public String logout(HttpSession session,HttpServletResponse response) {
    //     session.invalidate(); // close session

    //     Cookie cookie = new Cookie("token", "mySession");
    //     cookie.setMaxAge(0); // set expire now
    //     cookie.setSecure(true);
    //     cookie.setHttpOnly(true);
    //     cookie.setPath("/");
    //     response.addCookie(cookie);

    //     return "redirect:/auth/login"; //redirect to login 
    // }    

}