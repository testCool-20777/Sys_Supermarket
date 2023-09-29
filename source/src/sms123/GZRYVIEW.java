package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame.JDesktopIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mod.Spyj;

import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GZRYVIEW extends JFrame {

	private JPanel contentPane;
	JDesktopPane des;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GZRYVIEW frame = new GZRYVIEW();
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
	public GZRYVIEW() {
		setTitle("\u5DE5\u4F5C\u4EBA\u5458\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.setBounds(703, 486, 152, 60);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DL t1=new DL();
				t1.setVisible(true);
				GZRYVIEW.this.setVisible(false);
				
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u5DE5\u4F5C\u4EBA\u5458\u4F60\u597D\uFF0C\u6B22\u8FCE\u4F7F\u7528");
		lblNewLabel.setBounds(193, 198, 270, 76);
		lblNewLabel.setFont(new Font("新宋体", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 915, 23);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u8FDB\u8D27\u7BA1\u7406");
		mnNewMenu.setForeground(Color.RED);
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_3 = new JMenu("\u5B89\u6392\u8FDB\u8D27\u8BA1\u5212");
		mnNewMenu_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				
			}
		});
		mnNewMenu.add(mnNewMenu_3);
		
		JMenu mnNewMenu_18 = new JMenu("now");
		mnNewMenu_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("yes");
				apjh view=new apjh();
				
				GZRYVIEW.this.setVisible(false);
				view.setVisible(true);
			}
		});
		
		mnNewMenu_3.add(mnNewMenu_18);
		
		JMenu mnNewMenu_4 = new JMenu("\u67E5\u8BE2\u4F9B\u5E94\u5546\u63D0\u4F9B\u7684\u5546\u54C1\u4FE1\u606F");
		mnNewMenu_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                 Cxgys view=new Cxgys();
				
				GZRYVIEW.this.setVisible(false);
				view.setVisible(true);
				
			}
		});
		mnNewMenu.add(mnNewMenu_4);
		
		JMenu mnNewMenu_5 = new JMenu("\u67E5\u8BE2\u5546\u54C1\u7684\u5E93\u5B58\u5BB9\u91CF\r\n\r\n\r\n");
		mnNewMenu_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnNewMenu_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				    Cxsp view=new Cxsp();
					
					GZRYVIEW.this.setVisible(false);
					view.setVisible(true);
			}
		});
		mnNewMenu.add(mnNewMenu_5);
		
		JMenu mnNewMenu_1 = new JMenu("\u9500\u552E\u7BA1\u7406");
		mnNewMenu_1.setForeground(Color.GREEN);
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_6 = new JMenu("\u6DFB\u52A0\u8BA2\u5355");
		mnNewMenu_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Tjdd view=new Tjdd();
					
					GZRYVIEW.this.setVisible(false);
					view.setVisible(true);
			}
		});
		mnNewMenu_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mnNewMenu_1.add(mnNewMenu_6);
		
		JMenu mnNewMenu_7 = new JMenu("\u8BA2\u5355\u67E5\u8BE2");
		mnNewMenu_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Ddcx view=new Ddcx();
					
					GZRYVIEW.this.setVisible(false);
					view.setVisible(true);
			}
		});
		mnNewMenu_1.add(mnNewMenu_7);
		
		JMenu mnNewMenu_8 = new JMenu("\u9500\u552E\u7EDF\u8BA1\u67E5\u8BE2");
		mnNewMenu_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Xstj view=new Xstj();
					
					GZRYVIEW.this.setVisible(false);
					view.setVisible(true);
			}
		});
		mnNewMenu_1.add(mnNewMenu_8);
		
		JMenu mnNewMenu_2 = new JMenu("\u5E93\u5B58\u7BA1\u7406");
		mnNewMenu_2.setForeground(Color.BLUE);
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_9 = new JMenu("\u7BA1\u7406\u5546\u54C1");
		mnNewMenu_2.add(mnNewMenu_9);
		
		JMenu mnNewMenu_14 = new JMenu("\u5F55\u5165\u5546\u54C1\u4FE1\u606F");
		mnNewMenu_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Tjsp view=new Tjsp();
				 GZRYVIEW.this.setVisible(false);
				 view.setVisible(true);
			}
		});
		mnNewMenu_9.add(mnNewMenu_14);
		
		JMenu mnNewMenu_15 = new JMenu("\u4FEE\u6539\u5546\u54C1\u4EF7\u683C");
		mnNewMenu_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Xgsp view=new Xgsp();
				 GZRYVIEW.this.setVisible(false);
				 view.setVisible(true);
			}
		});
		mnNewMenu_9.add(mnNewMenu_15);
		
		JMenu mnNewMenu_16 = new JMenu("\u67E5\u8BE2\u5546\u54C1");
		mnNewMenu_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnNewMenu_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Czsp view=new Czsp();
				 GZRYVIEW.this.setVisible(false);
				 view.setVisible(true);
			}
		});
		mnNewMenu_9.add(mnNewMenu_16);
		
		JMenu mnNewMenu_17 = new JMenu("\u5220\u9664\u5546\u54C1");
		mnNewMenu_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Scsp view=new Scsp();
				 GZRYVIEW.this.setVisible(false);
				 view.setVisible(true);
			}
		});
		mnNewMenu_9.add(mnNewMenu_17);
		
		JMenu mnNewMenu_11 = new JMenu("\u67E5\u770B\u5546\u54C1\u9884\u8B66");
		mnNewMenu_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Spyj view=new Spyj();
				view.setVisible(true);
				GZRYVIEW.this.setVisible(false);
			}
		});
		mnNewMenu_9.add(mnNewMenu_11);
		
		JMenu mnNewMenu_10 = new JMenu("\u8FDB\u884C\u7F3A\u8D27\uFF0C\u538B\u8D27\u7B49\u9884\u8B66");
		mnNewMenu_2.add(mnNewMenu_10);
		
		JMenu mnNewMenu_12 = new JMenu("now");
		mnNewMenu_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Qhyj view=new Qhyj();
				 GZRYVIEW.this.setVisible(false);
				 view.setVisible(true);
			}
		});
		mnNewMenu_10.add(mnNewMenu_12);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E09\u5341\u5E74\u6CB3\u897F\uFF0C\u4E09\u5341\u5E74\u6CB3\u4E1C\uFF0C\u83AB\u6B3A\u5C11\u5E74\u7A77\uFF01");
		lblNewLabel_1.setFont(new Font("华文行楷", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 550, 695, 15);
		contentPane.add(lblNewLabel_1);
	}
}
