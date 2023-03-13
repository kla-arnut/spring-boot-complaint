package com.ssw.ssw_complaint.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter.Directive;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private SSWAuthenticationManager authenticationManager;

    public static final String[] ENDPOINTS_WHITELIST = {"/css/**","/js/**","/img/**","/","/home","/index","/auth/login","/admin/**"};
    public static final String LOGIN_URL = "/auth/login";
    public static final String LOGOUT_URL = "/auth/logout";
    public static final String LOGIN_FAIL_URL = LOGIN_URL + "?error";
    public static final String DEFAULT_SUCCESS_URL = "/admin/dashboard";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String COOKIE_NAME = "JSESSIONID";
    public static final String LOGOUT_SUCCESS_URL = LOGIN_URL + "?logout";
    public static final String INVALID_SESSION_URL = "/auth/invalidsession";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.
                authorizeHttpRequests ()
                    .requestMatchers(ENDPOINTS_WHITELIST).permitAll()
                    .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin()
                    .loginPage(LOGIN_URL)
                    .loginProcessingUrl(LOGIN_URL)
                    .failureUrl(LOGIN_FAIL_URL)
                    .usernameParameter(USERNAME)
                    .passwordParameter(PASSWORD)
                    .defaultSuccessUrl(DEFAULT_SUCCESS_URL,true)
                .and()
                .logout()
                    .logoutUrl("/auth/logout")
                    .invalidateHttpSession(true)
                    .deleteCookies(COOKIE_NAME)
                    .logoutSuccessUrl(LOGIN_URL + "?logout")
                .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                    .invalidSessionUrl(INVALID_SESSION_URL)
                    .maximumSessions(1)
                    .maxSessionsPreventsLogin(true);

        http.addFilter(new BasicAuthenticationFilter(authenticationManager)); 
        return http.build();
    }
}
