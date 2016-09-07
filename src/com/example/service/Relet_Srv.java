package com.example.service;

import com.example.dao.Car_Rental_Record_Dao;
import com.example.model.Rent_Record;

/**
 * 续租
 *
 */
public class Relet_Srv {
	Car_Rental_Record_Dao  crrd=new Car_Rental_Record_Dao();
	//更新租车记录
	public int update_Record(Rent_Record r){
		return crrd.update_record(r);
	}
}
