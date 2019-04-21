package com.service;

import java.util.List;

import com.daolayer.LoginDao;

public class User {
	private String userName;
	private String password;
	LoginDao loginDao=null;
	
	public boolean getLogin(String user,String password) {
		System.out.println("Service layer....");
		List<User> userList=getUserData();
		for(User login: userList)
		{
			if(user.equals(login.getUserName())&&password.equals(login.getPassword()))
				return true;
		}
		return false;
		
	}
	public List<User> getUserData() {
		System.out.println("getUserData on services layer....");
		loginDao=new LoginDao();
		List<User> list=loginDao.getUser();
		return list;
		
	}
	public String getPassword() {
		return password;
		
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName=userName;
	}
}
