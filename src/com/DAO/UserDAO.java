package com.DAO;

import java.sql.*;
import com.DBLink.*;

public class UserDAO {
	//登陆密码验证
	public String signin(String username,String password) {
		Connection conn = DBLink.getConn();
		Statement state =null;
        ResultSet rs = null;
        String ability = null;
        try {
        	String sql = "select * from user where username = '" + username + "'";//SQL语句,
            state = conn.createStatement();
            
            rs=state.executeQuery(sql);
            if(rs.next()) {
                if(rs.getString("password").equals(password)) {
                	ability = rs.getString("ability");
                	return ability;
                }
                else {
                	ability = "errorPass";
                	return ability;
                }
            }
            else {
            	ability = "noUser";
            	return ability;
            }
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally{
            DBLink.close(rs, state, conn);
        }
        return ability;
	}
	
	//获取Id
	public int getId(String username) {
		Connection conn = DBLink.getConn();
		Statement state =null;
        ResultSet rs = null;
        int Id = -1;
        try {
        	String sql = "select Id from user where username = '" + username + "'";//SQL语句,
            state = conn.createStatement();
            
            rs=state.executeQuery(sql);
            if(rs.next()) {
            	Id = rs.getInt("Id");
            	return Id;
            }
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally{
            DBLink.close(rs, state, conn);
        }
        return Id;
	}
	
	//获取注册时间
	public Date getsignuptime(String username) {
		Connection conn = DBLink.getConn();
		Statement state =null;
        ResultSet rs = null;
        Date signuptime = null;
        try {
        	String sql = "select signuptime from user where username = '" + username + "'";//SQL语句,
            state = conn.createStatement();
            
            rs=state.executeQuery(sql);
            if(rs.next()) {
            	signuptime = rs.getDate("siguptime");
            	return signuptime;
            }
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally{
            DBLink.close(rs, state, conn);
        }
        return signuptime;
	}
	
	//注册插入信息
	public String signup(String username,String password,String ability,java.sql.Date signuptime) {
		Connection conn = DBLink.getConn();
		Statement state =null;
		ResultSet rs = null;
        String result = null;
        try {
        	//先查看有没有该用户名
        	String sql = "select username from user where username = '" + username + "'";//SQL语句,
        	state = conn.createStatement();
            rs=state.executeQuery(sql);
            if(!rs.next()) {
	        	//没有则插入
	        	sql = "insert into user(username,password,ability,signuptime) values(?,?,?,?)";//SQL语句,
	        	PreparedStatement stmt = conn.prepareStatement(sql); 
	            
	        	stmt.setString(1,username);
	        	stmt.setString(2,password);
	        	stmt.setString(3,ability);
	        	stmt.setDate(4,signuptime);
	        	int i = stmt.executeUpdate();
	        	if(i == 1) {
	        		result = "success";
	        		return result;
	        	}
	        	else {
	        		result = "errorDB";
	        		return result;
	        	}
            }
            else {
            	result = "usernameexist";
            	return result;
            }
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally{
            DBLink.close(state, conn);
        }
        return result;
	}
}
