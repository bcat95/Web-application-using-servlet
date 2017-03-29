package model.bean;

/**
 * LienHe
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
 * 14-3-2017         ThinhDM            Create
 */
public class LienHe {
	private int maLienHe;
	private String tieuDe;
	private String noiDung;
	private String ngayGui;
	private String SDT;
	private String email;
	private int maVanDe;
	private String tenVanDe;
	
	public String getTenVanDe() {
		return tenVanDe;
	}
	public void setTenVanDe(String tenVanDe) {
		this.tenVanDe = tenVanDe;
	}
	public int getMaLienHe() {
		return maLienHe;
	}
	public void setMaLienHe(int maLienHe) {
		this.maLienHe = maLienHe;
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
	public String getNgayGui() {
		return ngayGui;
	}
	public void setNgayGui(String ngayGui) {
		this.ngayGui = ngayGui;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMaVanDe() {
		return maVanDe;
	}
	public void setMaVanDe(int maVanDe) {
		this.maVanDe = maVanDe;
	}
}
