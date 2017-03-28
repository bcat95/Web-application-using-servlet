package model.bean;
/**
 * LuuBDBean
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
 * 14-3-2017         VangLVD            Create
 */
public class LuuBDBean {
	private String maBaiDang;
	private String userName;
	private String ngayLuu;
	public LuuBDBean(String maBaiDang, String userName, String ngayLuu) {
		super();
		this.maBaiDang = maBaiDang;
		this.userName = userName;
		this.ngayLuu = ngayLuu;
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
	public String getNgayLuu() {
		return ngayLuu;
	}
	public void setNgayLuu(String ngayLuu) {
		this.ngayLuu = ngayLuu;
	}

}
