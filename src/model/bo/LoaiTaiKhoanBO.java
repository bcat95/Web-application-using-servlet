package model.bo;

import java.util.ArrayList;

import model.bean.LoaiTaiKhoanBean;
import model.bean.TinhThanhBean;
import model.dao.LoaiTaiKhoanDAO;

public class LoaiTaiKhoanBO {
	LoaiTaiKhoanDAO loaiTaiKhoanDAO= new LoaiTaiKhoanDAO();
	public ArrayList<LoaiTaiKhoanBean> getListLoaiTaiKhoan() {
		return loaiTaiKhoanDAO.getListLoaiTaiKhoan();
		
	}
}
