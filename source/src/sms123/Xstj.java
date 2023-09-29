package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Dao.Xs;
import mod.Pay;
import mod.Suplier;
import mod.Theorder;
import jdbc123.*;
public class Xstj extends JFrame {

	private JPanel contentPane;
	private JTextField no;
	private JTable table;
    Xs dao=new Xs();
    Jdbc cs=new Jdbc();
    private JTable table1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Xstj frame = new Xstj();
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
	public Xstj() {
		
		
		
		setTitle("\u9500\u552E\u7EDF\u8BA1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GZRYVIEW view=new GZRYVIEW();
				view.setVisible(true);
				Xstj.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(590, 505, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u65F6\u95F4");
		lblNewLabel.setBounds(25, 46, 104, 15);
		contentPane.add(lblNewLabel);
		
		no = new JTextField();
		no.setBounds(127, 43, 228, 21);
		contentPane.add(no);
		no.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 97, 658, 140);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"\u65F6\u95F4", "\u9500\u552E\u989D", "\u9500\u552E\u91CF"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(83);
		scrollPane.setViewportView(table);
		
		DefaultTableModel def=(DefaultTableModel)table.getModel();
		List<mod.Xstj>types= dao.xstjall();
		
		for(mod.Xstj type:types)
		{
			def.addRow(new Object[] {type.getPdate(),type.getRmb(),type.getNumber()});
		}
		
		JLabel lblNewLabel_1 = new JLabel("\u9500\u552E\u7EDF\u8BA1");
		lblNewLabel_1.setBounds(25, 72, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u627E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String t=no.getText();
				if(t.equals(""))
				{
					JOptionPane.showMessageDialog(Xstj.this, "输入时间可精确查找！");
					DefaultTableModel def=(DefaultTableModel)table.getModel();
					def.setRowCount(0);
					List<mod.Xstj>types= dao.xstjall();
					
					for(mod.Xstj type:types)
					{
						def.addRow(new Object[] {type.getPdate(),type.getRmb(),type.getNumber()});
					}
					
				}
				else
				{
					
					
					DefaultTableModel def=(DefaultTableModel)table.getModel();
					def.setRowCount(0);
					List<mod.Xstj>types= dao.xstj(t);
					
					for(mod.Xstj type:types)
					{
						def.addRow(new Object[] {type.getPdate(),type.getRmb(),type.getNumber()});
					}
				}
			}
		});
		btnNewButton_1.setBounds(382, 42, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2\u6700\u70ED\u9500\u5546\u54C1");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { 
				String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=sms123;user=sa;password=123zxc";
			    	 cs.getCon(url);
				 Connection con=cs.getCon(url);
			     PreparedStatement pstm=null;
			     ResultSet rs=null;
			     Statement stmt=con.createStatement(); 
			     System.out.println("最热销的商品号：");
			    	
			    	 String sql="select  max(number) zd from theorder ";
				     rs = stmt.executeQuery(sql);
				     int zd=0;
				     if(rs.next())
				     {
				    	 zd=rs.getInt("zd");
				     }
				     rs=null;
		    		 sql="select cno,number  from rx where number =(select max(number) from rx  )";
		    		  
				    pstm=con.prepareStatement(sql);						
		        	rs=pstm.executeQuery();
				    System.out.println("最热销的商品号：");
				       System.out.println("商品号"+"\t"+"销售量");  
				   DefaultTableModel def=(DefaultTableModel)table1.getModel();
					def.setRowCount(0);
				    while(rs.next()) {  
		                
		                def.addRow(new Object[] {rs.getString("cno"),rs.getString("number")});
		            } 
				    
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_2.setBounds(476, 427, 207, 23);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 271, 660, 101);
		contentPane.add(scrollPane_1);
		
		table1 = new JTable();
		table1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"\u5546\u54C1\u53F7", "\u9500\u552E\u91CF"
			}
		));
		scrollPane_1.setViewportView(table1);
	}
	
	public void rx() {
		
		
	}
}
