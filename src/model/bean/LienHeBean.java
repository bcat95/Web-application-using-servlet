package model.bean;
import java.sql.Date;
/**
 * LienHeBean
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
 * 7-3-2017         DonNA            Create
 */

public class LienHeBean {
	private String maLienHe;
	private String tieuDe;
	private String noiDung;
	private Date ngayGui;
	private String sDT;
	private String email;
	private int maVanDe;
	public LienHeBean(String maLienHe, String tieuDe, String noiDung, Date ngayGui, String sDT, String email,
			int maVanDe) {
		super();
		this.maLienHe = maLienHe;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
		this.ngayGui = ngayGui;
		this.sDT = sDT;
		this.email = email;
		this.maVanDe = maVanDe;
	}
	public String getMaLienHe() {
		return maLienHe;
	}
	public void setMaLienHe(String maLienHe) {
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
	public Date getNgayGui() {
		return ngayGui;
	}
	public void setNgayGui(Date ngayGui) {
		this.ngayGui = ngayGui;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
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
