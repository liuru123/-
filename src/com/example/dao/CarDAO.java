package com.example.dao;

import java.sql.ResultSet;

import com.example.dal.DBUtil;
import com.example.model.Car;

/**
 * 汽车增、删、改、查
 * 
 */
public class CarDAO {
	DBUtil db=new DBUtil();
	
	public int insert_car(Car c){
		try{
			String sql=" insert into Car values("+c.getCar_Id()+","+c.getCar_Name()+","+c.getCar_Type()+","+
					","+c.getSeat_Count()+","+c.getCar_Door()+","+c.getCar_Window()+","+c.getCar_GPS()+","+c.getCar_Oil()+","+
					c.getCar_Gasbag()+","+c.getCar_Color()+","+c.getCar_Image()+","+c.getCar_IsUseful()+","+","+c.getCar_Description()+")";
			if(!db.openConnection()){
				System.out.println("fail to connect database");
				return 0;
			}
			ResultSet rst = db.execQuery(sql);
			if(rst!=null)
				return 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
	}
	//根据车辆id返回相应车辆
	public Car select_car(int id){
		Car car = new Car();
		try{
			String sql = "select * from Car where Car_Id="+id+" ";
			if(!db.openConnection()){
				System.out.println("fail to connect database");
				return null;
			}
			ResultSet rst = db.execQuery(sql);
			if(rst!=null){
				while(rst.next()){
					car.setCar_Id(rst.getInt("Car_Id"));
					car.setCar_Type(rst.getString("Car_Type"));
					car.setCar_Name(rst.getString("Car_Name"));
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
		return car;
	}
//修改车辆是否还可以继续使用	
	public int delete_car(int id){
		int flag=0;
		try{
			String sql = "update Car set Car_IsUseful where Car_Id="+id;
			if(!db.openConnection()){
				System.out.println("fail to connect database");
				return flag;
			}
			 flag=db.execCommand(sql);
			 return flag;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
}
	
}
