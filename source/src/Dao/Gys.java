package Dao;
import java.util.ArrayList;
import java.util.List;
import sms123.Shop;

import jdbc123.Jdbc;
import mod.Buytype;
import mod.Employee;
import mod.Pay;
import mod.Shoptype;
import mod.Suplier;

public class Gys {
	
	Jdbc jdbc=new Jdbc();

    
    public int tjgys(int sno,String sname) {
        int t=0;
      	String	sql="INSERT INTO supplier VALUES(?, ?)"; 
    
  		t=jdbc.updatePreparedStatement(sql, sno,sname);
  		return t;
  	
  		
  	}
    

      
    public int sc(int sno) {
    	int t=0;
    	String sql="DELETE FROM supplier where sno=?";
    	t=jdbc.updatePreparedStatement(sql, sno);
		return t;
		
	}
    public int scall() {
    	int t=0;
    	String sql="DELETE FROM supplier;";
    	t=jdbc.updatePreparedStatement(sql);
		return t;
	}
    
    
    public int xgno(int a,int b) {
    	int t=0;
    	String sql="update supplier set sno= ? where sno =?;";
    	t=jdbc.updatePreparedStatement(sql,a,b);
		return t;
	}
    
    public int xgname(String a,int b) {
    	int t=0;
    	String sql="update supplier set sname= ? where sno =?;";
    	t=jdbc.updatePreparedStatement(sql,a,b);
		return t;
	}
    
    
    
    
    
    
    
    
    public List<Suplier> cxall() {
    	String sql="select * from supplier;";
    	List jg=new ArrayList();
    	List<Suplier> type= jdbc.queryPreparedStatement(sql, Suplier.class, jg);
		return type;
	}
    public List<Suplier> cx(int a) {
    	String sql="select * from supplier where sno=?;";
    	
    	List<Suplier> type= jdbc.queryPreparedStatement(sql, Suplier.class, a);
		return type;
	}
    
}

