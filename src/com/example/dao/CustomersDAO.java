package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.example.dal.DBUtil;
import com.example.model.Customers;

public class CustomersDAO {
	DBUtil db = new DBUtil();
	//更新用户信息
	public int update_cus(Customers u){
		try{
			String sql = "update Customers set Cus_Nickname='"+u.getCus_Nickname()+"',Cus_IdNum='"+u.getCus_IDNum()+"',Cus_Name='"+u.getCus_Name()+"',Cus_Address='"+u.getCus_Address()
				+"',Cus_Company='"+u.getCus_Company()+"',Cus_Sex='"+u.getCus_Sex()+"',Cus_Tel='"+u.getCus_Tel()
				+"',Cus_DriLicense_Id='"+u.getCus_DriLicense_Id()+"'  where Cus_Id="+u.getCus_Id();
			if(!db.openConnection()){
				System.out.println("fail to connect database");
				return 0;
			}
			int rst = db.execCommand(sql);
			if(rst!=0)
				return 1;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				db.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	//根据用户id返回相应用户
	public Customers select_cus(int id){
		Customers cus = new Customers();
		try{
			String sql = "select * from Customers where Cus_Id="+id+" ";
			if(!db.openConnection()){
				System.out.println("fail to connect database");
				return null;
			}
			ResultSet rst = db.execQuery(sql);
			if(rst!=null){
				while(rst.next()){
					cus.setCus_Id(rst.getInt("Cus_Id"));
					cus.setCus_Name(rst.getString("Cus_Name"));
					cus.setCus_Nickname(rst.getString("Cus_NickName"));
					cus.setCus_Address(rst.getString("Cus_Address"));
					cus.setCus_Company(rst.getString("Cus_Company"));
					cus.setCus_IDNum(rst.getString("Cus_IDNum"));
					cus.setCus_Sex(rst.getString("Cus_Sex"));
					cus.setCus_Tel(rst.getString("Cus_Tel"));
					cus.setCus_DriLicense_Id(rst.getString("Cus_DriLicense_Id"));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				db.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cus;
	}
	//返回所有的记录
	public List<Customers> fetchAll_cus(){
		List<Customers> lisCus=new ArrayList<Customers>();
		Customers c=new Customers();
		lisCus =null;
		lisCus=new LinkedList<Customers>();
		String sql="select * from Customers";
		try{
			if(!db.openConnection()){
				System.out.println("fail to connect database");
				return null;
			}
			ResultSet rst=db.execQuery(sql);
			while(rst.next()){
				c=new Customers();
				c.setCus_Id(rst.getInt("Cus_Id"));
				c.setCus_Name(rst.getString("Cus_Name"));
				c.setCus_Nickname(rst.getString("Cus_Nickname"));
				c.setCus_Address(rst.getString("Cus_Address"));
				c.setCus_Company(rst.getString("Cus_Company"));
				c.setCus_IDNum(rst.getString("Cus_IDNum"));
				c.setCus_Sex(rst.getString("Cus_Sex"));
				c.setCus_Tel(rst.getString("Cus_Tel"));
				c.setCus_DriLicense_Id(rst.getString("Cus_DriLicense_Id"));
				
				lisCus .add(c);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
				
		return lisCus;
	}
}