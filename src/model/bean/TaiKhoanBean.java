package model.bean;

public class TaiKhoanBean {
	private String Username;
	private String Pass;
	private String Email;
	private String Avatar;
	private String HoTen;
	private String GioiTinh;
	private String NgaySinh;
	private String SDT;
	private String NgayDangKy;
	private int MaQuyen;
	private int MaLoaiTK;
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAvatar() {
		return Avatar;
	}
	public void setAvatar(String avatar) {
		Avatar = avatar;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getNgayDangKy() {
		return NgayDangKy;
	}
	public void setNgayDangKy(String ngayDangKy) {
		NgayDangKy = ngayDangKy;
	}
	public int getMaQuyen() {
		return MaQuyen;
	}
	public void setMaQuyen(int maQuyen) {
		MaQuyen = maQuyen;
	}
	public int getMaLoaiTK() {
		return MaLoaiTK;
	}
	public void setMaLoaiTK(int maLoaiTK) {
		MaLoaiTK = maLoaiTK;
	}
	public TaiKhoanBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoanBean(String username, String pass, String email, String avatar, String hoTen, String gioiTinh,
			String ngaySinh, String sDT, String ngayDangKy, int maQuyen, int maLoaiTK) {
		super();
		Username = username;
		Pass = pass;
		Email = email;
		Avatar = avatar;
		HoTen = hoTen;
		GioiTinh = gioiTinh;
		NgaySinh = ngaySinh;
		SDT = sDT;
		NgayDangKy = ngayDangKy;
		MaQuyen = maQuyen;
		MaLoaiTK = maLoaiTK;
	}
	public TaiKhoanBean(String username, String pass, String hoTen, int maQuyen){
		super();
		Username = username;
		Pass = pass;
		HoTen = hoTen;
		MaQuyen = maQuyen;
	}
	
}
