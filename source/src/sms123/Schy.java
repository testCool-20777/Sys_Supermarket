package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.Gys;
import Dao.Hy;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Schy extends JFrame {

	private JPanel contentPane;
	private Hy dao=new Hy();
	private JTextField no;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Schy frame = new Schy();
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
	public Schy() {
		setTitle("\u5220\u9664\u4F1A\u5458");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 489);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GLYVIEW view=new GLYVIEW();
				view.setVisible(true);
				Schy.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(297, 394, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664\u6240\u6709\uFF08\u614E\u91CD\uFF01\uFF09");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int t=dao.scall();
				if(t<1)
				{
					JOptionPane.showMessageDialog(Schy.this, "操作成功！");
				}
				else
				{
					JOptionPane.showMessageDialog(Schy.this, "没有该会员");
				}
			}
		});
		btnNewButton_1.setBounds(507, 10, 176, 59);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\u8981\u5220\u9664\u7684\u4F1A\u5458\u53F7");
		lblNewLabel.setBounds(27, 79, 93, 15);
		contentPane.add(lblNewLabel);
		
		no = new JTextField();
		no.setBounds(140, 76, 76, 21);
		contentPane.add(no);
		no.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sno=Integer.parseInt(no.getText());
				int t=dao.sc(sno);
				if(t<1)
				{
					JOptionPane.showMessageDialog(Schy.this, "操作成功！");
				}
				else
				{
					JOptionPane.showMessageDialog(Schy.this, "没有该会员");
				}
			}
		});
		btnNewButton_2.setBounds(248, 75, 93, 23);
		contentPane.add(btnNewButton_2);
	}

}
