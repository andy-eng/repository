package com.gql.JDBC;

import java.sql.ResultSet;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.omg.CORBA.portable.InputStream;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Demo01Druid {
	public static void main(String[] args) throws Exception{
		Properties pro = new Properties();
//		InputStream resourceAsStream = (InputStream) Demo01Druid.class.getClassLoader().getResourceAsStream("j.properties");
		java.io.InputStream resourceAsStream2 = Demo01Druid.class.getClassLoader().getResourceAsStream("j.properties");
		pro.load(resourceAsStream2);
		
		String property = pro.getProperty("name");
		String password = pro.getProperty("password");
		System.out.println(password);
		System.out.println(property);
		
		DataSource datasource = DruidDataSourceFactory.createDataSource(pro);
		
		System.out.println(((java.sql.Statement) datasource).getConnection());
		
		Connection connection =(Connection) ((java.sql.Statement) datasource).getConnection();
		Statement createStatement =(Statement) connection.createStatement();
		String sql ="select * from t_user";
		ResultSet rs =createStatement.executeQuery(sql);
		
		while(rs.next()){
			String name =rs.getString("name");
			String address =rs.getString("address");
			Integer age =rs.getInt("age");
			System.out.println(name+address+age);
			
		}
		connection.close();
	}

}
