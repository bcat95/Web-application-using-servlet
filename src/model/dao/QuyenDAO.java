package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.DataBaseConnect;
import model.bean.QuyenBean;


/**
 * QuyenDAO
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
public class QuyenDAO extends DataBaseConnect{
	private static Statement st=null;
	private static ResultSet rs=null;
	
	/**
	 * Ham lay danh sach quyen
	 * @return
	 */
	public  ArrayList<QuyenBean> getListQuyen() {
		ArrayList<QuyenBean> list = new ArrayList<QuyenBean>();
		QuyenBean quyenBean;
		try {
			st=getConnect().createStatement();
			String sql="SELECT * from quyen";
			rs=st.executeQuery(sql);
			System.out.println("sql= "+sql);
			while (rs.next()) {
				quyenBean = new QuyenBean();
				quyenBean.setMaQuyen(rs.getString("MaQuyen"));
				quyenBean.setTenQuyen(rs.getString("TenQuyen"));
				list.add(quyenBean);
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
