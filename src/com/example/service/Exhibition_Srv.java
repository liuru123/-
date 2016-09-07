package com.example.service;

import java.sql.SQLException;

import java.util.List;

import com.example.dao.Car_TypeDao;
import com.example.dao.Exhibition_Dao;
import com.example.model.Car;
import com.example.model.Car_Type;

/**
 * 用车一览
 *
 */
public class Exhibition_Srv {
	Exhibition_Dao ed=new Exhibition_Dao();
	Car_TypeDao ctd = new Car_TypeDao();
	//String s;
		//返回所有的车辆
		public List<Car> FetchAll(){
			List<Car> listC=ed.CarList();
			
			return listC;
		}
		//根据字段查找车辆
		public List<Car> Fetch(String s){
			List<Car> listC=ed.CarList(s);
			return listC;
		}
		public Car_Type Fetch_Type(String s,String s2) throws SQLException, Exception{
			return ctd.lsCT(s,s2);
		}
}
