package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.DataBaseConnect;
import model.bean.KhuyenMaiBean;


public class KhuyenMaiDAO  extends DataBaseConnect{
	private static PreparedStatement prepSt=null;
	private static Statement st=null;
	private static ResultSet rs=null;

	public ArrayList<KhuyenMaiBean> getListKhuyenMai(int maBaiDang) {
		ArrayList<KhuyenMaiBean> list = new ArrayList<KhuyenMaiBean>();
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("select * FROM KhuyenMai where MaBaiDang = "+maBaiDang+" order by MaKhuyenMai ");
			KhuyenMaiBean khuyenMai;
			while(rs.next()){
				khuyenMai = new KhuyenMaiBean();
				khuyenMai.setMaKhuyenMai(rs.getInt("maKhuyenMai"));
				khuyenMai.setTieuDe(rs.getString("TieuDe"));
				khuyenMai.setNoiDung(rs.getString("NoiDung"));
				khuyenMai.setNgayBatDau(rs.getString("NgayBatDau"));
				khuyenMai.setNgayKetThuc(rs.getString("NgayKetThuc"));
				khuyenMai.setMaBaiDang(rs.getInt("MaBaiDang"));
				list.add(khuyenMai);
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
		return list;
	}

	public ArrayList<KhuyenMaiBean> infoKhuyenMai(int maKhuyenMai) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteKhuyenMai(int maKhuyenMai) {
		// TODO Auto-generated method stub
		
	}

	public void insertKhuyenMai(KhuyenMaiBean khuyenMai) {
		try {
			String insertTableSQL = "insert into KhuyenMai values(?,?,?,?,?)";
			PreparedStatement  prepSt= getConnect().prepareStatement(insertTableSQL);
			prepSt.setString(1, khuyenMai.getTieuDe());
			prepSt.setString(2, khuyenMai.getNoiDung());
			prepSt.setDate(3, java.sql.Date.valueOf(khuyenMai.getNgayBatDau()));
			prepSt.setDate(4, java.sql.Date.valueOf(khuyenMai.getNgayKetThuc()));
			prepSt.setInt(5, khuyenMai.getMaBaiDang());
			System.out.println("sql "+insertTableSQL);
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

	public void editKhuyenMai(KhuyenMaiBean khuyenMai) {
		try {
			String updateTableSQL  = "update KhuyenMai set "
					+ "TieuDe=?,NoiDung=?,NgayBatDau=?,NgayKetThuc=? "
					+ "where MaKhuyenMai="+khuyenMai.getMaKhuyenMai()+" and MaBaiDang="+khuyenMai.getMaBaiDang()+"";
			PreparedStatement prepSt = getConnect().prepareStatement(updateTableSQL);
			prepSt.setString(1, khuyenMai.getTieuDe());
			prepSt.setString(2, khuyenMai.getNoiDung());
			prepSt.setDate(3, java.sql.Date.valueOf(khuyenMai.getNgayBatDau()));
			prepSt.setDate(4, java.sql.Date.valueOf(khuyenMai.getNgayKetThuc()));
			System.out.println("sql "+updateTableSQL);
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
