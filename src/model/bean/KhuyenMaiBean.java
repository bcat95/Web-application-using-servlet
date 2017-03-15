package model.bean;

import java.util.Date;

public class KhuyenMaiBean {
	private String maKhuyenMai;
	private String tieuDe;
	private String noiDung; 
	private Date ngayBatDau;
	private Date ngayKetThuc;
	private String maBaiDang;
	
	public KhuyenMaiBean(String maKhuyenMai, String tieuDe, String noiDung, Date ngayBatDau, Date ngayKetThuc,
			String maBaiDang) {
		super();
		this.maKhuyenMai = maKhuyenMai;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.maBaiDang = maBaiDang;
	}
	public String getMaKhuyenMai() {
		return maKhuyenMai;
	}
	public void setMaKhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}
	public String getTieuDe() {
		return tieuDe;
	}
	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public String getMaBaiDang() {
		return maBaiDang;
	}
	public void setMaBaiDang(String maBaiDang) {
		this.maBaiDang = maBaiDang;
	}
	
	
}
