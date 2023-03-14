package com.ssw.ssw_complaint.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.ssw.ssw_complaint.service.User;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.HttpStatusCodeException;


@Component
@Slf4j
public class SSWAuthenticationManager implements AuthenticationManager {

    private String username = "";
    private String password = "";
    @Value("${app.api.loginurl}") private String loginurl;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        username = String.valueOf(authentication.getName());
        password = String.valueOf(authentication.getCredentials());

        User user = loginToSSWAPI(username, password) ;
        if (user != null) {
            UsernamePasswordAuthenticationToken authenticationToken;
            authenticationToken = new UsernamePasswordAuthenticationToken(user, null, getAuthorities());  
      
            return authenticationToken;
        }

        return null;

       
    }

    private User loginToSSWAPI(String username, String password) {

        log.debug("login url "+loginurl);
        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
        // setting up the request headers
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        // request body parameters
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("username", username);
        paramMap.put("password", password);
        paramMap.put("check", "Y");
        paramMap.put("fcm_token", "");
        paramMap.put("uid", "");
        // request entity is created with request body and headers
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(paramMap, requestHeaders);
        // send POST request to login
        ResponseEntity<User> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(loginurl, HttpMethod.POST, requestEntity, User.class);
        }
        catch(HttpStatusCodeException ex) {
            log.warn(ex.toString());
            log.warn(ex.getStatusCode().toString());
            return null;
        }
        catch(Exception ex) {
            log.warn(ex.toString());
            return null;
        }

        // TODO handle if response status is not 200OK
        // if login success 200 OK
        User userObj = null;
        if(responseEntity.getStatusCode() == HttpStatus.OK && responseEntity.getBody() != null){
            userObj = responseEntity.getBody();
            log.debug(userObj.toString());
            log.debug("user "+userObj.getUser().getName_th()+" loged in");
        }

        return userObj;
    }

    private List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<String> roles = Arrays.asList("ADMIN", "USER");
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));

        return authorities;
    }

    // Override timeouts in request factory
    private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(10000); // 10sec
        clientHttpRequestFactory.setReadTimeout(10000); // 10sec

        return clientHttpRequestFactory;
    }


}