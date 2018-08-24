package com.DAO;

import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;

import com.DBLink.*;

public class DrugDAO {
	public String[][] findalldrugs(String type) {
		String [][] druginfo = new String[11][100];
		Connection conn = DBLink.getConn();
		Statement state =null;
        ResultSet rs = null;
        int i = 0;
        try {
        	String sql = "select * from drugs where type like '%" + type + "%'";//SQL语句,
            state = conn.createStatement();
            
            rs=state.executeQuery(sql);
            while(rs.next()) {
            	druginfo[0][i] = Integer.toString(rs.getInt("Id"));
            	druginfo[1][i] = rs.getString("name");
            	if(rs.getInt("isprescription") == 1) {druginfo[2][i] = "是";}
    			else if(rs.getInt("isprescription") == 0){druginfo[2][i] = "否";}
           		druginfo[3][i] = rs.getString("approvalnumber");
           		druginfo[4][i] = rs.getString("type");
           		druginfo[5][i] = Integer.toString(rs.getInt("residual"));
           		druginfo[6][i] = rs.getString("information");
           		druginfo[7][i] = Long.toString(rs.getLong("sales"));
           		druginfo[8][i] = rs.getBigDecimal("inprice").toString();
           		druginfo[9][i] = rs.getBigDecimal("outprice").toString();
           		druginfo[10][i] = rs.getBigDecimal("totalprice").toString();
           		i++;
            }
        }catch(Exception e) {
        	e.printStackTrace();
        }
        finally {
        	DBLink.close(rs, state, conn);
        }
		return druginfo;
	}
	
	public String[] findonedrug(String name) {
		String [] druginfo = new String[11];
		Connection conn = DBLink.getConn();
		Statement state =null;
        ResultSet rs = null;

        try {
        	String sql = "select * from drugs where name = '" + name + "'";//SQL语句,
            state = conn.createStatement();
            
            rs=state.executeQuery(sql);
            if(rs.next()) {
            	druginfo[0] = Integer.toString(rs.getInt("Id"));
            	druginfo[1] = rs.getString("name");
            	if(rs.getInt("isprescription") == 1) {druginfo[2] = "是";}
    			else if(rs.getInt("isprescription") == 0){druginfo[2] = "否";}
           		druginfo[3] = rs.getString("approvalnumber");
           		druginfo[4] = rs.getString("type");
           		druginfo[5] = Integer.toString(rs.getInt("residual"));
           		druginfo[6] = rs.getString("information");
           		druginfo[7] = Long.toString(rs.getLong("sales"));
           		druginfo[8] = rs.getBigDecimal("inprice").toString();
           		druginfo[9] = rs.getBigDecimal("outprice").toString();
           		druginfo[10] = rs.getBigDecimal("totalprice").toString();
            }
        }catch(Exception e) {
        	e.printStackTrace();
        }
        finally {
        	DBLink.close(rs, state, conn);
        }
		return druginfo;
	}
	
	public boolean insertBuynum(int Id,int buynum) {
		Connection conn = DBLink.getConn();
		Statement state =null;
        ResultSet rs = null;
        boolean result = false;
        //先获取价格和剩余量和销售量
        //计算盈利和剩余量
        //后插入剩余量和销售量和盈利

        try {
        	String sql = "select inprice,outprice,residual,sales from drugs where Id = '" + Id + "'";//SQL语句,
            state = conn.createStatement();
            
            rs=state.executeQuery(sql);
            if(rs.next()) {
            	BigDecimal totalprice = (rs.getBigDecimal("outprice").subtract(rs.getBigDecimal("inprice"))).multiply(BigDecimal.valueOf((int)buynum));
            	int residual = rs.getInt("residual") - buynum;
            	int sales = rs.getInt("sales") + buynum;
            	if(residual<0) {return false;}
            	try {
	            	String sql_update = "update drugs set residual=?,sales=?,totalprice=? where Id=?";
	            	PreparedStatement stmt = conn.prepareStatement(sql_update);
	            	stmt.setInt(1,residual);
	            	stmt.setInt(2,sales);
	            	stmt.setBigDecimal(3,totalprice);
	            	stmt.setInt(4,Id);
	            	int n =  stmt.executeUpdate();
	            	if(n == 1)return true;
	            	else return false;
            	}catch(Exception e) {
                	e.printStackTrace();
            	}
                finally {
                    DBLink.close(state, conn);
                }
            }
        }catch(Exception e) {
        	e.printStackTrace();
        }
        finally {
        	DBLink.close(rs, state, conn);
        }
        return result;
	}

	public String[][] seelist() {
		Connection conn = DBLink.getConn();
		Statement state =null;
		ResultSet rs = null;
        String[][] result = new String[5][1000];
        int i = 0;
        try {
        	String sql = "select name,type,sales,outprice,totalprice from drugs";//SQL语句,
            state = conn.createStatement();
            
            rs=state.executeQuery(sql);
            while(rs.next()) {
            	result[0][i] = rs.getString("name");
            	result[1][i] = rs.getString("type");
            	result[2][i] = Integer.toString(rs.getInt("sales"));
            	result[3][i] = rs.getBigDecimal("outprice").toString();
            	result[4][i] = rs.getBigDecimal("totalprice").toString();
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

	public boolean insertMedy(String name, int isprescription, String approvalnumber, String type, int residual,
			String information, int sales, BigDecimal inprice, BigDecimal outprice, BigDecimal totalprice) {
		Connection conn = DBLink.getConn();
		Statement state =null;
        boolean result = false;
        try {
    		String sql_insert = "insert into drugs(name,isprescription,approvalnumber,type,residual,information,sales,inprice,outprice,totalprice) values(?,?,?,?,?,?,?,?,?,?)";
    		PreparedStatement stmt = conn.prepareStatement(sql_insert); 
            
        	stmt.setString(1,name);
        	stmt.setInt(2,isprescription);
        	stmt.setString(3,approvalnumber);
        	stmt.setString(4,type);
        	stmt.setInt(5,residual);
        	stmt.setString(6,information);
        	stmt.setInt(7,sales);
        	stmt.setBigDecimal(8,inprice);
        	stmt.setBigDecimal(9,outprice);
        	stmt.setBigDecimal(10,totalprice);
        	
        	int i = stmt.executeUpdate();
        	if(i == 1)return true;
        	else return false;
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		DBLink.close(state, conn);
    	}
        return result;
	}
     
}
