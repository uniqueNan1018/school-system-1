package com.school;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.school.config.SpringConfig;
import com.school.dao.LessonDao;

public class App4 {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
//		LessonDao lessonDao = (LessonDao) ctx.getBean(LessonDao.class);
		LessonDao lessonDao = (LessonDao) ctx.getBean("lessonDaoImpl");
		System.out.println(lessonDao.findLesson("aaa "));
	}

}
