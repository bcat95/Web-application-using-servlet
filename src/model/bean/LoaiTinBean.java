package model.bean;
/**
 * LoaiTinBean
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

public class LoaiTinBean {
	private String maLoaiTin;
	private String tenLoaiTin;
	private int capDoTin;
	
	public LoaiTinBean(String maLoaiTin, String tenLoaiTin, int capDoTin) {
		super();
		this.maLoaiTin = maLoaiTin;
		this.tenLoaiTin = tenLoaiTin;
		this.capDoTin = capDoTin;
	}
	public String getMaLoaiTin() {
		return maLoaiTin;
	}
	public void setMaLoaiTin(String maLoaiTin) {
		this.maLoaiTin = maLoaiTin;
	}
	public String getTenLoaiTin() {
		return tenLoaiTin;
	}
	public void setTenLoaiTin(String tenLoaiTin) {
		this.tenLoaiTin = tenLoaiTin;
	}
	public int getCapDoTin() {
		return capDoTin;
	}
	public void setCapDoTin(int capDoTin) {
		this.capDoTin = capDoTin;
	}

	

}
