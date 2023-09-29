package Dao;

import java.util.ArrayList;
import java.util.List;
import sms123.Shop;

import jdbc123.Jdbc;
import mod.Buytype;
import mod.Employee;
import mod.Pay;
import mod.Shoptype;

public class dao {
	
	Jdbc jdbc=new Jdbc();
    public int insert(int cno,String cname,String cdate,String ckeep) {
      int t=0;
    	String	sql="INSERT INTO commodity(cno, cname, cdata, ckeep) VALUES(?, ?, ?, ?)";
  
		t=jdbc.updatePreparedStatement(sql, cno,cname,cdate,ckeep);
		return t;
	
		
	}
    
    public int tjgys(int sno,int cno,String indate,String sname,float price,int number) {
        int t=0;
      	String	sql="INSERT INTO supply VALUES(?, ?, ?, ?, ?, ?)"; 
    
  		t=jdbc.updatePreparedStatement(sql, sno,cno,indate,sname,price,number);
  		return t;
  	
  		
  	}
    public List<Shoptype> cxsd() {
    	String sql="select * from shop;";
    	List jg=new ArrayList();
    	List<Shoptype> type= jdbc.queryPreparedStatement(sql, Shoptype.class, jg);
		return type;
	}
    
    public List<Buytype> cxddall(int a) {
    	String sql="select * from buy;";   	
    	List<Buytype> type= jdbc.queryPreparedStatement(sql, Buytype.class, a);
		return type;
	}
    public List<Pay> cxdd(int pno) {
    	String sql="select * from buy where pno=?;";
    	
    	List<Pay> type= jdbc.queryPreparedStatement(sql, Pay.class, pno);
		return type;
	}
    
    
    
    public int tjyg(int eno,String ename,String esex,int wage,int rmb) {
    	int t=0;
    	String sql="insert into employee values(?,?,?,?,2,?);";
    	t=jdbc.updatePreparedStatement(sql, eno,ename,esex,wage,rmb);
		return t;
	}
    public int scyg(int eno) {
    	int t=0;
    	String sql="DELETE FROM employee where eno=?";
    	t=jdbc.updatePreparedStatement(sql, eno);
		return t;
		
	}
    public int scygall() {
    	int t=0;
    	String sql="DELETE FROM employee;";
    	t=jdbc.updatePreparedStatement(sql);
		return t;
	}
    
    
    public int xgygno(int a,int b) {
    	int t=0;
    	String sql="update employee set eno= ? where eno =?;";
    	t=jdbc.updatePreparedStatement(sql,a,b);
		return t;
	}
    
    public int xgygname(String a,int b) {
    	int t=0;
    	String sql="update employee set ename= ? where eno =?;";
    	t=jdbc.updatePreparedStatement(sql,a,b);
		return t;
	}
    public int xgygsex(String a,int b) {
    	int t=0;
    	String sql="update employee set esex= ? where eno =?;";
    	t=jdbc.updatePreparedStatement(sql,a,b);
		return t;
	}
    public int xgygage(int a,int b) {
    	int t=0;
    	String sql="update employee set wage= ? where eno =?;";
    	t=jdbc.updatePreparedStatement(sql,a,b);
		return t;
	}
    public int xgyggz(int a,int b) {
    	int t=0;
    	String sql="update employee set number= ? where eno =?;";
    	t=jdbc.updatePreparedStatement(sql,a,b);
		return t;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<Employee> cxygall() {
    	String sql="select * from employee;";
    	List jg=new ArrayList();
    	List<Employee> type= jdbc.queryPreparedStatement(sql, Employee.class, jg);
		return type;
	}
    public List<Employee> cxyg(int a) {
    	String sql="select * from employee where eno=?;";
    	
    	List<Employee> type= jdbc.queryPreparedStatement(sql, Employee.class, a);
		return type;
	}
    
}

