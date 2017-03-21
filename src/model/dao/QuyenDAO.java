package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.DataBaseConnect;
import model.bean.QuyenBean;


public class QuyenDAO extends DataBaseConnect{
	private static Statement st=null;
	private static ResultSet rs=null;
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
