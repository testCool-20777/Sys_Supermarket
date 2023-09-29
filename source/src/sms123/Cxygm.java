package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.Gk;
import Dao.dao;
import mod.Pay;
import mod.Shoptype;
import mod.Suplier;
import mod.Theorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cxygm extends JFrame {

	private JPanel contentPane;
	private JTextField pno;
	private JTable table;
	Gk dao=new Gk();
	private JTextField cno;
	private JTable table1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cxygm frame = new Cxygm();
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
	public Cxygm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8BA2\u5355\u53F7");
		lblNewLabel.setBounds(30, 184, 104, 15);
		contentPane.add(lblNewLabel);
		
		pno = new JTextField();
		pno.setBounds(144, 181, 175, 21);
		contentPane.add(pno);
		pno.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6309\u987E\u5BA2\u53F7\u67E5\u8BE2");
		btnNewButton.setBounds(444, 103, 145, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String t=cno.getText();
				if(t.equals(""))
				{
					JOptionPane.showMessageDialog(Cxygm.this, "请输入顾客号！");
				}
				else
				{
					int cno1=Integer.parseInt(cno.getText());
			
				DefaultTableModel def=(DefaultTableModel)table.getModel();
				def.setRowCount(0);
				List<Pay>types= dao.cxall(cno1);
				
				for(Pay type:types)
				{
					def.addRow(new Object[] {type.getPno(),type.getPdate(),type.getEno(),type.getRmb()});
				}
				JOptionPane.showMessageDialog(Cxygm.this, "操作成功！");
				}
				
				
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 224, 852, 139);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355\u53F7", "\u652F\u4ED8\u65E5\u671F", "\u5DE5\u4F5C\u4EBA\u5458\u7684\u5458\u5DE5\u53F7", "\u603B\u91D1\u989D"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(142);
		table.getColumnModel().getColumn(3).setPreferredWidth(156);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gkview view=new Gkview();
				view.setVisible(true);
				Cxygm.this.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(764, 536, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u60A8\u7684\u987E\u5BA2\u53F7");
		lblNewLabel_1.setBounds(30, 104, 112, 21);
		contentPane.add(lblNewLabel_1);
		
		cno = new JTextField();
		cno.setBounds(144, 104, 138, 21);
		contentPane.add(cno);
		cno.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\u6309\u8BA2\u5355\u53F7\u67E5\u8BE2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String t=pno.getText();
				if(t.equals(""))
				{
					JOptionPane.showMessageDialog(Cxygm.this, "请输入订单号！");
				}
				else
				{
				
					int pno1=Integer.parseInt(pno.getText());
			
				DefaultTableModel def=(DefaultTableModel)table1.getModel();
				def.setRowCount(0);
				List<Theorder>types= dao.cx(pno1);
				
				for(Theorder type:types)
				{
					def.addRow(new Object[] {type.getPno(),type.getCno(),type.getNumber(),type.getRmb(),type.getPdate()});
				}
				JOptionPane.showMessageDialog(Cxygm.this, "操作成功！");
				}
			}
		});
		btnNewButton_2.setBounds(444, 180, 145, 23);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 411, 854, 91);
		contentPane.add(scrollPane_1);
		
		table1 = new JTable();
		table1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355\u53F7", "\u5546\u54C1\u53F7", "\u6570\u91CF", "\u91D1\u989D", "\u8D2D\u4E70\u65E5\u671F"
			}
		));
		scrollPane_1.setViewportView(table1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6309\u8BA2\u5355\u53F7\u67E5\u8BE2");
		lblNewLabel_2.setBounds(32, 540, 175, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6309\u987E\u5BA2\u53F7\u67E5\u8BE2");
		lblNewLabel_3.setBounds(32, 373, 127, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u67E5\u8BE2\u4E4B\u524D\u8BF7\u5148\u8F93\u5165\u987E\u5BA2\u53F7");
		lblNewLabel_4.setBounds(614, 184, 243, 15);
		contentPane.add(lblNewLabel_4);
		
		
		
	}

}
