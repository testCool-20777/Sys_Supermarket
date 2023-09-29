package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.dao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class Xgyg extends JFrame {

	private JPanel contentPane;
	private JTextField no;
	private JTextField eno;
	private JTextField name5;
	private JTextField age;
	private JTextField gz;
	private dao dao1=new dao();
	String sex="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Xgyg frame = new Xgyg();
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
	public Xgyg() {
		setTitle("\u4FEE\u6539\u5458\u5DE5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GLYVIEW view=new GLYVIEW();
				view.setVisible(true);
				Xgyg.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(572, 376, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u7684\u5458\u5DE5\u7684\u5458\u5DE5\u53F7");
		lblNewLabel.setBounds(10, 23, 171, 15);
		contentPane.add(lblNewLabel);
		
		no = new JTextField();
		no.setBounds(179, 20, 66, 21);
		contentPane.add(no);
		no.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int t=0;
				int t1=0;
				int t2=0;
				int t3=0;
				int t4=0;
				
				int no1=Integer.parseInt(no.getText());
				int age1=Integer.parseInt(age.getText());
				int eno1=Integer.parseInt(eno.getText());
				int gz1=Integer.parseInt(gz.getText());
				String name1=name5.getText();
				t3=dao1.xgygno(eno1, no1);
				t=dao1.xgygage(age1, no1);
				t1=dao1.xgyggz(gz1, no1);
				t2=dao1.xgygname(name1, no1);
				System.out.println(name1);
				t4=dao1.xgygsex(sex, no1);
				if(t3==1)
				{
					JOptionPane.showMessageDialog(Xgyg.this, "您的输入有误！");
				}
				else
				{
					JOptionPane.showMessageDialog(Xgyg.this, "操作成功！");
					
				}
			}
		});
		btnNewButton_1.setBounds(82, 376, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u4FEE\u6539\u540E\u7684\u5458\u5DE5\u53F7");
		lblNewLabel_1.setBounds(10, 79, 93, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 114, 93, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u4FEE\u6539\u540E\u7684\u5458\u5DE5\u540D");
		lblNewLabel_3.setBounds(10, 128, 93, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u4FEE\u6539\u540E\u7684\u5458\u5DE5\u6027\u522B");
		lblNewLabel_4.setBounds(10, 197, 117, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u4FEE\u6539\u540E\u7684\u5E74\u9F84");
		lblNewLabel_5.setBounds(10, 248, 77, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u4FEE\u6539\u540E\u7684\u5DE5\u8D44");
		lblNewLabel_6.setBounds(10, 289, 77, 15);
		contentPane.add(lblNewLabel_6);
		
		eno = new JTextField();
		eno.setBounds(113, 76, 66, 21);
		contentPane.add(eno);
		eno.setColumns(10);
		
		name5 = new JTextField();
		name5.setBounds(113, 125, 66, 21);
		contentPane.add(name5);
		name5.setColumns(10);
		
		age = new JTextField();
		age.setBounds(97, 245, 66, 21);
		contentPane.add(age);
		age.setColumns(10);
		
		gz = new JTextField();
		gz.setBounds(97, 286, 66, 21);
		contentPane.add(gz);
		gz.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u7537");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sex="男";
			}
		});
		rdbtnNewRadioButton.setBounds(124, 193, 121, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u5973");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sex="女";
			}
		});
		rdbtnNewRadioButton_1.setBounds(313, 193, 121, 23);
		contentPane.add(rdbtnNewRadioButton_1);
	}

}
