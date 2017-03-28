package model.bean;
/**
 * AdminPanelBean
 *
 * Version 1.0
 *
 * Date: 27-3-2017
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 27-3-2017         DonNA            Create
 */

public class AdminPanelBean {
	private String cotMot;
	private int soLuong;

	public AdminPanelBean() {
		super();
	}
	public AdminPanelBean(String cotMot, int soLuong) {
		super();
		this.cotMot = cotMot;
		this.soLuong = soLuong;
	}
	
	public String getCotMot() {
		return cotMot;
	}

	public void setCotMot(String cotMot) {
		this.cotMot = cotMot;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}	
}
