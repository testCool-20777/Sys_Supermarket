package Dao;

import java.util.ArrayList;
import java.util.List;
import sms123.Shop;

import jdbc123.Jdbc;
import mod.Buytype;
import mod.Employee;
import mod.Member;
import mod.Pay;
import mod.Shoptype;

public class Hy {
	
	Jdbc jdbc=new Jdbc();

       
    public int tj(int no,String name,String sex,int age,String phone,int no1) {
    	int t=0;
    	String sql="insert into member values(?,?,?,?,?,?);";
    	t=jdbc.updatePreparedStatement(sql, no,name,sex,age,phone,no1);
		return t;
	}
    
    public int sc(int no) {
    	int t=0;
    	String sql="DELETE FROM member where mno=?";
    	t=jdbc.updatePreparedStatement(sql, no);
		return t;
		
	}
    public int scall() {
    	int t=0;
    	String sql="DELETE FROM member;";
    	t=jdbc.updatePreparedStatement(sql);
		return t;
	}
    
    
    public int xgno(int a,int b) {
    	int t=0;
    	String sql="update member set mno= ? where mno =?;";
    	t=jdbc.updatePreparedStatement(sql,a,b);
		return t;
	}
    
    public int xgname(String a,int b) {
    	int t=0;
    	String sql="update member set mname= ? where mno =?;";
    	t=jdbc.updatePreparedStatement(sql,a,b);
		return t;
	}
    public int xgsex(String a,int b) {
    	int t=0;
    	String sql="update member set msex= ? where mno =?;";
    	t=jdbc.updatePreparedStatement(sql,a,b);
		return t;
	}
    public int xgage(int a,int b) {
    	int t=0;
    	String sql="update member set mage= ? where mno =?;";
    	t=jdbc.updatePreparedStatement(sql,a,b);
		return t;
	}
    public int xgphone(String a,int b) {
    	int t=0;
    	String sql="update member set mphone= ? where mno =?;";
    	t=jdbc.updatePreparedStatement(sql,a,b);
		return t;
	}
    
    public int xgno1(int a,int b) {
    	int t=0;
    	String sql="update member set clientno= ? where mno =?;";
    	t=jdbc.updatePreparedStatement(sql,a,b);
		return t;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<Member> cxall() {
    	String sql="select * from member;";
    	List jg=new ArrayList();
    	List<Member> type= jdbc.queryPreparedStatement(sql, Member.class, jg);
		return type;
	}
    public List<Member> cx(int a) {
    	String sql="select * from member where mno=?;";
    	
    	List<Member> type= jdbc.queryPreparedStatement(sql, Member.class, a);
		return type;
	}
    
}

