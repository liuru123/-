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
 * �����⳵
 * @author ����
 *
 */
public class LeaseCar_Srv {
	Car_Rental_Record_Dao  crrd=new Car_Rental_Record_Dao();
	Reserve_Dao rr=new Reserve_Dao();
	Car_TypeDao ctd = new Car_TypeDao();
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
	
	//����Ԥ��ļ�¼
	public int insert_Reserve(Reserve b){
			return rr.insert(b);
	}
	//�����⳵��¼
	public int insert_Record(Rent_Record r){
		return crrd.insert_record(r);
	}
	public Car_Type Fetch_Type(String s,String s2) throws SQLException, Exception{
		return ctd.lsCT(s,s2);
	}
}
