package model.bo;
/**
 * BinhLuanBO
 *
 * Version 1.0
 *
 * Date: 15-3-2017
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 15-3-2017         DonNA            Create
 */
import java.util.ArrayList;

import model.bean.BinhLuanBean;
import model.dao.BinhLuanDAO;

public class BinhLuanBO {
	public static void insertBinhLuan(BinhLuanBean binhLuan) {
		BinhLuanDAO.insertBinhLuan(binhLuan);
	}

	public static ArrayList<BinhLuanBean> infoBinhLuan(int maBaiDang) {
		return BinhLuanDAO.infoBinhLuanByMa(maBaiDang);
	}
}
