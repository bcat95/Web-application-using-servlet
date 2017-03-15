package model.dao;

//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.DataBaseConnect;
import model.bean.HinhAnhBean;
/**
 * HinhAnhDAO
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
public class HinhAnhDAO extends DataBaseConnect{
	//private static PreparedStatement prepSt=null;
	private static Statement st=null;
	private static ResultSet rs=null;
	//lay du lieu hinh anh
		public static ArrayList<HinhAnhBean> infoHinhAnhByMa(int maBaiDang) {
			ArrayList<HinhAnhBean> listHinhAnh = new ArrayList<HinhAnhBean>();
			HinhAnhBean hinhAnh;
			try {
				st=getConnect().createStatement();
				rs=st.executeQuery("select * FROM BaiDang "
						+ "join HinhAnh on BaiDang.MaBaiDang = HinhAnh.MaBaiDang "
						+ "where BaiDang.MaBaiDang = "+maBaiDang+"");
				while(rs.next()){
					hinhAnh = new HinhAnhBean();
					hinhAnh.setMaHinh(rs.getInt("MaHinh"));
					hinhAnh.setTenHinh(rs.getString("TenHinh"));
					listHinhAnh.add(hinhAnh);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					getConnect().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return listHinhAnh;
		}	
}
