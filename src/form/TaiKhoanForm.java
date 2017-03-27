package form;

import java.nio.charset.StandardCharsets;
import org.apache.struts.action.ActionForm;
import model.bean.TaiKhoanBean;

public class TaiKhoanForm extends ActionForm{
	private String userName;
	private String pass;
	private String email;
	private String avatar;
	private String hoTen;
	private String gioiTinh;
	private String ngaySinh;
	private String SDT;
	private String ngayDangKy;
	private int maQuyen;
	private int maLoaiTK;
	private String confirmMatKhau;
	private String submit;
	private int thongBao;
	private String tacVu;
	
	public String getTacVu() {
		return tacVu;
	}
	public void setTacVu(String tacVu) {
		this.tacVu = tacVu;
	}
	public void setTK(TaiKhoanBean user)
	{
		this.userName = user.getUserName();
		this.pass = user.getPassWord();
		this.email = user.geteMail();
		this.avatar = user.getAvatar();
		this.hoTen = user.getHoTen();
		this.gioiTinh = user.getGioiTinh();
		this.ngaySinh = user.getNgaySinh();
		this.SDT = user.getsDT();
		this.ngayDangKy = user.getNgayDangKy();
		this.maQuyen = user.getMaQuyen();
		this.maLoaiTK = user.getMaLoaiTaiKhoan();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		this.userName = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		byte[] bytes = hoTen.getBytes(StandardCharsets.ISO_8859_1);
		hoTen = new String(bytes, StandardCharsets.UTF_8);
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
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
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
	public int getMaLoaiTK() {
		return maLoaiTK;
	}
	public void setMaLoaiTK(int maLoaiTK) {
		this.maLoaiTK = maLoaiTK;
	}
	public String getConfirmMatKhau() {
		return confirmMatKhau;
	}
	public void setConfirmMatKhau(String confirmMatKhau) {
		this.confirmMatKhau = confirmMatKhau;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public int getThongBao() {
		return thongBao;
	}
	public void setThongBao(int thongBao) {
		this.thongBao = thongBao;
	}
}
