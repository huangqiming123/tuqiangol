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
	// ����������
	String driver="com.mysql.jdbc.Driver";
	public ArrayList<String> connect_tuqiang_sql(String host,int port,String db,String user,String passwd,String sql,String list){
		try{
			// ������������
			Class.forName(driver);
			// �������ݿ�
			java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"",user,passwd);
			if(!conn.isClosed()){
				System.out.println("Successed connecting to the Database!");
				// statement����ִ��SQL���
				java.sql.Statement statement=conn.createStatement();
				// �����
				ResultSet rs=statement.executeQuery(sql);
				ArrayList<String> sqlresult=new ArrayList<String>();
				while(rs.next()){
					// ѡ��list��������
					String data = rs.getString(list);
					// ����ʹ��ISO-8859-1�ַ�����name����Ϊ�ֽ����в�������洢�µ��ֽ������С�
		             // Ȼ��ʹ��GB2312�ַ�������ָ�����ֽ�����
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