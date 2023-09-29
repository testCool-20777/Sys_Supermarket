package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.Jh;
import mod.Supply;
import mod.Warning;

public class Cxsp extends JFrame {

	private JPanel contentPane;
	private JTextField no;
	private JTable table;
	private Jh dao=new Jh();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cxsp frame = new Cxsp();
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
	public Cxsp() {
		setTitle("\u67E5\u8BE2\u5546\u54C1\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GZRYVIEW view=new GZRYVIEW();
				view.setVisible(true);
				Cxsp.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(565, 298, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u5546\u54C1\u53F7");
		lblNewLabel.setBounds(37, 43, 125, 15);
		contentPane.add(lblNewLabel);
		
		no = new JTextField();
		no.setBounds(153, 40, 197, 21);
		contentPane.add(no);
		no.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u627E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String t=no.getText();
				if(t.equals(""))
				{
					JOptionPane.showMessageDialog(Cxsp.this, "输入商品号可进行精确查找！");
					DefaultTableModel def=(DefaultTableModel)table.getModel();
					def.setRowCount(0);
					List<Warning>types= dao.cxkcall();
					
					for(Warning type:types)
					{
						def.addRow(new Object[] {type.getCno(),type.getCnumber(),type.getCwarn(),type.getKwarn()});
					}
					
					
				}
				else
				{
					int a=Integer.parseInt(no.getText());
					DefaultTableModel def=(DefaultTableModel)table.getModel();
					def.setRowCount(0);
					List<Warning>types= dao.cxkc(a);
					
					for(Warning type:types)
					{
						def.addRow(new Object[] {type.getCno(),type.getCnumber(),type.getCwarn(),type.getKwarn()});
					}
				}
				
			}
		});
		btnNewButton_1.setBounds(396, 39, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 98, 653, 123);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"\u5546\u54C1\u53F7", "\u5269\u4F59\u6570\u91CF", "\u5E93\u5B58\u9884\u8B66\u503C", "\u65E5\u671F\u9884\u8B66\u503C"
			}
		));
		scrollPane.setViewportView(table);
		
		DefaultTableModel def=(DefaultTableModel)table.getModel();
		List<Warning>types= dao.cxkcall();
		
		for(Warning type:types)
		{
			def.addRow(new Object[] {type.getCno(),type.getCnumber(),type.getCwarn(),type.getKwarn()});
		}
		
		
		JLabel lblNewLabel_1 = new JLabel("\u5E93\u5B58\u60C5\u51B5");
		lblNewLabel_1.setBounds(30, 73, 54, 15);
		contentPane.add(lblNewLabel_1);
	}

}
