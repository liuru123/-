package com.example.ui;

import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.example.model.Rent_Record;
import com.example.service.Car_Rental_RecordSrv;
import com.example.service.Car_Srv;
import com.example.service.CustomersSrv;

/**
 * 租车记录
 *
 */
public class Car_Rental_Record extends JPanel{
	private static final long serialVersionUID=1L;
	JPanel panel = new JPanel();
	JPanel title = new Paintpanel(new ImageIcon("icon/title_record.PNG").getImage());
	Object[][] obj = new Object[31][9];
	Object[] head = new Object[]{"记录编号","用户编号", "用户姓名", "车辆名称","租车日期","还车日期","还车状态","代驾状态","租金"};
	JTable table = new JTable(null);
	DefaultTableModel tableModel;
	List<Rent_Record> record = new Car_Rental_RecordSrv().listSrv(MainMenu.id);
	
	public Car_Rental_Record(){
		this.setLayout(null);
		panel.setLayout(null);
		this.setVisible(false);
		this.setBounds(0,80,1280,640);
		panel.setBounds(0, 0, 1280, 640);
		title.setBounds(0, 0, 1280, 40);
		
		for(int i = 0;i < record.size();i++) {
			obj[i][0] = record.get(i).getRec_Id();
			obj[i][1] = record.get(i).getCus_Id();
			obj[i][2] = new CustomersSrv().select_CusSrv(MainMenu.id).getCus_Name();
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
