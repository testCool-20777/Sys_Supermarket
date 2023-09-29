package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.Gys;
import Dao.Zh;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class Tjzh extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField no;
	int rank=1;
	private Zh dao=new Zh();
	private JTextField pass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tjzh frame = new Tjzh();
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
	public Tjzh() {
		setTitle("\u6DFB\u52A0\u8D26\u6237");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GLYVIEW view=new GLYVIEW();
				view.setVisible(true);
				Tjzh.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(352, 436, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u8981\u6DFB\u52A0\u7684\u8D26\u6237\u4FE1\u606F");
		lblNewLabel.setFont(new Font("新宋体", Font.BOLD, 15));
		lblNewLabel.setBounds(44, 52, 308, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u767B\u9646\u540D");
		lblNewLabel_1.setBounds(44, 146, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2.setBounds(44, 210, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		name = new JTextField();
		name.setBounds(108, 143, 168, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u8D26\u6237\u7C7B\u522B");
		lblNewLabel_3.setBounds(44, 277, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u987E\u5BA2/\u4F1A\u5458");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rank=1;
			}
		});
		rdbtnNewRadioButton.setBounds(108, 273, 121, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u5DE5\u4F5C\u4EBA\u5458");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rank=2;
			}
		});
		rdbtnNewRadioButton_1.setBounds(262, 273, 121, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\u7BA1\u7406\u5458");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rank=3;
			}
		});
		rdbtnNewRadioButton_2.setBounds(429, 273, 121, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("\u8BBE\u5B9A\u5E8F\u5217\u53F7");
		lblNewLabel_4.setBounds(44, 339, 84, 15);
		contentPane.add(lblNewLabel_4);
		
		no = new JTextField();
		no.setBounds(108, 336, 66, 21);
		contentPane.add(no);
		no.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name1=name.getText();
				String pass1=pass.getText();
				int no1=Integer.parseInt(no.getText());
				int t=dao.tjuser(name1, pass1);
				int t2=dao.tjzcb(name1, no1, rank);
				if((t+t2)<1)
				{
					JOptionPane.showMessageDialog(Tjzh.this, "操作成功！");
					
				}
				else
				{
					JOptionPane.showMessageDialog(Tjzh.this, "您的输入有误！");
				}
			}
		});
		btnNewButton_1.setBounds(108, 436, 93, 23);
		contentPane.add(btnNewButton_1);
		
		pass = new JTextField();
		pass.setBounds(108, 207, 168, 21);
		contentPane.add(pass);
		pass.setColumns(10);
	}
}
