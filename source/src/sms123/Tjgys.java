package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.Gys;
import Dao.dao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Tjgys extends JFrame {

	private JPanel contentPane;
	private JTextField no;
	private JTextField name;
	private Gys dao=new Gys();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tjgys frame = new Tjgys();
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
	public Tjgys() {
		setTitle("\u6DFB\u52A0\u4F9B\u5E94\u5546");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GLYVIEW view=new GLYVIEW();
				view.setVisible(true);
				Tjgys.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(425, 333, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u4F9B\u5E94\u5546\u53F7");
		lblNewLabel.setBounds(22, 54, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F9B\u5E94\u5546\u540D");
		lblNewLabel_1.setBounds(22, 188, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		no = new JTextField();
		no.setBounds(129, 51, 151, 21);
		contentPane.add(no);
		no.setColumns(10);
		
		name = new JTextField();
		name.setBounds(129, 185, 151, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sno=Integer.parseInt(no.getText());
				String name1=name.getText();
				int t=dao.tjgys(sno, name1);
				if(t<1)
				{
					JOptionPane.showMessageDialog(Tjgys.this, "操作成功！");
					
				}
				else
				{
					JOptionPane.showMessageDialog(Tjgys.this, "您的输入有误！");
				}
				
			}
		});
		btnNewButton_1.setBounds(129, 333, 93, 23);
		contentPane.add(btnNewButton_1);
	}

}
