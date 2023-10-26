package com.school.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dao.AccountDao;
import com.school.model.Account;
import com.school.service.AccountService;
import com.school.service.LogService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDao accountDao;

	@Autowired
	LogService logService;

	@Override
	public void save(Account account) {
		accountDao.save(account);
	}

	@Override
	public void update(Account account) {
		accountDao.update(account);
	}

	@Override
	public void delete(int id) {
		accountDao.delete(id);
	}

	@Override
	public Account findById(int id) {
		return accountDao.findById(id);
	}

	@Override
	public List<Account> findAll() {
		return accountDao.findAll();
	}

	@Override
	public void transfer(int acId1, int acId2, int money) throws IOException {
		try {
			accountDao.outMoney(acId1, money);
//			int i = 1 / 0;
//			if(true) {
//				throw new IOException();
//			}
			accountDao.inMoney(acId2, money);
		} finally {
			logService.log(acId1, acId2, money);
		}
	}

}
