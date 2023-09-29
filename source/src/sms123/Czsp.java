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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.Kc;
import mod.Member;
import mod.Spxx;

public class Czsp extends JFrame {

	private JPanel contentPane;
	private JTextField no;
	private JTable table;
    Kc dao=new Kc();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Czsp frame = new Czsp();
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
	public Czsp() {
		setTitle("\u67E5\u627E\u5546\u54C1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("bcak");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GZRYVIEW view=new GZRYVIEW();
				view.setVisible(true);
				Czsp.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(319, 444, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u53F7");
		lblNewLabel.setBounds(10, 43, 54, 15);
		contentPane.add(lblNewLabel);
		
		no = new JTextField();
		no.setBounds(91, 40, 321, 21);
		contentPane.add(no);
		no.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u627E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String t=no.getText();
				if(t.equals(""))
				{
					JOptionPane.showMessageDialog(Czsp.this, "输入商品号可进行精确查找！");
					DefaultTableModel def=(DefaultTableModel)table.getModel();
					def.setRowCount(0);
					List<Spxx>types= dao.cxspall();
					
					for(Spxx type:types)
					{
						def.addRow(new Object[] {type.getCno(),type.getBuyprice(),type.getNumber(),type.getSuplier(),type.getIndate(),type.getCkeep()});
					}
				}
				else
				{
					int a=Integer.parseInt(t);
					DefaultTableModel def=(DefaultTableModel)table.getModel();
					def.setRowCount(0);
					List<Spxx>types= dao.cxsp(a);
					
					for(Spxx type:types)
					{
						def.addRow(new Object[] {type.getCno(),type.getBuyprice(),type.getNumber(),type.getSuplier(),type.getIndate(),type.getCkeep()});
					}
				}
				
			}
		});
		btnNewButton_1.setBounds(438, 39, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 85, 654, 324);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"\u5546\u54C1\u53F7", "\u8FDB\u8D27\u4EF7\u683C", "\u5E93\u5B58\u91CF", "\u4F9B\u5E94\u5546\u53F7", "\u5165\u5E93\u65F6\u95F4", "\u4FDD\u8D28\u671F\u81F3"
			}
		));
		scrollPane.setViewportView(table);
		
		DefaultTableModel def=(DefaultTableModel)table.getModel();
		List<Spxx>types= dao.cxspall();
		
		for(Spxx type:types)
		{
			def.addRow(new Object[] {type.getCno(),type.getBuyprice(),type.getNumber(),type.getSuplier(),type.getIndate(),type.getCkeep()});
		}
	}
}
