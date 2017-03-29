package model.bean;
/**
 * GiaoDichBean
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
public class GiaoDichBean {
	private String maGiaoDich;
	private String ngayGiaoDich;
	private String thanhTien;
	private String userName;
	public GiaoDichBean(String maGiaoDich, String ngayGiaoDich, String thanhTien, String userName) {
		super();
		this.maGiaoDich = maGiaoDich;
		this.ngayGiaoDich = ngayGiaoDich;
		this.thanhTien = thanhTien;
		this.userName = userName;
	}
	public String getMaGiaoDich() {
		return maGiaoDich;
	}
	public void setMaGiaoDich(String maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}
	public String getNgayGiaoDich() {
		return ngayGiaoDich;
	}
	public void setNgayGiaoDich(String ngayGiaoDich) {
		this.ngayGiaoDich = ngayGiaoDich;
	}
	public String getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(String thanhTien) {
		this.thanhTien = thanhTien;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
