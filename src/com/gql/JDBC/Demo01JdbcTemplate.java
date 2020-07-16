package com.gql.JDBC;

import java.util.List;

import com.gql.Dao.UserDao;
import com.gql.Dao.UserDaoImpl;

public class Demo01JdbcTemplate {
	public static void main(String[] args) {
		UserDao ud=new UserDaoImpl();
		
		List<User> List = ud.findAllUser();
		
		for(User user:List){
			System.out.println(user);
		}
	}


}
