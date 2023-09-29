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

import Dao.Zh;
import mod.Suplier;
import mod.Zhdl;

public class Czzh extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTable table;
	private Zh dao=new Zh();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Czzh frame = new Czzh();
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
	public Czzh() {
		setTitle("\u67E5\u627E\u8D26\u6237");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GLYVIEW view=new GLYVIEW();
				view.setVisible(true);
				Czzh.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(313, 422, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8981\u67E5\u627E\u7684\u8D26\u6237\u7684\u767B\u9646\u540D");
		lblNewLabel.setBounds(25, 34, 197, 15);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(213, 31, 291, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u627E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel def=(DefaultTableModel)table.getModel();
				def.setRowCount(0);
				String name1=name.getText();
				List<Zhdl>types= dao.cx(name1);				
				for(Zhdl type:types)
				{
					def.addRow(new Object[] {type.getName(),type.getPass(),type.getNo(),type.getRank()});
				}
				
			}
		});
		btnNewButton_1.setBounds(541, 30, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 99, 673, 284);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"\u767B\u9646\u540D", "\u5BC6\u7801", "\u8D26\u6237\u5E8F\u5217\u53F7", "\u8D26\u6237\u7C7B\u522B\u4EE3\u53F7"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(113);
		scrollPane.setViewportView(table);
		
		DefaultTableModel def=(DefaultTableModel)table.getModel();
		List<Zhdl>types= dao.cxall();
		
		for(Zhdl type:types)
		{
			def.addRow(new Object[] {type.getName(),type.getPass(),type.getNo(),type.getRank()});
		}
	}

}
