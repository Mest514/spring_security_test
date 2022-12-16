package com.mest.config;

import com.mest.handler.LogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


/**
 * @program: spring_security
 * @description:
 * @author: Mest
 * @create: 2022-12-15 20:39
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationSuccessHandler successHandler;
    @Autowired
    private AuthenticationFailureHandler failureHandler;

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    //使用手动认证方案
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //自定义认证成功处理器
        http.formLogin().successHandler(successHandler);
        //拦截保护
        http.authorizeRequests().anyRequest().authenticated();
        //自定义认证失败处理器
        http.formLogin().failureHandler(failureHandler);
        //自定义注销成功处理器
        http.logout().logoutSuccessHandler(logoutSuccessHandler);
    }
}
