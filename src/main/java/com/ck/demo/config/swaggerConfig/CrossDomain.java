package com.lishengjt.club_farmers.config.swaggerConfig;

import com.ck.demo.config.swaggerConfig.CORSInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CrossDomain extends WebMvcConfigurerAdapter {
    @Autowired
    private CORSInterceptor corsInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor);
    }
}
