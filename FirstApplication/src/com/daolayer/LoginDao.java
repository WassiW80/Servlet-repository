package com.daolayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.service.User;

public class LoginDao {
	static String CLASS_PATH ="com.mysql.cj.jdbc.Driver";
	static String URL_PATH ="jdbc:mysql://localhost:3306/student";
	static String USER_NAME ="root";
	static String PASSWORD ="Wassi123";
	Connection connection=null;
	PreparedStatement statement=null;
	static String sql="select *from user";
	ResultSet resultSet=null;
	
	public Connection connectTest() throws SQLException, ClassNotFoundException {
		Class.forName(CLASS_PATH);
		connection=DriverManager.getConnection(URL_PATH, USER_NAME, PASSWORD);
		System.out.println("DB connected....");
		return connection;
		}
	public List<User> getUser() {
		System.out.println("Dao layer....");
		List<User> list=new ArrayList<>();
		try {
			connection=connectTest();
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			while (resultSet.next()) {
				User user=new User();
				user.setUserName(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				list.add(user);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}

}
