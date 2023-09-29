package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.Hy;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;

public class Xghy extends JFrame {

	private JPanel contentPane;
	private JTextField no;
	private JTextField no1;
	private JTextField name;
	private JTextField age;
	private JTextField phone;
	private JTextField no2;
    String sex="";
    private Hy dao=new Hy();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Xghy frame = new Xghy();
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
	public Xghy() {
		setTitle("\u4FEE\u6539\u4F1A\u5458");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GLYVIEW view=new GLYVIEW();
				view.setVisible(true);
				Xghy.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(546, 358, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u8981\u4FEE\u6539\u7684\u4F1A\u5458\u7684\u4F1A\u5458\u53F7");
		lblNewLabel.setBounds(23, 29, 153, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4FEE\u6539\u7684\u503C");
		lblNewLabel_1.setBounds(23, 82, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u4F1A\u5458\u53F7");
		lblNewLabel_2.setBounds(23, 138, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u4F1A\u5458\u540D");
		lblNewLabel_3.setBounds(23, 188, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u5E74\u9F84");
		lblNewLabel_4.setBounds(23, 232, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u7535\u8BDD\u53F7\u7801");
		lblNewLabel_5.setBounds(23, 304, 54, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u6027\u522B");
		lblNewLabel_6.setBounds(23, 272, 54, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u987E\u5BA2\u53F7");
		lblNewLabel_7.setBounds(23, 358, 54, 15);
		contentPane.add(lblNewLabel_7);
		
		no = new JTextField();
		no.setBounds(186, 26, 118, 21);
		contentPane.add(no);
		no.setColumns(10);
		
		no1 = new JTextField();
		no1.setBounds(153, 135, 66, 21);
		contentPane.add(no1);
		no1.setColumns(10);
		
		name = new JTextField();
		name.setBounds(153, 185, 277, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setBounds(153, 229, 66, 21);
		contentPane.add(age);
		age.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(153, 301, 277, 21);
		contentPane.add(phone);
		phone.setColumns(10);
		
		no2 = new JTextField();
		no2.setBounds(153, 355, 66, 21);
		contentPane.add(no2);
		no2.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u7537");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sex="男";
			}
		});
		rdbtnNewRadioButton.setBounds(153, 268, 121, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u5973");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sex="女";
			}
		});
		rdbtnNewRadioButton_1.setBounds(325, 268, 121, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int t=0;
				int mno=Integer.parseInt(no.getText());
				 String mname=name.getText();
				int mage=Integer.parseInt(age.getText());
				int mno1=Integer.parseInt(no1.getText());
				int clientno=Integer.parseInt(no2.getText());
				String mphone=phone.getText();
				
				int t1=dao.xgage(mage, mno);
				int t2=dao.xgname(mname, mno);
				int t3=dao.xgno(mno1, mno);
				int t4=dao.xgno1(clientno,mno);
				int t5=dao.xgphone(mphone, mno);
				int t6=dao.xgsex(sex,mno );
				t=t1+t2+t3+t4+t5+t6;
						
				
				
				
					
				
				if(t<1)
				{
					JOptionPane.showMessageDialog(Xghy.this, "操作成功！");
					
				}
				else
				{
					JOptionPane.showMessageDialog(Xghy.this, "您的输入有误！");
				}
			}
		});
		btnNewButton_1.setBounds(339, 354, 93, 23);
		contentPane.add(btnNewButton_1);
	}

}
