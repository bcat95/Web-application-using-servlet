package model.bean;
/**
 * TinhThanhBean
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
public class TinhThanhBean {
	private int maTinhThanh;
	private String tenTinhThanh;
	
	
	public TinhThanhBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TinhThanhBean(int maTinhThanh, String tenTinhThanh) {
		super();
		this.maTinhThanh = maTinhThanh;
		this.tenTinhThanh = tenTinhThanh;
	}

	public int getMaTinhThanh() {
		return maTinhThanh;
	}

	public void setMaTinhThanh(int maTinhThanh) {
		this.maTinhThanh = maTinhThanh;
	}

	public String getTenTinhThanh() {
		return tenTinhThanh;
	}

	public void setTenTinhThanh(String tenTinhThanh) {
		this.tenTinhThanh = tenTinhThanh;
	}
	
	
}
