package model.bo;

import java.util.ArrayList;
import model.bean.LienHe;
import model.dao.LienHeDAO;


public class LienHeBO {
	LienHeDAO lienHeDAO = new LienHeDAO();
	
	public ArrayList<LienHe> getListLienHe() {
		return lienHeDAO.getListLienHe();
	}
	
	public ArrayList<LienHe> getListLienHe(String maVanDe) {
		return lienHeDAO.getListLienHe(maVanDe);
	}
		
	public ArrayList<LienHe> timSinhVien(String tim) {
		return lienHeDAO.timLienHe2(tim);
	}
	public ArrayList<LienHe> timSinhVien1(String tim,String maVanDe) {
		return lienHeDAO.timLienHe1(tim, maVanDe);
	}
	
	public LienHe getThongTinLienHe(int maLienHe) {
		return lienHeDAO.getThongTinLienHe(maLienHe);
	}

	public void themLienHe( String tieuDe, String noiDung, String ngayGui, String soDT, String email,
			int maVanDe) {
		lienHeDAO.themLienHe(tieuDe, noiDung, ngayGui, soDT, email, maVanDe);
		
	}
	public void xoaLienHe(int maLienHe) {
		lienHeDAO.xoaLienHe(maLienHe);
	}
}
