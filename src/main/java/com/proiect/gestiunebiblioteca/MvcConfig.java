package com.proiect.gestiunebiblioteca;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController("/gestiune/v1/login").setViewName("login");
//        registry.addViewController("/gestiune/v1/home").setViewName("Home");

    }
}
