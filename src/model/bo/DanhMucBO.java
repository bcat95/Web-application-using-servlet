package model.bo;

import java.util.ArrayList;

import model.bean.DanhMucBean;
import model.dao.DanhMucDAO;

public class DanhMucBO {
	DanhMucDAO danhMucDAO = new DanhMucDAO();
	public static ArrayList<DanhMucBean> getListDanhMuc() {
		return DanhMucDAO.getListDanhMuc();
	}
	public void themDanhMuc(String tenDanhMuc) {
		DanhMucDAO.themDanhMuc(tenDanhMuc);;
	}
	public void suaDanhMuc(int maDanhMuc,String tenDanhMuc) {
		DanhMucDAO.suaDanhMuc(maDanhMuc, tenDanhMuc);;
	}
	public void xoaDanhMuc(int maDanhMuc) {
		DanhMucDAO.xoaDanhMuc(maDanhMuc);
	}
	public ArrayList<DanhMucBean> getListDanhMuc(int i) {
		return DanhMucDAO.getListDanhMuc(i);
	}
}
