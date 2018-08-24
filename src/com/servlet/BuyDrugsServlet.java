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

@SuppressWarnings("serial")
@WebServlet("/BuyGrugsServlet")
public class BuyDrugsServlet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//设置字符集，避免乱码
		String method = req.getParameter("method");
		if("buydrugs".equals(method)) {
			buydrugs(req,resp);
		}
	}
		
	protected void buydrugs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		int drugId = Integer.parseInt(req.getParameter("Id"));
		int buynum = Integer.parseInt(req.getParameter("buynum"));
		DrugDAO drugDAO = new DrugDAO();
		UserbuyDrugsDAO userbuydrugsDAO = new UserbuyDrugsDAO();
		int userId = (int) req.getSession().getAttribute("Id");
		java.sql.Date buytime = new java.sql.Date(new java.util.Date().getTime());
		//药品数据库操作
		boolean res1 = drugDAO.insertBuynum(drugId,buynum);
		boolean res2 = userbuydrugsDAO.insertUserBuy(userId,drugId,buynum,buytime);
		if(res1 == true && res2 == true) {out.print("购买成功！");}
		else {out.print("购买失败！");}
	}
}


