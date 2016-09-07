package com.example.model;

import java.sql.Date;

public class Reserve {
	private int Res_Id;
	private int DesD_Is;
	private double Deposit;
	private double RentMoney;
	private Date  Car_RentDate;
	private Date  Car_BackDate;
	private int Cus_Id;
	private int Car_Id;
	public int getRes_Id() {
		return Res_Id;
	}
	public void setRes_Id(int res_Id) {
		Res_Id = res_Id;
	}
	public int getDesD_Is() {
		return DesD_Is;
	}
	public void setDesD_Is(int desD_Is) {
		DesD_Is = desD_Is;
	}
	public double getDeposit() {
		return Deposit;
	}
	public void setDeposit(double deposit) {
		Deposit = deposit;
	}
	public double getRentMoney() {
		return RentMoney;
	}
	public void setRentMoney(double rentMoney) {
		RentMoney = rentMoney;
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
	
	public int getCar_Id() {
		return Car_Id;
	}
	public void setCar_Id(int car_Id) {
		Car_Id = car_Id;
	}
	public int getCus_Id() {
		return Cus_Id;
	}
	public void setCus_Id(int cus_Id) {
		Cus_Id = cus_Id;
	}
}
