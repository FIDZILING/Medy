package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DrugDAO;


/**
 * Servlet implementation class FindMedyServlet
 */
@SuppressWarnings("serial")
@WebServlet("/FindMedyServlet")
public class FindMedyServlet extends HttpServlet {
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//设置字符集，避免乱码
		String method = req.getParameter("method");
		if("findmedy".equals(method)) {
			findmedy(req,resp);
		}
	}
	
	protected void findmedy(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String type = req.getParameter("type");
		DrugDAO drugDAO = new DrugDAO();
		String [][] druginfo = new String[11][100];
		druginfo = drugDAO.findalldrugs(type);
		String htmlinfo = "";
		for(int i = 0;druginfo[0][i] != null;i++) {
			htmlinfo = htmlinfo + "<tr>"
					+ "<td>"+ druginfo[0][i] + "</td>"
					+ "<td title='查看药品信息' style='cursor:pointer;' onclick=\"seeinfo('" + druginfo[1][i] + "')\">" + druginfo[1][i] + "</td>"
					+ "<td>"+ druginfo[2][i] + "</td>"
					+ "<td>"+ druginfo[4][i] + "</td>"
					+ "<td>"+ druginfo[9][i] + "</td>"
					+ "<td>"+ druginfo[5][i] + "</td>"
					+ "</tr>";
		}
		if(druginfo[0][0] == null) {
			htmlinfo = "<tr>"
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
 