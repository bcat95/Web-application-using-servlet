package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.DataBaseConnect;
import model.bean.LoaiTaiKhoanBean;

/**
 * LoaiTaiKhoanDAO
 *
 * Version 1.0
 *
 * Date: 14-3-2017
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 14-3-2017         Vannasone            Create
 */
public class LoaiTaiKhoanDAO extends DataBaseConnect{
	private static Statement st=null;
	private static ResultSet rs=null;
	
	/**
	 * Ham lay danh sach loai tai khoan
	 * @return
	 */
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
