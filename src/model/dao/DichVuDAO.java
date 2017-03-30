package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	private static PreparedStatement prepSt=null;
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

	/**
	 * Ham lay du lieu dich vu tu ma bai dang
	 * @param maBaiDang
	 * @return
	 */
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

	/**
	 * Ham Them dich vu
	 * @param baiDang
	 * @param dichVu
	 */
	public static void insertDichVu(BaiDangBean baiDang,String[] dichVu) {
		if(baiDang.getMaBaiDang()!=0){
			int dichvulen=dichVu.length;
			for (int i=0;i<dichvulen;i++)
			{
				try {
					prepSt=getConnect().prepareStatement("insert into DichVuBD values(?,?)");
					prepSt.setInt(1, Integer.parseInt(dichVu[i]));
					prepSt.setInt(2, baiDang.getMaBaiDang());
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
		}
		else {
            try {
				throw new SQLException("K co khoa chinh ma bai dang");
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
		
	}
	
	/**
	 * Ham xoa dich vu
	 * @param maBaiDang
	 */
	public static void deleteDichVu(int maBaiDang) {
		
		try {
			prepSt=getConnect().prepareStatement("delete from DichVuBD where MaBaiDang = "+maBaiDang+"");
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
	 * Ham sua dich vu
	 * @param baiDang
	 * @param dichVu
	 */
	public static void updateDichVu(BaiDangBean baiDang, String[] dichVu) {
		deleteDichVu(baiDang.getMaBaiDang());
		int dichvulen=dichVu.length;
		for (int i=0;i<dichvulen;i++)
		{
			try {
				prepSt=getConnect().prepareStatement("insert into DichVuBD values(?,?)");
				prepSt.setInt(1, Integer.parseInt(dichVu[i]));
				prepSt.setInt(2, baiDang.getMaBaiDang());
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
		
	}
	
	
	/**
	 * Ham them moi dich vu (admin)
	 */
	public static void themDichVu(String tenDichVu) {
		
		try {
			String sql=	String.format("INSERT INTO dichvu(TenDichVu) VALUES (N'"+tenDichVu+"')");
			PreparedStatement prepSt = getConnect().prepareStatement(sql);
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
	 * Ham sua moi dich vu (admin)
	 */
	public static void suaDichVu(String tenDichVu, int maDichVu) {
		
		try {
			String sql=	String.format("update dichvu set tendichvu= N'"+tenDichVu+"' where MaDichVu='"+maDichVu+"'");
			PreparedStatement prepSt = getConnect().prepareStatement(sql);
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
	
	public static void xoaDichVu(int maDichVu) {
		String sql=	String.format("DELETE FROM dichvu WHERE madichvu = '"+maDichVu+"'");
		try {
			PreparedStatement prepSt = getConnect().prepareStatement(sql);
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
	 * lay thong tin cua 1 dich vu
	 * @param maDichVu
	 */
	public static DichVuBean getThongTinDichVu(int maDichVu) {
		Connection conn = common.DataBaseConnect.getConnect();
		DichVuBean dichVuBean=null;
		String sql=	String.format("select * from dichvu where madichvu= %d", maDichVu);
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()){
				dichVuBean= new DichVuBean();
				dichVuBean.setMaDichVu(rs.getInt("MaDichVu"));
				dichVuBean.setTenDichVu(rs.getString("MaDichVu"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dichVuBean;
	}
	
	
}
