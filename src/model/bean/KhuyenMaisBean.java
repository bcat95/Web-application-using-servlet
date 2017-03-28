package model.bean;

/**
 * KhuyenMaisBean
 *
 * Version 1.0
 *
 * Date: 7-3-2017
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 24-3-2017         DonNA            Create
 */

public class KhuyenMaisBean {
	private int maBaiDang;
	private String tieuDe;
	private String anhBia; 
	private String noiDung; 
	private int maKhuyenMai;
	
	
	public int getMaBaiDang() {
		return maBaiDang;
	}
	public void setMaBaiDang(int maBaiDang) {
		this.maBaiDang = maBaiDang;
	}


	public String getTieuDe() {
		return tieuDe;
	}


	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}


	public String getAnhBia() {
		return anhBia;
	}


	public void setAnhBia(String anhBia) {
		this.anhBia = anhBia;
	}


	public String getNoiDung() {
		return noiDung;
	}


	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}


	public int getMaKhuyenMai() {
		return maKhuyenMai;
	}


	public void setMaKhuyenMai(int maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}


	public KhuyenMaisBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Ham tao
	 * @param maBaiDang
	 * @param tieuDe
	 * @param anhBia
	 * @param noiDung
	 * @param maKhuyenMai
	 */
	public KhuyenMaisBean(int maBaiDang, String tieuDe, String anhBia, String noiDung, int maKhuyenMai) {
		super();
		this.maBaiDang = maBaiDang;
		this.tieuDe = tieuDe;
		this.anhBia = anhBia;
		this.noiDung = noiDung;
		this.maKhuyenMai = maKhuyenMai;
	}
	
	
	
}
