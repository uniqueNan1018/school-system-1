package com.school.dao.impl;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.school.dao.BookDao;

@Repository
public class BookDaoImpl1 implements BookDao {
	@Value("aaa")
	private String name;

	@PostConstruct
	public void init() {
		System.out.println("bookdao is inited");
	}
	
	@Override
	public void save() {
//		Long startTime = System.currentTimeMillis();
		LocalDateTime t1 = LocalDateTime.now();
		System.out.println(t1);
		for (int i = 0; i < 10000; i++) {
			System.out.println("book is saved");
		}
//		Long endTime = System.currentTimeMillis();
//		Long totalTime = endTime - startTime;
//		System.out.println("メソッドを１万回が実行するのに必要な時間は：" + totalTime + "ms");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("bookdao is destroied");
	}

	@Override
	public void update() {
		System.out.println("book is updated");
	}

	@Override
	public int delete() {
		System.out.println("book is deleted");
		return 1;
	}

//	@Override
//	public void delete() {
//		System.out.println(name + "book is deleted");
//	}
	
	
}
