package model.bean;
/**
 * DichVuBean
 *
 * Version 1.0
 *
 * Date: Mars 10, 2017
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * Mars 10, 2017        	DonNA          Create
 */
public class DichVuBean {
	private int maDichVu;
	private String tenDichVu;
	
	
	public DichVuBean() {
		super();
	}
	public DichVuBean(int maDichVu, String tenDichVu) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
	}
	public int getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(int maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}	
}
