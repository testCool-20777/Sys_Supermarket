package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.Gys;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Xggys extends JFrame {

	private JPanel contentPane;
	private Gys dao=new Gys();
	private JTextField no;
	private JTextField no1;
	private JTextField name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Xggys frame = new Xggys();
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
	public Xggys() {
		setTitle("\u4FEE\u6539\u4F9B\u5E94\u5546");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GLYVIEW view=new GLYVIEW();
				view.setVisible(true);
				Xggys.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(340, 429, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u7684\u4F9B\u5E94\u5546\u53F7");
		lblNewLabel.setBounds(25, 37, 148, 15);
		contentPane.add(lblNewLabel);
		
		no = new JTextField();
		no.setBounds(207, 34, 131, 21);
		contentPane.add(no);
		no.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sno=Integer.parseInt(no.getText());
				int sno1=Integer.parseInt(no1.getText());
				String sname=name.getText();
				int t=dao.xgname(sname, sno);
				int t1=dao.xgno(sno1, sno);
				if((t+t1)<1)
				{
					JOptionPane.showMessageDialog(Xggys.this, "操作成功！");
					
				}
				else
				{
					JOptionPane.showMessageDialog(Xggys.this, "您的输入有误！");
				}
			}
		});
		btnNewButton_1.setBounds(118, 429, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u4FEE\u6539\u540E\u7684\u4F9B\u5E94\u5546\u53F7");
		lblNewLabel_1.setBounds(25, 90, 131, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u4FEE\u6539\u540E\u7684\u4F9B\u5E94\u5546\u540D");
		lblNewLabel_2.setBounds(25, 148, 148, 15);
		contentPane.add(lblNewLabel_2);
		
		no1 = new JTextField();
		no1.setBounds(207, 87, 131, 21);
		contentPane.add(no1);
		no1.setColumns(10);
		
		name = new JTextField();
		name.setBounds(207, 148, 141, 21);
		contentPane.add(name);
		name.setColumns(10);
	}

}
