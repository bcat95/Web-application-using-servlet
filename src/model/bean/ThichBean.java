package model.bean;

/**
 * ThichBean
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

public class ThichBean {
	private String maBaiDang;
	private String userName;
	private String ngayThich;

	
	public ThichBean() {
		super();
	}
	public ThichBean(String maBaiDang, String userName, String ngayThich) {
		super();
		this.maBaiDang = maBaiDang;
		this.userName = userName;
		this.ngayThich = ngayThich;
	}
	public String getMaBaiDang() {
		return maBaiDang;
	}
	public void setMaBaiDang(String maBaiDang) {
		this.maBaiDang = maBaiDang;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNgayThich() {
		return ngayThich;
	}
	public void setNgayThich(String ngayThich) {
		this.ngayThich = ngayThich;
	}
	
}
