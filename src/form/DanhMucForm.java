package form;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.DanhMucBean;

public class DanhMucForm  extends ActionForm{
	private int maDanhMuc;
	private String tenDanhMuc;
	private ArrayList<DanhMucBean> listDanhMuc;
	private String submit;
	
	private static final long serialVersionUID = 1L;
	public DanhMucForm() {
		// TODO Auto-generated constructor stub
	}

	public int getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		byte[] bytes = tenDanhMuc.getBytes(StandardCharsets.ISO_8859_1);
		tenDanhMuc = new String(bytes, StandardCharsets.UTF_8);
		this.tenDanhMuc = tenDanhMuc;
	}

	public ArrayList<DanhMucBean> getListDanhMuc() {
		return listDanhMuc;
	}

	public void setListDanhMuc(ArrayList<DanhMucBean> listDanhMuc) {
		this.listDanhMuc = listDanhMuc;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
}
