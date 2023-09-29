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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Tjyg extends JFrame {

	private JPanel contentPane;
	private JTextField no;
	private JTextField name;
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
					Tjyg frame = new Tjyg();
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
	public Tjyg() {
		setTitle("\u6DFB\u52A0\u5458\u5DE5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GLYVIEW view=new GLYVIEW();
				view.setVisible(true);
				Tjyg.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(319, 427, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u53F7");
		lblNewLabel.setBounds(28, 41, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5458\u5DE5\u59D3\u540D");
		lblNewLabel_1.setBounds(28, 77, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5E74\u9F84");
		lblNewLabel_2.setBounds(28, 144, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5DE5\u8D44");
		lblNewLabel_3.setBounds(28, 186, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton boy = new JRadioButton("\u7537");
		boy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sex="男";
			}
		});
		boy.setBounds(110, 102, 121, 23);
		contentPane.add(boy);
		
		JRadioButton gril = new JRadioButton("\u5973");
		gril.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sex="女";
			}
		});
		gril.setBounds(293, 102, 121, 23);
		contentPane.add(gril);
		
		JLabel lblNewLabel_4 = new JLabel("\u6027\u522B");
		lblNewLabel_4.setBounds(28, 105, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		no = new JTextField();
		no.setBounds(92, 38, 66, 21);
		contentPane.add(no);
		no.setColumns(10);
		
		name = new JTextField();
		name.setBounds(92, 74, 66, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setBounds(92, 141, 66, 21);
		contentPane.add(age);
		age.setColumns(10);
		
		gz = new JTextField();
		gz.setBounds(92, 183, 66, 21);
		contentPane.add(gz);
		gz.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u63D0\u4EA4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int no1=Integer.parseInt(no.getText());
				String name1=name.getText();
				int age1=Integer.parseInt(age.getText());
				int gz1=Integer.parseInt(gz.getText());
				int t=0;
				t=dao1.tjyg(no1, name1, sex, age1, gz1);
				if(t<1)
				{
					JOptionPane.showMessageDialog(Tjyg.this, "操作成功！");
					
				}
				else
				{
					JOptionPane.showMessageDialog(Tjyg.this, "您的输入有误！");
				}
			}
		});
		btnNewButton_1.setBounds(275, 186, 93, 23);
		contentPane.add(btnNewButton_1);
	}
}
