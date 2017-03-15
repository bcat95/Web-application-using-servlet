package model.bean;

public class LoaiTaiKhoanBean {
	private String maLoaiTK;
	private String tenLoaiTK;
	
	
	public LoaiTaiKhoanBean() {
		super();
	}


	public LoaiTaiKhoanBean(String maLoaiTK, String tenLoaiTK) {
		super();
		this.maLoaiTK = maLoaiTK;
		this.tenLoaiTK = tenLoaiTK;
	}


	public String getMaLoaiTK() {
		return maLoaiTK;
	}


	public void setMaLoaiTK(String maLoaiTK) {
		this.maLoaiTK = maLoaiTK;
	}


	public String getTenLoaiTK() {
		return tenLoaiTK;
	}


	public void setTenLoaiTK(String tenLoaiTK) {
		this.tenLoaiTK = tenLoaiTK;
	}
	
	
}
