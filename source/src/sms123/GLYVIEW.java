package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GLYVIEW extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GLYVIEW frame = new GLYVIEW();
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
	public GLYVIEW() {
		setTitle("\u7BA1\u7406\u5458\u754C\u9762");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 955, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DL t1=new DL();
				t1.setVisible(true);
				GLYVIEW.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(677, 440, 194, 58);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u5458\u4F60\u597D\uFF0C\u6B22\u8FCE\u4F7F\u7528");
		lblNewLabel.setFont(new Font("新宋体", Font.BOLD, 15));
		lblNewLabel.setBounds(340, 96, 220, 68);
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 941, 23);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7BA1\u7406\u5458\u5DE5");
		mnNewMenu.setForeground(Color.PINK);
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_4 = new JMenu("\u6DFB\u52A0\u5458\u5DE5");
		mnNewMenu_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Tjyg view=new Tjyg();
				 GLYVIEW.this.setVisible(false);
				 view.setVisible(true);
			}
		});
		mnNewMenu.add(mnNewMenu_4);
		
		JMenu mnNewMenu_5 = new JMenu("\u5220\u9664\u5458\u5DE5");
		mnNewMenu_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Scyg view=new Scyg();
				GLYVIEW.this.setVisible(false);
				view.setVisible(true);
			}
		});
		mnNewMenu.add(mnNewMenu_5);
		
		JMenu mnNewMenu_6 = new JMenu("\u4FEE\u6539\u5458\u5DE5");
		mnNewMenu_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Xgyg view=new Xgyg();
				GLYVIEW.this.setVisible(false);
				view.setVisible(true);
			}
		});
		mnNewMenu.add(mnNewMenu_6);
		
		JMenu mnNewMenu_7 = new JMenu("\u67E5\u627E\u5458\u5DE5");
		mnNewMenu_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Czyg view=new Czyg();
				GLYVIEW.this.setVisible(false);
				view.setVisible(true);
			}
		});
		mnNewMenu.add(mnNewMenu_7);
		
		JMenu mnNewMenu_1 = new JMenu("\u7BA1\u7406\u4F9B\u5E94\u5546");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_8 = new JMenu("\u6DFB\u52A0\u4F9B\u5E94\u5546");
		mnNewMenu_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tjgys view=new Tjgys();
				GLYVIEW.this.setVisible(false);
				view.setVisible(true);
			}
		});
		mnNewMenu_1.add(mnNewMenu_8);
		
		JMenu mnNewMenu_9 = new JMenu("\u4FEE\u6539\u4F9B\u5E94\u5546");
		mnNewMenu_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Xggys view=new Xggys();
				GLYVIEW.this.setVisible(false);
				view.setVisible(true);
			}
		});
		mnNewMenu_1.add(mnNewMenu_9);
		
		JMenu mnNewMenu_10 = new JMenu("\u67E5\u8BE2\u4F9B\u5E94\u5546");
		mnNewMenu_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cxgysxx view=new Cxgysxx();
				GLYVIEW.this.setVisible(false);
				view.setVisible(true);
			}
		});
		mnNewMenu_1.add(mnNewMenu_10);
		
		JMenu mnNewMenu_11 = new JMenu("\u5220\u9664\u4F9B\u5E94\u5546");
		mnNewMenu_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Scgys view=new Scgys();
				GLYVIEW.this.setVisible(false);
				view.setVisible(true);
			}
		});
		mnNewMenu_1.add(mnNewMenu_11);
		
		JMenu mnNewMenu_2 = new JMenu("\u7BA1\u7406\u4F1A\u5458");
		mnNewMenu_2.setForeground(Color.RED);
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_12 = new JMenu("\u6DFB\u52A0\u4F1A\u5458");
		mnNewMenu_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tjhy view=new Tjhy();
				GLYVIEW.this.setVisible(false);
				view.setVisible(true);
			}
		});
		mnNewMenu_2.add(mnNewMenu_12);
		
		JMenu mnNewMenu_13 = new JMenu("\u5220\u9664\u4F1A\u5458");
		mnNewMenu_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Schy view=new Schy();
				GLYVIEW.this.setVisible(false);
				view.setVisible(true);
			}
		});
		mnNewMenu_2.add(mnNewMenu_13);
		
		JMenu mnNewMenu_14 = new JMenu("\u67E5\u627E\u4F1A\u5458");
		mnNewMenu_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Czhy view=new Czhy();
				GLYVIEW.this.setVisible(false);
				view.setVisible(true);
			}
		});
		mnNewMenu_2.add(mnNewMenu_14);
		
		JMenu mnNewMenu_15 = new JMenu("\u4FEE\u6539\u4F1A\u5458");
		mnNewMenu_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Xghy view=new Xghy();
				GLYVIEW.this.setVisible(false);
				view.setVisible(true);
			}
		});
		mnNewMenu_2.add(mnNewMenu_15);
		
		JMenu mnNewMenu_3 = new JMenu("\u7BA1\u7406\u767B\u9646\u8D26\u6237");
		mnNewMenu_3.setForeground(Color.BLUE);
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_16 = new JMenu("\u6DFB\u52A0\u767B\u9646\u8D26\u6237");
		mnNewMenu_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tjzh view=new Tjzh();
				GLYVIEW.this.setVisible(false);
				view.setVisible(true);
			}
		});
		mnNewMenu_3.add(mnNewMenu_16);
		
		JMenu mnNewMenu_17 = new JMenu("\u5220\u9664\u767B\u9646\u8D26\u6237");
		mnNewMenu_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sczh view=new Sczh();
				GLYVIEW.this.setVisible(false);
				view.setVisible(true);
			}
		});
		mnNewMenu_3.add(mnNewMenu_17);
		
		JMenu mnNewMenu_18 = new JMenu("\u67E5\u627E\u767B\u9646\u8D26\u6237");
		mnNewMenu_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Czzh view=new Czzh();
				GLYVIEW.this.setVisible(false);
				view.setVisible(true);
			}
		});
		mnNewMenu_3.add(mnNewMenu_18);
		
		JMenu mnNewMenu_19 = new JMenu("\u4FEE\u6539\u767B\u9646\u8D26\u6237");
		mnNewMenu_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Xgzh view=new Xgzh();
				GLYVIEW.this.setVisible(false);
				view.setVisible(true);
			}
		});
		mnNewMenu_3.add(mnNewMenu_19);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E09\u5341\u5E74\u6CB3\u4E1C\uFF0C\u4E09\u5341\u5E74\u6CB3\u897F\uFF0C\u83AB\u6B3A\u5C11\u5E74\u7A77\uFF01");
		lblNewLabel_1.setFont(new Font("华文行楷", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 536, 451, 15);
		contentPane.add(lblNewLabel_1);
	}
}
