package com.example.ui;

import com.example.dao.LoginVerification;
import com.example.model.Customers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginEvent {
	static LoginVerification lv;
	Customers user_login = new Customers();
	
	JTextField id = MainMenu.l.getId();
	JPasswordField password  = MainMenu.l.getPassword();
	
	public LoginEvent() {		
		JButton login1 = MainMenu.m.getLogin();
		JButton login2 = MainMenu.l.getLogin();
		JButton logoff = MainMenu.m.getLogoff();
		
		login1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MainMenu.l.setVisible(true);	
			}
		});
		
		login2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					lv =new LoginVerification(user_login);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				if(lv.getFlag()) {
					MainMenu.l.setVisible(false);
					MainMenu.m.setUser2();
					MainMenu.m.setUserName(user_login.getCus_Nickname());
					MainMenu.loginStatus = true;
					try {
						MainMenu.idnum = lv.getIdNum();
						MainMenu.id = lv.getId();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		logoff.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MainMenu.m.setUser1();
				MainMenu.loginStatus = false;
				MainMenu.idnum = null;
			}
		});
		
		id.addKeyListener(new KeyAdapter() { 
	        public void keyReleased(KeyEvent e) { 
	                super.keyReleased(e); 
	                user_login.setCus_Nickname(id.getText());
	        } 
	    });
		
		password.addKeyListener(new KeyAdapter() { 
	        public void keyReleased(KeyEvent e) { 
	                super.keyReleased(e); 
	                char[] chars = password.getPassword(); 
	                user_login.setCus_Password(String.valueOf(chars));
	        } 
	    });
	}
	
}
