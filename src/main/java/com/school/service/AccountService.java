package com.school.service;

import java.io.IOException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.school.model.Account;

public interface AccountService {
	public void save(Account account);
	
	public void update(Account account);
	
	public void delete(int id);
	
	public Account findById(int id);
	
	public List<Account> findAll();
	
	/*
	 * @param int accountId1 振替元口座
	 * @param int accountId2 振替先口座
	 * @param int money 振替金額
	 */
	@Transactional(rollbackFor = {IOException.class})
	public void transfer(int accountId1, int accountId2, int money) throws IOException;
}
