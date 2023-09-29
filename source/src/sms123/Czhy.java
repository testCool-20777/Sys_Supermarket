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
import Dao.Hy;
import mod.Suplier;
import mod.Member;
public class Czhy extends JFrame {

	private JPanel contentPane;
	private JTextField no;
	private JTable table;
	private Hy dao=new Hy();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Czhy frame = new Czhy();
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
	public Czhy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GLYVIEW view=new GLYVIEW();
				view.setVisible(true);
				Czhy.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(320, 422, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u4F1A\u5458\u53F7");
		lblNewLabel.setBounds(41, 57, 54, 15);
		contentPane.add(lblNewLabel);
		
		no = new JTextField();
		no.setBounds(110, 54, 116, 21);
		contentPane.add(no);
		no.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u627E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sno=Integer.parseInt(no.getText());
				fill(sno);
			}
		});
		btnNewButton_1.setBounds(285, 53, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 112, 620, 259);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"\u4F1A\u5458\u53F7", "\u4F1A\u5458\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u7535\u8BDD\u53F7\u7801", "\u987E\u5BA2\u53F7"
			}
		));
		table.getColumnModel().getColumn(4).setPreferredWidth(151);
		scrollPane.setViewportView(table);
		DefaultTableModel def=(DefaultTableModel)table.getModel();
		List<Member>types= dao.cxall();
		
		for(Member type:types)
		{
			def.addRow(new Object[] {type.getMno(),type.getMname(),type.getMsex(),type.getMage(),type.getMphone(),type.getClientno()});
		}
	}
	
	
	public void fill(int a) {
		
		DefaultTableModel def=(DefaultTableModel)table.getModel();
		def.setRowCount(0);
		List<Member>types= dao.cx(a);
		
		for(Member type:types)
		{
			def.addRow(new Object[] {type.getMno(),type.getMname(),type.getMsex(),type.getMage(),type.getMphone(),type.getClientno()});
		}
		
		
	}

}
