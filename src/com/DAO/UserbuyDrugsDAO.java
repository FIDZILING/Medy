package com.DAO;

import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;

import com.DBLink.*;

public class UserbuyDrugsDAO {
	public boolean insertUserBuy(int userId,int drugId,int buynum,java.sql.Date buytime) {
		//查单价
		//计算总价
		//insert
		Connection conn = DBLink.getConn();
		Statement state =null;
		ResultSet rs = null;
        boolean result = false;
        try {
        	String sql = "select outprice from drugs where drugs.Id = '" + drugId + "'";//SQL语句,
            state = conn.createStatement();
            
            rs=state.executeQuery(sql);
            if(rs.next()) {
            	BigDecimal buypriceeach = rs.getBigDecimal("outprice");
            	BigDecimal buyprice = buypriceeach.multiply(BigDecimal.valueOf((int)buynum));
            	try {
            		String sql_insert = "insert into userbuydrugs(userid,drugsid,buynum,buypriceeach,buyprice,buytime) values(?,?,?,?,?,?)";
            		PreparedStatement stmt = conn.prepareStatement(sql_insert); 
    	            
    	        	stmt.setInt(1,userId);
    	        	stmt.setInt(2,drugId);
    	        	stmt.setInt(3,buynum);
    	        	stmt.setBigDecimal(4,buypriceeach);
    	        	stmt.setBigDecimal(5,buyprice);
    	        	stmt.setDate(6,buytime);
    	        	
    	        	int i = stmt.executeUpdate();
    	        	if(i == 1)return true;
	            	else return false;
            	}catch(Exception e) {
            		e.printStackTrace();
            	}finally {
            		DBLink.close(state, conn);
            	}
            }
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally{
        	DBLink.close(rs, state, conn);
        }
        return result;
	}
	
	public String[][] seelist(int userId) {
		Connection conn = DBLink.getConn();
		Statement state =null;
		ResultSet rs = null;
        String[][] result = new String[6][1000];
        int i = 0;
        try {
        	String sql = "select Id,drugsid,buynum,buypriceeach,buyprice,buytime from userbuydrugs where userid = '" + userId + "'";//SQL语句,
            state = conn.createStatement();
            
            rs=state.executeQuery(sql);
            while(rs.next()) {
            	result[0][i] = Integer.toString(rs.getInt("Id"));
            	result[1][i] = Integer.toString(rs.getInt("drugsid"));
            	result[2][i] = Integer.toString(rs.getInt("buynum"));
            	result[3][i] = rs.getBigDecimal("buypriceeach").toString();
            	result[4][i] = rs.getBigDecimal("buyprice").toString();
            	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            	result[5][i] = sf.format(rs.getDate("buytime"));
            	i++;
            }
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally{
        	DBLink.close(rs, state, conn);
        }
        return result;
	}

}
