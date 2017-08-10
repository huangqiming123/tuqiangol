package model;

//import java.io.UnsupportedEncodingException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.mysql.*;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;

public class connect_sql {
	// 驱动程序名
	String driver="com.mysql.jdbc.Driver";
	public ArrayList<String> connect_tuqiang_sql(String host,int port,String db,String user,String passwd,String sql,String list){
		try{
			// 加载驱动程序
			Class.forName(driver);
			// 连续数据库
			java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"",user,passwd);
			if(!conn.isClosed()){
				System.out.println("Successed connecting to the Database!");
				// statement用来执行SQL语句
				java.sql.Statement statement=conn.createStatement();
				// 结果集
				ResultSet rs=statement.executeQuery(sql);
				ArrayList<String> sqlresult=new ArrayList<String>();
				while(rs.next()){
					// 选择list这列数据
					String data = rs.getString(list);
					// 首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中。
		             // 然后使用GB2312字符集解码指定的字节数组
					data = new String(data.getBytes("ISO-8859-1"),"GB2312");
					sqlresult.add(data);
					}
				rs.close();
				conn.close();
				return sqlresult;
			}
		}catch(ClassNotFoundException e){
			System.out.println("Sorry,can`t find the Driver!"); 
            e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public static void main (String[] args){
		connect_sql conn=new connect_sql();
		String host="120.24.75.214";
		int port=3306;
		String db="tracker-web";
		String user="tuqiang_query";
		String passwd="tuqiang_query";
		String sql="select * from user_info as ui where ui.account='jimitest'";
		String list="userid";
		conn.connect_tuqiang_sql(host, port, db, user, passwd, sql, list);
	}

}