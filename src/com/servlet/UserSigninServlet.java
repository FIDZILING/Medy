package com.servlet;

import java.io.*;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.DAO.*;
import com.beans.User;

/**
 * Servlet implementation class UserSigninServlet
 */
@SuppressWarnings("serial")
@WebServlet("/UserSigninServlet")
public class UserSigninServlet extends HttpServlet {
	//当从jsp跳转到servlet类时，首先执行service函数（这是定理）
	 protected void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
		 req.setCharacterEncoding("utf-8");//设置字符集，避免乱码
		 String method = req.getParameter("method");
		 if("signin".equals(method)) {
			 signin(req,resp);
		 }
	 }
	 
	 protected void signin(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
		 req.setCharacterEncoding("utf-8");
		 String username = req.getParameter("username");
		 String password = req.getParameter("password");
	   	 UserDAO userDAO = new UserDAO();
	   	 String ability = userDAO.signin(username, password);//用来判断是否登陆成功
	   	 if(ability != null) {
	   		 if(ability.equals("errorPass")) {
	   			 String errorinfo = "error1.密码错误！";
	   			 req.setAttribute("errorinfo",errorinfo);
	   			 req.getRequestDispatcher("/signinError.jsp").forward(req, resp);
	   		 }
	   		 else if(ability.equals("noUser")) {
	   			 String errorinfo = "error2.用户名不存在！";
	   			 req.setAttribute("errorinfo",errorinfo);
	   			 req.getRequestDispatcher("/signinError.jsp").forward(req, resp);
	        }
	        else {
	        	int Id = userDAO.getId(username);
	        	java.sql.Date signuptime = userDAO.getsignuptime(username);
	        	req.setAttribute("username", username);
	        	req.setAttribute("ability", ability);
	        	req.setAttribute("signuptime", signuptime);
	        	req.getSession().setAttribute("username", username);
	        	req.getSession().setAttribute("Id", Id);
	        	req.getSession().setAttribute("ability", ability);
	        	req.getSession().setAttribute("signuptime", signuptime);
	        	req.getRequestDispatcher("/MedyTotal.jsp").forward(req, resp);
	        }
	   	 }
	   	 else {
	   		 String errorinfo = "error3.登录失败！请联系管理员！";
	   		 req.setAttribute("errorinfo",errorinfo);
	   		 req.getRequestDispatcher("/signinError.jsp").forward(req, resp);
	   	 }
	 }
	 
}
