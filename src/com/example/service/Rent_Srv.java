package com.example.service;

import com.example.dao.Rent_Dao;

/**
 *�����ɷ�
 *
 */
public class Rent_Srv {
	Rent_Dao rd=new Rent_Dao();
	
	public int update_RentRecSrv(int id) {
		return rd.update_RentRec(id);
	}
	
}
