package model.dao;

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
}
