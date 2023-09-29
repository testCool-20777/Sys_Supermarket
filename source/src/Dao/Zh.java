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
import mod.Uers;
import mod.Zcb;
import mod.Zhdl;
public class Zh {
	
	Jdbc jdbc=new Jdbc();

       
    public int tjuser(String name,String pass) {
    	int t=0;
    	String sql="insert into users values(?,?);";
    	t=jdbc.updatePreparedStatement(sql, name,pass);
		return t;
	}
    
    public int tjzcb(String name,int no,int rank) {
    	int t=0;
    	String sql="insert into zcb values(?,?,?);";
    	t=jdbc.updatePreparedStatement(sql, name,no,rank);
		return t;
	}
    
    public int sc(String name) {
    	int t=0;
    	String sql="DELETE FROM users where name=?";
    	t=jdbc.updatePreparedStatement(sql, name);
		return t;
		
	}
    public int scall() {
    	int t=0;
    	String sql="DELETE FROM users;";
    	t=jdbc.updatePreparedStatement(sql);
		return t;
	}
    
    
    public int xgno(int a,String b) {
    	int t=0;
    	String sql="update zcb set no= ? where name =?;";
    	t=jdbc.updatePreparedStatement(sql,a,b);
		return t;
	}
    
    public int xgname(String a,String b) {
    	int t=0;
    	String sql="update users set name= ? where name =?;";
    	t=jdbc.updatePreparedStatement(sql,a,b);
        sql="update zcb set name= ? where name =?;";
    	int t1=jdbc.updatePreparedStatement(sql,a,b);
		return (t+t1);
	}
    public int xgpass(String a,String b) {
    	int t=0;
    	String sql="update users set pass= ? where name =?;";
    	t=jdbc.updatePreparedStatement(sql,a,b);
		return t;
	}

    public int xgrank(int a,String b) {
    	int t=0;
    	String sql="update zcb set rank= ? where name =?;";
    	t=jdbc.updatePreparedStatement(sql,a,b);
		return t;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<Zhdl> cxall() {
    	String sql="select * from dlzh;";
    	List jg=new ArrayList();
    	List<Zhdl> type= jdbc.queryPreparedStatement(sql, Zhdl.class, jg);
		return type;
	}
    public List<Zhdl> cx(String a) {
    	String sql="select * from dlzh where name=?;";
    	
    	List<Zhdl> type= jdbc.queryPreparedStatement(sql, Zhdl.class, a);
		return type;
	}

    
}

