package model.bean;

/**
 * HinhAnhBean
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
 * 14-3-2017         DonNA            Create
 */
public class HinhAnhBean {
	private int maHinh;
	private String tenHinh;
	private String maBaiDang;
	private String[] hinhAnh;
	
	public HinhAnhBean() {
		super();
	}
	public HinhAnhBean(int maHinh, String tenHinh, String maBaiDang, String[] hinhAnh) {
		super();
		this.maHinh = maHinh;
		this.tenHinh = tenHinh;
		this.maBaiDang = maBaiDang;
		this.hinhAnh = hinhAnh;
	}
	public int getMaHinh() {
		return maHinh;
	}
	public void setMaHinh(int maHinh) {
		this.maHinh = maHinh;
	}
	public String getTenHinh() {
		return tenHinh;
	}
	public void setTenHinh(String tenHinh) {
		this.tenHinh = tenHinh;
	}
	public String getMaBaiDang() {
		return maBaiDang;
	}
	public void setMaBaiDang(String maBaiDang) {
		this.maBaiDang = maBaiDang;
	}
	public String[] getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
}
