package model.bean;
/**
 * ChiTietGiaoDichBaen
 *
 * Version 1.0
 *
 * Date: Mars 3, 2017
 *
 * Copyright 
 *
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * Mars 3, 2017        	Vannasone          Create
 */
public class ChiTietGiaoDichBaen {
	private String maGiaoDich;
	private String maGoi;
	private int soLuong;
	public ChiTietGiaoDichBaen(String maGiaoDich, String maGoi, int soLuong) {
		super();
		this.maGiaoDich = maGiaoDich;
		this.maGoi = maGoi;
		this.soLuong = soLuong;
	}
	public String getMaGiaoDich() {
		return maGiaoDich;
	}
	public void setMaGiaoDich(String maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}
	public String getMaGoi() {
		return maGoi;
	}
	public void setMaGoi(String maGoi) {
		this.maGoi = maGoi;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}	
}
