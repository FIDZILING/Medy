package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DrugDAO;

/**
 * Servlet implementation class MoneylistServlet
 */
@SuppressWarnings("serial")
@WebServlet(name = "MoneyServlet", urlPatterns = { "/MoneyServlet" })
public class MoneylistServlet extends HttpServlet {

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//设置字符集，避免乱码
		String method = req.getParameter("method");
		if("money".equals(method)) {
			money(req,resp);
		}
	}
	
	protected void money(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		DrugDAO drugDAO = new DrugDAO();
		String[][] list = new String[6][1000];
		list = drugDAO.seelist();
		String htmlinfo = "";
		if(list[0][0] != null) {
			BigDecimal maxmax = new BigDecimal(0);
			for(int i = 0;list[0][i] != null;i++) {
				htmlinfo = htmlinfo + "<tr>"
						+ "<td>"+ list[0][i] + "</td>"
						+ "<td>"+ list[1][i] + "</td>"
						+ "<td>"+ list[2][i] + "</td>"
						+ "<td>"+ list[3][i] + "</td>"
						+ "<td>"+ list[4][i] + "</td>"
						+ "</tr>";
				BigDecimal maxi = new BigDecimal(list[4][i]);
				maxmax = maxmax.add(maxi);
			}
			htmlinfo = htmlinfo + "<br><p>总盈利：" + maxmax.toString() +"</p>";
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
