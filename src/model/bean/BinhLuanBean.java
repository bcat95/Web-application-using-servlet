package model.bean;

import java.util.Date;

/**
 * BinhLuanBean
 *
 * Version 1.2
 *
 * Date: 7-3-2017
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 7-3-2017         DonNA            Create
 * 14-3-2017        DonNA            Update tieuDe
 * 15-3-2017        DonNA            Insert listBinhLuan
 */

public class BinhLuanBean {
	private int maBinhLuan;
	private int maBaiDang;
	private String userName;
	private String tieuDe;
	private String noiDung;
	private Date ngayBinhLuan;
	private int diemDanhGia;

	public BinhLuanBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Ham tao
	 * @param maBinhLuan
	 * @param maBaiDang
	 * @param userName
	 * @param tieuDe
	 * @param noiDung
	 * @param ngayBinhLuan
	 * @param diemDanhGia
	 */
	public BinhLuanBean(int maBinhLuan, int maBaiDang, String userName, String tieuDe, String noiDung,
			Date ngayBinhLuan, int diemDanhGia) {
		super();
		this.maBinhLuan = maBinhLuan;
		this.maBaiDang = maBaiDang;
		this.userName = userName;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
		this.ngayBinhLuan = ngayBinhLuan;
		this.diemDanhGia = diemDanhGia;
	}
	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public int getMaBinhLuan() {
		return maBinhLuan;
	}
	public void setMaBinhLuan(int maBinhLuan) {
		this.maBinhLuan = maBinhLuan;
	}
	public int getMaBaiDang() {
		return maBaiDang;
	}
	public void setMaBaiDang(int maBaiDang) {
		this.maBaiDang = maBaiDang;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public Date getNgayBinhLuan() {
		return ngayBinhLuan;
	}
	public void setNgayBinhLuan(Date ngayBinhLuan) {
		this.ngayBinhLuan = ngayBinhLuan;
	}
	public int getDiemDanhGia() {
		return diemDanhGia;
	}
	public void setDiemDanhGia(int diemDanhGia) {
		this.diemDanhGia = diemDanhGia;
	}
	
	
}
