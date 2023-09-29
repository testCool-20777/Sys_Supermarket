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

import Dao.dao;
import mod.Employee;
import mod.Shoptype;

public class Czyg extends JFrame {

	private JPanel contentPane;
	private JTextField no;
	private JTable table;
	dao dao1= new dao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Czyg frame = new Czyg();
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
	public Czyg() {
		setTitle("\u67E5\u627E\u5458\u5DE5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GLYVIEW view=new GLYVIEW();
				view.setVisible(true);
				Czyg.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(292, 363, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u53F7");
		lblNewLabel.setBounds(40, 27, 54, 15);
		contentPane.add(lblNewLabel);
		
		no = new JTextField();
		no.setBounds(155, 24, 138, 21);
		contentPane.add(no);
		no.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u627E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			int t=Integer.parseInt(no.getText());
			fill(t);
			
			
				
			
			}
		});
		btnNewButton_1.setBounds(332, 23, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 89, 565, 240);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"\u5458\u5DE5\u53F7", "\u5458\u5DE5\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u5DE5\u8D44"
			}
		));
		
		
		
		
		
		DefaultTableModel def=(DefaultTableModel)table.getModel();
		List<Employee>types= dao1.cxygall();
		
		for(Employee type:types)
		{
			def.addRow(new Object[] {type.getEno(),type.getEname(),type.getEsex(),type.getWage(),type.getNumber()});
		}
		
		
		scrollPane.setViewportView(table);
		
		
		
	}
	public void fill(int a) {
		
		DefaultTableModel def=(DefaultTableModel)table.getModel();
		def.setRowCount(0);
		List<Employee>types= dao1.cxyg(a);
		
		for(Employee type:types)
		{
			def.addRow(new Object[] {type.getEno(),type.getEname(),type.getEsex(),type.getWage(),type.getNumber()});
		}
		
		
	}
}
