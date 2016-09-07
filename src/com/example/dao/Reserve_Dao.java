package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import com.example.dal.DBUtil;
import com.example.model.Reserve;

public class Reserve_Dao {

		DBUtil db=new DBUtil();
		//插入预租记录
		public int insert(Reserve c){
				try {
	
					String sql = "insert into Reserve(DesD_Is,Deposit, Car_RentDate,Car_BackDate, Cus_Id,Car_Id,Rent_Money)"
							+ " values("
							+ c.getDesD_Is()
							+","
							+c.getDeposit()
							+ ", '" + c.getCar_RentDate() 
							+ "', '" + c.getCar_BackDate()
							+"', "+c.getCus_Id()
							+", "+c.getCar_Id()
							+","+c.getRentMoney()
							+ ")";
					if(!db.openConnection()){
						System.out.println("fail to connect database");
						return 0;
					}
					if(db.execCommand(sql)!=0)
						return 1;
				} catch (Exception e) {
					e.printStackTrace();
				}finally{				
					try {
						db.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}				
				}
				
				return 0;
	}
//	public int update_Reserve(bespeak r){
//		try{
//			String sql = "update bespeak set Car_RentDate="+r.getCar_RentDate()+"','Car_BackDate="+r.getCar_BackDate()+"  where Bes_Id =  "+r.getBes_Id();
//			if(!db.openConnection()){
//				System.out.println("fail to connect database");
//				return 0;
//			}
//			ResultSet rst = db.execQuery(sql);
//			if(rst!=null){
//				return 1;
//			}
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			try {
//				db.close();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return 0;
//	   }
	//返回所有的预租记录
	public List<Reserve> fetchAll_Reserve(){
		List<Reserve> LRecord=null;
		LRecord = new LinkedList<Reserve>();
		String sql = "select * from Reserve";
		try{
			if(!db.openConnection()){
				System.out.println("fail to connect database");
				return null;
			}
			ResultSet rst = db.execQuery(sql);
			while(rst.next()){
				Reserve r = new Reserve();
				r.setRes_Id(rst.getInt("Res_Id"));
				r.setDesD_Is(rst.getInt("DesD_Is"));
				r.setDeposit(rst.getDouble("Deposit"));
				r.setCar_RentDate(rst.getDate("Car_RentDate"));
				r.setCar_BackDate(rst.getDate("Car_BackDate"));
				r.setCus_Id(rst.getInt("Cus_Id"));
				r.setCar_Id(rst.getInt("Car_Id"));
				r.setRentMoney(rst.getDouble("Rent_Money"));
				LRecord.add(r);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				db.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return LRecord;
	}
	//查询当前用户预租记录
	public Reserve search_Reserve(int Cus_Id) throws Exception{
		ResultSet rst=null;
		Reserve r = new Reserve();
		String sql="select * from Reserve where Cus_Id="+Cus_Id;
		try{
			
			if(!db.openConnection()){
				System.out.println("fail to connect database");	
			}
			rst=db.execQuery(sql);
			if(rst.next()){
				
				r.setRes_Id(rst.getInt("Res_Id"));
				r.setDesD_Is(rst.getInt("DesD_Is"));
				r.setDeposit(rst.getDouble("Deposit"));
				r.setCar_RentDate(rst.getDate("Car_RentDate"));
				r.setCar_BackDate(rst.getDate("Car_BackDate"));
				r.setCus_Id(rst.getInt("Cus_Id"));
				r.setCar_Id(rst.getInt("Car_Id"));
				r.setRentMoney(rst.getDouble("Rent_Money"));
				return r;
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return null;
	}
	
	//删除当前用户预租记录
	public int delete_Reserve(int Cus_Id) throws Exception{
		String sql="delete from Reserve where Cus_Id="+Cus_Id+" ";
		try{		
			if(!db.openConnection()){
				System.out.println("fail to connect database");	
			}
			return db.execCommand(sql);
				
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return 0;
		}
}
