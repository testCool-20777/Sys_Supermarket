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
import mod.Supply;
import mod.Theorder;
import mod.Uers;
import mod.Warning;
import mod.Zcb;
import mod.Zhdl;
public class Jh {
	
	Jdbc jdbc=new Jdbc();
    public List<Supply> cxjg(int a) {
    	String sql="select  *  from supply where cno = ?;";
    	
    	List<Supply> type= jdbc.queryPreparedStatement(sql, Supply.class, a);
		return type;
	}
    
    
    
    
    
    public List<Supply> cxsp(int a) {
    	String sql="select  *  from supply where sno = ?";
    	
    	List<Supply> type= jdbc.queryPreparedStatement(sql, Supply.class, a);
		return type;
	}
  
    
    public List<Supply> cxall() {
    	String sql="select  *  from supply";
    	
    	List<Supply> type= jdbc.queryPreparedStatement(sql, Supply.class);
		return type;
	}

    public List<Warning> cxkc(int a) {
    	String sql="select  *  from warning where cno = ?";
    	
    	List<Warning> type= jdbc.queryPreparedStatement(sql, Warning.class, a);
		return type;
	}
    public List<Warning> cxkcall() {
    	String sql="select  *  from warning";
    	
    	List<Warning> type= jdbc.queryPreparedStatement(sql, Warning.class);
		return type;
	}
    
    
    public List<Theorder> cxqk(int a) {
    	String sql="select  *  from theorder where cno = ?";
    	
    	List<Theorder> type= jdbc.queryPreparedStatement(sql, Theorder.class, a);
		return type;
	}
    
}

