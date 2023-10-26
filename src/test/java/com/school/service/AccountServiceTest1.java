package com.school.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.school.config.SpringConfig;
import com.school.model.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTest1 {
	@Autowired
	AccountService accountService;

	@Test
	public void test1() {
		Account ac = accountService.findById(1);
		ac.setMoney(100);
		accountService.update(ac);
		ac = accountService.findById(1);
		System.out.println(ac);
	}

}
