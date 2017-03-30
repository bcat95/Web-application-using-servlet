package form;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.LienHe;
import model.bean.VanDe;
/**
 * DanhSachLienHeForm
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
public class DanhSachLienHeForm extends ActionForm{
	private String maVanDe;
	private String tim;
	private ArrayList<VanDe> listVanDe;
	private ArrayList<LienHe> listLienHe;
	
	public String getMaVanDe() {
		return maVanDe;
	}
	public void setMaVanDe(String maVanDe) {
		this.maVanDe = maVanDe;
	}
	public String getTim() {
		return tim;
	}
	public void setTim(String tim) {
		byte[] bytes = tim.getBytes(StandardCharsets.ISO_8859_1);
        tim = new String(bytes, StandardCharsets.UTF_8);
		this.tim = tim;
	}
	public ArrayList<VanDe> getListVanDe() {
		return listVanDe;
	}
	public void setListVanDe(ArrayList<VanDe> listVanDe) {
		this.listVanDe = listVanDe;
	}
	public ArrayList<LienHe> getListLienHe() {
		return listLienHe;
	}
	public void setListLienHe(ArrayList<LienHe> listLienHe) {
		this.listLienHe = listLienHe;
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
