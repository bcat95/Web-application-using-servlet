package form;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import model.bean.LoaiTaiKhoanBean;
import model.bean.QuyenBean;
import model.bean.TaiKhoanBean;

public class DanhSachTaiKhoanForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sTT;
	private String userName;
	private String passWord;
	private String eMail;
	private String avatar;
	private String hoTen;
	private String gioiTinh;
	private String ngaySinh;
	private String sDT;
	private int maQuyen;
	private String tenQuyen;
	private String ngayDangKy;
	private int maLoaiTaiKhoan;
	private String tenLoaiTaiKhoan;
	private String submit;
	
	private ArrayList<TaiKhoanBean>listTaiKhoan;
	private ArrayList<QuyenBean>listQuyen;
	private ArrayList<LoaiTaiKhoanBean> listLoaiTaiKhoan;

	public TaiKhoanBean getTaiKhoan() {
		return new TaiKhoanBean(userName, passWord, eMail, avatar, hoTen, gioiTinh, ngaySinh, sDT, ngayDangKy, maQuyen, maLoaiTaiKhoan);
	}
	
	public ArrayList<QuyenBean> getListQuyen() {
		return listQuyen;
	}

	public void setListQuyen(ArrayList<QuyenBean> listQuyen) {
		this.listQuyen = listQuyen;
	}

	public ArrayList<LoaiTaiKhoanBean> getListLoaiTaiKhoan() {
		return listLoaiTaiKhoan;
	}

	public void setListLoaiTaiKhoan(ArrayList<LoaiTaiKhoanBean> listLoaiTaiKhoan) {
		this.listLoaiTaiKhoan = listLoaiTaiKhoan;
	}

	public String getUserName() {
		return userName;
	}

	public String getTenLoaiTaiKhoan() {
		return tenLoaiTaiKhoan;
	}

	public void setTenLoaiTaiKhoan(String tenLoaiTaiKhoan) {
		this.tenLoaiTaiKhoan = tenLoaiTaiKhoan;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getTenQuyen() {
		return tenQuyen;
	}

	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}

	public int getsTT() {
		return sTT;
	}

	public void setsTT(int sTT) {
		this.sTT = sTT;
	}

	

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public String getNgayDangKy() {
		return ngayDangKy;
	}

	public void setNgayDangKy(String ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}
	public int getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(int maQuyen) {
		this.maQuyen = maQuyen;
	}

	public int getMaLoaiTaiKhoan() {
		return maLoaiTaiKhoan;
	}

	public void setMaLoaiTaiKhoan(int maLoaiTaiKhoan) {
		this.maLoaiTaiKhoan = maLoaiTaiKhoan;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public ArrayList<TaiKhoanBean> getListTaiKhoan() {
		return listTaiKhoan;
	}

	public void setListTaiKhoan(ArrayList<TaiKhoanBean> listTaiKhoan) {
		this.listTaiKhoan = listTaiKhoan;
	}

	public ActionErrors validateBaiDang(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors =new ActionErrors();
		if (StringProcess.equals(submit, "themTK")){
			/*if (StringProcess.checkRong(tieuDe)){
				errors.add("tieuDeError",new ActionMessage("err.tieude.trong"));
			}
			if (StringProcess.checkRong(diaChi)){
				errors.add("diaChiError",new ActionMessage("err.diachi.trong"));
			}*/
		}
		return errors;
	}
	
	
}
