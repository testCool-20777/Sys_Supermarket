package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.Zh;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Sczh extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private Zh dao=new Zh();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sczh frame = new Sczh();
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
	public Sczh() {
		setTitle("\u5220\u9664\u8D26\u6237");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GLYVIEW view=new GLYVIEW();
				view.setVisible(true);
				Sczh.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(474, 346, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664\u6240\u6709\uFF08\u614E\u91CD\uFF09");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int t=dao.scall();
				if(t<1)
				{
					JOptionPane.showMessageDialog(Sczh.this, "操作成功！");
					
				}
				else
				{
					JOptionPane.showMessageDialog(Sczh.this, "您的输入有误！");
				}
			}
		});
		btnNewButton_1.setBounds(46, 341, 144, 32);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u7684\u8D26\u6237\u7684\u767B\u9646\u540D");
		lblNewLabel.setBounds(33, 38, 192, 15);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(211, 35, 144, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name1=name.getText();
				int t=dao.sc(name1);
				if((t)<1)
				{
					JOptionPane.showMessageDialog(Sczh.this, "操作成功！");
					
				}
				else
				{
					JOptionPane.showMessageDialog(Sczh.this, "您的输入有误！");
				}
			}
		});
		btnNewButton_2.setBounds(397, 34, 93, 23);
		contentPane.add(btnNewButton_2);
	}

}
