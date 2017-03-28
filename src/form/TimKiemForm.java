package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.BaiDangBean;
import model.bean.DanhMucBean;
import model.bean.TinhThanhBean;

/**
 * TimKiemForm
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
 * 14-3-2017         AnNBH            Create
 */
public class TimKiemForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;
	
	private String maDanhMuc;
	private String tenDanhMuc;
	private ArrayList<DanhMucBean> listDanhMuc;
	private String maTinhThanh;
	private String tenTinhThanh;
	private ArrayList<TinhThanhBean> listTinhThanh;
	private String noiDung;
	private ArrayList<BaiDangBean> listBaiDang;
	
	public TimKiemForm() {
		// TODO Auto-generated constructor stub
	}

	public String getMaDanhMuc() {
		return maDanhMuc;
	}
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
	public ArrayList<DanhMucBean> getListDanhMuc() {
		return listDanhMuc;
	}
	public void setListDanhMuc(ArrayList<DanhMucBean> listDanhMuc) {
		this.listDanhMuc = listDanhMuc;
	}

	public String getMaTinhThanh() {
		return maTinhThanh;
	}

	public void setMaTinhThanh(String maTinhThanh) {
		this.maTinhThanh = maTinhThanh;
	}

	public String getTenTinhThanh() {
		return tenTinhThanh;
	}

	public void setTenTinhThanh(String tenTinhThanh) {
		this.tenTinhThanh = tenTinhThanh;
	}

	public ArrayList<TinhThanhBean> getListTinhThanh() {
		return listTinhThanh;
	}

	public void setListTinhThanh(ArrayList<TinhThanhBean> listTinhThanh) {
		this.listTinhThanh = listTinhThanh;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public ArrayList<BaiDangBean> getListBaiDang() {
		return listBaiDang;
	}

	public void setListBaiDang(ArrayList<BaiDangBean> listBaiDang) {
		this.listBaiDang = listBaiDang;
	}

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
