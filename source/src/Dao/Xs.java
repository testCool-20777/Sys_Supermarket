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
import mod.Theorder;
import mod.Warning;
import mod.Xstj;

public class Xs {
	
	Jdbc jdbc=new Jdbc();

       
    public int tj(int pno,int cno,int number,float rmb,String pdate) {
    	int t=0;
    	String sql="INSERT INTO theorder VALUES(?, ?, ?, ?,?)";
    	t=jdbc.updatePreparedStatement(sql, pno,cno,number,rmb,pdate);
		return t;
	}
     
    public int xgnumber(int a,int b) {
    	int t=0;
    	String sql="update warning set cnumber= ? where cno =?;";
    	t=jdbc.updatePreparedStatement(sql,a,b);
		return t;
	}

    
    
    
    
    public List<Warning> cxsl(int a) {
    	String sql="select * from warning where cno=?;";    	
    	
    	List<Warning> type= jdbc.queryPreparedStatement(sql, Warning.class, a);
		return type;
	}
    
    
    
       
    public List<Pay> cxdd(int a) {
    	String sql="select * from pay where pno=?;";    	
    	
    	List<Pay> type= jdbc.queryPreparedStatement(sql, Pay.class, a);
		return type;
	}
    public List<Pay> cxddall() {
    	String sql="select * from pay;";    	
    	
    	List<Pay> type= jdbc.queryPreparedStatement(sql, Pay.class);
		return type;
	}
    
    
    
    
    public List<Xstj> xstjall() {
    	String sql="select * from xstj;";
    	List jg=new ArrayList();
    	List<Xstj> type= jdbc.queryPreparedStatement(sql, Xstj.class, jg);
		return type;
	}
    
    public List<Xstj> xstjm() {
    	String sql="select  max(number)  from xstj;";
    	List jg=new ArrayList();
    	List<Xstj> type= jdbc.queryPreparedStatement(sql, Xstj.class, jg);
		return type;
	}
    public List<Xstj> xstj(String a) {
    	String sql="select * from xstj where pdate=?;";
    	
    	List<Xstj> type= jdbc.queryPreparedStatement(sql, Xstj.class, a);
		return type;
	}
    public List<Xstj>xstjmax() {
    	String sql="select  max(number)  from xstj;";
    	
    	List jg=new ArrayList();
    	List<Xstj> type= jdbc.getmax(sql,Xstj.class);
		return type;
	}
    
    public List<Theorder>xstjcno(int a) {
    	  String sql="select  cno   from theorder where number = ?";
    	
    	List<Theorder> type= jdbc.queryPreparedStatement(sql, Theorder.class, a);
		return type;
	}
    
}

