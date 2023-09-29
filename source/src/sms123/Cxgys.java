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

import Dao.Gys;
import Dao.Jh;
import mod.Suplier;
import mod.Supply;

public class Cxgys extends JFrame {

	private JPanel contentPane;
	private JTextField sno;
	private JTextField cno;
	private JTable table;
	private Jh dao=new Jh();

	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cxgys frame = new Cxgys();
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
	public Cxgys() {
		setTitle("\u67E5\u8BE2\u4F9B\u5E94\u5546\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GZRYVIEW view=new GZRYVIEW();
				view.setVisible(true);
				Cxgys.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(528, 402, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u4F9B\u5E94\u5546\u53F7");
		lblNewLabel.setBounds(27, 33, 54, 15);
		contentPane.add(lblNewLabel);
		
		sno = new JTextField();
		sno.setBounds(107, 30, 137, 21);
		contentPane.add(sno);
		sno.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u53F7");
		lblNewLabel_1.setBounds(27, 130, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		cno = new JTextField();
		cno.setBounds(107, 127, 137, 21);
		contentPane.add(cno);
		cno.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u6309\u4F9B\u5E94\u5546\u53F7\u67E5\u8BE2\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a=sno.getText();
				if(a.equals(""))
				{
					JOptionPane.showMessageDialog(Cxgys.this, "请输入供应商号！");
				}
				else
				{
					
					int no=Integer.parseInt(a);
					DefaultTableModel def=(DefaultTableModel)table.getModel();
					def.setRowCount(0);
					List<Supply>types= dao.cxsp(no);
					
					for(Supply type:types)
					{
						def.addRow(new Object[] {type.getSno(),type.getCno(),type.getIndate(),type.getSname(),type.getPrice(),type.getNumber()});
					}
				}
			}
		});
		btnNewButton_1.setBounds(365, 29, 218, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u6309\u5546\u54C1\u53F7\u67E5\u8BE2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a=cno.getText();
				if(a.equals(""))
				{
					JOptionPane.showMessageDialog(Cxgys.this, "请输入供应商号！");
					
				}
				else
				{
					int no=Integer.parseInt(a);
					DefaultTableModel def=(DefaultTableModel)table.getModel();
					def.setRowCount(0);
					List<Supply>types= dao.cxjg(no);
					
					for(Supply type:types)
					{
						def.addRow(new Object[] {type.getSno(),type.getCno(),type.getIndate(),type.getSname(),type.getPrice(),type.getNumber()});
					}
				}
			}
		});
		btnNewButton_2.setBounds(365, 126, 218, 23);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 200, 600, 155);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"\u4F9B\u5E94\u5546\u53F7", "\u5546\u54C1\u53F7", "\u5165\u5E93\u65E5\u671F", "\u4F9B\u5E94\u5546\u540D\u79F0", "\u4EF7\u683C", "\u6570\u91CF"
			}
		));
		scrollPane.setViewportView(table);
		
		DefaultTableModel def=(DefaultTableModel)table.getModel();
		List<Supply>types= dao.cxall();
		
		for(Supply type:types)
		{
			def.addRow(new Object[] {type.getSno(),type.getCno(),type.getIndate(),type.getSname(),type.getPrice(),type.getNumber()});
		}
	}

}
