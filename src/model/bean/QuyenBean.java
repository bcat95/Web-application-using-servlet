package model.bean;

/**
 * QuyenBean
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
public class QuyenBean {
	private String maQuyen;
	private String tenQuyen;
	public QuyenBean() {
		super();
	}
	public QuyenBean(String maQuyen, String tenQuyen) {
		super();
		this.maQuyen = maQuyen;
		this.tenQuyen = tenQuyen;
	}
	public String getMaQuyen() {
		return maQuyen;
	}
	public void setMaQuyen(String maQuyen) {
		this.maQuyen = maQuyen;
	}
	public String getTenQuyen() {
		return tenQuyen;
	}
	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}
	
	
}
