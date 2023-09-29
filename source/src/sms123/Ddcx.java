package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.Xs;
import mod.Pay;
import mod.Suplier;

public class Ddcx extends JFrame {

	private JPanel contentPane;
	private JTextField no;
	private JTable table;
    Xs dao=new Xs();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ddcx frame = new Ddcx();
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
	public Ddcx() {
		setTitle("\u8BA2\u5355\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GZRYVIEW view=new GZRYVIEW();
				view.setVisible(true);
				Ddcx.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(340, 438, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8BA2\u5355\u53F7");
		lblNewLabel.setBounds(29, 75, 93, 15);
		contentPane.add(lblNewLabel);
		
		no = new JTextField();
		no.setBounds(132, 72, 268, 21);
		contentPane.add(no);
		no.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String t=no.getText();
				
				
				if(t.equals(""))
				{
					JOptionPane.showMessageDialog(Ddcx.this, "输入订单号可进行精确查找！");
				}
				else
				{
					int a=Integer.parseInt(t);
					DefaultTableModel def=(DefaultTableModel)table.getModel();
					def.setRowCount(0);
					List<Pay>types= dao.cxdd(a);
					
					for(Pay type:types)
					{
						def.addRow(new Object[] {type.getPno(),type.getClientno(),type.getEno(),type.getRmb(),type.getPdate()});
					}
				}
				
				
			}
		});
		btnNewButton_1.setBounds(456, 71, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 123, 562, 266);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"\u8BA2\u5355\u53F7", "\u987E\u5BA2\u53F7", "\u5458\u5DE5\u53F7", "\u91D1\u989D", "\u652F\u4ED8\u65E5\u671F"
			}
		));
		scrollPane.setViewportView(table);
		
		DefaultTableModel def=(DefaultTableModel)table.getModel();
		List<Pay>types= dao.cxddall();
		
		for(Pay type:types)
		{
			def.addRow(new Object[] {type.getPno(),type.getClientno(),type.getEno(),type.getRmb(),type.getPdate()});
		}
	}

}
