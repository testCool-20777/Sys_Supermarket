package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.Kc;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Scsp extends JFrame {

	private JPanel contentPane;
	private JTextField no;
	Kc dao=new Kc();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scsp frame = new Scsp();
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
	public Scsp() {
		setTitle("\u5220\u9664\u5546\u54C1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GZRYVIEW view=new GZRYVIEW();
				view.setVisible(true);
				Scsp.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(340, 444, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u53F7");
		lblNewLabel.setBounds(39, 48, 54, 15);
		contentPane.add(lblNewLabel);
		
		no = new JTextField();
		no.setBounds(101, 45, 150, 21);
		contentPane.add(no);
		no.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String t=no.getText();
				if(t.equals(""))
				{
					JOptionPane.showMessageDialog(Scsp.this, "«Î ‰»Î…Ã∆∑∫≈£°");
				}
				else
				{
					int sno=Integer.parseInt(t);
					int t0=dao.sc(sno);
					if(t0<1)
					{
						JOptionPane.showMessageDialog(Scsp.this, "…æ≥˝≥…π¶£°");
					}
					else
					{
						JOptionPane.showMessageDialog(Scsp.this, "…æ≥˝ ß∞‹£°");
					}
				}
			}
		});
		btnNewButton_1.setBounds(297, 44, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664\u6240\u6709\uFF08\u614E\u91CD\uFF01\uFF09");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int t=dao.scall();
				if(t<1)
				{
					JOptionPane.showMessageDialog(Scsp.this, "…æ≥˝≥…π¶£°");
				}
				else
				{
					JOptionPane.showMessageDialog(Scsp.this, "…æ≥˝ ß∞‹£°");
				}
			}
		});
		btnNewButton_2.setBounds(534, 44, 167, 23);
		contentPane.add(btnNewButton_2);
	}

}
