package com.gql.Dao;

import java.util.List;

import com.gql.JDBC.User;

public interface UserDao {
	// 查询所有
	List<User> findAllUser();

}
