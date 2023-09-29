package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.Gys;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Scgys extends JFrame {

	private JPanel contentPane;
	private Gys dao=new Gys();
	private JTextField no;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scgys frame = new Scgys();
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
	public Scgys() {
		setTitle("\u5220\u9664\u4F9B\u5E94\u5546");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GLYVIEW view=new GLYVIEW();
				view.setVisible(true);
				Scgys.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(317, 405, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664\u6240\u6709\uFF08\u614E\u91CD\uFF01\uFF09");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int t=dao.scall();
				if(t<1)
				{
					JOptionPane.showMessageDialog(Scgys.this, "操作成功！");
				}
				else
				{
					JOptionPane.showMessageDialog(Scgys.this, "没有该供应商");
				}
				
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(512, 31, 152, 44);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\u4F9B\u5E94\u5546\u53F7");
		lblNewLabel.setBounds(27, 85, 54, 15);
		contentPane.add(lblNewLabel);
		
		no = new JTextField();
		no.setBounds(91, 82, 66, 21);
		contentPane.add(no);
		no.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sno=Integer.parseInt(no.getText());
				int t=dao.sc(sno);
				if(t<1)
				{
					JOptionPane.showMessageDialog(Scgys.this, "操作成功！");
				}
				else
				{
					JOptionPane.showMessageDialog(Scgys.this, "没有该供应商");
				}
			}
		});
		btnNewButton_2.setBounds(171, 81, 93, 23);
		contentPane.add(btnNewButton_2);
	}

}
