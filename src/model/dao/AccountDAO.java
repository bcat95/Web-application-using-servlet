package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.DataBaseConnect;
import model.bean.Account;


public class AccountDAO extends DataBaseConnect{
	private Statement st=null;
	
	public boolean checkLogin(String tenDangNhap, String matKhau) {
		String sql=	String.format("SELECT HoTen FROM TaiKhoan WHERE Username = '%s' AND pass = '%s'", tenDangNhap, matKhau);
		ResultSet rs = null;
		try {
			st=getConnect().createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void themAccount(String tenDangNhap, String matKhau) {
		String sql=	String.format("INSERT INTO TaiKhoan(Username, pass) "+
					" VALUES ( '%s','%s' )", tenDangNhap, matKhau);
		try {
			st=getConnect().createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Account selectOne(String username) {
		String sql=	"SELECT Username, pass from TaiKhoan where Username = '"+username+"'";
		ResultSet resultSet = null;
		Account item = null;
		try {
			st=getConnect().createStatement();
			resultSet = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(resultSet.next())
			{
				item  = new Account (resultSet.getString("Username"), 
						resultSet.getString("pass"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return item;
	}
}
