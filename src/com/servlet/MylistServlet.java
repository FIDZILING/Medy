package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DrugDAO;
import com.DAO.UserbuyDrugsDAO;

/**
 * Servlet implementation class MylistServlet
 */
@SuppressWarnings("serial")
@WebServlet(name = "MyListServlet", urlPatterns = { "/MyListServlet" })
public class MylistServlet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//设置字符集，避免乱码
		String method = req.getParameter("method");
		if("findlist".equals(method)) {
			findlist(req,resp);
		}
	}
	
	protected void findlist(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		int userId = (int) req.getSession().getAttribute("Id");
		String username = (String) req.getSession().getAttribute("username");
		UserbuyDrugsDAO userbuydrugsDAO = new UserbuyDrugsDAO();
		String[][] list = new String[6][1000];
		list = userbuydrugsDAO.seelist(userId);
		String htmlinfo = "";
		for(int i = 0;list[0][i] != null;i++) {
			htmlinfo = htmlinfo + "<tr>"
					+ "<td>"+ list[0][i] + "</td>"
					+ "<td>"+ username + "</td>"
					+ "<td>"+ list[1][i] + "</td>"
					+ "<td>"+ list[2][i] + "</td>"
					+ "<td>"+ list[3][i] + "</td>"
					+ "<td>"+ list[4][i] + "</td>"
					+ "<td>"+ list[5][i] + "</td>"
					+ "</tr>";
		}
		if(list[0][0] == null) {
			htmlinfo = "<tr>"
					+ "<td>"+ "空空如也" + "</td>"
					+ "<td>"+ "空空如也" + "</td>"
					+ "<td>"+ "空空如也" + "</td>"
					+ "<td>"+ "空空如也" + "</td>"
					+ "<td>"+ "空空如也" + "</td>"
					+ "<td>"+ "空空如也" + "</td>"
					+ "<td>"+ "空空如也" + "</td>"
					+ "</tr>";
		}
		out.print(htmlinfo);
	}

}
