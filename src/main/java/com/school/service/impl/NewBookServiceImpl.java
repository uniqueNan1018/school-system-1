package com.school.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.controller.Code;
import com.school.dao.NewBookDao;
import com.school.exception.BusinessException;
import com.school.exception.SystemException;
import com.school.model.NewBook;
import com.school.service.NewBookService;

@Service
public class NewBookServiceImpl implements NewBookService {
	@Autowired
	NewBookDao newBookDao;

	@Override
	public boolean save(NewBook newBook) {
		int res = newBookDao.save(newBook);
		if (res > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(NewBook newBook) {
		newBookDao.update(newBook);
		return true;
	}

	@Override
	public boolean delete(Integer id) {
		newBookDao.delete(id);
		return true;
	}

	@Override
	public NewBook getById(Integer id) {
		System.out.println(id);
		if (id == 0) {
			throw new BusinessException(Code.BUSINESS_ERROR, "ビジネスエラーです");
		}
		// 発生する可能性がある例外をラッパーして、カスタマ例外に変更する
		try {
			int i = 1/0;
		} catch(Exception e) {
			
			System.out.println("getById");
			throw new SystemException(Code.SYSTEM_TIMEOUT_ERROR, "サーバがタイムアウトしました、もう一度お試してください");
		}
		return newBookDao.findById(id);
	}

	@Override
	public List<NewBook> fundAll() {
		return newBookDao.fundAll();
	}
}
