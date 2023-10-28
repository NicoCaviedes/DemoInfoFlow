package com.quatrosphere.apipublica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
*/

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
    /*
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth -> {
            // auth.requestMatchers("/","/login","/register","/assets/**","/css/**","/js/**").permitAll();
            // auth.requestMatchers("/dashboard/emp", "/dashboard/emp/**").hasAnyRole(RolesDatabase.ADMIN.name(),RolesDB.EMP.name());
            // auth.requestMatchers("/dashboard/admin","/dashboard/admin/**").hasRole(RolesDB.ADMIN.name());
            // auth.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll();
            auth.anyRequest().permitAll();
        })
        .formLogin(form -> {
            form.loginPage("/login");
            form.loginProcessingUrl("/login");
            form.usernameParameter("email");
            form.defaultSuccessUrl("/", true);
            form.permitAll(true);
        })
        .logout(logout -> {
            logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
            logout.logoutSuccessUrl("/");
            logout.invalidateHttpSession(true);
            logout.deleteCookies("JSESSIONID");
            logout.permitAll(true);
        })
        .exceptionHandling(excepHandling -> {
            excepHandling.authenticationEntryPoint(new Http403ForbiddenEntryPoint());
        })
        .sessionManagement(sessionMnger ->{
            sessionMnger.maximumSessions(3);
        })
        .build();
    }
    */
}
