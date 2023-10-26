package com.school;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.school.config.SpringConfig;
import com.school.model.Account;
import com.school.service.AccountService;

public class App2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		AccountService as = ctx.getBean(AccountService.class);
		Account ac = as.findById(1);
		System.out.println(ac);
	}

}
