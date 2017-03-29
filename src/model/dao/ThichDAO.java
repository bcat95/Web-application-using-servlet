package model.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.DataBaseConnect;
import common.StringProcess;

/**
 * ThichDao
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
public class ThichDAO extends DataBaseConnect{
	private static Statement st=null;

	/**
	 * kiem tra thich
	 * @param maBaiDang
	 * @param userName
	 * @return
	 */
	public static boolean checkThich(int maBaiDang, String userName) {
		String sql=	String.format("SELECT maBaiDang FROM Thich WHERE maBaiDang = '%s' AND userName = '%s'", maBaiDang, userName);
		ResultSet rs = null;
		try {
			st=getConnect().createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ham gan du lieu cho Thich
	 * @param checkThich
	 * @param maBaiDang
	 * @param userName
	 */
	public static void setThich(boolean checkThich, int maBaiDang, String userName) {
		String sql="";
		if (checkThich == true){
			sql=String.format("delete from Thich where MaBaiDang = '%s' and  userName = '%s'",maBaiDang, userName);
		}
		if (checkThich == false){
			sql=String.format("INSERT INTO Thich(MaBaiDang, userName, NgayThich) "+
					" VALUES ( '%s','%s','%s' )", maBaiDang, userName,new Date(StringProcess.getNgayDangDate().getTime()));
		}
		if (sql!=""){
			try {
				st=getConnect().createStatement();
				st.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
