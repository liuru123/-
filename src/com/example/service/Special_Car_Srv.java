package com.example.service;

import java.util.List;


import com.example.dao.Car_Rental_Record_Dao;
import com.example.dao.Exhibition_Dao;
import com.example.model.Car;
import com.example.model.Rent_Record;

/**
 * 专车
 *
 */
public class Special_Car_Srv {
	Car_Rental_Record_Dao  crrd=new Car_Rental_Record_Dao();
	//返回所有车辆的信息
	public List<Car> CarLi(){
		List <Car> listCar=new Exhibition_Dao().CarList();
		return listCar;
		}
	
	//根据车辆类型返回车辆信息
	public List<Car> CarL(String type){
	List <Car> listCar=new Exhibition_Dao().CarList(type);
	return listCar;
	}
	
	//插入租车记录
	public int insert_Record(Rent_Record r){
		return crrd.insert_record(r);
	}
}
