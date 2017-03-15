package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.DataBaseConnect;
import model.bean.BaiDangBean;
import model.bean.DichVuBean;
/**
 * DichVuDAO
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
public class DichVuDAO extends DataBaseConnect{
	private static Statement st=null;
	private static ResultSet rs=null;
	
	public static ArrayList<DichVuBean> getListDichVu() {
		ArrayList<DichVuBean> list = new ArrayList<DichVuBean>();
		DichVuBean dichVuBean;
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("SELECT MaDichVu, TenDichVu FROM DichVu");
			while (rs.next()) {
				dichVuBean = new DichVuBean();
				dichVuBean.setMaDichVu(rs.getInt("MaDichVu"));
				dichVuBean.setTenDichVu(rs.getString("TenDichVu"));
				list.add(dichVuBean);
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
	//lay du lieu dich vu tu ma bai dang
	public static ArrayList<DichVuBean> infoDichVuByMa(int maBaiDang) {
		ArrayList<DichVuBean> listDichVu = new ArrayList<DichVuBean>();
		DichVuBean dichVu;
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("select * FROM BaiDang "
					+ "join DichVuBD on BaiDang.MaBaiDang = DichVuBD.MaBaiDang "
					+ "join DichVu on DichVuBD.MaDichVu =DichVu.MaDichVu "
					+ "where BaiDang.MaBaiDang = "+maBaiDang+"");
			while(rs.next()){
				dichVu = new DichVuBean();
				dichVu.setMaDichVu(rs.getInt("MaDichVu"));
				dichVu.setTenDichVu(rs.getString("TenDichVu"));
				listDichVu.add(dichVu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				getConnect().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		};
		return listDichVu;
	}
}
