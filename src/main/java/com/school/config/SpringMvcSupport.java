package com.school.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.school.controller.interceptor.ProjectInterceptor;
import com.school.controller.interceptor.ProjectInterceptor2;

@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
	@Autowired
	private ProjectInterceptor projectInterceptor;
	@Autowired
	private ProjectInterceptor2 projectInterceptor2;
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
	}

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(projectInterceptor).addPathPatterns("/newBooks", "/newBooks/*");
		registry.addInterceptor(projectInterceptor2).addPathPatterns("/newBooks", "/newBooks/*");
	}
	
	
}
