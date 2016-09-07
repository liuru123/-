package com.example.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import com.example.service.Exhibition_Srv;

/**
 * 用车一览
 *
 */	

	public class Exhibition extends JPanel{
		int j = 0;
		private static final long serialVersionUID = 1L;
		JPanel panel = new Paintpanel(new ImageIcon("icon/background_ex.jpg").getImage());
		JScrollPane js1 = new JScrollPane();
		JScrollPane js2 = new JScrollPane();
		JPanel exhibition1 = new Paintpanel(new ImageIcon("icon/background1.jpg").getImage());//显示所有车辆
		JPanel exhibition2 = new Paintpanel(new ImageIcon("icon/background1.jpg").getImage());//显示搜索或单选得到的车辆
		JTextField search = new JTextField(60);
		JButton search_button = new JButton(new ImageIcon("icon/search.png"));
		JButton[] car_button = new JButton[12];
		JLabel[] car_label = new JLabel[12];
		
		ButtonGroup type = new ButtonGroup();
		JRadioButton type1 = new JRadioButton("不限");
		JRadioButton type2 = new JRadioButton("经济型");
		JRadioButton type3 = new JRadioButton("商务型");
		JRadioButton type4 = new JRadioButton("豪华型");
		JRadioButton type5 = new JRadioButton("SUV");
		JRadioButton type6 = new JRadioButton("跑车型");
		Exhibition_Srv exSrv = new Exhibition_Srv();
		List<Car> carList = exSrv.FetchAll();//所有车辆的列表
		List<Car> searchList = new ArrayList<>();//搜索或单选得到的车辆列表
		
		public Exhibition() {
			this.setLayout(null);
			this.setVisible(false);
			panel.setLayout(null);
			search.setOpaque(false);
			exhibition1.setLayout(null);
			exhibition2.setLayout(null);
			js2.setVisible(false);
			for(int i = 0;i < carList.size();i++) { //显示所有车辆
				j++;
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
						new CarInfo(car);
						
						
					}
				});
				
			}
			search_button.setBorderPainted(false);
			search_button.setContentAreaFilled(false);
			type1.setBorderPainted(false);
			type1.setContentAreaFilled(false);
			type1.setSelected(true);
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
			
			this.setBounds(0, 80, 1280, 640);
			panel.setBounds(0, 0, 1280, 640);
			js1.setBounds(180, 100, 960, 480);
			js2.setBounds(180, 100, 960, 480);
			exhibition1.setBounds(0, 0, 960, 480);
			exhibition2.setBounds(0, 0, 960, 480);
			search.setBounds(250, 30 , 600 , 30);
			search_button.setBounds(880, 30, 80 , 30);
			type1.setBounds(0, 240, 120, 20);
			type2.setBounds(0, 280, 120, 20);
			type3.setBounds(0, 320, 120, 20);
			type4.setBounds(0, 360, 120, 20);
			type5.setBounds(0, 400, 120, 20);
			type6.setBounds(0, 440, 120, 20);
			
			type.add(type1);
			type.add(type2);
			type.add(type3);
			type.add(type4);
			type.add(type5);
			type.add(type6);
			js1.setViewportView(exhibition1);
			js2.setViewportView(exhibition2);
			panel.add(js1);
			panel.add(js2);
			panel.add(search);
			panel.add(search_button);
			panel.add(type1);
			panel.add(type2);
			panel.add(type3);
			panel.add(type4);
			panel.add(type5);
			panel.add(type6);
			this.add(panel);
		
			search_button.addActionListener(new ActionListener() { //根据搜索结果更新searchList
				public void actionPerformed(ActionEvent arg0) {
					String s = search.getText();
					searchList.clear();
					searchList = exSrv.Fetch(s);
					Refresh();
				}
			});
			
			//根据单选结果更新searchList
			type1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					searchList.clear();
					searchList = exSrv.FetchAll();
					Refresh();
				}
			});
			
			type2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String s = "小型";
					searchList.clear();
					searchList = exSrv.Fetch(s);
					Refresh();
				}
			});
			
			type3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String s = "中型";
					searchList.clear();
					searchList = exSrv.Fetch(s);
					Refresh();
				}
			});
			
			type4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String s = "豪华型";
					searchList.clear();
					searchList = exSrv.Fetch(s);
					Refresh();
				}
			});
			
			type5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String s = "suv";
					searchList.clear();
					searchList = exSrv.Fetch(s);
					Refresh();
				}
			});
			
			type6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String s = "跑车";
					searchList.clear();
					searchList = exSrv.Fetch(s);
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
				j++;
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
						new CarInfo(car);	
					}
				});
			}
		}
		
		public void changePanel() {
			js1.setVisible(true);
			js2.setVisible(false);
		}
		
	}
	
	class CarInfo extends JDialog{//显示车辆详细信息
		private static final long serialVersionUID = 1L;
		JDialog jd = new JDialog(MainMenu.frame, "车辆信息", true);
		JLabel name = new JLabel();
		JLabel type = new JLabel();
		JLabel worth = new JLabel();
		JLabel count = new JLabel();
		JLabel seat = new JLabel();
		JLabel color = new JLabel();
		JLabel door = new JLabel();
		JLabel window = new JLabel();
		JLabel gps = new JLabel();
		JLabel gasbag = new JLabel();
		JLabel isUseful = new JLabel();
		JLabel description = new JLabel();
		JLabel oil = new JLabel();
		JLabel rent = new JLabel();
		Car_Type cartype;
		public CarInfo(Car car) {
			jd.setLayout(null);
			try {
				cartype = new Exhibition_Srv().Fetch_Type(car.getCar_Type(), car.getCar_Name());
			} catch (Exception e) {
				e.printStackTrace();
			}
			name.setText("车辆名称："+car.getCar_Name());
			type.setText("车辆类型："+car.getCar_Type());
			worth.setText("车辆价值："+cartype.getCar_Worth());
			count.setText("剩余数量："+cartype.getCar_Count());
			seat.setText("车座数量："+car.getSeat_Count());
			color.setText("车辆颜色："+car.getCar_Color());
			door.setText("车门数量："+car.getCar_Door());
			window.setText("天窗数量："+car.getCar_Window());
			gps.setText("车辆导航："+car.getCar_GPS());
			gasbag.setText("安全气囊："+car.getCar_Gasbag());
			isUseful.setText("是否可用："+car.getCar_IsUseful());
			description.setText("新旧状态："+car.getCar_Description());
			oil.setText("百公里油耗："+car.getCar_Oil());
			rent.setText("租金："+cartype.getCar_RentMoney());
			name.setBounds(20, 30, 150, 30);
			type.setBounds(180, 30, 150, 30);
			worth.setBounds(20, 80, 150, 30);
			count.setBounds(180, 80, 150, 30);
			seat.setBounds(20, 130, 150, 30);
			color.setBounds(180, 130, 150, 30);
			door.setBounds(20, 180, 150, 30);
			window.setBounds(180, 180, 150, 30);
			gps.setBounds(20, 230, 150, 30);
			gasbag.setBounds(180, 230, 150, 30);
			isUseful.setBounds(20, 280, 150, 30);
			description.setBounds(180, 280, 150, 30);
			oil.setBounds(20, 330, 150, 30);
			rent.setBounds(180, 330, 150, 30);
			jd.add(name);
			jd.add(type);
			jd.add(worth);
			jd.add(count);
			jd.add(seat);
			jd.add(color);
			jd.add(door);
			jd.add(window);
			jd.add(gps);
			jd.add(gasbag);
			jd.add(isUseful);
			jd.add(description);
			jd.add(oil);
			jd.add(rent);
			jd.setBounds(420, 100, 400, 560);
			jd.setVisible(true);
			
		}	
	}

