package com.school.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface LogService {
	/*
	 * @param int accountId1 振替元口座
	 * @param int accountId2 振替先口座
	 * @param int money 振替金額
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void log(int accountId1, int accountId2, int money);
}
