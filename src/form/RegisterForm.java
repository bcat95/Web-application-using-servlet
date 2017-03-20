package form;

import java.nio.charset.StandardCharsets;
import org.apache.struts.action.ActionForm;

public class RegisterForm extends ActionForm{
	private String hoTen;
	private String email;
	private String tenDangNhap;
	private String matKhau;
	private String confirmMatKhau;
	private String submit;
	private int thongBao;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		byte[] bytes = hoTen.getBytes(StandardCharsets.ISO_8859_1);
		hoTen = new String(bytes, StandardCharsets.UTF_8);
		this.hoTen = hoTen;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getConfirmMatKhau() {
		return confirmMatKhau;
	}
	public void setConfirmMatKhau(String confirmMatKhau) {
		this.confirmMatKhau = confirmMatKhau;
	}
}
