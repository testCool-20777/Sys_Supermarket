package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;

public class Zc extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField pass;
	private JTextField no;
	String sex="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zc frame = new Zc();
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
	public Zc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 998, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String connectionUrl = "jdbc:sqlserver://localhost:1433;"  
		                + "databaseName=AdventureWorks;integratedSecurity=true;";  
		        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=sms123;user=sa;password=123zxc";//以sa身份连接数据库:请根据自己的用户名和密码进行重新设置！！！！！！
		      
		         Statement stmt = null;  
		        ResultSet rs = null; 
		        PreparedStatement pstm=null;
		        String name1=name.getText();
		        String pass1=pass.getText();
		        
		        String sql=null;
		        
		        int f=0;
		        
		        int clientno= Integer.parseInt(no.getText());
		        Connection con = null;
		        System.out.println(clientno);
		       try {
		    	   
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			} 
		       
		        
		        
		       
		        
                	  
	                 
	                 
	                
	                	try {
	                	
	                		 pstm=null;
	    		        	 con = DriverManager.getConnection(url);
	    		        	 sql="INSERT INTO  zcb VALUES(?, ?,1)";           			
	    		              pstm=con.prepareStatement(sql);					            	   
	    			            
	    			           
	    			            pstm.setString(1, name1);
	    			           pstm.setInt(2,clientno);
	    			            
	    			         
	    			            pstm.execute();
	                	 sql="INSERT INTO  users VALUES(?, ?)";
		                 
						  pstm=con.prepareStatement(sql);
						  pstm.setString(1, name1);
		                  pstm.setString(2,pass1);
		                  pstm.execute();
				            
				            sql="INSERT INTO  client VALUES(?, ?,?,?)";           			
			                pstm=con.prepareStatement(sql);					            	   
				            
				           
				            pstm.setInt(1,clientno);
				            pstm.setString(2,name1);
				            pstm.setString(3,sex);
				            pstm.setInt(4,0);
				            
				            
				            Zc.this.setVisible(false);
				            DL t1=new DL();
							t1.setVisible(true);
				            
					} catch (Exception e) {
						// TODO: handle exception
						
						f=1;
						JOptionPane.showMessageDialog(Zc.this, "已有顾客号或登录名，请更改！");
						
						
							
					} 
	                 
	                 
	                 if(f!=1)
				      JOptionPane.showMessageDialog(Zc.this, "注册成功！");
	                  
			            
			            
			            
			            
				
					// TODO Auto-generated catch block
					
	            	//JOptionPane.showMessageDialog(Zc.this, "已有登陆名，请更改！");
	            	
				     
									            	   
	           
	           
	            
	         
			}
		});
		btnNewButton.setBounds(400, 518, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setBounds(89, 84, 65, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(89, 157, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u4F60\u5E0C\u671B\u7684\u987E\u5BA2\u53F7");
		lblNewLabel_2.setBounds(52, 219, 151, 23);
		contentPane.add(lblNewLabel_2);
		
		name = new JTextField();
		name.setBounds(192, 85, 320, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(192, 154, 320, 21);
		contentPane.add(pass);
		pass.setColumns(10);
		
		no = new JTextField();
		no.setColumns(10);
		no.setBounds(192, 220, 320, 21);
		contentPane.add(no);
		
		JLabel lblNewLabel_3 = new JLabel("\u5C0A\u656C\u7684\u987E\u5BA2\uFF0C\u6B22\u8FCE\u6CE8\u518C");
		lblNewLabel_3.setFont(new Font("新宋体", Font.BOLD, 15));
		lblNewLabel_3.setBounds(192, 24, 362, 38);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton nan = new JRadioButton("\u7537");
		nan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sex="男";
			}
		});
		nan.setBounds(189, 292, 121, 23);
		contentPane.add(nan);
		
		JRadioButton nv = new JRadioButton("\u5973");
		nv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sex="女";
			}
		});
		nv.setBounds(400, 292, 121, 23);
		contentPane.add(nv);
		
		JLabel lblNewLabel_4 = new JLabel("\u6027\u522B");
		lblNewLabel_4.setBounds(66, 296, 54, 15);
		contentPane.add(lblNewLabel_4);
	}
}
