package com.example.service;

import java.sql.SQLException;

import java.util.List;

import com.example.dao.Car_TypeDao;
import com.example.dao.Exhibition_Dao;
import com.example.model.Car;
import com.example.model.Car_Type;

/**
 * �ó�һ��
 *
 */
public class Exhibition_Srv {
	Exhibition_Dao ed=new Exhibition_Dao();
	Car_TypeDao ctd = new Car_TypeDao();
	//String s;
		//�������еĳ���
		public List<Car> FetchAll(){
			List<Car> listC=ed.CarList();
			
			return listC;
		}
		//�����ֶβ��ҳ���
		public List<Car> Fetch(String s){
			List<Car> listC=ed.CarList(s);
			return listC;
		}
		public Car_Type Fetch_Type(String s,String s2) throws SQLException, Exception{
			return ctd.lsCT(s,s2);
		}
}
