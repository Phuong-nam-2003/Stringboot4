package com.example.assignmentspringsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("securityDataSource")
    private DataSource securityDataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(securityDataSource);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/tickets/showForm*").hasAnyRole("MANAGER","ADMIN")
                .antMatchers("/tickets/save*").hasAnyRole("MANAGER","ADMIN")
                .antMatchers("/tickets/**").hasAnyRole("EMPLOYEE","ADMIN","MANAGER")
                .antMatchers("/tickets/delete").hasRole("ADMIN")
                .antMatchers("/resources/**").permitAll()
                .and()
                .formLogin()
                    .loginPage("/showMyLoginPage")
                    .loginProcessingUrl("/authenticateTheUser")
                    .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }


}
