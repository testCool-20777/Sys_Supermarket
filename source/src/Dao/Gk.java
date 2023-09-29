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
import mod.Uers;
import mod.Zcb;
import mod.Zhdl;
public class Gk {
	
	Jdbc jdbc=new Jdbc();
    public List<Pay> cxall(int a) {
    	String sql="select * from pay where clientno=?;";    	
    	
    	List<Pay> type= jdbc.queryPreparedStatement(sql, Pay.class, a);
		return type;
	}
    public List<Theorder> cx(int a) {
    	String sql="select * from theorder where pno=?;";
    	
    	
    	List<Theorder> type= jdbc.queryPreparedStatement(sql, Theorder.class, a);
    	return type;
	}

    
}

