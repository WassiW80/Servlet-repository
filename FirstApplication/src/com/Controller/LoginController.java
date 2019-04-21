package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.User;


public class LoginController extends HttpServlet {
	User login=null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("Login.html");
		PrintWriter writer=response.getWriter();
		String user=request.getParameter("unm");
		String pass=request.getParameter("pwd");
		
		if(checkLogin(user,pass))
			response.sendRedirect("Success.html");
		else {
			dispatcher.include(request,response);
			writer.print("<b><br>Username and password may be incorrect!</b>");
		}
		
		
	}
	public boolean checkLogin(String user, String pass) {
		System.out.println("Controller layer....");
		login= new User();
		return login.getLogin(user,pass);
		
	}

}
