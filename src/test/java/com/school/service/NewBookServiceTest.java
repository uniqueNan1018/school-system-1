package com.school.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.school.config.SpringConfig;
import com.school.model.NewBook;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class NewBookServiceTest {
	@Autowired
	private NewBookService newBookService;
	
	@Test
	public void testGetById() {
		NewBook nb = newBookService.getById(2);
		System.out.println(nb.getType());
	}

}
