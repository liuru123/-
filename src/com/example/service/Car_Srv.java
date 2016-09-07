package com.example.service;

import com.example.dao.CarDAO;
import com.example.dao.Car_TypeDao;
import com.example.model.Car;

public class Car_Srv {
	CarDAO cd=new CarDAO();
	Car_TypeDao ctd = new Car_TypeDao();;
	
	public Car select_CarSrv(int Car_Id){
		
		return cd.select_car(Car_Id); 
	}
	
	public int add_Count_Srv(String s1,String s2){
		
		return ctd.countAdd(s1, s2);
	}

	public int sub_Count_Srv(String s1,String s2){
	
		return ctd.countSub(s1, s2); 
}
}
