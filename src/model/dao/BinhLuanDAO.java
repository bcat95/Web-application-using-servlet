package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.DataBaseConnect;
import common.StringProcess;
import model.bean.BinhLuanBean;

public class BinhLuanDAO extends DataBaseConnect{
	private static PreparedStatement prepSt=null;

	public static void insertBinhLuan(BinhLuanBean binhLuan) {
		try {
			String insertTableSQL = "insert into BinhLuan values(?,?,?,?,?,?)";
			prepSt = getConnect().prepareStatement(insertTableSQL);
			prepSt.setString(1, binhLuan.getTieuDe());
			prepSt.setString(2, binhLuan.getNoiDung());
			prepSt.setDate(3, new Date(StringProcess.getNgayDangDate().getTime()));
			prepSt.setInt(4, binhLuan.getDiemDanhGia());
			prepSt.setInt(5, binhLuan.getMaBaiDang());
			prepSt.setString(6, binhLuan.getUserName());
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
