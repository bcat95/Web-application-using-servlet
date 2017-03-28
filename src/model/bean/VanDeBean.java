package model.bean;
/**
 * VanDeBean
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
 * 14-3-2017         ThinhDM            Create
 */
public class VanDeBean {
	private String maVanDe;
	private String tenVanDe;
	public VanDeBean(String maVanDe, String tenVanDe) {
		super();
		this.maVanDe = maVanDe;
		this.tenVanDe = tenVanDe;
	}
	public String getMaVanDe() {
		return maVanDe;
	}
	public void setMaVanDe(String maVanDe) {
		this.maVanDe = maVanDe;
	}
	public String getTenVanDe() {
		return tenVanDe;
	}
	public void setTenVanDe(String tenVanDe) {
		this.tenVanDe = tenVanDe;
	}
	
}

