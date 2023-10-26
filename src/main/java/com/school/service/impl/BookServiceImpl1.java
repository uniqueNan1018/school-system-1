package com.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dao.BookDao;
import com.school.service.BookService;

@Service
public class BookServiceImpl1 implements BookService {
	@Autowired
	BookDao bookDao;

	@Override
	public void printBook() {
		System.out.println("this is a book!");
		bookDao.save();
	}
}
