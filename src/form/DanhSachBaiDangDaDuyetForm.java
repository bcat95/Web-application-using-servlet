package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.BaiDangBean;
/**
 * DanhMucForm
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
public class DanhSachBaiDangDaDuyetForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sTT;
	private int maBaiDang; 
	private String tieuDe;
	private int maDanhMuc;
	private String ngayDang;
	private ArrayList<BaiDangBean> listBaiDang;

	private String noiDung;
	private String anhBia;
	private String diaChi;
	private String diaChiWeb;
	private String viDo;
	private String kinhDo;
	private String sDT;
	private int giaCaoNhat;
	private int giaThapNhat;
	private String ngayHetHan;
	
	
	private int soLuongTruyCap;
	private int soLuotThich;
	private int maLoaiTin;
	private String userName;

	private int maTinhThanh;
	private String tenDanhMuc;
	private String tenTinhThanh;
	private String tenLoaiTin;
	private String submit;
	private boolean duyetTin;
	private boolean goDuyetTin;
	
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}


	public boolean isGoDuyetTin() {
		return goDuyetTin;
	}
	public void setGoDuyetTin(boolean goDuyetTin) {
		this.goDuyetTin = goDuyetTin;
	}
	public boolean isDuyetTin() {
		return duyetTin;
	}
	public void setDuyetTin(boolean duyetTin) {
		this.duyetTin = duyetTin;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	private int diemDanhGia;
	
	public int getsTT() {
		return sTT;
	}
	public void setsTT(int sTT) {
		this.sTT = sTT;
	}
	public int getDiemDanhGia() {
		return diemDanhGia;
	}
	public void setDiemDanhGia(int diemDanhGia) {
		this.diemDanhGia = diemDanhGia;
	}
	public int getMaBaiDang() {
		return maBaiDang;
	}
	public void setMaBaiDang(int maBaiDang) {
		this.maBaiDang = maBaiDang;
	}
	public String getViDo() {
		return viDo;
	}
	public void setViDo(String viDo) {
		this.viDo = viDo;
	}
	public String getTieuDe() {
		return tieuDe;
	}
	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}
	public int getMaDanhMuc() {
		return maDanhMuc;
	}
	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
	public String getNgayDang() {
		return ngayDang;
	}
	public void setNgayDang(String ngayDang) {
		this.ngayDang = ngayDang;
	}
	public ArrayList<BaiDangBean> getListBaiDang() {
		return listBaiDang;
	}
	public void setListBaiDang(ArrayList<BaiDangBean> listBaiDang) {
		this.listBaiDang = listBaiDang;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getAnhBia() {
		return anhBia;
	}
	public void setAnhBia(String anhBia) {
		this.anhBia = anhBia;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDiaChiWeb() {
		return diaChiWeb;
	}
	public void setDiaChiWeb(String diaChiWeb) {
		this.diaChiWeb = diaChiWeb;
	}

	public String getKinhDo() {
		return kinhDo;
	}
	public void setKinhDo(String kinhDo) {
		this.kinhDo = kinhDo;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	public int getGiaCaoNhat() {
		return giaCaoNhat;
	}
	public void setGiaCaoNhat(int giaCaoNhat) {
		this.giaCaoNhat = giaCaoNhat;
	}
	public int getGiaThapNhat() {
		return giaThapNhat;
	}
	public void setGiaThapNhat(int giaThapNhat) {
		this.giaThapNhat = giaThapNhat;
	}
	public String getNgayHetHan() {
		return ngayHetHan;
	}
	public void setNgayHetHan(String ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	public int getSoLuongTruyCap() {
		return soLuongTruyCap;
	}
	public void setSoLuongTruyCap(int soLuongTruyCap) {
		this.soLuongTruyCap = soLuongTruyCap;
	}
	public int getSoLuotThich() {
		return soLuotThich;
	}
	public void setSoLuotThich(int soLuotThich) {
		this.soLuotThich = soLuotThich;
	}
	public int getMaLoaiTin() {
		return maLoaiTin;
	}
	public void setMaLoaiTin(int maLoaiTin) {
		this.maLoaiTin = maLoaiTin;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getMaTinhThanh() {
		return maTinhThanh;
	}
	public void setMaTinhThanh(int maTinhThanh) {
		this.maTinhThanh = maTinhThanh;
	}
	
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
	public String getTenTinhThanh() {
		return tenTinhThanh;
	}
	public void setTenTinhThanh(String tenTinhThanh) {
		this.tenTinhThanh = tenTinhThanh;
	}
	public String getTenLoaiTin() {
		return tenLoaiTin;
	}
	public void setTenLoaiTin(String tenLoaiTin) {
		this.tenLoaiTin = tenLoaiTin;
	}
	
	/**
	 * Ham set thuoc tinh bai dang da duyet
	 * @param item
	 */
	public void setBaiDangDaDuyet(BaiDangBean item)
	{
		this.maBaiDang= item.getMaBaiDang();
		this.tieuDe = item.getTieuDe();
		this.noiDung = item.getNoiDung();
		this.anhBia= item.getAnhBia();
		this.diaChi = item.getDiaChi();
		this.diaChiWeb = item.getDiaChiWeb();
		this.sDT = item.getsDT();
		this.ngayDang= item.getNgayDang().toString();
		//this.ngayHetHan= item.getNgayHetHan().toString();
		this.giaCaoNhat = item.getGiaCaoNhat();
		this.giaThapNhat = item.getGiaThapNhat();
		this.userName = item.getUserName();
		this.tenDanhMuc = item.getTenDanhMuc();
		this.tenTinhThanh = item.getTenTinhThanh();
		this.tenLoaiTin= item.getTenLoaiTin();
	}
}
