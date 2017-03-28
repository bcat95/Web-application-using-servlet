package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.DataBaseConnect;
import model.bean.TinhThanhBean;

/**
 * TinhThanhDAO
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
 * 14-3-2017         DonNA            Create
 */
public class TinhThanhDAO extends DataBaseConnect{
	private static Statement st=null;
	private static ResultSet rs=null;
	
	/**
	 * lay danh sach tinh thanh
	 * @return
	 */
	public static ArrayList<TinhThanhBean> getListTinhThanh() {
		ArrayList<TinhThanhBean> list = new ArrayList<TinhThanhBean>();
		TinhThanhBean tinhThanhBean;
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("SELECT MaTinhThanh, TenTinhThanh FROM TinhThanh");
			while (rs.next()) {
				tinhThanhBean = new TinhThanhBean();
				tinhThanhBean.setMaTinhThanh(rs.getInt("MaTinhThanh"));
				tinhThanhBean.setTenTinhThanh(rs.getString("TenTinhThanh"));
				list.add(tinhThanhBean);
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
