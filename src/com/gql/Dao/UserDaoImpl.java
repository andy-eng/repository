package com.gql.Dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gql.JDBC.JDBCUtils;
import com.gql.JDBC.User;

public class UserDaoImpl implements UserDao{
	
	JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
	public List<User> findAllUser(){
		
		String sql= "select * from person";
		List<User> List = jt.query(sql,new BeanPropertyRowMapper<User>(User.class));
		return List;
	}

}
