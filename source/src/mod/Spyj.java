package mod;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sms123.Cxsp;
import sms123.GZRYVIEW;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.Kc;

import javax.swing.JTextField;

public class Spyj extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table1;
	private JTextField time;
	Kc dao=new Kc();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Spyj frame = new Spyj();
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
	public Spyj() {
		setTitle("\u67E5\u770B\u5546\u54C1\u9884\u8B66");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GZRYVIEW view=new GZRYVIEW();
				view.setVisible(true);
				Spyj.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(607, 486, 93, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 52, 645, 156);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"\u5546\u54C1\u53F7", "\u5E93\u5B58\u4F59\u91CF"
			}
		));
		scrollPane.setViewportView(table);
		
		DefaultTableModel def=(DefaultTableModel)table.getModel();
		List<Kctx>types= dao.cxyj();
		
		for(Kctx type:types)
		{
			def.addRow(new Object[] {type.getCno(),type.getNumber()});
		}
		
		
		
		JLabel lblNewLabel = new JLabel("\u7F3A\u8D27\u9884\u8B66\uFF08\u8BF7\u5C3D\u5FEB\u5B89\u6392\u8FDB\u8D27\uFF01\uFF09");
		lblNewLabel.setBounds(34, 25, 445, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u538B\u8D27\u9884\u8B66\uFF08\u8BF7\u53CA\u65F6\u8BBE\u5B9A\u4F18\u60E0\u6E05\u5E93\u5B58\uFF01\uFF09");
		lblNewLabel_1.setBounds(34, 438, 423, 15);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(34, 282, 645, 146);
		contentPane.add(scrollPane_1);
		
		table1 = new JTable();
		table1.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"\u5546\u54C1\u53F7", "\u5E93\u5B58\u6570\u91CF"
			}
		));
		scrollPane_1.setViewportView(table1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BF7\u8F93\u5165\u5F53\u524D\u65F6\u95F4");
		lblNewLabel_2.setBounds(34, 240, 114, 15);
		contentPane.add(lblNewLabel_2);
		
		time = new JTextField();
		time.setBounds(144, 237, 169, 21);
		contentPane.add(time);
		time.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a=time.getText();
				if(a.equals(""))
				{
					JOptionPane.showMessageDialog(Spyj.this, "输入当前时间！");
				}
				else
				{
					int t=Integer.parseInt(time.getText());
					
					DefaultTableModel def=(DefaultTableModel)table1.getModel();
					def.setRowCount(0);
					List<Warning>types= dao.cxyh(t);
					
					for(Warning type:types)
					{
						def.addRow(new Object[] {type.getCno(),type.getKwarn()});
					}
				}
				
				
			}
		});
		btnNewButton_1.setBounds(362, 236, 93, 23);
		contentPane.add(btnNewButton_1);
	}

}
