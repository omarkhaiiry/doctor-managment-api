package com.es.doctorManagment;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Omar Khairy
 *
 * This is class is responsible for configuring the API security
 * this class implements WebSecurityConfigurerAdapter which allows
 * overriding the default security behavior provided by spring security
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * <p>this method gets an instanceof AuthenticationManagerBuilder
     * that is responsible building in memory authentication
     * </p>
     * @param auth AuthenticationManagerBuilder instance
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("omar")
                .password("123456")
                .roles("admin");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * <p>overriding this method to configure the Http security
     * </p>
     * @param http HttpSecurity instance that allows configuring web based security
     *             for specific http requests
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/doctors/**").hasRole("admin")
                .antMatchers("/patients/**").hasRole("admin")
                .antMatchers("/appointments/**").hasRole("admin")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}