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
 * Servlet implementation class InsertMedyServlet
 */
@SuppressWarnings("serial")
@WebServlet("/InsertMedyServlet")
public class InsertMedyServlet extends HttpServlet {

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//设置字符集，避免乱码
		String method = req.getParameter("method");
		if("insertmedy".equals(method)) {
			insertmedy(req,resp);
		}
	}
	
	protected void insertmedy(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		DrugDAO drugDAO = new DrugDAO();
		//信息
		String name = req.getParameter("name");
		int isprescription = Integer.parseInt(req.getParameter("isprescription"));
		String approvalnumber = req.getParameter("approvalnumber");
		String type = req.getParameter("type");
		int residual = Integer.parseInt(req.getParameter("residual"));
		String information = req.getParameter("information");
		int sales = Integer.parseInt(req.getParameter("sales"));
		BigDecimal inprice = new BigDecimal(req.getParameter("inprice"));
		BigDecimal outprice = new BigDecimal(req.getParameter("outprice"));
		BigDecimal totalprice = new BigDecimal(req.getParameter("totalprice"));
		//导入
		boolean result = drugDAO.insertMedy(name,isprescription,approvalnumber,type,residual,information,sales,inprice,outprice,totalprice);
		if(result) {out.print("添加成功！");}else {out.print("添加失败！");}
	}
}
