package model.bo;

import java.util.ArrayList;

import model.bean.DichVuBean;
import model.dao.DichVuDAO;

public class DichVuBO {
	public static ArrayList<DichVuBean> getListDichVu() {
		return DichVuDAO.getListDichVu();
	}
	
	/**
	 * Ham lay du lieu dich vu tu ma bai dang
	 * @param maBaiDang
	 * @return
	 */
	public static ArrayList<DichVuBean> infoDichVuByMa(int maBaiDang) {
		return DichVuDAO.infoDichVuByMa(maBaiDang);
	}
	/**
	 * Them dich vu (admin)
	 * @param tenDichVu
	 */
	public static void themDichVu(String tenDichVu) {
		DichVuDAO.themDichVu(tenDichVu);
	}

	public void xoaDichVu(int maDichVu) {
		DichVuDAO.xoaDichVu(maDichVu);
	}
	
	public DichVuBean getThongTinDichVu(int maDichVu) {
		return DichVuDAO.getThongTinDichVu(maDichVu);
	}
	
	public void suaDichVu(String tenDichVu, int maDichVu) {
		DichVuDAO.suaDichVu(tenDichVu, maDichVu);
	}
}
