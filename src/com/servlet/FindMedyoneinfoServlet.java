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
 * Servlet implementation class FindMedyoneinfoServlet
 */
@SuppressWarnings("serial")
@WebServlet("/FindMedyoneinfoServlet")
public class FindMedyoneinfoServlet extends HttpServlet {

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//设置字符集，避免乱码
		String method = req.getParameter("method");
		if("seemedyinfo".equals(method)) {
			seemedyinfo(req,resp);
		}
	}
	
	protected void seemedyinfo(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		DrugDAO drugDAO = new DrugDAO();
		String [] druginfo = new String[11];
		druginfo = drugDAO.findonedrug(name);
		String htmlinfo = "";
		htmlinfo = htmlinfo + "<h3>药品名称</h3>" + druginfo[1] 
				+ "<br><br><h3>批准文号</h3>"+ druginfo[3] 
				+ "<br><br><h3>说明书</h3>" + druginfo[6]
				+ "<br><br><h3>售价</h3>" + druginfo[9]
				+ "<br>"
				+ "<font style=\"font-size:16px;margin:0 0 0 50px;\">购买数量</font><input id='numberofbuy' type='text' name='numberofdrugs' onkeyup=\"value=value.replace(/[^\\d]/g,'')\" class=\"input-num\" /><br>"
				+ "<button class='btn-check-buy' onclick='buydrugs(\""+ druginfo[0] +"\")'>购&nbsp;&nbsp;买</button>";
		out.print(htmlinfo);
	}

}
