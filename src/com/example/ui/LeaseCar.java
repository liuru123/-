package com.example.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import com.example.model.Car;
import com.example.model.Car_Type;
import com.example.model.Reserve;
import com.example.service.LeaseCar_Srv;
import com.example.service.ReserveSrv;

/**
 * 个人租车
 *
 */
public class LeaseCar extends JPanel{
	
	private static final long serialVersionUID = 1L;
	JPanel panel = new Paintpanel(new ImageIcon("icon/background_lc.jpg").getImage());;
	JPanel title = new Paintpanel(new ImageIcon("icon/title_lease.PNG").getImage());
	JScrollPane js1 = new JScrollPane();
	JScrollPane js2 = new JScrollPane();
	JPanel exhibition1 = new Paintpanel(new ImageIcon("icon/background2.jpg").getImage());//显示所有车辆
	JPanel exhibition2 = new Paintpanel(new ImageIcon("icon/background2.jpg").getImage());//显单选得到的车辆
	JButton[] car_button = new JButton[12];
	JLabel[] car_label = new JLabel[12];
	JButton type1 = new JButton( new ImageIcon("icon/type11.png"));
	JButton type2 = new JButton( new ImageIcon("icon/type21.png"));
	JButton type3 = new JButton( new ImageIcon("icon/type31.png"));
	JButton type4 = new JButton( new ImageIcon("icon/type41.png"));
	JButton type5 = new JButton( new ImageIcon("icon/type51.png"));
	JButton type6 = new JButton( new ImageIcon("icon/type61.png"));
	rentOrder ro = new rentOrder(null);
	LeaseCar_Srv lcSrv = new LeaseCar_Srv();
	List<Car> carList = lcSrv.CarLi();//所有车辆的列表
	List<Car> searchList = new ArrayList<>();//搜索或单选得到的车辆列表

	public LeaseCar() {
		this.setLayout(null);
		this.setVisible(false);
		panel.setLayout(null);
		exhibition1.setLayout(null);
		exhibition2.setLayout(null);
		js2.setVisible(false);
		
		for(int i = 0;i < carList.size();i++) { //显示所有车辆
			final Car car = carList.get(i);
			car_button[i] = new JButton(new ImageIcon("icon/car1.jpg"));
			car_label[i] = new JLabel(car.getCar_Name());
			car_button[i].setBorderPainted(false);
			car_button[i].setContentAreaFilled(false);
			car_button[i].setBounds(40+(i%6)*150, (i/6)*100, 120, 70);
			car_label[i].setBounds(70+(i%6)*150, (i/6)*100+70, 120, 20);
			exhibition1.add(car_button[i]);
			exhibition1.add(car_label[i]);
			car_button[i].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent Arg0) {
					ro = new rentOrder(car);
					ro.jd.setVisible(true);
					
				}
			});
			
		}
		
		type1.setBorderPainted(false);
		type1.setContentAreaFilled(false);
		type2.setBorderPainted(false);
		type2.setContentAreaFilled(false);
		type3.setBorderPainted(false);
		type3.setContentAreaFilled(false);
		type4.setBorderPainted(false);
		type4.setContentAreaFilled(false);
		type5.setBorderPainted(false);
		type5.setContentAreaFilled(false);
		type6.setBorderPainted(false);
		type6.setContentAreaFilled(false);
		this.setBounds(0,80,1280,640);
		panel.setBounds(0, 0, 1280, 640);
		js1.setBounds(220, 80, 960, 480);
		js2.setBounds(220, 80, 960, 480);
		exhibition1.setBounds(0, 0, 960, 480);
		exhibition2.setBounds(0, 0, 960, 480);
		title.setBounds(0, 0, 1280, 40);
		type1.setBounds(0, 240, 82, 52);
		type2.setBounds(100, 240, 82, 52);
		type3.setBounds(0, 320, 82, 52);
		type4.setBounds(100, 320, 82, 52);
		type5.setBounds(0, 400, 82, 52);
		type6.setBounds(100, 400, 82, 52);
		js1.setViewportView(exhibition1);
		js2.setViewportView(exhibition2);
		panel.add(title);
		panel.add(js1);
		panel.add(js2);
		panel.add(type1);
		panel.add(type2);
		panel.add(type3);
		panel.add(type4);
		panel.add(type5);
		panel.add(type6);
		this.add(panel);
		
		type1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				type1.setIcon( new ImageIcon("icon/type12.png"));
				type2.setIcon( new ImageIcon("icon/type21.png"));
				type3.setIcon( new ImageIcon("icon/type31.png"));
				type4.setIcon( new ImageIcon("icon/type41.png"));
				type5.setIcon( new ImageIcon("icon/type51.png"));
				type6.setIcon( new ImageIcon("icon/type61.png"));
				searchList.clear();
				searchList = lcSrv.CarLi();
				Refresh();
				
			}
		});
		
		type2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				type1.setIcon( new ImageIcon("icon/type11.png"));
				type2.setIcon( new ImageIcon("icon/type22.png"));
				type3.setIcon( new ImageIcon("icon/type31.png"));
				type4.setIcon( new ImageIcon("icon/type41.png"));
				type5.setIcon( new ImageIcon("icon/type51.png"));
				type6.setIcon( new ImageIcon("icon/type61.png"));
				String s = "小型";
				searchList.clear();
				searchList = lcSrv.CarL(s);
				Refresh();
				
			}
		});
		
		type3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				type1.setIcon( new ImageIcon("icon/type11.png"));
				type2.setIcon( new ImageIcon("icon/type21.png"));
				type3.setIcon( new ImageIcon("icon/type32.png"));
				type4.setIcon( new ImageIcon("icon/type41.png"));
				type5.setIcon( new ImageIcon("icon/type51.png"));
				type6.setIcon( new ImageIcon("icon/type61.png"));
				String s = "中型";
				searchList.clear();
				searchList = lcSrv.CarL(s);
				Refresh();
				
			}
		});
		
		type4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				type1.setIcon( new ImageIcon("icon/type11.png"));
				type2.setIcon( new ImageIcon("icon/type21.png"));
				type3.setIcon( new ImageIcon("icon/type31.png"));
				type4.setIcon( new ImageIcon("icon/type42.png"));
				type5.setIcon( new ImageIcon("icon/type51.png"));
				type6.setIcon( new ImageIcon("icon/type61.png"));
				String s = "豪华型";
				searchList.clear();
				searchList = lcSrv.CarL(s);
				Refresh();
				
			}
		});
		
		type5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				type1.setIcon( new ImageIcon("icon/type11.png"));
				type2.setIcon( new ImageIcon("icon/type21.png"));
				type3.setIcon( new ImageIcon("icon/type31.png"));
				type4.setIcon( new ImageIcon("icon/type41.png"));
				type5.setIcon( new ImageIcon("icon/type52.png"));
				type6.setIcon( new ImageIcon("icon/type61.png"));
				String s = "suv";
				searchList.clear();
				searchList = lcSrv.CarL(s);
				Refresh();
				
			}
		});
		
		type6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				type1.setIcon( new ImageIcon("icon/type11.png"));
				type2.setIcon( new ImageIcon("icon/type21.png"));
				type3.setIcon( new ImageIcon("icon/type31.png"));
				type4.setIcon( new ImageIcon("icon/type41.png"));
				type5.setIcon( new ImageIcon("icon/type51.png"));
				type6.setIcon( new ImageIcon("icon/type62.png"));
				String s = "跑车";
				searchList.clear();
				searchList = lcSrv.CarL(s);
				Refresh();
				
			}
		});
		
	}
	public void Refresh() {//根据搜索或单选将显示所有车辆的exhibition更新为显示相应车辆的exhibition1
		js1.setVisible(false);
		js2.setVisible(true);
		exhibition2.removeAll();
		exhibition2.updateUI();
		for( int i = 0;i < searchList.size();i++) {
			final Car car = searchList.get(i);
			car_button[i] = new JButton(new ImageIcon("icon/car1.jpg"));
			car_label[i] = new JLabel(car.getCar_Name());
			car_button[i].setBorderPainted(false);
			car_button[i].setContentAreaFilled(false);
			car_button[i].setBounds(40+(i%6)*150, (i/6)*100, 120, 70);
			car_label[i].setBounds(70+(i%6)*150, (i/6)*100+70, 120, 20);
			exhibition2.add(car_button[i]);
			exhibition2.add(car_label[i]);
			car_button[i].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent Arg0) {
					ro = new rentOrder(car);
					ro.jd.setVisible(true);
				}
			});
		}
	}
	
	public void changePanel() {
		js1.setVisible(true);
		js2.setVisible(false);
	}
	
}


class rentOrder extends JDialog{//显示预租订单信息
	private static final long serialVersionUID = 1L;
	JDialog jd = new JDialog(MainMenu.frame, "预租信息", true);
	JLabel name = new JLabel();
	JLabel type = new JLabel();
	JLabel rentMoney = new JLabel();
	JLabel count = new JLabel();
	JLabel seat = new JLabel();
	JLabel color = new JLabel();
	JLabel isUseful = new JLabel();
	JLabel description = new JLabel();
	JTextField Date1 = new JTextField();
	JTextField Date2 = new JTextField();
	String date1 = new String("");
	String date2 = new String("");
	ButtonGroup desd = new ButtonGroup();
	JRadioButton desd1 = new JRadioButton("有代驾");
	JRadioButton desd2 = new JRadioButton("无代驾");
	JButton submit = new JButton("提交预租");
	Reserve reserve = new Reserve();
	Car_Type cartype;
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Calendar addDay = java.util.Calendar.getInstance(); 
	public rentOrder(final Car car) {
		jd.setLayout(null);
		jd.setVisible(false);
		if(car != null) {
		try {
			cartype = new LeaseCar_Srv().Fetch_Type(car.getCar_Type(), car.getCar_Name());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		name.setText("车辆名称："+car.getCar_Name());
		type.setText("车辆类型："+car.getCar_Type());
		rentMoney.setText("日租金: "+cartype.getCar_RentMoney());
		count.setText("剩余数量: "+cartype.getCar_Count());
		seat.setText("车座数量："+car.getSeat_Count());
		color.setText("车辆颜色："+car.getCar_Color());
		isUseful.setText("是否可用："+car.getCar_IsUseful());
		description.setText("新旧程度："+car.getCar_Description());
		}
		Date1.setText("输入租车日期：yyyy-mm-dd");
		Date1.setForeground(Color.GRAY);
		Date2.setText("输入租车天数：");
		Date2.setForeground(Color.GRAY);
		desd.add(desd1);
		desd.add(desd2);
		name.setBounds(20, 30, 150, 30);
		type.setBounds(180, 30, 150, 30);
		rentMoney.setBounds(20, 80, 150, 30);
		count.setBounds(180, 80, 150, 30);
		seat.setBounds(20, 130, 150, 30);
		color.setBounds(180, 130, 150, 30);
		isUseful.setBounds(20, 180, 150, 30);
		description.setBounds(180, 180, 150, 30);
		desd1.setBounds(20, 230, 150, 30);
		desd2.setBounds(180, 230, 150, 30);
		Date1.setBounds(20, 280, 180, 30);
		Date2.setBounds(210, 280, 100, 30);
		submit.setBounds(150, 450, 100, 40);
		jd.add(name);
		jd.add(type);
		jd.add(rentMoney);
		jd.add(count);
		jd.add(seat);
		jd.add(color);
		jd.add(isUseful);
		jd.add(description);
		jd.add(desd1);
		jd.add(desd2);
		jd.add(Date1);
		jd.add(Date2);
		jd.add(submit);
		jd.setBounds(420, 100, 400, 560);
		jd.addWindowListener(new WindowAdapter(){
		       public void windowOpened(WindowEvent e) {
		             submit.requestFocus();
		       }
		});
		
		Date1.addFocusListener(new FocusListener() {//日期输入提示
			public void focusLost(FocusEvent e) {
				date1 = Date1.getText();
				if(Date1.getText().isEmpty()) {
					Date1.setForeground(Color.GRAY);
					Date1.setText("输入租车日期：yyyy-mm-dd");
				}		
			}
			public void focusGained(FocusEvent e) {
				Date1.setText("");
				Date1.setForeground(Color.BLACK);
			}
		});
		
		Date2.addFocusListener(new FocusListener() {//日期输入提示
			public void focusLost(FocusEvent e) {
				date2 = Date2.getText();
				if(Date2.getText().isEmpty()) {
					Date2.setForeground(Color.GRAY);
					Date2.setText("输入租车天数：");
				}		
			}
			public void focusGained(FocusEvent e) {
				Date2.setText("");
				Date2.setForeground(Color.BLACK);
			}
		});
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(desd1.isSelected())
					reserve.setDesD_Is(1);
				else
					reserve.setDesD_Is(0);
				
				try {
					if(new ReserveSrv().search_Res(MainMenu.id) != null)
						javax.swing.JOptionPane.showMessageDialog(MainMenu.frame, "用户存在未完成预租记录");
					
					else if(date1.compareTo("") != 0 && date2.compareTo("") != 0 && isNumeric(date2)) {
						addDay.setTime(dateformat.parse(date1));
						addDay.add(Calendar.DATE, Integer.parseInt(date2));
						String date3 = dateformat.format(addDay.getTime());
						reserve.setCar_RentDate(setStringDate(date1));
						reserve.setCar_BackDate(setStringDate(date3));
						reserve.setRentMoney(cartype.getCar_RentMoney()*Integer.parseInt(date2));
						reserve.setDeposit(cartype.getCar_RentMoney()*Integer.parseInt(date2)*0.3);
						reserve.setCus_Id(MainMenu.id);
						reserve.setCar_Id(car.getCar_Id());
						javax.swing.JOptionPane.showMessageDialog(MainMenu.frame, "成功提交预租");
						new ReserveSrv().add(reserve);
						jd.setVisible(false);
					}
					else if(!isNumeric(date2)) {
						javax.swing.JOptionPane.showMessageDialog(MainMenu.frame, "租车天数有误");
					}
					
					else
						javax.swing.JOptionPane.showMessageDialog(MainMenu.frame, "输入信息不完整");
				} catch (ParseException e) {
					javax.swing.JOptionPane.showMessageDialog(MainMenu.frame, "日期格式有误");
				}
		
			}
		});
	}	
	
	public static java.sql.Date setStringDate(String dateStr) throws ParseException {//字符串转换SQL日期格式
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date date = null;
		String s = dateformat.format(dateformat.parse(dateStr));
		date = java.sql.Date.valueOf(s);
		return date;
	}
	
	public static boolean isNumeric(String str){//租车天数格式限定
		for (int i = 0; i < str.length(); i++){
			if (!Character.isDigit(str.charAt(i)))
				return false;
		}
		return true;
	}
}
