package model.dao;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				getConnect().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
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
				// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
