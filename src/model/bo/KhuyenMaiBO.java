package model.bo;

import java.util.ArrayList;

import model.bean.KhuyenMaiBean;
import model.bean.KhuyenMaisBean;
import model.dao.KhuyenMaiDAO;


public class KhuyenMaiBO {
	KhuyenMaiDAO khuyenMaiDAO = new KhuyenMaiDAO();
	
	public ArrayList<KhuyenMaiBean> getListKhuyenMai(int maBaiDang) {
		return khuyenMaiDAO.getListKhuyenMai(maBaiDang);
	}
	
	public ArrayList<KhuyenMaiBean> infoKhuyenMai(int maKhuyenMai) {
		return khuyenMaiDAO.infoKhuyenMai(maKhuyenMai);
	}
	public void insertKhuyenMai(KhuyenMaiBean khuyenMai) {
		khuyenMaiDAO.insertKhuyenMai(khuyenMai);
		
	}
	public void deleteKhuyenMai(int maKhuyenMai) {
		khuyenMaiDAO.deleteKhuyenMai(maKhuyenMai);
	}

	public void editKhuyenMai(KhuyenMaiBean khuyenMai) {
		khuyenMaiDAO.editKhuyenMai(khuyenMai);
	}

	public ArrayList<KhuyenMaisBean> getListBaiDangKM() {
		return khuyenMaiDAO.getListBaiDangKM();
	}
}
