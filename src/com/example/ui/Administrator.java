package com.example.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.example.model.Car;
import com.example.model.Car_Type;
import com.example.model.Customers;
import com.example.model.Rent_Record;
import com.example.model.Reserve;
import com.example.service.Car_Rental_RecordSrv;
import com.example.service.Car_Srv;
import com.example.service.CustomersSrv;
import com.example.service.Exhibition_Srv;
import com.example.service.ReserveSrv;

public class Administrator {
	static Ad_login log;
	static Ad_MainMenu mainMenu;	
	public static void main(String[] args) {
		log = new Ad_login();
		log.setVisible(true);
	}
	
}

class Ad_MainMenu {
	
	JFrame frame = new JFrame();
	JPanel title = new Paintpanel(new ImageIcon("icon/title_background.PNG").getImage());
	JPanel menu = new JPanel();
	JPanel user = new JPanel();
	JLabel login_status = new JLabel(new ImageIcon("icon/login_status3.PNG"));
	Ad_Record ar = new Ad_Record();
	Ad_Reserve are = new Ad_Reserve();
	Ad_Car ac = new Ad_Car();
	Ad_Customer acr = new Ad_Customer();
	JPanel record = new Paintpanel(new ImageIcon("icon/ad_record.PNG").getImage());
	JPanel reserve = new Paintpanel(new ImageIcon("icon/ad_reserve.PNG").getImage());
	JPanel car = new Paintpanel(new ImageIcon("icon/ad_car.PNG").getImage());
	JPanel customer = new Paintpanel(new ImageIcon("icon/ad_customer.PNG").getImage());
	JButton back = new JButton(new ImageIcon("icon/back.png"));
	
	public Ad_MainMenu() {
		frame.setLayout(null);
		frame.setResizable(false);
		title.setLayout(null);
		user.setLayout(null);
		menu.setLayout(null);
		user.setBackground(Color.CYAN);
		record.setBackground(Color.BLACK);
		reserve.setBackground(Color.BLUE);
		car.setBackground(Color.YELLOW);
		customer.setBackground(Color.ORANGE);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		user.add(login_status);
		title.add(user);
		menu.add(record);
		menu.add(reserve);
		menu.add(car);
		menu.add(customer);
		frame.add(title);
		frame.add(menu);
		login_status.setBounds(20,20,240,40);
		user.setBounds(1000,0,280,80);
		title.setBounds(0,0,1280,80);
		menu.setBounds(0, 80, 1280, 640);
		record.setBounds(0, 0, 640, 320);
		reserve.setBounds(640, 0, 640, 320);
		car.setBounds(0, 320, 640, 320);
		customer.setBounds(640, 320, 640, 320);	
		frame.setSize(1280, 720);
		frame.setVisible(true);
		
		record.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				ar = new Ad_Record();
				menu.setVisible(false);
				ar.setVisible(true);
				back.setBounds(1200, 560, 80, 60);
				ar.panel.add(back);
				frame.add(ar);
				back.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						menu.setVisible(true);
						frame.remove(ar);
					}
				});
			}
		});
		
		reserve.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				
				are = new Ad_Reserve();
				JButton approve = new JButton("核准预租");
				menu.setVisible(false);
				are.setVisible(true);
				are.panel.add(back);
				are.panel.add(approve);
				back.setBounds(1200, 560, 80, 60);
				approve.setBounds(0, 570, 120, 40);
				frame.add(are);
				back.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						menu.setVisible(true);
						frame.remove(are);
					}
				});
				approve.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						int row = are.table.getSelectedRow();
						if(row == -1){
							JOptionPane.showMessageDialog(are,"请选择要核准的行!");
						}else{
							
							List<Rent_Record> record = new Car_Rental_RecordSrv().listSrv((int)are.table.getValueAt(row, 1));
							if(record.size() > 0) {
								if(record.get(record.size()-1).getCar_IsBack() == 0)
									JOptionPane.showMessageDialog(are,"当前用户存在正在进行的租车记录!");
								else {
									new Car_Rental_RecordSrv().dealReserve((int)are.table.getValueAt(row, 0));
									new ReserveSrv().delete_Res(((int)are.table.getValueAt(row, 1)));
									are.tableModel.removeRow(row);
								}
							}else {
								new Car_Rental_RecordSrv().dealReserve((int)are.table.getValueAt(row, 0));
								new ReserveSrv().delete_Res(((int)are.table.getValueAt(row, 1)));
								are.tableModel.removeRow(row);
							}
						}	
					}
				});
			}
		});
		
		car.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				ac = new Ad_Car();
				JButton delete = new JButton("删除车辆");
				menu.setVisible(false);
				ac.setVisible(true);
				ac.panel.add(back);
				ac.panel.add(delete);
				back.setBounds(1200, 560, 80, 60);
				delete.setBounds(0, 570, 120, 40);
				frame.add(ac);
				back.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						menu.setVisible(true);
						frame.remove(ac);
					}
				});	
				delete.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						int row = ac.table.getSelectedRow();
						if(row == -1){
							JOptionPane.showMessageDialog(ac,"请选择要删除的行!");
						}else
							ac.tableModel.removeRow(row);
					}
				});
			}
		});
		
		customer.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				acr = new Ad_Customer();
				menu.setVisible(false);
				acr.setVisible(true);
				back.setBounds(1200, 560, 80, 60);
				acr.panel.add(back);
				frame.add(acr);
				back.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						menu.setVisible(true);
						frame.remove(acr);
					}
				});
			}
		});
	}
}

class Ad_login extends JDialog {
	private static final long serialVersionUID = 1L;
	JLabel ID = new JLabel(new ImageIcon("icon/id.png"));
	JTextField id = new JTextField();
	JLabel PASSWORD = new JLabel(new ImageIcon("icon/password.png"));
	JPasswordField password = new JPasswordField();
	JButton loginButton = new JButton(new ImageIcon("icon/user.png"));

	public Ad_login() {
		this.setTitle("管理员登录");
		this.setModal(true);
		this.setLayout(null);
		this.setVisible(false);
		this.setBounds(480, 240, 300, 200);
		ID.setBounds(20, 40, 40, 20);
		id.setBounds(60, 40, 160, 20);
		PASSWORD.setBounds(20, 80, 40, 20);
		password.setBounds(60, 80, 160, 20);
		loginButton.setBounds(110, 120, 50, 30);
		loginButton.setBackground(Color.PINK);
		this.getContentPane().add(ID);
		this.getContentPane().add(id);
		this.getContentPane().add(PASSWORD);
		this.getContentPane().add(password);
		this.getContentPane().add(loginButton);	
	
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administrator.log.setVisible(false);
				Administrator.mainMenu = new Ad_MainMenu();
			}
		});
	}
	
}

class Ad_Record extends JPanel{//租车记录
	private static final long serialVersionUID=1L;
	JPanel panel = new JPanel();
	JPanel title = new Paintpanel(new ImageIcon("icon/title_record.PNG").getImage());
	Object[][] obj = new Object[31][9];
	Object[] head = new Object[]{"记录编号","用户编号", "用户姓名", "车辆名称","租车日期","还车日期","还车状态","代驾状态","租金"};
	JTable table = new JTable(null);
	DefaultTableModel tableModel;
	List<Rent_Record> record = new Car_Rental_RecordSrv().listSrv();
	
	public Ad_Record(){
		this.setLayout(null);
		panel.setLayout(null);
		this.setVisible(false);
		this.setBounds(0,80,1280,640);
		panel.setBounds(0, 0, 1280, 640);
		title.setBounds(0, 0, 1280, 40);
		
		for(int i = 0;i < record.size();i++) {
			obj[i][0] = record.get(i).getRec_Id();
			obj[i][1] = record.get(i).getCus_Id();
			obj[i][2] = new CustomersSrv().select_CusSrv(record.get(i).getCus_Id()).getCus_Name();
			obj[i][3] = new Car_Srv().select_CarSrv(record.get(i).getCar_Id()).getCar_Name();
			obj[i][4] = record.get(i).getCar_RentDate();
			obj[i][5] = record.get(i).getCar_BackDate();
			obj[i][6] = record.get(i).getCar_IsBack();
			obj[i][7] = record.get(i).getDesD_Is();
			obj[i][8] = record.get(i).getCar_RentMoney();
		}
		
		tableModel = new DefaultTableModel(obj, head);
		table.setModel(tableModel);
		table.setEnabled(false);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(0, 40, 1280, 520);
		panel.add(sp);
		panel.add(title);
		this.add(panel);
		
	}
	
}

class Ad_Reserve extends JPanel {//预租记录
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	JPanel title = new Paintpanel(new ImageIcon("icon/title_reserve.PNG").getImage());
	Object[][] obj = new Object[31][9];
	Object[] head = new Object[]{"记录编号", "用户编号", "用户姓名", "车辆名称", "租车日期","还车日期","押金","租金","代驾状态"};
	JTable table = new JTable(null);
	DefaultTableModel tableModel;
	List<Reserve> record = new ReserveSrv().listRes();

	public Ad_Reserve() {
		this.setLayout(null);
		panel.setLayout(null);
		this.setVisible(false);
		this.setBounds(0,80,1280,640);
		panel.setBounds(0, 0, 1280, 640);
		title.setBounds(0, 0, 1280, 40);
		
		for(int i = 0;i < record.size();i++) {
			obj[i][0] = record.get(i).getRes_Id();
			obj[i][1] = record.get(i).getCus_Id();
			obj[i][2] = new CustomersSrv().select_CusSrv(record.get(i).getCus_Id()).getCus_Name();
			obj[i][3] = new Car_Srv().select_CarSrv(record.get(i).getCar_Id()).getCar_Name();
			obj[i][4] = record.get(i).getCar_RentDate();
			obj[i][5] = record.get(i).getCar_BackDate();
			obj[i][6] = record.get(i).getDeposit();
			obj[i][7] = record.get(i).getRentMoney();
			obj[i][8] = record.get(i).getDesD_Is();
		}
		tableModel = new DefaultTableModel(obj, head);
		table.setModel(tableModel);
		table.setSelectionBackground(Color.RED);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(0, 40, 1280, 520);
		panel.add(sp);
		panel.add(title);
		this.add(panel);
	}
}

class Ad_Car extends JPanel{//车辆信息
	private static final long serialVersionUID=1L;
	JPanel panel = new JPanel();
	JPanel title = new Paintpanel(new ImageIcon("icon/title_car.PNG").getImage());
	Object[][] obj = new Object[31][14];
	Object[] head = new Object[]{"车辆名称","车辆类型", "车辆价值", "剩余数量","车座数量","车辆颜色","车门数量","天窗数量","车辆导航","安全气囊","是否可用","新旧状态","百公里油耗","日租金"};
	JTable table = new JTable(null);
	DefaultTableModel tableModel;
	List<Car> carList = new Exhibition_Srv().FetchAll();
	
	public Ad_Car(){
		this.setLayout(null);
		panel.setLayout(null);
		this.setVisible(false);
		this.setBounds(0,80,1280,640);
		panel.setBounds(0, 0, 1280, 640);
		title.setBounds(0, 0, 1280, 40);
		
		for(int i = 0;i < carList.size();i++) {
			Car car = carList.get(i);
			Car_Type cartype = null;
			try {
				cartype = new Exhibition_Srv().Fetch_Type(car.getCar_Type(), car.getCar_Name());
			} catch (Exception e) {
				e.printStackTrace();
			}
			obj[i][0] = car.getCar_Name();
			obj[i][1] = car.getCar_Type();
			obj[i][2] = cartype.getCar_Worth();
			obj[i][3] = cartype.getCar_Count();
			obj[i][4] = car.getSeat_Count();
			obj[i][5] = car.getCar_Color();
			obj[i][6] = car.getCar_Door();
			obj[i][7] = car.getCar_Window();
			obj[i][8] = car.getCar_GPS();
			obj[i][9] = car.getCar_Gasbag();
			obj[i][10] = car.getCar_IsUseful();
			obj[i][11] = car.getCar_Description();
			obj[i][12] = car.getCar_Oil();
			obj[i][13] = cartype.getCar_RentMoney();
		}
		
		tableModel = new DefaultTableModel(obj, head);
		table.setModel(tableModel);
		table.setSelectionBackground(Color.RED);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(0, 40, 1280, 520);
		panel.add(sp);
		panel.add(title);
		this.add(panel);
		
	}
	
}

class Ad_Customer extends JPanel{//会员信息
	private static final long serialVersionUID=1L;
	JPanel panel = new JPanel();
	JPanel title = new Paintpanel(new ImageIcon("icon/title_customer.PNG").getImage());
	Object[][] obj = new Object[31][9];
	Object[] head = new Object[]{"会员编号", "会员姓名", "账户名","身份证","性别","公司","电话","地址","驾驶证"};
	JTable table = new JTable(null);
	DefaultTableModel tableModel;
	List<Customers> customer = new CustomersSrv().lisCus();
	
	public Ad_Customer(){
		this.setLayout(null);
		panel.setLayout(null);
		this.setVisible(false);
		this.setBounds(0,80,1280,640);
		panel.setBounds(0, 0, 1280, 640);
		title.setBounds(0, 0, 1280, 40);
		
		for(int i = 0;i < customer.size();i++) {
			obj[i][0] = customer.get(i).getCus_Id();
			obj[i][1] = customer.get(i).getCus_Name();
			obj[i][2] = customer.get(i).getCus_Nickname();
			obj[i][3] = customer.get(i).getCus_IDNum();
			obj[i][4] = customer.get(i).getCus_Sex();
			obj[i][5] = customer.get(i).getCus_Company();
			obj[i][6] = customer.get(i).getCus_Tel();
			obj[i][7] = customer.get(i).getCus_Address();
			obj[i][8] = customer.get(i).getCus_DriLicense_Id();
		}
		
		tableModel = new DefaultTableModel(obj, head);
		table.setModel(tableModel);
		table.setEnabled(false);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(0, 40, 1280, 520);
		panel.add(sp);
		panel.add(title);
		this.add(panel);
		
	}
	
}