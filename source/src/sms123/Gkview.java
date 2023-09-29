package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;

public class Gkview extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gkview frame = new Gkview();
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
	public Gkview() {
		setTitle("\u987E\u5BA2\u754C\u9762");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1049, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton tc = new JButton("\u9000\u51FA\u767B\u9646");
		tc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DL t1=new DL();
				t1.setVisible(true);
				Gkview.this.setVisible(false);
				
				
			}
		});
		tc.setBounds(744, 497, 174, 58);
		contentPane.add(tc);
		
		JLabel lblNewLabel = new JLabel("\u987E\u5BA2\u4F60\u597D\uFF0C\u6B22\u8FCE\u524D\u5F80\u7EBF\u4E0B\u95E8\u5E97\u8FDB\u884C\u9009\u8D2D");
		lblNewLabel.setFont(new Font("ÐÂËÎÌå", Font.BOLD, 16));
		lblNewLabel.setBounds(275, 79, 339, 58);
		contentPane.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(108, 195, 1, 1);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("\u6253\u5F00\u5546\u5E97");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Shop view=new Shop();
				view.setVisible(true);
				Gkview.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(345, 192, 200, 58);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2\u5DF2\u8D2D\u4E70");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cxygm view=new Cxygm();
				view.setVisible(true);
				Gkview.this.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(345, 348, 186, 48);
		contentPane.add(btnNewButton_1);
	}
}
