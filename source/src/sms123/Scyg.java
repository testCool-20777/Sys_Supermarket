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

public class Scyg extends JFrame {

	private JPanel contentPane;
	private JTextField no;
	private dao dao1=new dao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scyg frame = new Scyg();
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
	public Scyg() {
		setTitle("\u5220\u9664\u5458\u5DE5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GLYVIEW view=new GLYVIEW();
				view.setVisible(true);
				Scyg.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(314, 353, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664\u6240\u6709\uFF08\u614E\u91CD\uFF01\uFF09");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int t=0;
				t=dao1.scygall();
				if(t<1)
				{
					JOptionPane.showMessageDialog(Scyg.this, "操作成功！");
				}
				else
				{
					JOptionPane.showMessageDialog(Scyg.this, "没有该员工");
				}
			}
		});
		
		btnNewButton_1.setBounds(522, 177, 221, 48);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u53F7");
		lblNewLabel.setBounds(23, 102, 54, 15);
		contentPane.add(lblNewLabel);
		
		no = new JTextField();
		no.setBounds(87, 99, 66, 21);
		contentPane.add(no);
		no.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int t=0;
				
				int no1=Integer.parseInt(no.getText());
				t=dao1.scyg(no1);
				if(t<1)
				{
					JOptionPane.showMessageDialog(Scyg.this, "操作成功！");
				}
				else
				{
					JOptionPane.showMessageDialog(Scyg.this, "没有该员工");
				}
			}
		});
		btnNewButton_2.setBounds(216, 98, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("\u6309\u5458\u5DE5\u53F7\u5220\u9664");
		lblNewLabel_1.setBounds(23, 64, 243, 15);
		contentPane.add(lblNewLabel_1);
	}

}
