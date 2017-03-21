package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.StringProcess;
import model.bean.LienHe;


public class LienHeDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=SE12";
	String userName = "sa";
	String password = "12345678-";
	Connection connection;
	
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
	
	public ArrayList<LienHe> getListLienHe() {
		connect();
		String sql=	"SELECT lh.MaLienHe, lh.TieuDe, lh.NoiDung, convert(varchar(10),lh.NgayGui,103) as ngaygui,"
				+ "lh.SDT, lh.Email, vd.TenVanDe FROM LienHe lh INNER JOIN VanDe AS vd ON lh.MaVanDe = vd.MaVanDe";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<LienHe> list = new ArrayList<LienHe>();
		LienHe lienHe;
		try {
			while(rs.next()){
				lienHe = new LienHe();
				lienHe.setMaLienHe(rs.getInt("MaLienHe"));
				lienHe.setTieuDe(rs.getString("TieuDe"));
				lienHe.setNoiDung(rs.getString("NoiDung"));
				lienHe.setNgayGui(rs.getString("ngaygui"));
				lienHe.setSDT(rs.getString("SDT"));
				lienHe.setEmail(rs.getString("Email"));
				lienHe.setTenVanDe(rs.getString("TenVanDe"));
				list.add(lienHe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<LienHe> getListLienHe(String maVanDe) {
		connect();
		String sql=	String.format("SELECT lh.MaLienHe, lh.TieuDe, lh.NoiDung, convert(varchar(10),lh.NgayGui,103) as ngaygui,"
				+ "lh.SDT, lh.Email, vd.TenVanDe FROM LienHe lh INNER JOIN VanDe AS vd ON lh.MaVanDe = vd.MaVanDe"+
					" WHERE lh.MaVanDe = '%s'", maVanDe);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<LienHe> list = new ArrayList<LienHe>();
		LienHe lienHe;
		try {
			while(rs.next()){
				lienHe = new LienHe();
				lienHe.setMaLienHe(rs.getInt("MaLienHe"));
				lienHe.setTieuDe(rs.getString("TieuDe"));
				lienHe.setNoiDung(rs.getString("NoiDung"));
				lienHe.setNgayGui(rs.getString("ngaygui"));
				lienHe.setSDT(rs.getString("SDT"));
				lienHe.setEmail(rs.getString("Email"));
				lienHe.setTenVanDe(rs.getString("TenVanDe"));
				list.add(lienHe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<LienHe> timLienHe1(String tim,String maVanDe) {
		connect();
		String sql=	"SELECT lh.MaLienHe, lh.TieuDe, lh.NoiDung, convert(varchar(10),lh.NgayGui,103) as ngaygui,"
				+ "lh.SDT, lh.Email, vd.TenVanDe FROM LienHe lh INNER JOIN VanDe AS vd ON lh.MaVanDe = vd.MaVanDe"+
				" WHERE lh.TieuDe like N'%"+tim+"%' and vd.MaVanDe like N'%"+maVanDe+"'";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<LienHe> list = new ArrayList<LienHe>();
		LienHe lienHe;
		try {
			while(rs.next()){
				lienHe = new LienHe();
				lienHe.setMaLienHe(rs.getInt("MaLienHe"));
				lienHe.setTieuDe(rs.getString("TieuDe"));
				lienHe.setNoiDung(rs.getString("NoiDung"));
				lienHe.setNgayGui(rs.getString("ngaygui"));
				lienHe.setSDT(rs.getString("SDT"));
				lienHe.setEmail(rs.getString("Email"));
				lienHe.setTenVanDe(rs.getString("TenVanDe"));
				list.add(lienHe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<LienHe> timLienHe2(String tim) {
		connect();
		String sql=	"SELECT lh.MaLienHe, lh.TieuDe, lh.NoiDung, convert(varchar(10),lh.NgayGui,103) as ngaygui,"
				+ "lh.SDT, lh.Email, vd.TenVanDe FROM LienHe lh INNER JOIN VanDe AS vd ON lh.MaVanDe = vd.MaVanDe"+
				" WHERE lh.TieuDe like N'%"+tim+"%'";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<LienHe> list = new ArrayList<LienHe>();
		LienHe lienHe;
		try {
			while(rs.next()){
				lienHe = new LienHe();
				lienHe.setMaLienHe(rs.getInt("MaLienHe"));
				lienHe.setTieuDe(rs.getString("TieuDe"));
				lienHe.setNoiDung(rs.getString("NoiDung"));
				lienHe.setNgayGui(rs.getString("ngaygui"));
				lienHe.setSDT(rs.getString("SDT"));
				lienHe.setEmail(rs.getString("Email"));
				lienHe.setTenVanDe(rs.getString("TenVanDe"));
				list.add(lienHe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void themLienHe(String tieuDe, String noiDung, String ngayGui, String soDT, String email, int maVanDe) {
		connect();
		String sql=	String.format("INSERT INTO LienHe(TieuDe,NoiDung,NgayGui,SDT,Email,MaVanDe) "+
					" VALUES ( N'%s',N'%s','%s','%s','%s','%s' )", tieuDe, noiDung, new Date(StringProcess.getNgayDangDate().getTime()), soDT, email, maVanDe);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public LienHe getThongTinLienHe(int maLienHe) {
		connect();
		String sql=	String.format("SELECT TieuDe, NoiDung, NgayGui, SDT, Email, MaVanDe, MaLienHe "+
					" FROM LienHe WHERE MaLienHe = '%s'", maLienHe);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		LienHe lienHe = new LienHe();
		try {
			while(rs.next()){
				lienHe.setMaLienHe(rs.getInt("MaLienHe"));
				lienHe.setTieuDe(rs.getString("TieuDe"));
				lienHe.setNoiDung(rs.getString("NoiDung"));
				lienHe.setNgayGui(rs.getString("NgayGui"));
				lienHe.setSDT(rs.getString("SDT"));
				lienHe.setEmail(rs.getString("Email"));
				lienHe.setMaVanDe(rs.getInt("MaVanDe"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lienHe;
	}

	public  void xoaLienHe(int maLienHe) {
		connect();
		String sql=	String.format("DELETE FROM LienHe WHERE MaLienHe = '%s'", maLienHe);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
