package com.example.model;

public class Car {
	private  int     Car_Id;
	private  String  Car_Name;
	private  String  Car_Type;
	private  int     Seat_Count;     		//座位数
	private  int     Car_Door;				//车门数
	private  int     Car_Window;    		//天窗
	private  int     Car_GPS;
	private  int     Car_Oil;     			//油箱容量
	private  int     Car_Gasbag;            //	气囊
	private  String	 Car_Color;
	private  String    Car_Image;
	private  int 	 Car_IsUseful;
	private  String  Car_Description;	
	
	
	public int getCar_Id() {
		return Car_Id;
	}
	public void setCar_Id(int car_Id) {
		Car_Id = car_Id;
	}
	public String getCar_Name() {
		return Car_Name;
	}
	public void setCar_Name(String car_Name) {
		Car_Name = car_Name;
	}
	public String getCar_Type() {
		return Car_Type;
	}
	public void setCar_Type(String car_Type) {
		Car_Type = car_Type;
	}

	public int getCar_Door() {
		return Car_Door;
	}
	public void setCar_Door(int car_Door) {
		Car_Door = car_Door;
	}
	public int getCar_Window() {
		return Car_Window;
	}
	public void setCar_Window(int car_Window) {
		Car_Window = car_Window;
	}
	public int getCar_GPS() {
		return Car_GPS;
	}
	public void setCar_GPS(int car_GPS) {
		Car_GPS = car_GPS;
	}
	public int getCar_Oil() {
		return Car_Oil;
	}
	public void setCar_Oil(int car_Oil) {
		Car_Oil = car_Oil;
	}
	public int getCar_Gasbag() {
		return Car_Gasbag;
	}
	public void setCar_Gasbag(int car_Gasbag) {
		Car_Gasbag = car_Gasbag;
	}
	public String getCar_Color() {
		return Car_Color;
	}
	public void setCar_Color(String car_Color) {
		Car_Color = car_Color;
	}
	

	public String getCar_Description() {
		return Car_Description;
	}
	public void setCar_Description(String car_Description) {
		Car_Description = car_Description;
	}
	public int getCar_IsUseful() {
		return Car_IsUseful;
	}
	public void setCar_IsUseful(int car_IsUseful) {
		Car_IsUseful = car_IsUseful;
	}
	public String getCar_Image() {
		return Car_Image;
	}
	public void setCar_Image(String car_Image) {
		Car_Image = car_Image;
	}
	public int getSeat_Count() {
		return Seat_Count;
	}
	public void setSeat_Count(int string) {
		Seat_Count = string;
	}			
}