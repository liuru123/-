package com.example.ui;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.example.model.Reserve;
import com.example.service.Car_Srv;
import com.example.service.CustomersSrv;
import com.example.service.ReserveSrv;

public class Reserve_Record extends JPanel {
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	JPanel title = new Paintpanel(new ImageIcon("icon/title_reserve.PNG").getImage());
	Object[][] obj = new Object[31][9];
	Object[] head = new Object[]{"记录编号", "用户编号", "用户姓名", "车辆名称", "租车日期","还车日期","押金","租金","代驾状态"};
	JTable table = new JTable(null);
	DefaultTableModel tableModel;
	Reserve record = new ReserveSrv().search_Res(MainMenu.id);

	public Reserve_Record() {
		this.setLayout(null);
		panel.setLayout(null);
		this.setVisible(false);
		this.setBounds(0,80,1280,640);
		panel.setBounds(0, 0, 1280, 640);
		title.setBounds(0, 0, 1280, 40);
		
		if(record != null) {
			obj[0][0] = record.getRes_Id();
			obj[0][1] = record.getCus_Id();
			obj[0][2] = new CustomersSrv().select_CusSrv(MainMenu.id).getCus_Name();
			obj[0][3] = new Car_Srv().select_CarSrv(record.getCar_Id()).getCar_Name();
			obj[0][4] = record.getCar_RentDate();
			obj[0][5] = record.getCar_BackDate();
			obj[0][6] = record.getDeposit();
			obj[0][7] = record.getRentMoney();
			obj[0][8] = record.getDesD_Is();
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
