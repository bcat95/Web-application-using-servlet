package model.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TaiKhoanBean {
	private int sTT;
	private String userName;
	private String passWord;
	private String eMail;
	private String avatar;
	private String hoTen;
	private String gioiTinh;
	private String ngaySinh;
	private String sDT;
	private String ngayDangKy;
	private int maQuyen;
	private String tenQuyen;
	private int maLoaiTaiKhoan;
	private String tenLoaiTaiKhoan;
	private SimpleDateFormat sdf;
	
	public int getMaLoaiTaiKhoan() {
		return maLoaiTaiKhoan;
	}

	public void setMaLoaiTaiKhoan(int maLoaiTaiKhoan) {
		this.maLoaiTaiKhoan = maLoaiTaiKhoan;
	}

	public String getTenQuyen() {
		return tenQuyen;
	}

	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}
	
	public String getTenLoaiTaiKhoan() {
		return tenLoaiTaiKhoan;
	}

	public void setTenLoaiTaiKhoan(String tenLoaiTaiKhoan) {
		this.tenLoaiTaiKhoan = tenLoaiTaiKhoan;
	}

	public TaiKhoanBean() {
		super();
	}

	public TaiKhoanBean(String userName, String passWord, String eMail, String avatar, String hoTen, String gioiTinh,
			String ngaySinh, String sDT, String ngayDangKy, int maQuyen, int maLoaiTaiKhoan) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.eMail = eMail;
		this.avatar = avatar;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.sDT = sDT;
		this.ngayDangKy = ngayDangKy;
		this.maQuyen = maQuyen;
		this.maLoaiTaiKhoan = maLoaiTaiKhoan;
	}
	
	public TaiKhoanBean(String user, String pass, String eMail2) {
		this.userName = user;
		this.passWord = pass;
		this.eMail = eMail2;
	}
	//su dung cho dang nhap 
	public TaiKhoanBean(String userName, String passWord, String hoTen, int maQuyen) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.hoTen = hoTen;
		this.maQuyen = maQuyen;
	}
	
	public SimpleDateFormat getSdf()
	{
		if(sdf == null)
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf;
	}
	

	//lay ngay hien tai
		public Date getNgayDangDate() 
		{
			Date date=new Date();
			String str= getSdf().format(date);
			
			Date currentDate=null;
			try {
				currentDate = getSdf().parse(str);
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			System.out.println("ngay dang:"+currentDate);
			return currentDate;
		}
		
		
	
	public int getsTT() {
		return sTT;
	}

	public void setsTT(int sTT) {
		this.sTT = sTT;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
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
	
}
