package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.dal.DBUtil;
import com.example.model.Customers;

public class LoginVerification {
	
	String id;
	String password;
	ResultSet res;
	Boolean flag = false;
	public LoginVerification(Customers user) throws Exception {
		id = user.getCus_Nickname();
		password = user.getCus_Password();
		String sql = "select * from Customers where Cus_NickName = '"+id+"' and Cus_Password = '"+password+"'";
		DBUtil db = new DBUtil();
		db.openConnection();
		res = db.execQuery(sql);
		if(res.next()) {
			flag = true;
		}
		else
			System.out.println("login failed");
	}
	
	public String getIdNum() throws SQLException {
		return res.getString(5);
	}
	public int getId(){
		try {
			return res.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public Boolean getFlag() {
		return flag;
	}
}

