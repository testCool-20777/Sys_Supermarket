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

public class Qhyj extends JFrame {

	private JPanel contentPane;
	private JTextField cno;
	private JTextField qh;
    Kc dao=new Kc();
    private JTextField yh;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Qhyj frame = new Qhyj();
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
	public Qhyj() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GZRYVIEW view=new GZRYVIEW();
				view.setVisible(true);
				Qhyj.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(578, 521, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u53F7");
		lblNewLabel.setBounds(42, 54, 54, 15);
		contentPane.add(lblNewLabel);
		
		cno = new JTextField();
		cno.setBounds(135, 51, 131, 21);
		contentPane.add(cno);
		cno.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u8BBE\u5B9A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String a=cno.getText();
				String b=qh.getText();
				String c=yh.getText();
				if(a.equals("")||b.equals("") ||c.equals(""))
				{
					JOptionPane.showMessageDialog(Qhyj.this, "请输入！");
				}
				else
				{
					int cno1=Integer.parseInt(cno.getText());
					int qh1=Integer.parseInt(qh.getText());
					int yh1=Integer.parseInt(yh.getText());
					int t=dao.xgyj(qh1, yh1, cno1);
					if(t<1)
					{
						JOptionPane.showMessageDialog(Qhyj.this, "修改成功！");
					}
					else
					{
						JOptionPane.showMessageDialog(Qhyj.this, "您的输入有误！");
					}
				}
				
			}
		});
		btnNewButton_1.setBounds(418, 237, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BBE\u5B9A\u5176\u7F3A\u8D27\u9884\u8B66\u503C");
		lblNewLabel_1.setBounds(10, 150, 105, 15);
		contentPane.add(lblNewLabel_1);
		
		qh = new JTextField();
		qh.setBounds(135, 147, 131, 21);
		contentPane.add(qh);
		qh.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BBE\u5B9A\u538B\u8D27\u9884\u8B66\u503C");
		lblNewLabel_2.setBounds(10, 241, 105, 15);
		contentPane.add(lblNewLabel_2);
		
		yh = new JTextField();
		yh.setBounds(135, 238, 131, 21);
		contentPane.add(yh);
		yh.setColumns(10);
	}

}
