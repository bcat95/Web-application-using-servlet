package model.bo;

import java.util.ArrayList;

import model.bean.DanhMucBean;
import model.dao.DanhMucDAO;

public class DanhMucBO {
	DanhMucDAO danhMucDAO = new DanhMucDAO();
	public static ArrayList<DanhMucBean> getListDanhMuc() {
		return DanhMucDAO.getListDanhMuc();
	}
}
