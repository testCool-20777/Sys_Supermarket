package sms123;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.PasswordAuthentication;
import java.nio.file.attribute.AclEntry;
import java.awt.event.ActionEvent;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;  
import java.sql.Statement;  
import java.sql.SQLException;
import javax.swing.JPasswordField;
public class DL extends JFrame {

	private JPanel contentPane;
	private JTextField usersname;
	private JPasswordField pass1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	   
					DL frame = new DL();
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
	public DL() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u767B\u9646\u540D");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(137, 150, 104, 48);
		contentPane.add(lblNewLabel);
		
		usersname = new JTextField();
		usersname.setBounds(251, 158, 179, 37);
		contentPane.add(usersname);
		usersname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_1.setBounds(137, 253, 99, 37);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u767B\u9646");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"  
		                + "databaseName=AdventureWorks;integratedSecurity=true;";  
		        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=sms123;user=sa;password=123zxc";//以sa身份连接数据库:请根据自己的用户名和密码进行重新设置！！！！！！
		  
		        
		        Connection con = null;  
		        Statement stmt = null;  
		        ResultSet rs = null;  
				String name=usersname.getText();
				String pass=pass1.getText();
				String username2;
				String password2;
		        try{
		    		
			    	  
			    	    int rank=0;
			            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			            con = DriverManager.getConnection(url);  
			            
			            stmt=con.createStatement();
			            String sql="select * from users;";
			            rs=stmt.executeQuery(sql);
			            int flag=0;
			            while(rs.next())
			            {
			            	username2=rs.getString("name");
		            		password2=rs.getString("pass");
		            		if(name.equals(username2) 	&&pass.equals(password2))
		            		{
		            			
		            			
		            			flag=1;
		            			break;
		                     
		            		}
		            		
			            
			            }
			            if(flag==0)
			            {
			            	
			            	rs=stmt.executeQuery(sql);
			            	JOptionPane.showMessageDialog(DL.this, "用户名或者密码错误！");
			            }
			            else
			            {
			            	rs=null;
			            	sql="select rank from zcb where name= ? ";
		            		PreparedStatement pstm=con.prepareStatement(sql);
		            	    
		            		pstm.setString(1, name);
		            		rs=pstm.executeQuery();
		            		

		            		if(rs.next())
		            		{
		            		 rank=rs.getInt("rank");
		            		}
			            	DL.this.setVisible(false);
			            	
			            if(rank==1)
			            {
			            Gkview mainview = new Gkview(); 
			             mainview.setVisible(true);
			            }
			            else if(rank==2)
			            {
			            	GZRYVIEW view2 = new GZRYVIEW();
			            	view2.setVisible(true);
			            }
			            else
			            {
			            	GLYVIEW view3 = new GLYVIEW();
			            	view3.setVisible(true);
			            }
			            	
			            
			            
			            }
			             
			     
			      }catch (Exception e) {
			    	  
					// TODO: handle exception
				}
				
				
				
			    
				
			
			     
			      
	            
				
				
			}
		});
		btnNewButton.setBounds(148, 371, 93, 37);
		contentPane.add(btnNewButton);
		
		JButton zc = new JButton("\u6CE8\u518C");
		zc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Zc view=new Zc();
				view.setVisible(true);
				DL.this.setVisible(false);
				
			}
		});
		zc.setBounds(404, 371, 104, 37);
		contentPane.add(zc);
		
		JLabel lblNewLabel_2 = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u8D85\u5E02\u7BA1\u7406\u7CFB\u7EDFsms");
		lblNewLabel_2.setFont(new Font("新宋体", Font.BOLD, 30));
		lblNewLabel_2.setBounds(137, 34, 363, 102);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6CE8\u518C\u529F\u80FD\u4EC5\u9650\u987E\u5BA2\u4F7F\u7528\uFF0C\u5176\u4ED6\u4EBA\u5458\u8BF7\u8054\u7CFB\u7BA1\u7406\u5458\u5F00\u901A\u8D26\u6237");
		lblNewLabel_3.setBounds(224, 431, 545, 15);
		contentPane.add(lblNewLabel_3);
		
		pass1 = new JPasswordField();
		pass1.setBounds(251, 258, 179, 31);
		contentPane.add(pass1);
	}
}
