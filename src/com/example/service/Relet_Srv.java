package com.example.service;

import com.example.dao.Car_Rental_Record_Dao;
import com.example.model.Rent_Record;

/**
 * ����
 *
 */
public class Relet_Srv {
	Car_Rental_Record_Dao  crrd=new Car_Rental_Record_Dao();
	//�����⳵��¼
	public int update_Record(Rent_Record r){
		return crrd.update_record(r);
	}
}
