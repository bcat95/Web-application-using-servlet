package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.bean.VanDe;

public class VanDeDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=SE12";
	String userName = "sa";
	String password = "12345678";
	Connection connection;
	
	/**
	 * Ham ket noi SQL
	 */
	void connect(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Ket noi thanh cong");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		}
	}
	
	/**
	 * Ham lay danh sach Van de
	 * @return
	 */
	public ArrayList<VanDe> getListVanDe() {
		connect();
		String sql=	"SELECT MaVanDe, TenVanDe FROM VanDe";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<VanDe> list = new ArrayList<VanDe>();
		VanDe vanDe;
		try {
			while(rs.next()){
				vanDe = new VanDe();
				vanDe.setMaVanDe(rs.getInt("MaVanDe"));
				vanDe.setTenVanDe(rs.getString("TenVanDe"));
				list.add(vanDe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Ham lay thong tin chi tiet cua Van De
	 * @param maVanDe
	 * @return
	 */
	public VanDe getThongTinVanDe(int maVanDe) {
		connect();
		String sql=	String.format("SELECT MaVanDe, TenVanDe "+
					" FROM VanDe WHERE MaVanDe = '%s'", maVanDe);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		VanDe vanDe = new VanDe();
		try {
			while(rs.next()){
				vanDe.setMaVanDe(rs.getInt("MaVanDe"));
				vanDe.setTenVanDe(rs.getString("TenVanDe"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vanDe;
	}
}
