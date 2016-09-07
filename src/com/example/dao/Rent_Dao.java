package com.example.dao;

import com.example.dal.DBUtil;

public class Rent_Dao {
	DBUtil db=new DBUtil();
	
	public int update_RentRec(int id)
	{
		String sql="update Rent_Record set Car_IsBack = 1 where Rec_Id="+id;
		try{
			if(!db.openConnection())
			{
				System.out.println("fail to connect database");
				return 0;
			}
			try {
				if(db.execCommand(sql)!=0){
					return 1;
				}
				else
					return 0;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				db.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	
}
