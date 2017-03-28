package model.bean;
/**
 * LoaiTKUuDaiBean
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
public class LoaiTKUuDaiBean {
	private String maLoaiTK;
	private String maUuDai;
	
	
	public LoaiTKUuDaiBean(String maLoaiTK, String maUuDai) {
		super();
		this.maLoaiTK = maLoaiTK;
		this.maUuDai = maUuDai;
	}
	public String getMaLoaiTK() {
		return maLoaiTK;
	}
	public void setMaLoaiTK(String maLoaiTK) {
		this.maLoaiTK = maLoaiTK;
	}
	public String getMaUuDai() {
		return maUuDai;
	}
	public void setMaUuDai(String maUuDai) {
		this.maUuDai = maUuDai;
	}
	
	
}
