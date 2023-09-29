package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.Hy;
import Dao.dao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class Tjhy extends JFrame {

	private JPanel contentPane;
	private JTextField no;
	private JTextField name;
	private JTextField age;
	private JTextField phone;
	private JTextField no1;
	private Hy dao1=new Hy();
	String sex="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tjhy frame = new Tjhy();
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
	public Tjhy() {
		setTitle("\u6DFB\u52A0\u4F1A\u5458");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GLYVIEW view=new GLYVIEW();
				view.setVisible(true);
				Tjhy.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(498, 361, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u4F1A\u5458\u53F7");
		lblNewLabel.setBounds(30, 41, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F1A\u5458\u540D");
		lblNewLabel_1.setBounds(30, 76, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B");
		lblNewLabel_2.setBounds(30, 123, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5E74\u9F84");
		lblNewLabel_3.setBounds(30, 170, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u7535\u8BDD\u53F7\u7801");
		lblNewLabel_4.setBounds(30, 220, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u987E\u5BA2\u53F7");
		lblNewLabel_5.setBounds(30, 261, 54, 15);
		contentPane.add(lblNewLabel_5);
		
		no = new JTextField();
		no.setBounds(146, 38, 93, 21);
		contentPane.add(no);
		no.setColumns(10);
		
		name = new JTextField();
		name.setBounds(145, 73, 94, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setBounds(146, 167, 93, 21);
		contentPane.add(age);
		age.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(146, 217, 93, 21);
		contentPane.add(phone);
		phone.setColumns(10);
		
		no1 = new JTextField();
		no1.setBounds(145, 261, 94, 21);
		contentPane.add(no1);
		no1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int mno=Integer.parseInt(no.getText());
				String mname=name.getText();
				int mage=Integer.parseInt(age.getText());
				int clientno=Integer.parseInt(no1.getText());
				String mphone=phone.getText();
				int t=dao1.tj(mno, mname, sex, mage, mphone, clientno);
				if(t<1)
				{
					JOptionPane.showMessageDialog(Tjhy.this, "操作成功！");
					
				}
				else
				{
					JOptionPane.showMessageDialog(Tjhy.this, "您的输入有误！");
				}
				
			}
		});
		btnNewButton_1.setBounds(103, 361, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u7537");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sex="男";
			}
		});
		rdbtnNewRadioButton.setBounds(135, 119, 121, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u5973");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sex="女";
			}
		});
		rdbtnNewRadioButton_1.setBounds(337, 119, 121, 23);
		contentPane.add(rdbtnNewRadioButton_1);
	}

}
