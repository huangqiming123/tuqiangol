package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class connectMySql {
	  public List<String> connectMySqlM(String sql,String listValue) throws SQLException {
		  //String[] arr=null;
		  Driver driver = new com.mysql.jdbc.Driver();
		  Properties info=new Properties();
		  info.put("user", "tuqiang_query");
		  info.put("password", "tuqiang_query");
		  String url="jdbc:mysql://120.24.75.214/tracker-web";
		  Connection connect= driver.connect(url, info);
	      Statement stmt = connect.createStatement();
	      ResultSet rs = stmt.executeQuery("select"+"\t"+listValue+"\t"+sql);
	      List<String> list1=new ArrayList<String>();
	      //List<String> split=new ArrayList<String>();
	      if(listValue.contains(",")){
	    	  String []split=listValue.split(",");
	    	  while (rs.next()) {
	    	  for(int j=1;j<=split.length;j++){
	    	  //System.out.println(rs.getString(j));
		
	    	  list1.add(rs.getString(j));
	      }
	    	  }
	      /*
	      if(list1!=null&& list1.size()>=0){
	    	  String[] arr1=new String[list1.size()];
	
	    	  for(int i=0;i<list1.size();i++){
	    		  arr1[i]=list1.get(i);
	    	  }
	    	  arr=arr1;
	    	  System.out.println(list1);
	      }
	      */
	      //return arr;
	      //System.out.println(list1);
	      return list1;
	    	}else{
	    		
		    	  while (rs.next()) {
		    	  
		    	  System.out.println(rs.getString(1));
			
		    	  list1.add(rs.getString(1));
		      
		    	  }
		    	  return list1;
	    		
	    	}
	  }
	  public static void main(String[] args) throws SQLException{
	  	connectMySql conn=new connectMySql();
	  	String listValue="u.type,u.phone,u.parentId,u.nickName"; 
		String sql="FROM `user_info` AS u where account='jimitest'";
	  	conn.connectMySqlM(sql, listValue);
	  	}
	   }

