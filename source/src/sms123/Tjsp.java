package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.Kc;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Tjsp extends JFrame {

	private JPanel contentPane;
	private JTextField cno;
	private JTextField cname;
	private JTextField cdate;
	private JTextField ckeep;
	private JTextField number;
	private JTextField sno;
	private JTextField sname;
	private JTextField indate;
	private JTextField price;
	Kc dao=new Kc();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tjsp frame = new Tjsp();
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
	public Tjsp() {
		setTitle("\u6DFB\u52A0\u5546\u54C1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GZRYVIEW view=new GZRYVIEW();
				view.setVisible(true);
				Tjsp.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(618, 381, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u53F7");
		lblNewLabel.setBounds(0, 27, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u540D\u79F0");
		lblNewLabel_1.setBounds(0, 69, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u751F\u4EA7\u65E5\u671F");
		lblNewLabel_2.setBounds(0, 124, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u4FDD\u8D28\u671F");
		lblNewLabel_3.setBounds(0, 175, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u6570\u91CF");
		lblNewLabel_4.setBounds(0, 215, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u4F9B\u5E94\u5546\u53F7");
		lblNewLabel_5.setBounds(0, 267, 54, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u4F9B\u5E94\u5546\u540D\u79F0");
		lblNewLabel_6.setBounds(0, 317, 85, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u5165\u5E93\u65E5\u671F");
		lblNewLabel_7.setBounds(0, 363, 54, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\u8D2D\u4E70\u4EF7\u683C");
		lblNewLabel_8.setBounds(0, 416, 54, 15);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a=price.getText();
				if(a.equals(""))
				{
					JOptionPane.showMessageDialog(Tjsp.this, "请输入！");
				}
				else
				{
					int cno1=Integer.parseInt(cno.getText());
					String cname1=cname.getText();
					String cdate1=cdate.getText();
					String ckeep1=ckeep.getText();
					int number1=Integer.parseInt(number.getText());
					int sno1=Integer.parseInt(sno.getText());				
					String indate1=indate.getText();
					String sname1=sname.getText();
					float price1=Float.parseFloat(price.getText());
					int t=dao.tjkc(sno1, cno1, indate1, sname1, price1, number1);
					int t2=dao.tjsp(cno1, cname1, cdate1, ckeep1, number1);
					t+=t2;
					if(t<1)
					{
						JOptionPane.showMessageDialog(Tjsp.this, "操作成功！");
						
					}
					else
					{
						JOptionPane.showMessageDialog(Tjsp.this, "您的输入有误！");
					}
				}
			
			}
		});
		btnNewButton_1.setBounds(442, 381, 93, 23);
		contentPane.add(btnNewButton_1);
		
		cno = new JTextField();
		cno.setBounds(124, 24, 156, 21);
		contentPane.add(cno);
		cno.setColumns(10);
		
		cname = new JTextField();
		cname.setBounds(124, 66, 156, 21);
		contentPane.add(cname);
		cname.setColumns(10);
		
		cdate = new JTextField();
		cdate.setBounds(124, 121, 156, 21);
		contentPane.add(cdate);
		cdate.setColumns(10);
		
		ckeep = new JTextField();
		ckeep.setBounds(124, 172, 156, 21);
		contentPane.add(ckeep);
		ckeep.setColumns(10);
		
		number = new JTextField();
		number.setBounds(124, 212, 156, 21);
		contentPane.add(number);
		number.setColumns(10);
		
		sno = new JTextField();
		sno.setBounds(124, 264, 156, 21);
		contentPane.add(sno);
		sno.setColumns(10);
		
		sname = new JTextField();
		sname.setBounds(124, 314, 156, 21);
		contentPane.add(sname);
		sname.setColumns(10);
		
		indate = new JTextField();
		indate.setBounds(124, 360, 156, 21);
		contentPane.add(indate);
		indate.setColumns(10);
		
		price = new JTextField();
		price.setBounds(124, 413, 156, 21);
		contentPane.add(price);
		price.setColumns(10);
	}
}
