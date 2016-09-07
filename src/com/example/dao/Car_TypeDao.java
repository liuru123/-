package com.example.dao;

import java.sql.ResultSet;
import com.example.dal.DBUtil;
import com.example.model.Car_Type;

public class Car_TypeDao {
	
	Car_Type cart=new Car_Type();
	DBUtil db = new DBUtil();
	//返回车辆信息
		public Car_Type  lsCT(String s,String s2) {
			
			try{
				String sql="select * from Car_Type where Car_Type='"+s+"' and  Car_Name='"+s2+"'";
				if(!db.openConnection()){
					System.out.println("fail to connect database");
					return null;
				}
				ResultSet rst = db.execQuery(sql);
				if(rst!=null&&rst.first()){
						cart.setCar_Worth(rst.getDouble("Car_Worth"));
						cart.setCar_RentMoney(rst.getDouble("Car_RentMoney"));
						cart.setCar_Name(rst.getString("Car_Name"));
						cart.setCar_Count(rst.getInt("Car_Count"));
						
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
			return cart;
	}
		
		public int countAdd(String s1,String s2)
		{
			try{
				String sql="update Car_Type set Car_Count=Car_Count+1 where Car_Type='"+s1+"' and Car_Name='"+s2+"'";
				if(!db.openConnection()){
					System.out.println("fail to connect database");
					return 0;
				}
				if(db.execCommand(sql)!=0)
					return 1;
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try {
					db.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return 0;
		}
		//减少车辆数
		public int countSub(String s1,String s2)
		{
			try{
				String sql="update Car_Type set Car_Count=Car_Count-1 where Car_Type='"+s1+"' and Car_Name='"+s2+"'";
				if(!db.openConnection()){
					System.out.println("fail to connect database");
					return 0;
				}
				if(db.execCommand(sql)!=0)
					return 1;
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try {
					db.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return 0;
		}
	
}
