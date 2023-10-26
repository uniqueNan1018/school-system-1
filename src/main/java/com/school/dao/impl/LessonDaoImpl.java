package com.school.dao.impl;

import org.springframework.stereotype.Repository;

import com.school.dao.LessonDao;

@Repository
public class LessonDaoImpl implements LessonDao {

	@Override
	public String findLesson(String name) {
		if ("aaa".equals(name)) {
			return "AAA";
		} else if ("bbb".equals(name)) {
			return "BBB";
		} 
		return "CCC";
	}

}
