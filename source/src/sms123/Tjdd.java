package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.Xs;
import mod.Suplier;
import mod.Warning;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Tjdd extends JFrame {

	private JPanel contentPane;
	private JTextField pno;
	private JTextField cno;
	private JTextField number;
	private JTextField rmb;
	private JTextField date;
    Xs dao=new Xs(); 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tjdd frame = new Tjdd();
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
	public Tjdd() {
		setTitle("\u6DFB\u52A0\u8BA2\u5355");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GZRYVIEW view=new GZRYVIEW();
				view.setVisible(true);
				Tjdd.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(603, 56, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u8BA2\u5355\u53F7");
		lblNewLabel.setBounds(39, 60, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u53F7");
		lblNewLabel_1.setBounds(39, 122, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6570\u91CF");
		lblNewLabel_2.setBounds(39, 189, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u91D1\u989D");
		lblNewLabel_3.setBounds(39, 257, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u8BA2\u5355\u65E5\u671F");
		lblNewLabel_4.setBounds(39, 339, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		pno = new JTextField();
		pno.setBounds(117, 57, 66, 21);
		contentPane.add(pno);
		pno.setColumns(10);
		
		cno = new JTextField();
		cno.setBounds(117, 119, 66, 21);
		contentPane.add(cno);
		cno.setColumns(10);
		
		number = new JTextField();
		number.setBounds(117, 186, 66, 21);
		contentPane.add(number);
		number.setColumns(10);
		
		rmb = new JTextField();
		rmb.setBounds(117, 254, 66, 21);
		contentPane.add(rmb);
		rmb.setColumns(10);
		
		date = new JTextField();
		date.setBounds(117, 336, 66, 21);
		contentPane.add(date);
		date.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pno1=Integer.parseInt(pno.getText());
				int cno1=Integer.parseInt(cno.getText());
				int number1=Integer.parseInt(number.getText());
				Float rmb1=Float.parseFloat(rmb.getText());
				String pdate=date.getText();
				
				List<Warning> types= dao.cxsl(cno1);
				int sl=0;
				for(Warning type:types)
				{
					sl=type.getCnumber();
				}
				int b=number1;
				int xg=sl-number1;
				System.out.println(sl);
				System.out.println(b);
				System.out.println(xg);
				if(xg<0)
				{
					JOptionPane.showMessageDialog(Tjdd.this, "添加失败，没有那么多的库存！");
				}
				else
				{
					int t2=dao.xgnumber(xg, cno1);
					int t=dao.tj(pno1, cno1, number1, rmb1, pdate);
					if(t<1)
				{     
					JOptionPane.showMessageDialog(Tjdd.this, "添加成功！");
					
				}
				else
				{
					JOptionPane.showMessageDialog(Tjdd.this, "添加失败，您的输入有误！");
				}
					
				}
				
			
				
				
				
					
			}
		});
		btnNewButton_1.setBounds(393, 339, 93, 23);
		contentPane.add(btnNewButton_1);
	}

}
