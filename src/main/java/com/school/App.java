package com.school;

import java.io.IOException;
import java.io.InputStream;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.school.config.SpringConfig;
import com.school.dao.AccountDao;
import com.school.model.Account;
import com.school.service.BookService;

public class App {

	public static void main(String[] args) throws IOException {
		// XMLファイルでコンフィグする
		/*ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookDao bookDao = (BookDao)ctx.getBean("bookDao");
		bookDao.save();
		
		BookService bookService = (BookService)ctx.getBean(BookService.class);
		bookService.printBook();*/
		
		// アノテーションでコンフィグする
		//ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
//		BookDao bookDao = (BookDao)ctx.getBean("bookDao");
//		bookDao.save();
		
		BookService bookService = (BookService)ctx.getBean(BookService.class);
		bookService.printBook();
//		ctx.close();
		
		DataSource ds = ctx.getBean(DataSource.class);
		System.out.println(ds);
		
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
		Account sc = accountDao.findById(1);
		System.out.println(sc);
		sqlSession.close();
	}

}
