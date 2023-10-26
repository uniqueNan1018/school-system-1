package com.school.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.school.controller", "com.school.config"})
@EnableWebMvc
public class SpringMvcConfig {
	
}
