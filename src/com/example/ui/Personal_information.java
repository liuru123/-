package com.example.ui;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.example.model.Customers;
import com.example.service.CustomersSrv;

/**
 * 个人信息
 *
 */
public class Personal_information extends JPanel{
	private static final long serialVersionUID=1L;
	JPanel panel1 = new Paintpanel(new ImageIcon("icon/background_pi.jpg").getImage());
	JPanel panel2 = new JPanel();
	JLabel user_account = new JLabel();
	JLabel user_name = new JLabel();
	JLabel user_idnum = new JLabel();
	JLabel user_sex = new JLabel();
	JLabel user_company = new JLabel();
	JLabel user_tel = new JLabel();
	JLabel user_drilicense = new JLabel();
	JLabel user_address = new JLabel();
	JButton complete = new JButton("完善信息");
	Complete c = new Complete();
	CustomersSrv cs = new CustomersSrv();
	Customers customer  = new Customers();
	
	public Personal_information(){
		this.setLayout(null);
		panel1.setLayout(null);
		panel2.setLayout(null);
		this.setVisible(false);
		this.setBounds(0,80,1280,640);
		panel1.setBounds(0, 0, 1280, 640);
		panel2.setBounds(280, 0, 720, 640);
		customer = cs.select_CusSrv(MainMenu.id);
		user_account.setText("用户名："+customer.getCus_Nickname());
		user_account.setBounds(50, 20, 180, 40);
		user_account.setFont(new Font("宋体", Font.PLAIN, 20));
		user_name.setText("姓名："+customer.getCus_Name());
		user_name.setBounds(380, 20, 180, 40);
		user_name.setFont(new Font("宋体", Font.PLAIN, 20));
		user_idnum.setText("身份证："+customer.getCus_IDNum());
		user_idnum.setBounds(50, 100, 180, 40);
		user_idnum.setFont(new Font("宋体", Font.PLAIN, 20));
		user_sex.setText("性别："+customer.getCus_Sex());
		user_sex.setBounds(380, 100, 180, 40);
		user_sex.setFont(new Font("宋体", Font.PLAIN, 20));
		user_company.setText("公司："+customer.getCus_Company());
		user_company.setBounds(50, 180, 180, 40);
		user_company.setFont(new Font("宋体", Font.PLAIN, 20));
		user_tel.setText("电话："+customer.getCus_Tel());
		user_tel.setBounds(380, 180, 180, 40);
		user_tel.setFont(new Font("宋体", Font.PLAIN, 20));
		user_drilicense.setText("驾驶证："+customer.getCus_DriLicense_Id());
		user_drilicense.setBounds(50, 260, 180, 40);
		user_drilicense.setFont(new Font("宋体", Font.PLAIN, 20));
		user_address.setText("地址："+customer.getCus_Address());
		user_address.setBounds(380, 260, 180, 40);
		user_address.setFont(new Font("宋体", Font.PLAIN, 20));
		complete.setBounds(310, 560, 100, 40);
		panel2.add(user_account);
		panel2.add(user_name);
		panel2.add(user_idnum);
		panel2.add(user_sex);
		panel2.add(user_company);
		panel2.add(user_tel);
		panel2.add(user_drilicense);
		panel2.add(user_address);
		panel2.add(complete);
		panel1.add(panel2);
		this.add(panel1);
		
		complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.jd.setVisible(true);
				
			}
		});
		
		c.submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!MainMenu.loginStatus) {
					javax.swing.JOptionPane.showMessageDialog(MainMenu.frame, "请先登录");
				}
				else if(c.name.getText().compareTo("") == 0||c.account.getText().compareTo("") == 0||c.idnum.getText().compareTo("") == 0) {
					javax.swing.JOptionPane.showMessageDialog(MainMenu.frame, "信息输入不完整");
				}
				else{
					customer.setCus_Nickname(c.account.getText());
					customer.setCus_IDNum(c.idnum.getText());
					customer.setCus_Name(c.name.getText());
					customer.setCus_Name(c.name.getText());
					customer.setCus_Name(c.name.getText());
					customer.setCus_Sex(c.sex.getText());
					customer.setCus_Company(c.company.getText());
					customer.setCus_Tel(c.tel.getText());
					customer.setCus_DriLicense_Id(c.drilicense.getText());
					customer.setCus_Address(c.address.getText());
					if(cs.update_CusSrv(customer) == 1) {
						javax.swing.JOptionPane.showMessageDialog(MainMenu.frame, "更新成功");
					}					
					c.jd.setVisible(false);	
					
				}
				
			}
		});
		
	}
	
}

class Complete extends JDialog {
	private static final long serialVersionUID = 1L;
	JDialog jd = new JDialog(MainMenu.frame, "完善信息", true);
	JTextField account = new JTextField(60);
	JLabel account_hint = new JLabel("*请输入用户名");
	JTextField idnum = new JTextField(60);
	JLabel idnum_hint = new JLabel("*请输入身份证号");
	JTextField name = new JTextField(60);
	JLabel name_hint = new JLabel("*请输入真实姓名");
	JTextField sex = new JTextField(60);
	JLabel sex_hint = new JLabel("*请输入性别");
	JTextField company = new JTextField(60);
	JLabel company_hint = new JLabel("*请输入公司名");
	JTextField tel = new JTextField(60);
	JLabel tel_hint = new JLabel("*请输入联系电话");
	JTextField drilicense = new JTextField(60);
	JLabel drilicense_hint = new JLabel("*请输入驾驶证号");
	JTextField address = new JTextField(60);
	JLabel address_hint = new JLabel("*请输入家庭住址");
	JButton submit = new JButton("提交");
	public Complete() {
		jd.setLayout(null);
		jd.setVisible(false);
		account.setBounds(50, 30, 150, 20);
		account_hint.setForeground(Color.PINK);
		account_hint.setBounds(230, 30, 150, 20);
		idnum.setBounds(50, 80, 150, 20);
		idnum_hint.setForeground(Color.PINK);
		idnum_hint.setBounds(230, 80, 150, 20);
		name.setBounds(50, 130, 150, 20);
		name_hint.setForeground(Color.PINK);
		name_hint.setBounds(230, 130, 150, 20);
		sex.setBounds(50, 180, 150, 20);
		sex_hint.setForeground(Color.GRAY);;
		sex_hint.setBounds(230, 180, 150, 20);
		company.setBounds(50, 230, 150, 20);
		company_hint.setForeground(Color.GRAY);
		company_hint.setBounds(230, 230, 150, 20);
		tel.setBounds(50, 280, 150, 20);
		tel_hint.setForeground(Color.GRAY);
		tel_hint.setBounds(230, 280, 150, 20);
		drilicense.setBounds(50, 330, 150, 20);
		drilicense_hint.setForeground(Color.GRAY);
		drilicense_hint.setBounds(230, 330, 150, 20);
		address.setBounds(50, 380, 150, 20);
		address_hint.setForeground(Color.GRAY);
		address_hint.setBounds(230, 380, 150, 20);
		submit.setBounds(150, 450, 80, 40);
		jd.add(account);
		jd.add(account_hint);
		jd.add(idnum);
		jd.add(idnum_hint);
		jd.add(name);
		jd.add(name_hint);
		jd.add(sex);
		jd.add(sex_hint);
		jd.add(company);
		jd.add(company_hint);
		jd.add(tel);
		jd.add(tel_hint);
		jd.add(drilicense);
		jd.add(drilicense_hint);
		jd.add(address);
		jd.add(address_hint);
		jd.add(submit);
		jd.setBounds(440, 100, 400, 560);
				
	}
}


