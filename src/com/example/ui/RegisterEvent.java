package com.example.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.example.dao.RegistrationRecord;
import com.example.model.Customers;


public class RegisterEvent {
	static RegistrationRecord rr;
	Customers user_register = new Customers();
	String second_password = "";
	JTextField id = MainMenu.r.getId();
	JTextField id_Card = MainMenu.r.getIdCard();
	JPasswordField password1  = MainMenu.r.getPassword1();
	JPasswordField password2  = MainMenu.r.getPassword2();
	
	public RegisterEvent() {
		user_register.setCus_Password("");
		user_register.setCus_IDNum("");
		JButton register1 = MainMenu.m.getRegister();
		final JButton register2 = MainMenu.r.getRegister();
		
		MainMenu.r.addWindowListener(new WindowAdapter(){

		       public void windowOpened(WindowEvent e) {

		             register2.requestFocus();

		       }

		});

		register1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MainMenu.r.setVisible(true);	
			}
		});
		
		register2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(user_register.getCus_Nickname().compareTo("") == 0||user_register.getCus_Password().compareTo("") == 0||second_password.compareTo("") == 0||user_register.getCus_IDNum().compareTo("") == 0) {
					javax.swing.JOptionPane.showMessageDialog(MainMenu.r, "������Ϣ������");
				}
				else if(user_register.getCus_Password().compareTo(second_password) != 0) {
					javax.swing.JOptionPane.showMessageDialog(MainMenu.r, "�����������벻��ͬ");
				}
				else {
					javax.swing.JOptionPane.showMessageDialog(MainMenu.r, "ע��ɹ�");
					try {
						rr = new RegistrationRecord(user_register);
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					MainMenu.r.setVisible(false);
				}
				id.setForeground(Color.GRAY);
				id.setText("�������û�����");
				password1.setForeground(Color.GRAY);
				password1.setEchoChar((char)0);
				password1.setText("���������룺");
				password2.setForeground(Color.GRAY);
				password2.setEchoChar((char)0);
				password2.setText("���ظ��������룺");
				id_Card.setForeground(Color.GRAY);
				id_Card.setText("���������֤�ţ�");
			}
		});
		
		id.addFocusListener(new FocusListener() {
			
			public void focusLost(FocusEvent e) {
				user_register.setCus_Nickname(id.getText());
				if(user_register.getCus_Nickname().isEmpty()) {
					id.setForeground(Color.GRAY);
					id.setText("�������û�����");
				}		
			}
			public void focusGained(FocusEvent e) {
				id.setText("");
				id.setForeground(Color.BLACK);
			}
		});
		id_Card.addFocusListener(new FocusListener() {
			
			public void focusLost(FocusEvent e) {
				user_register.setCus_IDNum(id_Card.getText());
				if(user_register.getCus_IDNum().isEmpty()) {
					id_Card.setForeground(Color.GRAY);
					id_Card.setText("���������֤�ţ�");
				}		
			}
			public void focusGained(FocusEvent e) {
				id_Card.setText("");
				user_register.setCus_IDNum("");
				id_Card.setForeground(Color.BLACK);
			}
		});
		
		password1.addFocusListener(new FocusListener() {
			
			public void focusLost(FocusEvent e) {
				char[] chars = password1.getPassword(); 
				user_register.setCus_Password(String.valueOf(chars));
				if(user_register.getCus_Password().isEmpty()) {
					password1.setEchoChar((char)0);
					password1.setForeground(Color.GRAY);
					password1.setText("���������룺");
				}		
			}
			public void focusGained(FocusEvent e) {
				password1.setText("");
				password1.setEchoChar('*');
				password1.setForeground(Color.BLACK);
			}
		});
		
		password2.addFocusListener(new FocusListener() {
			
			public void focusLost(FocusEvent e) {
				char[] chars = password2.getPassword(); 
				second_password = String.valueOf(chars);
				if(second_password.isEmpty()) {
					second_password = (String.valueOf(chars));
					password2.setEchoChar((char)0);
					password2.setForeground(Color.GRAY);
					password2.setText("���ظ��������룺");
				}		
			}
			public void focusGained(FocusEvent e) {
				password2.setText("");
				password2.setEchoChar('*');
				password2.setForeground(Color.BLACK);
			}
		});
	}
	
}
