package com.example.ui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register extends JDialog {
	
	private static final long serialVersionUID = 1L;
	JLabel ID = new JLabel(new ImageIcon("icon/id.png"));
	JTextField id = new JTextField();
	JLabel PASSWORD1 = new JLabel(new ImageIcon("icon/password.png"));
	JPasswordField password1 = new JPasswordField("«Î ‰»Î√‹¬Î£∫");
	JLabel PASSWORD2 = new JLabel(new ImageIcon("icon/password.png"));
	JPasswordField password2 = new JPasswordField("«Î÷ÿ∏¥ ‰»Î√‹¬Î£∫");
	JLabel IDCard = new JLabel(new ImageIcon("icon/id.png"));
	JTextField id_Card = new JTextField("«Î ‰»Î…Ì∑›÷§∫≈£∫");
	JButton registerButton = new JButton("◊¢≤·");
	
	
		
	public Register() {
		id.setForeground(Color.GRAY);
		id_Card.setForeground(Color.GRAY);
		password1.setEchoChar((char)0);
		password1.setForeground(Color.GRAY);
		password2.setEchoChar((char)0);
		password2.setForeground(Color.GRAY);
		this.setTitle("ª·‘±◊¢≤·");
		this.setModal(true);
		this.setLayout(null);
		this.setVisible(false);
		this.setBounds(320, 50, 640, 640);
		ID.setBounds(80, 40, 80, 40);
		id.setBounds(150, 47, 320, 30);
		PASSWORD1.setBounds(80, 120, 80, 40);
		password1.setBounds(150, 127, 320, 30);
		PASSWORD2.setBounds(80, 200, 80, 40);
		password2.setBounds(150, 207, 320, 30);
		IDCard.setBounds(80, 280, 80, 40);
		id_Card.setBounds(150, 287, 320, 30);
		registerButton.setBounds(280, 420, 60, 40);
		this.getContentPane().add(ID);
		this.getContentPane().add(id);
		this.getContentPane().add(PASSWORD1);
		this.getContentPane().add(password1);
		this.getContentPane().add(PASSWORD2);
		this.getContentPane().add(password2);
		this.getContentPane().add(IDCard);
		this.getContentPane().add(id_Card);
		this.getContentPane().add(registerButton);
	}
	
	public JTextField getId() {
		return id;
	}
	public JTextField getIdCard() {
		return id_Card;
	}
	public JPasswordField getPassword1() {
		return password1;
	}
	public JPasswordField getPassword2() {
		return password2;
	}
	public JButton getRegister() {
		return registerButton;
	}
}
