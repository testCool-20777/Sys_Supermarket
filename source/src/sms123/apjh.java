package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Dao.dao;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@SuppressWarnings("all")
public class apjh extends JFrame {
    private dao dao1=new dao();
	private JPanel contentPane;
	private JTextField cno;
	private JTextField cname;
	private JTextField sno;
	private JTextField sname;
	private JTextField indate;
	private JTextField cdate;
	private JTextField kdate;
	private JTextField price;
	private JTextField number;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					apjh frame = new apjh();
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
	public apjh() {
		setTitle("\u5B89\u6392\u8FDB\u8D27");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8981\u8FDB\u8D27\u7684\u5546\u54C1\u53F7");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		cno = new JTextField();
		GridBagConstraints gbc_cno = new GridBagConstraints();
		gbc_cno.insets = new Insets(0, 0, 5, 0);
		gbc_cno.fill = GridBagConstraints.HORIZONTAL;
		gbc_cno.gridx = 1;
		gbc_cno.gridy = 0;
		contentPane.add(cno, gbc_cno);
		cno.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u540D\u79F0");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		cname = new JTextField();
		GridBagConstraints gbc_cname = new GridBagConstraints();
		gbc_cname.insets = new Insets(0, 0, 5, 0);
		gbc_cname.fill = GridBagConstraints.HORIZONTAL;
		gbc_cname.gridx = 1;
		gbc_cname.gridy = 1;
		contentPane.add(cname, gbc_cname);
		cname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u4F9B\u5E94\u5546\u53F7");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		sno = new JTextField();
		GridBagConstraints gbc_sno = new GridBagConstraints();
		gbc_sno.insets = new Insets(0, 0, 5, 0);
		gbc_sno.fill = GridBagConstraints.HORIZONTAL;
		gbc_sno.gridx = 1;
		gbc_sno.gridy = 2;
		contentPane.add(sno, gbc_sno);
		sno.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u4F9B\u5E94\u5546\u540D\u79F0");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		sname = new JTextField();
		GridBagConstraints gbc_sname = new GridBagConstraints();
		gbc_sname.insets = new Insets(0, 0, 5, 0);
		gbc_sname.fill = GridBagConstraints.HORIZONTAL;
		gbc_sname.gridx = 1;
		gbc_sname.gridy = 3;
		contentPane.add(sname, gbc_sname);
		sname.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u8BA1\u5212\u5165\u5E93\u7684\u65E5\u671F");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		indate = new JTextField();
		GridBagConstraints gbc_indate = new GridBagConstraints();
		gbc_indate.insets = new Insets(0, 0, 5, 0);
		gbc_indate.fill = GridBagConstraints.HORIZONTAL;
		gbc_indate.gridx = 1;
		gbc_indate.gridy = 4;
		contentPane.add(indate, gbc_indate);
		indate.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u6240\u9700\u7684\u751F\u4EA7\u65E5\u671F");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		cdate = new JTextField();
		GridBagConstraints gbc_cdate = new GridBagConstraints();
		gbc_cdate.insets = new Insets(0, 0, 5, 0);
		gbc_cdate.fill = GridBagConstraints.HORIZONTAL;
		gbc_cdate.gridx = 1;
		gbc_cdate.gridy = 5;
		contentPane.add(cdate, gbc_cdate);
		cdate.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u4FDD\u8D28\u671F");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		kdate = new JTextField();
		GridBagConstraints gbc_kdate = new GridBagConstraints();
		gbc_kdate.insets = new Insets(0, 0, 5, 0);
		gbc_kdate.fill = GridBagConstraints.HORIZONTAL;
		gbc_kdate.gridx = 1;
		gbc_kdate.gridy = 6;
		contentPane.add(kdate, gbc_kdate);
		kdate.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u8FDB\u8D27\u7684\u4EF7\u683C");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		price = new JTextField();
		GridBagConstraints gbc_price = new GridBagConstraints();
		gbc_price.insets = new Insets(0, 0, 5, 0);
		gbc_price.fill = GridBagConstraints.HORIZONTAL;
		gbc_price.gridx = 1;
		gbc_price.gridy = 7;
		contentPane.add(price, gbc_price);
		price.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\u6570\u91CF");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 8;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		number = new JTextField();
		GridBagConstraints gbc_number = new GridBagConstraints();
		gbc_number.insets = new Insets(0, 0, 5, 0);
		gbc_number.fill = GridBagConstraints.HORIZONTAL;
		gbc_number.gridx = 1;
		gbc_number.gridy = 8;
		contentPane.add(number, gbc_number);
		number.setColumns(10);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("\u63D0\u4EA4");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cno1=Integer.parseInt(cno.getText());
				String cname1=cname.getText();
				int sno1=Integer.parseInt(sno.getText());
				String sname1=sname.getText();
				String indate1=indate.getText();
				String cdate1=cdate.getText();
				String kdate1=kdate.getText();
				float price1=Float.parseFloat(price.getText());
				int number1=Integer.parseInt(number.getText());
				int t=0;
				int t2=0;
				
					t=dao1.insert(cno1,cname1,cdate1,kdate1);
					t2=dao1.tjgys(sno1, cno1, indate1, sname1, price1, number1);
				if(t<1)
				{
					
					if(t2<1)
					{
						JOptionPane.showMessageDialog(apjh.this, "操作成功！");
					}
					else
					{
						JOptionPane.showMessageDialog(apjh.this, "您的输入有误！");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(apjh.this, "您的输入有误！");
				}
				
				
			}
		});
		GridBagConstraints gbc_tglbtnNewToggleButton = new GridBagConstraints();
		gbc_tglbtnNewToggleButton.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNewToggleButton.gridx = 0;
		gbc_tglbtnNewToggleButton.gridy = 11;
		contentPane.add(tglbtnNewToggleButton, gbc_tglbtnNewToggleButton);
		
		JButton tc = new JButton("\u9000\u51FA");
		tc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				GZRYVIEW t1=new GZRYVIEW();
				t1.setVisible(true);
				apjh.this.setVisible(false);
				
			}
		});
		GridBagConstraints gbc_tc = new GridBagConstraints();
		gbc_tc.insets = new Insets(0, 0, 5, 0);
		gbc_tc.gridx = 1;
		gbc_tc.gridy = 11;
		contentPane.add(tc, gbc_tc);
	}

}
