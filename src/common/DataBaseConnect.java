package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnect {
	
	static Connection conn=null;
	
	static String url="jdbc:sqlserver://localhost:1433;databaseName=SE12";
	static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String user="sa";
	static String pass="12345678";
	
	/**
	 * tao ket noi den database
	 * @return
	 */
	public static Connection getConnect(){
		try {
			Class.forName(driver);
			
			conn=DriverManager.getConnection(url,user,pass);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
