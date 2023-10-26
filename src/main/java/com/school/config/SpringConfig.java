package com.school.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({JdbcConfig.class, MybatisConfig.class})
@ComponentScan("{com.school.aop, com.school.dao, com.school.service, com.school.service.impl}")
//@ComponentScan(value="com.school", 
//	excludeFilters = @ComponentScan.Filter(
//			type = FilterType.ANNOTATION,
//			classes = Controller.class
//	)
//)
@PropertySource("classpath:jdbc.properties")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfig {
	
	
}
