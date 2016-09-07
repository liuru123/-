package com.example.ui;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JDialog {
	
	private static final long serialVersionUID = 1L;
	JLabel ID = new JLabel(new ImageIcon("icon/id.png"));
	JTextField id = new JTextField();
	JLabel PASSWORD = new JLabel(new ImageIcon("icon/password.png"));
	JPasswordField password = new JPasswordField();
	JButton loginButton = new JButton(new ImageIcon("icon/user.png"));

	public Login() {
		this.setTitle("»áÔ±µÇÂ¼");
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
		
	}
	
	public JTextField getId() {
		return id;
	}
	public JPasswordField getPassword() {
		return password;
	}
	public JButton getLogin() {
		return loginButton;
	}
}
