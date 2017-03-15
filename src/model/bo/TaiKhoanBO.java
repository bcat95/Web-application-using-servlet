package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.TaiKhoanBean;
import model.dao.TaiKhoanDAO;

public class TaiKhoanBO {

	TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
	public ArrayList<TaiKhoanBean> danhSachThanhVien() throws SQLException {
		return taiKhoanDAO.danhSachTaiKhoan();
	}
	public TaiKhoanBean getThongTinTaiKhoan(String userName) {
		return taiKhoanDAO.getThongTinTaiKhoan(userName);
	}
	
	public void capNhatThongTinTaiKhoan(String userName, String passWord) {
		taiKhoanDAO.capNhatThongTinTaiKhoan(userName, passWord);
	}
	
}