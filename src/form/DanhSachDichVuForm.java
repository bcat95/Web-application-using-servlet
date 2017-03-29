package form;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;
import model.bean.DanhMucBean;
import model.bean.DichVuBean;

/**
 * DanhSachTaiKhoanForm
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
public class DanhSachDichVuForm extends ActionForm{
	private int maDichVu;
	private String tenDichVu;
	private ArrayList<DichVuBean> listDichVu;
	private String submit;
	public int getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(int maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		byte[] bytes = tenDichVu.getBytes(StandardCharsets.ISO_8859_1); // tieng Viet
		tenDichVu = new String(bytes, StandardCharsets.UTF_8);
		this.tenDichVu = tenDichVu;
	}
	
	public ArrayList<DichVuBean> getListDichVu() {
		return listDichVu;
	}
	public void setListDichVu(ArrayList<DichVuBean> listDichVu) {
		this.listDichVu = listDichVu;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
}
