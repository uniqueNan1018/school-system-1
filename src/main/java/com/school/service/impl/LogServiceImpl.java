package com.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dao.LogDao;
import com.school.service.LogService;

@Service
public class LogServiceImpl implements LogService {
	@Autowired
	private LogDao logDao;

	@Override
	public void log(int accountId1, int accountId2, int money) {
		logDao.log("口座ID:" + accountId1 + "から" + "口座ID:" + accountId2 + "に" + money + "円を振り込みました");
	}
	
}
