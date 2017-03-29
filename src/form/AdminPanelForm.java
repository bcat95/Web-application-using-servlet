package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.AdminPanelBean;
/**
 * AdminForm
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
public class AdminPanelForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<AdminPanelBean> tKBaiDang;
	private ArrayList<AdminPanelBean> tKBinhLuan;
	private ArrayList<AdminPanelBean> tKYeuThich;
	private ArrayList<AdminPanelBean> tKTaiKhoan;
	private ArrayList<AdminPanelBean> tKTinhThanh;
	private ArrayList<AdminPanelBean> tKDanhMuc;
	private int admin;
	
	
	
	public int getAdmin() {
		return admin;
	}


	public void setAdmin(int admin) {
		this.admin = admin;
	}


	public ArrayList<AdminPanelBean> gettKDanhMuc() {
		return tKDanhMuc;
	}


	public void settKDanhMuc(ArrayList<AdminPanelBean> tKDanhMuc) {
		this.tKDanhMuc = tKDanhMuc;
	}


	public ArrayList<AdminPanelBean> gettKTinhThanh() {
		return tKTinhThanh;
	}


	public void settKTinhThanh(ArrayList<AdminPanelBean> tKTinhThanh) {
		this.tKTinhThanh = tKTinhThanh;
	}


	public ArrayList<AdminPanelBean> gettKTaiKhoan() {
		return tKTaiKhoan;
	}


	public void settKTaiKhoan(ArrayList<AdminPanelBean> tKTaiKhoan) {
		this.tKTaiKhoan = tKTaiKhoan;
	}


	public ArrayList<AdminPanelBean> gettKYeuThich() {
		return tKYeuThich;
	}


	public void settKYeuThich(ArrayList<AdminPanelBean> tKYeuThich) {
		this.tKYeuThich = tKYeuThich;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public ArrayList<AdminPanelBean> gettKBaiDang() {
		return tKBaiDang;
	}


	public void settKBaiDang(ArrayList<AdminPanelBean> tKBaiDang) {
		this.tKBaiDang = tKBaiDang;
	}


	public ArrayList<AdminPanelBean> gettKBinhLuan() {
		return tKBinhLuan;
	}


	public void settKBinhLuan(ArrayList<AdminPanelBean> tKBinhLuan) {
		this.tKBinhLuan = tKBinhLuan;
	}

	/**
	 * ham reset
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try
		{
			request.setCharacterEncoding("UTF-8");
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		super.reset(mapping, request);
	}
}
