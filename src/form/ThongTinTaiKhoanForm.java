package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;
import model.bean.BaiDangBean;
import model.bean.TaiKhoanBean;
/**
 * ThongTinTaiKhoanForm
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
public class ThongTinTaiKhoanForm  extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String eMail;
	private String submit;
	private String passCu;
	private String passMoi;
	private String passMoiXN;
	private ArrayList<BaiDangBean> listBaiDang;
	private ArrayList<BaiDangBean> listYeuThich;
	private ArrayList<TaiKhoanBean> listTaiKhoan;
	

	public ArrayList<BaiDangBean> getListYeuThich() {
		return listYeuThich;
	}
	public void setListYeuThich(ArrayList<BaiDangBean> listYeuThich) {
		this.listYeuThich = listYeuThich;
	}
	public ArrayList<BaiDangBean> getListBaiDang() {
		return listBaiDang;
	}
	public void setListBaiDang(ArrayList<BaiDangBean> listBaiDang) {
		this.listBaiDang = listBaiDang;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassCu() {
		return passCu;
	}
	public void setPassCu(String passCu) {
		this.passCu = passCu;
	}
	public String getPassMoi() {
		return passMoi;
	}
	public void setPassMoi(String passMoi) {
		this.passMoi = passMoi;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
	public String getPassMoiXN() {
		return passMoiXN;
	}
	public void setPassMoiXN(String passMoiXN) {
		this.passMoiXN = passMoiXN;
	}

	public ArrayList<TaiKhoanBean> getListTaiKhoan() {
		return listTaiKhoan;
	}
	public void setListTaiKhoan(ArrayList<TaiKhoanBean> listTaiKhoan) {
		this.listTaiKhoan = listTaiKhoan;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ham kiem tra hop le cac thuoc tinh truoc khi them vao CSDL
	 * @param mapping
	 * @param request
	 * @return
	 */
	public ActionErrors validateBaiDang(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors =new ActionErrors();
		if (StringProcess.equals(submit, "CapNhapPass")){
			
			if (StringProcess.checkRong(passCu)){
				errors.add("passCuError",new ActionMessage("err.passCu.trong"));
			}
			if (StringProcess.checkRong(passMoi)){
				errors.add("passMoiError",new ActionMessage("err.passMoi.trong"));
			}
			if (StringProcess.checkRong(passMoiXN)){
				errors.add("passMoiXNError",new ActionMessage("err.passMoiXN.trong"));
			}
		}
		return errors;
	}
}
