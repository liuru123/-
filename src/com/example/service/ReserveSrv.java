package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.Reserve_Dao;
import com.example.model.Reserve;

public class ReserveSrv {
		Reserve_Dao rse=new Reserve_Dao();
		List <Reserve> lis=new ArrayList<Reserve>();
		
		//����һ��Ԥ���¼
		public int add(Reserve rec){
			return rse.insert(rec);
		}
		//�������е�Ԥ���¼
		public List<Reserve> listRes(){
			lis=rse.fetchAll_Reserve();
			return lis;
		}
		//�����û�Ԥ���¼
		public Reserve search_Res(int cusId){
			try {
				return rse.search_Reserve(cusId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		//ɾ���û�Ԥ���¼
		public int delete_Res(int cusId){
			try {
				return rse.delete_Reserve(cusId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}
}
