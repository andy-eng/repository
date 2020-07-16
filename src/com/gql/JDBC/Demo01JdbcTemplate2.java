package com.gql.JDBC;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Demo01JdbcTemplate2 {
	
	public static void main(String[] args) {
		//添加
		//addUser();
		//查询所有
		//findAllUser();
		//根据id查询
		//findUserByid(); 
		//修改
		updateUser();
		//删除
		//deleteUser();
	}

	private static void findAllUser() {
		//查询所有
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		String sql ="select * from person ";
		List<User> list = jt.query(sql, new BeanPropertyRowMapper(User.class));
		//List<User> list = jt.query(sql1, new BeanPropertyRowMapper<User>(User.class));
		System.out.println("查询所有");
		for (User user:list){
			System.out.println(user);
		}
		}
	 private static void addUser() {
		//添加
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		//update
		String sql =" insert into person(name,username,password,age,des,height) values(?,?,?,?,?,?)";
		int update1 = jt.update(sql,"奥恩","aoen","11",28,"坦克","184");
		int update2 = jt.update(sql,"塞恩","saien","22",23,"坦克","187");
		int update3 = jt.update(sql,"剑圣","jiansheng","33",27,"战士","188");
		int update4 = jt.update(sql,"剑姬","jianji","44",29,"战士","189");
		int update5 = jt.update(sql,"剑豪","jianhao","55",24,"刺客","181");
		System.out.println(update1);
		System.out.println(update2);
		System.out.println(update3);
		System.out.println(update4);
		System.out.println(update5);
	}
	 private static void updateUser() {
		 //修改
		 JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		 int update = jt.update("update person set name = ? ,username = ?, password = ?, age = ? ,des = ? , height = ? where id = ? ","杰斯","jiesi","123",25,"刺客","190",7);
		 System.out.println(update);
	 }
	 private static void deleteUser() {
		 //删除
		 JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		 int delete1 = jt.update("delete from person where id=?",6);
		 int delete2 = jt.update("delete from person where name=?","剑圣");
		 System.out.println(delete1);
		 System.out.println(delete2);
	 }
	 private static void findUserByid() {
		 //根据id查询
		 JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
         List<User> List= jt.query("select * from person where id = ?",new BeanPropertyRowMapper(User.class),6);
         User user2= List.get(0);
         System.out.println("根据id查询");
         System.out.println(user2);
	 }
}

