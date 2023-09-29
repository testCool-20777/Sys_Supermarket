package sms123;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableModel;

import Dao.Zh;
import mod.Zhdl;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
public class Xgzh extends JFrame {

	private JPanel contentPane;
	private JTextField name3;
	private JTable table;
	private JTextField name2;
	private JTextField pass;
	private JTextField no;
    int rank=1;
    private Zh dao=new Zh();
    private JTextField thename;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Xgzh frame = new Xgzh();
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
	public Xgzh() {
		setTitle("\u4FEE\u6539\u8D26\u6237");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 749);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GLYVIEW view=new GLYVIEW();
				view.setVisible(true);
				Xgzh.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(529, 631, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u4FEE\u6539\u7684\u767B\u9646\u540D");
		lblNewLabel.setBounds(33, 45, 163, 15);
		contentPane.add(lblNewLabel);
		
		name3 = new JTextField();
		name3.setBounds(206, 42, 289, 21);
		contentPane.add(name3);
		name3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel def=(DefaultTableModel)table.getModel();
				String a=name3.getText();
				if(a.equals(""))
				{
					def.setRowCount(0);
					List<Zhdl>types= dao.cxall();
					
					for(Zhdl type:types)
					{
						def.addRow(new Object[] {type.getName(),type.getPass(),type.getNo(),type.getRank()});
					}
				}
				else
				{
					def.setRowCount(0);
				String name1=name3.getText();
				List<Zhdl>types= dao.cx(name1);				
				for(Zhdl type:types)
				{
					def.addRow(new Object[] {type.getName(),type.getPass(),type.getNo(),type.getRank()});
				}
				
				}
				
				
			}
		});
		btnNewButton_1.setBounds(529, 41, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 84, 577, 124);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int num=table.getSelectedRow();
				String name=table.getValueAt(num, 0).toString();
				String pass1=table.getValueAt(num, 1).toString();
				String number =table.getValueAt(num, 2).toString();
				
				name2.setText(name);
				pass.setText(pass1);
				no.setText(number);
			
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"\u767B\u9646\u540D", "\u5BC6\u7801", "\u5E8F\u5217\u53F7", "\u8D26\u6237\u7C7B\u578B\u4EE3\u53F7"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(105);
		scrollPane.setViewportView(table);
		DefaultTableModel def=(DefaultTableModel)table.getModel();
		List<Zhdl>types= dao.cxall();
		
		for(Zhdl type:types)
		{
			def.addRow(new Object[] {type.getName(),type.getPass(),type.getNo(),type.getRank()});
		}
		
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.GREEN);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(45, 276, 577, 287);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u4FEE\u6539\u4FE1\u606F");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(10, 10, 133, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u767B\u9646\u540D");
		lblNewLabel_2.setBounds(89, 60, 54, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5BC6\u7801");
		lblNewLabel_3.setBounds(89, 113, 54, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u5E8F\u5217\u53F7");
		lblNewLabel_4.setBounds(89, 149, 54, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u8D26\u6237\u7C7B\u578B\u4EE3\u53F7");
		lblNewLabel_5.setBounds(32, 190, 97, 15);
		panel.add(lblNewLabel_5);
		
		name2 = new JTextField();
		name2.setEnabled(false);
		name2.setBounds(181, 57, 66, 21);
		panel.add(name2);
		name2.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(181, 110, 66, 21);
		panel.add(pass);
		pass.setColumns(10);
		
		no = new JTextField();
		no.setBounds(181, 146, 66, 21);
		panel.add(no);
		no.setColumns(10);
		
		JRadioButton cs = new JRadioButton("\u987E\u5BA2/\u4F1A\u5458");
		cs.setBackground(Color.WHITE);
		cs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rank=1;
			}
		});
		cs.setBounds(178, 190, 121, 23);
		panel.add(cs);
		
		JRadioButton cs1 = new JRadioButton("\u5DE5\u4F5C\u4EBA\u5458");
		cs1.setBackground(Color.WHITE);
		cs1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rank=2;
			}
		});
		cs1.setBounds(323, 190, 121, 23);
		panel.add(cs1);
		
		JRadioButton cs2 = new JRadioButton("\u7BA1\u7406\u5458");
		cs2.setBackground(Color.WHITE);
		cs2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rank=3;
			}
		});
		cs2.setBounds(465, 190, 121, 23);
		panel.add(cs2);
		
		
		JButton btnNewButton_2 = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				int num=table.getSelectedRow();	
				String zq=table.getValueAt(num, 0).toString();
				String dlm=name3.getText();
				String mm=pass.getText();
				Integer no1=Integer.parseInt(no.getText());
				String name=thename.getText();
				int t0=dao.xgname(name, zq);
				int t2=dao.xgno(no1, zq);
				int t3=dao.xgpass(mm, zq);
				int t4=dao.xgrank(rank,zq);
				int t=t2+t3+t4;
				if(t0<1)
				{
					JOptionPane.showMessageDialog(Xgzh.this, "操作成功！");
					
				}
				else
				{
					JOptionPane.showMessageDialog(Xgzh.this, "您的输入有误！");
				}
			}
		});
		btnNewButton_2.setBounds(181, 241, 93, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("\u4FEE\u6539\u540E\u7684\u767B\u9646\u540D");
		lblNewLabel_6.setBounds(293, 60, 103, 15);
		panel.add(lblNewLabel_6);
		
		thename = new JTextField();
		thename.setBounds(406, 57, 66, 21);
		panel.add(thename);
		thename.setColumns(10);
	}
}
