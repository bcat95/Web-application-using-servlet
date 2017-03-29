package model.dao;

/**
 * DanhMucDAO
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
 * 14-3-2017         AnNBH            Create
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.DataBaseConnect;
import model.bean.DanhMucBean;

public class DanhMucDAO extends DataBaseConnect{
	private static Statement st=null;
	private static ResultSet rs=null;
	
	/**
	 * Ham lay danh sach cac danh muc
	 * @return
	 */
	public static ArrayList<DanhMucBean> getListDanhMuc() {
		ArrayList<DanhMucBean> list = new ArrayList<DanhMucBean>();
		DanhMucBean danhMucBean;
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("SELECT MaDanhMuc, TenDanhMuc FROM DanhMuc");
			while (rs.next()) {
				danhMucBean = new DanhMucBean();
				danhMucBean.setMaDanhMuc(rs.getInt("MaDanhMuc"));
				danhMucBean.setTenDanhMuc(rs.getString("TenDanhMuc"));
				list.add(danhMucBean);
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
	
	/**
	 * Ham them moi danh muc
	 */
	public static void themDanhMuc(String tenDanhMuc) {
		
		try {
			String sql=	String.format("INSERT INTO DanhMuc(TenDanhMuc) VALUES (N'"+tenDanhMuc+"')");
			PreparedStatement prepSt = getConnect().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			prepSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				getConnect().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Ham sua danh muc
	 * @param maDanhMuc
	 * @param tenDanhMuc
	 */
	public static void suaDanhMuc(int maDanhMuc,String tenDanhMuc) {
		String sql=	String.format("UPDATE DanhMuc SET TenDanhMuc=('"+tenDanhMuc+"') WHERE MaDanhMuc='"+maDanhMuc+"'");
		try {
			PreparedStatement prepSt = getConnect().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			prepSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				getConnect().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void xoaDanhMuc(int maDanhMuc) {
		String sql=	String.format("DELETE FROM DanhMuc WHERE MaDanhMuc = '"+maDanhMuc+"'");
		try {
			PreparedStatement prepSt = getConnect().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			prepSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				getConnect().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Ham Lay 7 danh muc cho trang chu
	 * @param i
	 * @return
	 */
	public static ArrayList<DanhMucBean> getListDanhMuc(int i) {
		ArrayList<DanhMucBean> list = new ArrayList<DanhMucBean>();
		DanhMucBean danhMucBean;
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("SELECT TOP "+i+" MaDanhMuc, TenDanhMuc FROM DanhMuc");
			while (rs.next()) {
				danhMucBean = new DanhMucBean();
				danhMucBean.setMaDanhMuc(rs.getInt("MaDanhMuc"));
				danhMucBean.setTenDanhMuc(rs.getString("TenDanhMuc"));
				list.add(danhMucBean);
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
