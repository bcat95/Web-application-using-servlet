package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.BaiDangBean;
import model.bean.TaiKhoanBean;
import model.dao.TaiKhoanDAO;

public class TaiKhoanBO {

	TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
	//vang dang nhap
	public boolean checkUsername(String username) {
		return taiKhoanDAO.checkUsername(username);
	}
	public boolean checkEmail(String email) {
		return taiKhoanDAO.checkEmail(email);
	}
	public boolean checkEmailUpdate(String email, String username) {
		return taiKhoanDAO.checkEmailUpdate(email, username);
	}
	public TaiKhoanBean selectOne(String username) {
		return taiKhoanDAO.selectOne(username);
	}
	public boolean checkLogin(String tenDangNhap, String matKhau) {
		return taiKhoanDAO.checkLogin(tenDangNhap, matKhau);
	}
	public void updateTK(String username, String pass, String email, String avatar, String hoTen, String gioiTinh, String ngaySinh, String SDT) {
		taiKhoanDAO.updateTK(username, pass, email, avatar, hoTen, gioiTinh, ngaySinh, SDT);
	}
	public void themTaiKhoan(String tenDangNhap, String matKhau, String email, String avatar, String hoTen, int MaQuyen, int MaLoaiTK) {
		taiKhoanDAO.themTaiKhoan(tenDangNhap, matKhau, email, avatar, hoTen, MaQuyen, MaLoaiTK);
	}
	public ArrayList<TaiKhoanBean> danhSachThanhVien() throws SQLException {
		return taiKhoanDAO.danhSachTaiKhoan();
	}
	public TaiKhoanBean getThongTinTaiKhoan(String userName) {
		return taiKhoanDAO.getThongTinTaiKhoan(userName);
	}
	
	public void capNhatThongTinTaiKhoan(String userName, String passWord) {
		taiKhoanDAO.capNhatThongTinTaiKhoan(userName, passWord);
	}
	//danh sach yeu thich
	public static ArrayList<BaiDangBean> danhSachYeuThich(TaiKhoanBean user) {
		return TaiKhoanDAO.danhSachYeuThich(user);
	}
	//danh sach bai dang
	public static ArrayList<BaiDangBean> danhSachBaiDang(TaiKhoanBean user) {
		return TaiKhoanDAO.danhSachBaiDang(user);
	}
	//admin
	public ArrayList<TaiKhoanBean> getListTaiKhoan() {
		return taiKhoanDAO.getListTaiKhoan();
	}
	public void xoaTaiKhoan(String user) {
		taiKhoanDAO.xoaTaiKhoan(user);
	}
	public void themTaiKhoan(TaiKhoanBean taiKhoan){
		/*taiKhoanDAO.themTaiKhoan(userName, pass, email, hoTen, gioiTinh, ngaySinh, sDT, ngayDangKy, maQuyen, maLoaiTaiKhoan);*/
		taiKhoanDAO.themTaiKhoan(taiKhoan);
	}
	public void suaTaiKhoan(TaiKhoanBean taiKhoan){
		taiKhoanDAO.suaTaiKhoan(taiKhoan);
	}
	public TaiKhoanBean getListTaiKhoan(String username){
		return taiKhoanDAO.getListTaiKhoan(username);
	}
}