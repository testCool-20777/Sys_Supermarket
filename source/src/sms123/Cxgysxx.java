package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.Gys;
import mod.Employee;
import mod.Shoptype;
import mod.Suplier;

public class Cxgysxx extends JFrame {

	private JPanel contentPane;
	private JTextField no;
	private JTable table;
	private Gys dao=new Gys();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cxgysxx frame = new Cxgysxx();
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
	public Cxgysxx() {
		setTitle("\u67E5\u8BE2\u4F9B\u5E94\u5546\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GLYVIEW view=new GLYVIEW();
				view.setVisible(true);
				Cxgysxx.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(327, 379, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u4F9B\u5E94\u5546\u53F7");
		lblNewLabel.setBounds(55, 40, 54, 15);
		contentPane.add(lblNewLabel);
		
		no = new JTextField();
		no.setBounds(158, 37, 145, 21);
		contentPane.add(no);
		no.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sno=Integer.parseInt(no.getText());
				fill(sno);
				
			}
		});
		btnNewButton_1.setBounds(367, 36, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 104, 627, 232);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"\u4F9B\u5E94\u5546\u53F7", "\u4F9B\u5E94\u5546\u540D\u79F0"
			}
		));
		scrollPane.setViewportView(table);
		
		DefaultTableModel def=(DefaultTableModel)table.getModel();
		List<Suplier>types= dao.cxall();
		
		for(Suplier type:types)
		{
			def.addRow(new Object[] {type.getSno(),type.getSname()});
		}
		
		
	}
	public void fill(int a) {
		
		DefaultTableModel def=(DefaultTableModel)table.getModel();
		def.setRowCount(0);
		List<Suplier>types= dao.cx(a);
		
		for(Suplier type:types)
		{
			def.addRow(new Object[] {type.getSno(),type.getSname()});
		}
		
		
	}

}
