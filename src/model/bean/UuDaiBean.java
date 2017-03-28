package model.bean;
/**
 * UuDaiBean
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
public class UuDaiBean {
	private String maUuDai;
	private String tenUuDai;
	private String thoiHanUuDai;
	private String maLoaiTK;
	
	public UuDaiBean(String maUuDai, String tenUuDai, String thoiHanUuDai, String maLoaiTK) {
		super();
		this.maUuDai = maUuDai;
		this.tenUuDai = tenUuDai;
		this.thoiHanUuDai = thoiHanUuDai;
		this.maLoaiTK = maLoaiTK;
	}
	public String getMaUuDai() {
		return maUuDai;
	}
	public void setMaUuDai(String maUuDai) {
		this.maUuDai = maUuDai;
	}
	public String getTenUuDai() {
		return tenUuDai;
	}
	public void setTenUuDai(String tenUuDai) {
		this.tenUuDai = tenUuDai;
	}
	public String getThoiHanUuDai() {
		return thoiHanUuDai;
	}
	public void setThoiHanUuDai(String thoiHanUuDai) {
		this.thoiHanUuDai = thoiHanUuDai;
	}
	public String getMaLoaiTK() {
		return maLoaiTK;
	}
	public void setMaLoaiTK(String maLoaiTK) {
		this.maLoaiTK = maLoaiTK;
	}
	
}
