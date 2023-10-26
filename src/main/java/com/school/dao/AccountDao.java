package com.school.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.school.model.Account;

@Repository
public interface AccountDao {
	@Insert("insert into tb_account(username, password, gender, addr) values (#{username},#{password},#{gender},#{addr})")
	void save(Account account);
	
	@Delete("delete from tb_account where id = #{id}")
	void delete(Integer id);
	
	@Update("update tb_account set username = #{username} ,money = #{money} where id = #{id}")
	void update(Account account);
	
	@Select("select * from tb_account")
	List<Account> findAll();
	
	@Select("select * from tb_account where id = #{id}")
	Account findById(Integer id);
	
	@Update("update tb_account set money = money + #{money} where id = #{id}")
	void inMoney(@Param("id") int id, @Param("money") int money);
	
	@Update("update tb_account set money = money - #{money} where id = #{id}")
	void outMoney(@Param("id") int id, @Param("money") int money);
}
