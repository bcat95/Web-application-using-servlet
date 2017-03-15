package model.bean;

public class TaiKhoanBean {
	private String userName;
	private String passWord;
	private String eMail;
	private String avatar;
	private String hoTen;
	private String gioiTinh;
	private String ngaySinh;
	private String sDT;
	private String ngayDangKy;
	private String maQuyen;
	private int maLoaiTK;
	
	public TaiKhoanBean() {
		super();
	}

	public TaiKhoanBean(String userName, String passWord, String eMail, String avatar, String hoTen, String gioiTinh,
			String ngaySinh, String sDT, String ngayDangKy, String maQuyen, int maLoaiTK) {
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
		this.maLoaiTK = maLoaiTK;
	}
	
	public TaiKhoanBean(String user, String pass, String eMail2) {
		this.userName = user;
		this.passWord = pass;
		this.eMail = eMail2;
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

	public String getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(String maQuyen) {
		this.maQuyen = maQuyen;
	}

	public int getMaLoaiTK() {
		return maLoaiTK;
	}

	public void setMaLoaiTK(int maLoaiTK) {
		this.maLoaiTK = maLoaiTK;
	}
	
	
	
}
