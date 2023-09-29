package jdbc123;



import mod.Xstj;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
@SuppressWarnings("all")
public class Jdbc {
	
	private Connection conn=null;
	private PreparedStatement pstm=null;
	private ResultSet rs=null;
	private  String connectionUrl = "jdbc:sqlserver://localhost:1433;"  
            + "databaseName=AdventureWorks;integratedSecurity=true;";  
	private    String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=sms123;user=sa;password=123zxc";
	private int t=0;
	static{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}
	
	public Connection getConn(){
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public Connection getCon(String t){
		try {
			conn = DriverManager.getConnection(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//澧炲垹鏀�
	public int updatePreparedStatement(String sql,List<Object> params){
		getConn();
		int t=0;
		try {
			pstm = conn.prepareStatement(sql);
			
			if(params!=null){
				for(int i=0;i<params.size();i++){
					pstm.setObject(i+1, params.get(i));
				}
			}
			
			pstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			t=1;
			e.printStackTrace();
		}
		return t;
		
	}

	public int updatePreparedStatement(String sql,Object... params){
		getConn();
		int t=0;
		try {
			pstm = conn.prepareStatement(sql);
			
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstm.setObject(i+1, params[i]);
				}
			}
			
			pstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			t=1;
			e.printStackTrace();
		}
		return t;
	}
	//鏌ヨ
	
	public <T> List<T> getmax(String sql,Class<T> clazz){
		getConn();
		List<T> result = new ArrayList<T>();
		try {
			pstm = conn.prepareStatement(sql);
			
			
			
			rs = pstm.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			//鑾峰彇鍒楃殑鏁伴噺
			int count = rsmd.getColumnCount();
			//瀛樺偍鎵�鏈夊垪鐨勫悕瀛�
			List<String> column = new ArrayList<String>();
			for(int i=0;i<count;i++){
				column.add(rsmd.getColumnName(i+1));
			}
			int t=0;
			while(rs.next()){
				//鍒涘缓瀵硅薄
			
				T obj = clazz.newInstance();
				
				for(int i=0;i<count;i++){
					String name = column.get(i).toLowerCase();
					
					//鏍规嵁鍒楁槑鑾峰彇灞炴��
					Field f = clazz.getDeclaredField(name);
					f.setAccessible(true);
					//鑾峰彇灞炴�х殑绫诲瀷
					String type = f.getType().getName();
					if("int".equals(type) || "java.lang.Integer".equals(type)){
						int val = rs.getInt(name);
						f.set(obj, val);
					}else if("double".equals(type) || "java.lang.Double".equals(type)){
						double val = rs.getDouble(name);
						f.set(obj, val);
					}else if("float".equals(type) || "java.lang.Float".equals(type)){
						float val = rs.getFloat(name);
						f.set(obj, val);
					}else if("java.lang.String".equals(type)){
						String val = rs.getString(name);
						f.set(obj, val);
					}else if("java.util.Date".equals(type)){
						Date val = rs.getDate(name);
						f.set(obj, val);
					}else if("boolean".equals(type) || "java.lang.Boolean".equals(type)){
						boolean val = rs.getBoolean(name);
						f.set(obj, val);
					}
					
				}
				
				result.add(obj);
				
				
			}
			
		} catch (Exception e) {
			System.out.println("不能输入空值");			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}	
	

	public <T> List<T> queryPreparedStatement(String sql,Class<T> clazz,List<Object> params){
		getConn();
		List<T> result = new ArrayList<T>();
		try {
			pstm = conn.prepareStatement(sql);
			
			if(params!=null){
				for(int i=0;i<params.size();i++){
					pstm.setObject(i+1, params.get(i));
				}
			}
			
			rs = pstm.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			//鑾峰彇鍒楃殑鏁伴噺
			int count = rsmd.getColumnCount();
			//瀛樺偍鎵�鏈夊垪鐨勫悕瀛�
			List<String> column = new ArrayList<String>();
			for(int i=0;i<count;i++){
				column.add(rsmd.getColumnName(i+1));
			}
			
			while(rs.next()){
				//鍒涘缓瀵硅薄
				T obj = clazz.newInstance();
				
				for(int i=0;i<count;i++){
					String name = column.get(i).toLowerCase();
					
					//鏍规嵁鍒楁槑鑾峰彇灞炴��
					Field f = clazz.getDeclaredField(name);
					f.setAccessible(true);
					//鑾峰彇灞炴�х殑绫诲瀷
					String type = f.getType().getName();
					if("int".equals(type) || "java.lang.Integer".equals(type)){
						int val = rs.getInt(name);
						f.set(obj, val);
					}else if("double".equals(type) || "java.lang.Double".equals(type)){
						double val = rs.getDouble(name);
						f.set(obj, val);
					}else if("float".equals(type) || "java.lang.Float".equals(type)){
						float val = rs.getFloat(name);
						f.set(obj, val);
					}else if("java.lang.String".equals(type)){
						String val = rs.getString(name);
						f.set(obj, val);
					}else if("java.util.Date".equals(type)){
						Date val = rs.getDate(name);
						f.set(obj, val);
					}else if("boolean".equals(type) || "java.lang.Boolean".equals(type)){
						boolean val = rs.getBoolean(name);
						f.set(obj, val);
					}
					
				}
				
				result.add(obj);
				
				
			}
			
		} catch (Exception e) {
			System.out.println("不能输入空值");			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public <T> List<T> queryPreparedStatement(String sql,Class<T> clazz,Object...params){
		getConn();
		List<T> result = new ArrayList<T>();
		try {
			pstm = conn.prepareStatement(sql);
			
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstm.setObject(i+1, params[i]);
				}
			}
			
			rs = pstm.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			//鑾峰彇鍒楃殑鏁伴噺
			int count = rsmd.getColumnCount();
			//瀛樺偍鎵�鏈夊垪鐨勫悕瀛�
			List<String> column = new ArrayList<String>();
			for(int i=0;i<count;i++){
				column.add(rsmd.getColumnName(i+1));
			}
			
			while(rs.next()){
				//鍒涘缓瀵硅薄
				T obj = clazz.newInstance();
				
				for(int i=0;i<count;i++){
					String name = column.get(i).toLowerCase();
					
					//鏍规嵁鍒楁槑鑾峰彇灞炴��
					Field f = clazz.getDeclaredField(name);
					f.setAccessible(true);
					//鑾峰彇灞炴�х殑绫诲瀷
					String type = f.getType().getName();
					if("int".equals(type) || "java.lang.Integer".equals(type)){
						int val = rs.getInt(name);
						f.set(obj, val);
					}else if("double".equals(type) || "java.lang.Double".equals(type)){
						double val = rs.getDouble(name);
						f.set(obj, val);
					}else if("float".equals(type) || "java.lang.Float".equals(type)){
						float val = rs.getFloat(name);
						f.set(obj, val);
					}else if("java.lang.String".equals(type)){
						String val = rs.getString(name);
						f.set(obj, val);
					}else if("java.util.Date".equals(type)){
						Date val = rs.getDate(name);
						f.set(obj, val);
					}else if("boolean".equals(type) || "java.lang.Boolean".equals(type)){
						boolean val = rs.getBoolean(name);
						f.set(obj, val);
					}
					
				}
				
				result.add(obj);
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("no");
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public void close(){
		try {
			if(pstm!=null){
				pstm.close();
			}
			if(conn!=null){
				conn.close();
			}
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
