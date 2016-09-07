package com.example.ui;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.example.model.Rent_Record;
import com.example.service.Car_Rental_RecordSrv;
import com.example.service.Car_Srv;
import com.example.service.CustomersSrv;
import java.util.List;

/**
 *还车缴费
 */
public class Rent extends JPanel{
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	JPanel title = new Paintpanel(new ImageIcon("icon/title_rent.PNG").getImage());
	Object[][] obj = new Object[31][9];
	Object[] head = new Object[]{"用户姓名", "车辆名称", "租车日期","还车日期","还车状态","租金"};
	JTable table = new JTable(null);
	DefaultTableModel tableModel;
	List<Rent_Record> record = new Car_Rental_RecordSrv().listSrv(MainMenu.id);
	

	public Rent() {
		this.setLayout(null);
		panel.setLayout(null);
		this.setVisible(false);
		this.setBounds(0,80,1280,640);
		panel.setBounds(0, 0, 1280, 640);
		title.setBounds(0, 0, 1280, 40);
		if(record.size()>0){
			int i=record.size()-1;
			if(record.get(i).getCar_IsBack()==0){
				obj[0][0] = new CustomersSrv().select_CusSrv(MainMenu.id).getCus_Name();
				obj[0][1] = new Car_Srv().select_CarSrv(record.get(i).getCar_Id()).getCar_Name();
				obj[0][2] = record.get(i).getCar_RentDate();
				obj[0][3] = record.get(i).getCar_BackDate();
				obj[0][4] = record.get(i).getCar_IsBack();
				obj[0][5] = record.get(i).getCar_RentMoney();
			}
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
