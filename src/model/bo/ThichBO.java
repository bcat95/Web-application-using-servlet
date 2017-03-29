package model.bo;

import java.sql.SQLException;

import model.bean.BaiDangBean;
import model.dao.BaiDangDAO;
import model.dao.ThichDAO;
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
public class ThichBO {

	public static BaiDangBean infoBaiDang(int maBaiDang) throws SQLException, ClassNotFoundException{
			return BaiDangDAO.infobaiDang(maBaiDang);
	}
	public static boolean checkThich(int maBaiDang, String userName) {
		return ThichDAO.checkThich(maBaiDang,userName);
	}
	public static void setThich(boolean checkThich, int maBaiDang, String userName) {
		ThichDAO.setThich(checkThich,maBaiDang,userName);
	}
}
