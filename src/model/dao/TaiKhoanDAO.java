package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.TaiKhoanBean;

public class TaiKhoanDAO {
	private ArrayList<TaiKhoanBean> arrTaiKhoan;

	/**
	 * get all list thanh vien create by 
	 * 
	 * @return list thanh vien
	 * @throws SQLException
	 */

	public ArrayList<TaiKhoanBean> danhSachTaiKhoan() throws SQLException {
		arrTaiKhoan = new ArrayList<>();
		Connection conn = common.DataBaseConnect.getConnect();
		String query = "Select * from TaiKhoan";
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(query);
		while (rs.next()) {
//			String maTaiKhoan = rs.getString("MaTaiKhoan");
			String email = rs.getString("Email");
			String hoTen = rs.getString("HoTen");
			String matKhau = rs.getString("MatKhau");
//			String diaChi = rs.getString("DiaChi");
//			String soDienThoai = rs.getString("SoDienThoai");
//			int trangThai = rs.getInt("TrangThai");
//			String ghiChu = rs.getString("GhiChu");
			
//			TaiKhoanBean itemTaiKhoanBean = new TaiKhoanBean(maTaiKhoan, email, hoTen, matKhau, diaChi, soDienThoai, ghiChu, trangThai);
//			arrTaiKhoan.add(itemTaiKhoanBean);
		}
		System.out.println(arrTaiKhoan.size()+"");
		return arrTaiKhoan;
	}
	
	/**
	 * lay thong tin cua 1 user
	 * @param userName
	 */
	public TaiKhoanBean getThongTinTaiKhoan(String userName) {
		Connection conn = common.DataBaseConnect.getConnect();
		TaiKhoanBean taiKhoanBean=null;
		String sql=	String.format("select * from taikhoan where Username= '%s'", userName);
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()){
				String user= rs.getString("Username");
				String pass= rs.getString("Pass");
				String mail= rs.getString("Email");
				/*taiKhoanBean.setUserName(rs.getString("Username"));
				taiKhoanBean.setPassWord(rs.getString("Pass"));
				taiKhoanBean.seteMail(rs.getString("Email"));
				taiKhoan.add(taiKhoanBean);*/
				taiKhoanBean= new TaiKhoanBean(user, pass, mail);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taiKhoanBean;
	}
	
	/**
	 * Cap nhat thong tin tai khoan
	 * @param userName
	 * @param passWord
	 * @param eMail
	 */
	public void capNhatThongTinTaiKhoan(String userName, String passWord) {
		Connection conn = common.DataBaseConnect.getConnect();
		String sql=	String.format("update TaiKhoan set Pass= '%s' where Username='%s'",passWord, userName);
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
