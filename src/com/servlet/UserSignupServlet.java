package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserDAO;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class UserSignupServlet
 */
@SuppressWarnings("serial")
@WebServlet("/UserSignupServlet")
public class UserSignupServlet extends HttpServlet {
	

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//设置字符集，避免乱码
		String method = req.getParameter("method");
		if("signup".equals(method)) {
			signup(req,resp);
		}
	}
	
	protected void signup(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String ability = req.getParameter("ability");
		java.sql.Date signuptime = new java.sql.Date(new java.util.Date().getTime());
		UserDAO userDAO = new UserDAO();
		
		String result = userDAO.signup(username, password, ability, signuptime);
		if(result.equals("success")) {
			String successinfo = "注册成功！";
   			req.setAttribute("successinfo",successinfo);
   			req.getRequestDispatcher("/signupSuccess.jsp").forward(req, resp);
		}
		else if(result.equals("errorDB")) {
			String errorinfo = "error1.插入数据库失败！";
  			req.setAttribute("errorinfo",errorinfo);
  			req.getRequestDispatcher("/signupError.jsp").forward(req, resp);
		}
		else if(result.equals("usernameexist")) {
			String errorinfo = "error2.存在重复用户名！";
  			req.setAttribute("errorinfo",errorinfo);
  			req.getRequestDispatcher("/signupError.jsp").forward(req, resp);
		}
		else {
			String errorinfo = "error3.注册失败！请联系管理员！";
  			req.setAttribute("errorinfo",errorinfo);
  			req.getRequestDispatcher("/signupError.jsp").forward(req, resp);
		}
	}
}
