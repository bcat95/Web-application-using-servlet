package model.bean;
/**
 * DichVuBaiDangBean
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
public class DichVuBaiDangBean {
	private String maDichVu;
	private String tenDichVu;
	public DichVuBaiDangBean(String maDichVu, String tenDichVu) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
	}
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
}
