package model.bean;

/**
 * KhuyenMaiBean
 *
 * Version 1.0
 *
 * Date: 14-3-2017
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 14-3-2017         Vannasone            Create
 */
public class KhuyenMaiBean {
	private int maKhuyenMai;
	private String tieuDe;
	private String noiDung; 
	private String ngayBatDau;
	private String ngayKetThuc;
	private int maBaiDang;
	
	public KhuyenMaiBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhuyenMaiBean(int maKhuyenMai, String tieuDe, String noiDung, String ngayBatDau, String ngayKetThuc,
			int maBaiDang) {
		super();
		this.maKhuyenMai = maKhuyenMai;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.maBaiDang = maBaiDang;
	}
	
	public int getMaKhuyenMai() {
		return maKhuyenMai;
	}
	public void setMaKhuyenMai(int maKhuyenMai) {
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
	public String getNgayBatDau() {
		return ngayBatDau;
	}
	public String getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public int getMaBaiDang() {
		return maBaiDang;
	}
	public void setMaBaiDang(int maBaiDang) {
		this.maBaiDang = maBaiDang;
	}
	
	
}
