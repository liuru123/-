package com.example.model;

import java.sql.Date;

/**
 * 租车记录
 *
 */
public class Rent_Record {
	private int    Rec_Id;
	private int    E_Id;
	private int    Car_Id;
	private int Cus_Id;
	private Date   Car_RentDate;
	private Date   Car_BackDate;
	private int    Car_IsBack;   //车的出租状态
	private double Deposit;
	private int    DesD_Is;
	private double Car_RentMoney;
	public int getRec_Id() {
		return Rec_Id;
	}
	public void setRec_Id(int rec_Id) {
		Rec_Id = rec_Id;
	}
	public int getE_Id() {
		return E_Id;
	}
	public void setE_Id(int e_Id) {
		E_Id = e_Id;
	}
	public int getCar_Id() {
		return Car_Id;
	}
	public void setCar_Id(int car_Id) {
		Car_Id = car_Id;
	}
	
	public Date getCar_RentDate() {
		return Car_RentDate;
	}
	public void setCar_RentDate(Date car_RentDate) {
		Car_RentDate = car_RentDate;
	}
	public Date getCar_BackDate() {
		return Car_BackDate;
	}
	public void setCar_BackDate(Date car_BackDate) {
		Car_BackDate = car_BackDate;
	}
	public int getCar_IsBack() {
		return Car_IsBack;
	}
	public void setCar_IsBack(int car_IsBack) {
		Car_IsBack = car_IsBack;
	}
	public double getDeposit() {
		return Deposit;
	}
	public void setDeposit(double deposit) {
		Deposit = deposit;
	}
	public int getDesD_Is() {
		return DesD_Is;
	}
	public void setDesD_Is(int desD_Is) {
		DesD_Is = desD_Is;
	}
	public double getCar_RentMoney() {
		return Car_RentMoney;
	}
	public void setCar_RentMoney(double car_RentMoney) {
		Car_RentMoney = car_RentMoney;
	}
	public int getCus_Id() {
		return Cus_Id;
	}
	public void setCus_Id(int cus_Id) {
		Cus_Id = cus_Id;
	}
	
}