package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.DataBaseConnect;
import model.bean.LoaiTaiKhoanBean;

public class LoaiTaiKhoanDAO extends DataBaseConnect{
	private static Statement st=null;
	private static ResultSet rs=null;
	public  ArrayList<LoaiTaiKhoanBean> getListLoaiTaiKhoan() {
		ArrayList<LoaiTaiKhoanBean> list = new ArrayList<LoaiTaiKhoanBean>();
		LoaiTaiKhoanBean loaiTaiKhoanBean;
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("SELECT maloaitk, tenloaitk FROM loaitaikhoan");
			while (rs.next()) {
				loaiTaiKhoanBean = new LoaiTaiKhoanBean();
				loaiTaiKhoanBean.setMaLoaiTaiKhoan(rs.getInt("MaLoaiTK"));
				loaiTaiKhoanBean.setTenLoaiTaiKhoan(rs.getString("TenLoaiTK"));
				list.add(loaiTaiKhoanBean);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				getConnect().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}
	
}
