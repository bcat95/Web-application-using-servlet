package form;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.LienHe;
import model.bean.VanDe;

/**
 * LienHeForm
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
public class LienHeForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maLienHe;
	private String tieuDe;
	private String noiDung;
	private String ngayGui;
	private String soDT;
	private String email;
	private boolean daGiaiQuyet;
	private int maVanDe;
	private String action;
	private ArrayList<VanDe> listVanDe;
	private String submit;
	private LienHe lienHe;
	private String tenVanDe;
	
	public boolean isDaGiaiQuyet() {
		return daGiaiQuyet;
	}
	public void setDaGiaiQuyet(boolean daGiaiQuyet) {
		this.daGiaiQuyet = daGiaiQuyet;
	}
	public String getTenVanDe() {
		return tenVanDe;
	}
	public void setTenVanDe(String tenVanDe) {
		this.tenVanDe = tenVanDe;
	}
	public int getMaLienHe() {
		return maLienHe;
	}
	public void setMaLienHe(int maLienHe) {
		this.maLienHe = maLienHe;
	}
	public String getTieuDe() {
		return tieuDe;
	}
	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getNgayGui() {
		return ngayGui;
	}
	public void setNgayGui(String ngayGui) {
		this.ngayGui = ngayGui;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMaVanDe() {
		return maVanDe;
	}
	public void setMaVanDe(int maVanDe) {
		this.maVanDe = maVanDe;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public ArrayList<VanDe> getListVanDe() {
		return listVanDe;
	}
	public void setListVanDe(ArrayList<VanDe> listVanDe) {
		this.listVanDe = listVanDe;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public LienHe getLienHe() {
		return lienHe;
	}
	public void setLienHe(LienHe lienHe) {
		this.lienHe = lienHe;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
