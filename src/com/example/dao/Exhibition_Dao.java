package com.example.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import com.example.dal.DBUtil;
import com.example.model.Car;

public class Exhibition_Dao {
	//返回所有的车辆信息
	public List<Car> CarList(){
		List <Car> listCar=null;
		listCar = new LinkedList<Car>();
		try{
			String sql = "select * from Car";
	
			DBUtil db = new DBUtil();
			if(!db.openConnection()){
				System.out.println("fail to connect database");
				return null;
			}
			ResultSet rst = db.execQuery(sql);
			if(rst!=null){
				while(rst.next()){
					Car car = new Car();
					car.setCar_Id(rst.getInt("Car_Id"));
					car.setCar_Name(rst.getString("Car_Name"));
					car.setCar_Type(rst.getString("Car_Type"));
					car.setSeat_Count(rst.getInt("Seat_Count"));
					car.setCar_Door(rst.getInt("Car_Door"));
					car.setCar_Window(rst.getInt("Car_Window"));
					car.setCar_GPS(rst.getInt("Car_Gps"));
					car.setCar_Oil(rst.getInt("Car_Oil"));
					car.setCar_Gasbag(rst.getInt("Car_Gasbag"));
					car.setCar_Color(rst.getString("Car_Color"));
					car.setCar_Image(rst.getString("Car_Image"));
					car.setCar_IsUseful(rst.getInt("Car_IsUseful"));
					car.setCar_Description(rst.getString("Car_Description"));
					
					listCar.add(car);
					
				}
			}
			db.close(rst);
			db.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{	
		}
		return listCar;
	}
	
	//根据字段查找车辆信息
	public List<Car> CarList(String s){
		List <Car> listCar=null;
		listCar = new LinkedList<Car>();
		try{
			String sql = "select * from Car where Car_Name like '%"+s+"%' or Car_Type='"+s+"'";
			s.trim();
			DBUtil db = new DBUtil();
			if(!db.openConnection()){
				System.out.println("fail to connect database");
				return null;
			}
			ResultSet rst = db.execQuery(sql);
			if(rst!=null){
				while(rst.next()){
					Car car = new Car();
					car.setCar_Id(rst.getInt("Car_Id"));
					car.setCar_Name(rst.getString("Car_Name"));
					car.setCar_Type(rst.getString("Car_Type"));
					car.setSeat_Count(rst.getInt("Seat_Count"));
					car.setCar_Door(rst.getInt("Car_Door"));
					car.setCar_Window(rst.getInt("Car_Window"));
					car.setCar_GPS(rst.getInt("Car_Gps"));
					car.setCar_Oil(rst.getInt("Car_Oil"));
					car.setCar_Gasbag(rst.getInt("Car_Gasbag"));
					car.setCar_Color(rst.getString("Car_Color"));
					car.setCar_Image(rst.getString("Car_Image"));
					car.setCar_IsUseful(rst.getInt("Car_IsUseful"));
					car.setCar_Description(rst.getString("Car_Description"));
					listCar.add(car);
					
				}
			}
			db.close(rst);
			db.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return listCar;
	}
	
	
	
}
