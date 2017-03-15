package model.bo;

import java.sql.Date;

import model.bean.BinhLuanBean;
import model.dao.BinhLuanDAO;

public class BinhLuanBO {
	public static void insertBinhLuan(BinhLuanBean binhLuan) {
		BinhLuanDAO.insertBinhLuan(binhLuan);
	}
}
