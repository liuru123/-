package com.example.dao;

import com.example.dal.DBUtil;
import com.example.model.Customers;

public class RegistrationRecord {
	
	String nickName;
	String password;
	String id_Card;
	
	public RegistrationRecord(Customers user) throws Exception {
		this.nickName = user.getCus_Nickname();
		this.password = user.getCus_Password();
		this.id_Card = user.getCus_IDNum();
		String sql ="insert into Customers(Cus_Nickname,Cus_Password,Cus_IdNum) values ('"+nickName+"','"+password+"','"+id_Card+"')" ;
		DBUtil db = new DBUtil();
		if(db.openConnection())
			db.execCommand(sql);
		else
			System.out.println("fail to connect");
	}

}
