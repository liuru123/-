package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.Reserve_Dao;
import com.example.model.Reserve;

public class ReserveSrv {
		Reserve_Dao rse=new Reserve_Dao();
		List <Reserve> lis=new ArrayList<Reserve>();
		
		//插入一条预租记录
		public int add(Reserve rec){
			return rse.insert(rec);
		}
		//返回所有的预租记录
		public List<Reserve> listRes(){
			lis=rse.fetchAll_Reserve();
			return lis;
		}
		//返回用户预租记录
		public Reserve search_Res(int cusId){
			try {
				return rse.search_Reserve(cusId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		//删除用户预租记录
		public int delete_Res(int cusId){
			try {
				return rse.delete_Reserve(cusId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}
}
