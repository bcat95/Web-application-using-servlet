package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;
import model.bean.KhuyenMaiBean;

/**
 * KhuyenMaiForm
 *
 * Version 1.0
 *
 * Date: 23-3-2017
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 23-3-2017         DonNA            Create
 */
public class KhuyenMaiForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maKhuyenMai;
	private String tieuDe;
	private String noiDung;
	private String ngayBatDau;
	private String ngayKetThuc;
	private int maBaiDang;
	private ArrayList<KhuyenMaiBean> listKhuyenMai;
	private String submit;
	
	
	
	/**
	 * Ham get thuoc tinh Khuyen Mai
	 * @return
	 */
	public KhuyenMaiBean getKhuyenMai() {
		return new KhuyenMaiBean(maKhuyenMai,tieuDe,noiDung,ngayBatDau,ngayKetThuc,maBaiDang);
	}
	public int getMaKhuyenMai() {
		return maKhuyenMai;
	}
	public void setMaKhuyenMai(int maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
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
	public String getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public String getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public int getMaBaiDang() {
		return maBaiDang;
	}
	public void setMaBaiDang(int maBaiDang) {
		this.maBaiDang = maBaiDang;
	}
	public ArrayList<KhuyenMaiBean> getListKhuyenMai() {
		return listKhuyenMai;
	}
	public void setListKhuyenMai(ArrayList<KhuyenMaiBean> listKhuyenMai) {
		this.listKhuyenMai = listKhuyenMai;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
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
	
	/**
	 * Ham kiem tra hop le truoc khi them vao CSDL
	 * @param mapping
	 * @param request
	 * @return
	 */
	public ActionErrors validateBaiDang(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors =new ActionErrors();
		if (StringProcess.equals(submit, "dangTin")){
			if (StringProcess.checkRong(tieuDe)){
				errors.add("tieuDeError",new ActionMessage("err.tieude.trong"));
			}
			if (StringProcess.checkRong(noiDung)){
				errors.add("noiDungError",new ActionMessage("err.noidung.trong"));
			}
		}
		return errors;
	}
}
