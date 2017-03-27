package model.bo;

import java.util.ArrayList;

import model.bean.AdminPanelBean;
import model.dao.AdminPanelDAO;

public class AdminPanelBO {
	AdminPanelDAO adminPanelDAO = new AdminPanelDAO();

	public ArrayList<AdminPanelBean> getListTKBaiDang() {
		return adminPanelDAO.getListTKBaiDang();
	}

	public ArrayList<AdminPanelBean> getListTKBinhLuan() {
		return adminPanelDAO.getListTKBinhLuan();
	}

	public ArrayList<AdminPanelBean> getListTKYeuThich() {
		return adminPanelDAO.getListTKYeuThich();
	}

	public ArrayList<AdminPanelBean> getListTKTaiKhoan() {
		return adminPanelDAO.getListTKTaiKhoan();
	}

	public ArrayList<AdminPanelBean> getListTKTinhThanh() {
		return adminPanelDAO.getListTKTinhThanh();
	}

	public ArrayList<AdminPanelBean> getListTKDanhMuc() {
		return adminPanelDAO.getListTKDanhMuc();
	}
	
}
