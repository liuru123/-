package com.example.service;

import java.util.List;


import com.example.dao.Car_Rental_Record_Dao;
import com.example.dao.Exhibition_Dao;
import com.example.model.Car;
import com.example.model.Rent_Record;

/**
 * ר��
 *
 */
public class Special_Car_Srv {
	Car_Rental_Record_Dao  crrd=new Car_Rental_Record_Dao();
	//�������г�������Ϣ
	public List<Car> CarLi(){
		List <Car> listCar=new Exhibition_Dao().CarList();
		return listCar;
		}
	
	//���ݳ������ͷ��س�����Ϣ
	public List<Car> CarL(String type){
	List <Car> listCar=new Exhibition_Dao().CarList(type);
	return listCar;
	}
	
	//�����⳵��¼
	public int insert_Record(Rent_Record r){
		return crrd.insert_record(r);
	}
}
