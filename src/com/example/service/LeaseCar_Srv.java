package com.example.service;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.Car_Rental_Record_Dao;
import com.example.dao.Car_TypeDao;
import com.example.dao.Exhibition_Dao;
import com.example.dao.Reserve_Dao;
import com.example.model.Car;
import com.example.model.Car_Type;
import com.example.model.Rent_Record;
import com.example.model.Reserve;

/**
 * 个人租车
 * @author 代栋
 *
 */
public class LeaseCar_Srv {
	Car_Rental_Record_Dao  crrd=new Car_Rental_Record_Dao();
	Reserve_Dao rr=new Reserve_Dao();
	Car_TypeDao ctd = new Car_TypeDao();
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
	
	//插入预租的记录
	public int insert_Reserve(Reserve b){
			return rr.insert(b);
	}
	//插入租车记录
	public int insert_Record(Rent_Record r){
		return crrd.insert_record(r);
	}
	public Car_Type Fetch_Type(String s,String s2) throws SQLException, Exception{
		return ctd.lsCT(s,s2);
	}
}
