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

public class Xgsp extends JFrame {

	private JPanel contentPane;
	private JTextField no;
	private JTextField sprice;
	private JTextField mprice;
    Kc dao=new Kc();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Xgsp frame = new Xgsp();
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
	public Xgsp() {
		setTitle("\u4FEE\u6539\u5546\u54C1\u4EF7\u683C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GZRYVIEW view=new GZRYVIEW();
				view.setVisible(true);
				Xgsp.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(552, 434, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u53F7");
		lblNewLabel.setBounds(45, 70, 54, 15);
		contentPane.add(lblNewLabel);
		
		no = new JTextField();
		no.setBounds(134, 67, 156, 21);
		contentPane.add(no);
		no.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a=no.getText();
				String b=sprice.getText();
				String c=mprice.getText();
				if(a.equals("") ||b.equals("") ||c.equals(""))
				{
					JOptionPane.showMessageDialog(Xgsp.this, "请输入！");
				}
				else
				{
					int cno=Integer.parseInt(a);
					float sp=Float.parseFloat(b);
					float mp=Float.parseFloat(c);
					
					int t=dao.xgprice(sp, mp, cno);
					if(t<1)
					{
						JOptionPane.showMessageDialog(Xgsp.this, "操作成功！");
						
					}
					else
					{
						JOptionPane.showMessageDialog(Xgsp.this, "操作失败！");
					}
				}
				
			}
		});
		btnNewButton_1.setBounds(336, 265, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u9500\u552E\u4EF7");
		lblNewLabel_1.setBounds(45, 124, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u4F1A\u5458\u4EF7");
		lblNewLabel_2.setBounds(45, 173, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		sprice = new JTextField();
		sprice.setBounds(134, 124, 156, 21);
		contentPane.add(sprice);
		sprice.setColumns(10);
		
		mprice = new JTextField();
		mprice.setBounds(134, 170, 175, 21);
		contentPane.add(mprice);
		mprice.setColumns(10);
	}

}
