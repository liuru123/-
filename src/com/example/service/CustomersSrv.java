package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.CustomersDAO;
import com.example.model.Customers;

public class CustomersSrv {
	CustomersDAO cod=new CustomersDAO();
	List<Customers> lcs=new ArrayList<Customers>();
	//更新用户的信息
	public int update_CusSrv(Customers cu){
		
		return cod.update_cus(cu);
	}
	
	//根据用户id查询用户的信息
	public Customers select_CusSrv(int Cus_Id){
		
		return cod.select_cus(Cus_Id); 
	}
	public List<Customers> lisCus(){
		lcs=cod.fetchAll_cus();
		return lcs;
	}
}
