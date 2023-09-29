package Dao;

import java.util.ArrayList;
import java.util.List;
import sms123.Shop;

import jdbc123.Jdbc;
import mod.Buytype;
import mod.Employee;
import mod.Kctx;
import mod.Member;
import mod.Pay;
import mod.Shoptype;
import mod.Spxx;
import mod.Warning;

public class Kc {
	
	Jdbc jdbc=new Jdbc();

       
    public int tjsp(int cno,String cname,String cdate,String ckeep,int number) {
    	int t=0;
    	String sql="insert into commodity values(?,?,?,?);";
    	t=jdbc.updatePreparedStatement(sql, cno,cname,cdate,ckeep);
    	sql="insert into warning values(?,?,10,2022);";
    	int t1=jdbc.updatePreparedStatement(sql, cno,number);
		return t;
	}
    
    public int tjkc(int sno,int cno,String indate,String sname,float price,int number) {
    	int t=0;
    	String sql="INSERT INTO supply VALUES(?, ?, ?, ?, ?, ?)";
    	t=jdbc.updatePreparedStatement(sql, sno,cno,indate,sname,price,number);
		return t;
	}
    
    
    
    
    
    public int sc(int no) {
    	int t=0;
    	String sql="DELETE FROM commodity where cno=?";       
    	t=jdbc.updatePreparedStatement(sql, no);
    	sql="delete from supply where cno= ?";
    	int t1=jdbc.updatePreparedStatement(sql, no);
    	sql="delete from warning where cnp=?";
    	int t2=jdbc.updatePreparedStatement(sql,no);
		return (t+t1);
		
	}
    public int scall() {
    	int t=0;
    	String sql="DELETE FROM commodity;";
    	t=jdbc.updatePreparedStatement(sql);
    	sql="delete from supply";
    	int t1=jdbc.updatePreparedStatement(sql);
    	sql="delete from warning";
    	int t2=jdbc.updatePreparedStatement(sql);
    	t=t+t1+t2;
		return t;
	}
    
    
    public int xgprice(float a,float b,int c) {
    	int t=0;
    	String sql="update price set sellprice= ? where cno =?;";
    	t=jdbc.updatePreparedStatement(sql,a,c);
        sql="update price set memberprice= ? where cno =?;";
    	int t1=jdbc.updatePreparedStatement(sql, b,c);
		return (t+t1);
	}

    public int xgyj(int a,int b,int c) {
    	int t=0;
    	String sql="update warning set cwarn= ? where cno =?;";
    	t=jdbc.updatePreparedStatement(sql,a,c);
    	sql="update warning set kwarn= ? where cno =?;";
    	int t1=jdbc.updatePreparedStatement(sql,b,c);
        
		return (t+t1);
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<Spxx> cxspall() {
    	String sql="select * from spxx;";
    	List jg=new ArrayList();
    	List<Spxx> type= jdbc.queryPreparedStatement(sql, Spxx.class, jg);
		return type;
	}
    
    public List<Spxx> cxsp(int a) {
    	String sql="select * from spxx where cno=?;";
    	
    	List<Spxx> type= jdbc.queryPreparedStatement(sql, Spxx.class,a);
		return type;
	}
    public List<Kctx> cxyj() {
    	String sql="select * from kctx;";
    	
    	List<Kctx> type= jdbc.queryPreparedStatement(sql, Kctx.class);
		return type;
	}
    
    public List<Warning> cxyh(int a) {
    	String sql="select * from warning where kwarn<= ?;";
    	
    	List<Warning> type= jdbc.queryPreparedStatement(sql,Warning.class,a);
		return type;
	}
    
}

