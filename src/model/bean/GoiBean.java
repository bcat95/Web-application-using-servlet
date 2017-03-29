package model.bean;
/**
 * GoiBean
 *
 * Version 1.0
 *
 * Date: Mars 3, 2017
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * Mars 3, 2017        	Vannasone          Create
 */
public class GoiBean {
	private String maGoi;
	private String donGia;
	private int soLuong;
	public GoiBean(String maGoi, String donGia, int soLuong) {
		super();
		this.maGoi = maGoi;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}
	public String getMaGoi() {
		return maGoi;
	}
	public void setMaGoi(String maGoi) {
		this.maGoi = maGoi;
	}
	public String getDonGia() {
		return donGia;
	}
	public void setDonGia(String donGia) {
		this.donGia = donGia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
}
