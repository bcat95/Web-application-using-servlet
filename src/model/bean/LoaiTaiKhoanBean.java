package model.bean;

/**
 * LoaiTaiKhoanBean
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
public class LoaiTaiKhoanBean {
	private int maLoaiTaiKhoan;
	private String tenLoaiTaiKhoan;
	
	
	public LoaiTaiKhoanBean() {
		super();
	}

	

	public LoaiTaiKhoanBean(int maLoaiTaiKhoan, String tenLoaiTaiKhoan) {
		super();
		this.maLoaiTaiKhoan = maLoaiTaiKhoan;
		this.tenLoaiTaiKhoan = tenLoaiTaiKhoan;
	}



	public int getMaLoaiTaiKhoan() {
		return maLoaiTaiKhoan;
	}



	public void setMaLoaiTaiKhoan(int maLoaiTaiKhoan) {
		this.maLoaiTaiKhoan = maLoaiTaiKhoan;
	}



	public String getTenLoaiTaiKhoan() {
		return tenLoaiTaiKhoan;
	}



	public void setTenLoaiTaiKhoan(String tenLoaiTaiKhoan) {
		this.tenLoaiTaiKhoan = tenLoaiTaiKhoan;
	}
	
	
}
