package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.dao;
import mod.Shoptype;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@SuppressWarnings("all")
public class Shop extends JFrame {

	private JPanel contentPane;
	private JTable table;
	dao dao1= new dao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
       
      
       
       
      
        
       
        
       
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shop frame = new Shop();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Shop() {
		        
	     
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 955, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 100, 761, 372);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5546\u54C1\u53F7", "\u5546\u54C1\u540D\u79F0", "\u9500\u552E\u4EF7", "\u4F1A\u5458\u4EF7", "\u4F59\u91CF"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Float.class, Float.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		DefaultTableModel def=(DefaultTableModel)table.getModel();
		List<Shoptype>types= dao1.cxsd();
		
		for(Shoptype type:types)
		{
			def.addRow(new Object[] {type.getCno(),type.getCname(),type.getSellprice(),type.getMenberprice(),type.getNumber()});
		}
		
		
		
		/*try {
			while(rs.next()) {
				def.addRow(new Object[] {rs.getString("商品名称"),rs.getString("商品号"),rs.getString("销售价"),rs.getString("会员价"),rs.getString("余量")});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u672C\u8D85\u5E02\u6709\u4EE5\u4E0B\u5546\u54C1");
		lblNewLabel.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(217, 23, 313, 38);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gkview view=new Gkview();
				view.setVisible(true);
				Shop.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(723, 482, 93, 23);
		contentPane.add(btnNewButton);
	}
}
