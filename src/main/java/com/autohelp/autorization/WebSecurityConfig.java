package com.autohelp.autorization;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * Created by jek on 11.01.16.
 */
@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
        .antMatchers("/tools/*").authenticated()
                .anyRequest().permitAll();
                //.antMatchers("/webresources/**","/","index","/index","/appointments","/appointmentsResult","/contact","/price").permitAll();



//        http.authorizeRequests().
//                antMatchers("/tools/**").permitAll().anyRequest().authenticated();



        http.
                 formLogin()
                .loginPage("/tools/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }

    @Configuration
    protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter
    {

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception
        {
            auth
                    .inMemoryAuthentication()
                    .withUser("user").password("password").roles("USER");
        }

    }

}
