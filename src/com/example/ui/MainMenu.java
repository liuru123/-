package com.example.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.service.Car_Srv;
import com.example.service.Rent_Srv;
import com.example.service.ReserveSrv;


public class MainMenu {
	public static MainMenu m;
	public static Login l;
	public static Register r;
	public static String idnum;
	public static int id;
	public static Boolean loginStatus = false;
	static JFrame frame = new JFrame();
	JPanel title = new Paintpanel(new ImageIcon("icon/title_background.PNG").getImage());
	JPanel user1 = new JPanel();
	JPanel user2 = new JPanel();
	JPanel menu = new JPanel();
	Exhibition ex = new Exhibition();
	Car_Rental_Record crr = new Car_Rental_Record();
	Personal_information pi = new Personal_information();
	Reserve_Record rr = new Reserve_Record();
	Enterprise_Car_Rental ecr = new Enterprise_Car_Rental();
	Special_Car sc = new Special_Car();
	LeaseCar lc = new LeaseCar();
	Rent rt = new Rent();
	JPanel exhibition = new Paintpanel(new ImageIcon("icon/exhibition.jpg").getImage());
	JPanel car_Rental_Record = new Paintpanel(new ImageIcon("icon/car_Rental_Record.png").getImage());
	JPanel personal_Information = new Paintpanel(new ImageIcon("icon/personal_information.jpg").getImage());
	JPanel reserve_Record = new Paintpanel(new ImageIcon("icon/reserve.png").getImage());
	JPanel enterprise_Car_Rental = new Paintpanel(new ImageIcon("icon/enterprise_car_rental.jpg").getImage());
	JPanel special_Car = new Paintpanel(new ImageIcon("icon/special_car.jpg").getImage());
	JPanel leaseCar = new Paintpanel(new ImageIcon("icon/leasecar.png").getImage());
	JPanel rent = new Paintpanel(new ImageIcon("icon/rent.png").getImage());
	ImageIcon status1 = new ImageIcon("icon/login_status1.PNG");
	ImageIcon status2 = new ImageIcon("icon/login_status2.PNG");
	ImageIcon backIcon = new ImageIcon("icon/back.png");
	JLabel login_status1 = new JLabel(status1);
	JLabel login_status2 = new JLabel(status2);
	JLabel user_name = new JLabel("");
	JButton login = new JButton("登录");
	JButton register =new JButton("注册"); 
	JButton logoff = new JButton("注销");
	JButton back = new JButton(backIcon);
	
	public static void main(String[] args) {
		m = new MainMenu();
		l = new Login();
		r = new Register();
		new LoginEvent();
		new RegisterEvent();
		l.dispose();
		r.dispose();
	}
	
	public MainMenu() {
		
		frame.setLayout(null);
		frame.setResizable(false);
		title.setLayout(null);
		menu.setLayout(null);
		user1.setBackground(Color.CYAN);
		user2.setBackground(Color.CYAN);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		exhibition.setBackground(Color.BLACK);
		car_Rental_Record.setBackground(Color.PINK);
		personal_Information.setBackground(Color.GRAY);
		reserve_Record.setBackground(Color.lightGray);
		enterprise_Car_Rental.setBackground(Color.YELLOW);
		special_Car.setBackground(Color.RED);
		leaseCar.setBackground(Color.GREEN);
		rent.setBackground(Color.ORANGE);
		user1.add(login_status1);
		user2.add(login_status2);
		user2.add(user_name);
		user1.add(login);
		user1.add(register);
		user2.add(logoff);
		title.add(user1);
		title.add(user2);
		menu.add(exhibition);
		menu.add(car_Rental_Record);
		menu.add(personal_Information);
		menu.add(reserve_Record);
		menu.add(enterprise_Car_Rental);
		menu.add(special_Car);
		menu.add(leaseCar);
		menu.add(rent);
		frame.add(title);
		frame.add(menu);
		user1.setBounds(1000,0,280,80);
		user2.setBounds(1000,0,280,80);
		title.setBounds(0,0,1280,80);
		menu.setBounds(0, 80, 1280, 640);
		exhibition.setBounds(0, 0, 320, 640);
		car_Rental_Record.setBounds(320, 0, 340, 213);
		personal_Information.setBounds(660, 0, 340, 213 );
		reserve_Record.setBounds(1000, 0, 280, 213);
		enterprise_Car_Rental.setBounds(320, 213, 480, 213);
		special_Car.setBounds(800, 213, 480, 213);
		leaseCar.setBounds(320, 426, 680, 213);
		rent.setBounds(1000, 426, 280 , 213);
		frame.setSize(1280, 720);
		frame.setVisible(true);
		user1.setVisible(true);
		user2.setVisible(false);
		
		exhibition.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				menu.setVisible(false);
				ex.setVisible(true);
				ex.search.setText("");
				ex.panel.add(back);
				ex.changePanel();
				back.setBounds(1200, 560, 80, 60);
				frame.add(ex);
				back.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						menu.setVisible(true);
						frame.remove(ex);
					}
				});
			}
		});
		
		car_Rental_Record.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				if(loginStatus) {
					crr = new Car_Rental_Record();
					menu.setVisible(false);
					crr.setVisible(true);
					back.setBounds(1200, 560, 80, 60);
					crr.panel.add(back);
					frame.add(crr);
					back.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent arg0) {
							menu.setVisible(true);
							frame.remove(crr);
						}
					});
				}
				else
					javax.swing.JOptionPane.showMessageDialog(frame, "请先进行登录或注册");
			}
		});
		
		personal_Information.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				if(loginStatus) {
					pi = new Personal_information();
					menu.setVisible(false);
					pi.setVisible(true);
					pi.panel1.add(back);
					back.setBounds(1200, 560, 80, 60);
					frame.add(pi);
					back.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent arg0) {
							menu.setVisible(true);
							frame.remove(pi);
						}
					});
				}
				else
					javax.swing.JOptionPane.showMessageDialog(frame, "请先进行登录或注册");
			
			}
		});
		

		
		reserve_Record.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				if(loginStatus) {
					rr = new Reserve_Record();
					JButton cancel = new JButton("取消预租");
					menu.setVisible(false);
					rr.setVisible(true);
					rr.panel.add(back);
					rr.panel.add(cancel);
					back.setBounds(1200, 560, 80, 60);
					cancel.setBounds(0, 570, 120, 40);
					frame.add(rr);
					back.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent arg0) {
							menu.setVisible(true);
							frame.remove(rr);
						}
					});
					cancel.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent arg0) {
		
							if(rr.record != null) {
								new ReserveSrv().delete_Res(id);
							}
						}
					});
				}	
				else
					javax.swing.JOptionPane.showMessageDialog(frame, "请先进行登录或注册");
			
			}
		});
		
		enterprise_Car_Rental.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				if(loginStatus) {
					menu.setVisible(false);
					ecr.setVisible(true);
					ecr.add(back);
					back.setBounds(1200, 560, 80, 60);
					frame.add(ecr);
					back.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent arg0) {
							menu.setVisible(true);
							frame.remove(ecr);
						}
					});
				}
				else
					javax.swing.JOptionPane.showMessageDialog(frame, "请先进行登录或注册");
			
			}
		});
		
		special_Car.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				if(loginStatus) {
					menu.setVisible(false);
					sc.setVisible(true);
					sc.add(back);
					back.setBounds(1200, 560, 80, 60);
					frame.add(sc);
					back.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent arg0) {
							menu.setVisible(true);
							frame.remove(sc);
						}
					});
				}
				else
					javax.swing.JOptionPane.showMessageDialog(frame, "请先进行登录或注册");
			
			}
		});
		
		leaseCar.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				if(loginStatus) {
					menu.setVisible(false);
					lc.setVisible(true);
					lc.panel.add(back);
					lc.changePanel();
					back.setBounds(1200, 560, 80, 60);
					frame.add(lc);
					back.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent arg0) {
							menu.setVisible(true);
							frame.remove(lc);
						}
					});
				}
				else
					javax.swing.JOptionPane.showMessageDialog(frame, "请先进行登录或注册");
			
			}
		});
		
		rent.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				if(loginStatus) {
					rt = new Rent();
					JButton returnCar = new JButton("还车缴费");
					menu.setVisible(false);
					rt.setVisible(true);	
					rt.panel.add(back);
					rt.panel.add(returnCar);
					back.setBounds(1200, 560, 80, 60);
					returnCar.setBounds(0, 570, 120, 40);
					frame.add(rt);
					back.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent arg0) {
							menu.setVisible(true);
							frame.remove(rt);
						}
					});
					returnCar.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent arg0) {
		
							if(rt.record.size() != 0) {
								String s1 = new Car_Srv().select_CarSrv(rt.record.get(rt.record.size()-1).getCar_Id()).getCar_Type();
								String s2= new Car_Srv().select_CarSrv(rt.record.get(rt.record.size()-1).getCar_Id()).getCar_Name();
								System.out.println(s1+s2);
								new Car_Srv().add_Count_Srv(s1, s2);
								new Rent_Srv().update_RentRecSrv(rt.record.get(rt.record.size()-1).getRec_Id());
								javax.swing.JOptionPane.showMessageDialog(frame, "还车成功");
							}
						}
					});
				}
				else
					javax.swing.JOptionPane.showMessageDialog(frame, "请先进行登录或注册");
			}
		});
	}
	
	public void setUser1() {
		user1.setVisible(true);
		user2.setVisible(false);
	}
	
	public void setUser2() {
		user1.setVisible(false);
		user2.setVisible(true);
	}
	
	public void setUserName(String username) {
		user_name.setText(username+"   ");
		user_name.setForeground(Color.RED);
		user_name.setFont(new Font("宋体", Font.PLAIN, 30)); 
	}
	
	public JButton getLogin() {
		return login;
	}
	public JButton getRegister() {
		return register;
	}
	public JButton getLogoff() {
		return logoff;
	}
}

class Paintpanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image image = null;
	public Paintpanel(Image image) {
		this.image = image;
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null, this);
	}
}

