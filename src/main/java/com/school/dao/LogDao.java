package com.school.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDao {
	@Insert("insert into tb_log(info,createDate) values(#{info}, now())")
	void log(String info);
}
