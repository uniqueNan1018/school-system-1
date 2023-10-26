package com.school;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.school.config.SpringConfig;
//import com.school.dao.impl.BookDaoImpl1;
import com.school.dao.AccountDao;

public class App3 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
//		BookDao bookDao = (BookDao) ctx.getBean("bookDaoImpl1");
//		int ret = bookDao.delete();
//		System.out.println(ret);
		
		AccountDao accountDao = ctx.getBean(AccountDao.class);
		accountDao.findById(1);
	}

}
