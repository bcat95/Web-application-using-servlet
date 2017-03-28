package form;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.BaiDangBean;
import model.bean.BinhLuanBean;
import model.bean.DanhMucBean;
import model.bean.DichVuBean;
import model.bean.HinhAnhBean;
import model.bean.KhuyenMaiBean;
import model.bean.TinhThanhBean;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import common.StringProcess;
/**
 * BaiDangForm
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
 * 14-3-2017         DonNA            Create
 */
public class BaiDangForm  extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maBaiDang;
	private int maLoaiTin;
	private String tieuDe;
	private String anhBia;
	private boolean anhBiaXoa;
	private String noiDung;
	private String diaChi;
	private String diaChiWeb;
	private String viDo;
	private String kinhDo;
	private String sDT;
	private int giaCaoNhat;
	private int giaThapNhat;
	private Date ngayDang;
	private String ngayHetHan;
	private FormFile fileAnhBia;
	
	private ArrayList<KhuyenMaiBean> listKhuyenMai;
	
	private String userName;
	private boolean yeuThich;
	private boolean setThich;
	
	private int maDanhMuc;
	private String tenDanhMuc;
	private ArrayList<DanhMucBean> listDanhMuc;
	
	private int maTinhThanh;
	private String tenTinhThanh;
	private ArrayList<TinhThanhBean> listTinhThanh;
	
	private float diemDanhGia;
	
	private String[] dichVu;
	private ArrayList<DichVuBean> listDichVu;
	private ArrayList<DichVuBean> listDichVuSua;
	
	private ArrayList<FormFile> fileHinhAnh;
	private ArrayList<HinhAnhBean> listHinhAnh;
	private String[] hinhXoa;
	//binh luan
	private int bl_maBinhLuan;
	private String bl_userName;
	private String bl_tieuDe;
	private String bl_noiDung;
	private Date bl_ngayBinhLuan;
	private int bl_diemDanhGia;
	private ArrayList<BinhLuanBean> listBinhLuan;
	
	private String submit;
	private SimpleDateFormat sdf;
	
	private ArrayList<BaiDangBean> listBaiDang;
	private ArrayList<BaiDangBean> listBaiDangDanhMuc;
	
	/**
	 * ngay
	 */
	public SimpleDateFormat getSdf()
	{
		if(sdf == null)
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf;
	}

	public boolean isAnhBiaXoa() {
		return anhBiaXoa;
	}

	public int getMaLoaiTin() {
		return maLoaiTin;
	}

	public void setMaLoaiTin(int maLoaiTin) {
		this.maLoaiTin = maLoaiTin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	public ArrayList<KhuyenMaiBean> getListKhuyenMai() {
		return listKhuyenMai;
	}

	public void setListKhuyenMai(ArrayList<KhuyenMaiBean> listKhuyenMai) {
		this.listKhuyenMai = listKhuyenMai;
	}

	public float getDiemDanhGia() {
		return diemDanhGia;
	}

	public void setDiemDanhGia(float diemDanhGia) {
		this.diemDanhGia = diemDanhGia;
	}

	public ArrayList<FormFile> getFileHinhAnh() {
		return fileHinhAnh;
	}
	public void setFileHinhAnh(ArrayList<FormFile> fileHinhAnh) {
		this.fileHinhAnh = fileHinhAnh;
	}

	public void setAnhBiaXoa(boolean anhBiaXoa) {
		this.anhBiaXoa = anhBiaXoa;
	}

	
	public String[] getHinhXoa() {
		return hinhXoa;
	}

	public void setHinhXoa(String[] hinhXoa) {
		this.hinhXoa = hinhXoa;
	}

	public ArrayList<DichVuBean> getListDichVuSua() {
		return listDichVuSua;
	}

	public void setListDichVuSua(ArrayList<DichVuBean> listDichVuSua) {
		this.listDichVuSua = listDichVuSua;
	}

	public ArrayList<BinhLuanBean> getListBinhLuan() {
		return listBinhLuan;
	}

	public void setListBinhLuan(ArrayList<BinhLuanBean> listBinhLuan) {
		this.listBinhLuan = listBinhLuan;
	}

	public int getBl_diemDanhGia() {
		return bl_diemDanhGia;
	}

	public void setBl_diemDanhGia(int bl_diemDanhGia) {
		this.bl_diemDanhGia = bl_diemDanhGia;
	}

	public int getBl_maBinhLuan() {
		return bl_maBinhLuan;
	}

	public void setBl_maBinhLuan(int bl_maBinhLuan) {
		this.bl_maBinhLuan = bl_maBinhLuan;
	}


	public String getBl_userName() {
		return bl_userName;
	}

	public void setBl_userName(String bl_userName) {
		this.bl_userName = bl_userName;
	}

	public String getBl_tieuDe() {
		return bl_tieuDe;
	}

	public void setBl_tieuDe(String bl_tieuDe) {
		this.bl_tieuDe = bl_tieuDe;
	}

	public String getBl_noiDung() {
		return bl_noiDung;
	}

	public void setBl_noiDung(String bl_noiDung) {
		this.bl_noiDung = bl_noiDung;
	}

	public Date getBl_ngayBinhLuan() {
		return bl_ngayBinhLuan;
	}

	public void setBl_ngayBinhLuan(Date bl_ngayBinhLuan) {
		this.bl_ngayBinhLuan = bl_ngayBinhLuan;
	}

	public boolean isYeuThich() {
		return yeuThich;
	}
	
	public void setYeuThich(boolean yeuThich) {
		this.yeuThich = yeuThich;
	}
	
	public String getTenTinhThanh() {
		return tenTinhThanh;
	}
	
	public void setTenTinhThanh(String tenTinhThanh) {
		this.tenTinhThanh = tenTinhThanh;
	}
	
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	
	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
	
	public ArrayList<HinhAnhBean> getListHinhAnh() {
		return listHinhAnh;
	}
	
	public void setListHinhAnh(ArrayList<HinhAnhBean> listHinhAnh) {
		this.listHinhAnh = listHinhAnh;
	}
	
	public int getMaBaiDang() {
		return maBaiDang;
	}
	public void setMaBaiDang(int maBaiDang) {
		this.maBaiDang = maBaiDang;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String[] getDichVu() {
		return dichVu;
	}

	public void setDichVu(String[] dichVu) {
		this.dichVu = dichVu;
	}

	public ArrayList<DichVuBean> getListDichVu() {
		return listDichVu;
	}

	public void setListDichVu(ArrayList<DichVuBean> listDichVu) {
		this.listDichVu = listDichVu;
	}
	
	public FormFile getFileAnhBia() {
		return fileAnhBia;
	}

	public void setFileAnhBia(FormFile fileAnhBia) {
		this.fileAnhBia = fileAnhBia;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
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
	
	public String getViDo() {
		return viDo;
	}

	public void setViDo(String viDo) {
		this.viDo = viDo;
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

	public Date getNgayDangDate() 
	{
		Date date=new Date();
		String str= getSdf().format(date);
		
		Date currentDate=null;
		try {
			currentDate = getSdf().parse(str);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return currentDate;
	}
	public Date getNgayDang() {
		return ngayDang;
	}

	public void setNgayDang(Date ngayDang) {
		this.ngayDang = ngayDang;
	}
	
	public String getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(String ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public String getAnhBia() {
		return anhBia;
	}

	public void setAnhBia(String anhBia) {
		this.anhBia = anhBia;
	}

	public int getMaTinhThanh() {
		return maTinhThanh;
	}

	public void setMaTinhThanh(int maTinhThanh) {
		this.maTinhThanh = maTinhThanh;
	}

	public ArrayList<TinhThanhBean> getListTinhThanh() {
		return listTinhThanh;
	}

	public void setListTinhThanh(ArrayList<TinhThanhBean> listTinhThanh) {
		this.listTinhThanh = listTinhThanh;
	}

	public ArrayList<DanhMucBean> getListDanhMuc() {
		return listDanhMuc;
	}

	public void setListDanhMuc(ArrayList<DanhMucBean> listDanhMuc) {
		this.listDanhMuc = listDanhMuc;
	}

	public int getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
	/**
	 * ham set thuoc tinh bai dang khi xem bai dang
	 * @param itemBD
	 */
	public void setXemBaiDang(BaiDangBean itemBD) {
		//this.set
		this.maBaiDang = itemBD.getMaBaiDang();
		this.maLoaiTin=itemBD.getMaLoaiTin();
		this.tieuDe = itemBD.getTieuDe();
		this.noiDung = itemBD.getNoiDung();
		this.anhBia=itemBD.getAnhBia();
		this.diaChi = itemBD.getDiaChi();
		this.diaChiWeb = itemBD.getDiaChiWeb();
		this.viDo = itemBD.getViDo();
		this.kinhDo = itemBD.getKinhDo();
		this.sDT = itemBD.getsDT();
		this.giaCaoNhat = itemBD.getGiaCaoNhat();
		this.giaThapNhat = itemBD.getGiaThapNhat();
		this.ngayDang=itemBD.getNgayDang();
		this.userName = itemBD.getUserName();
		this.maDanhMuc = itemBD.getMaDanhMuc();
		this.tenDanhMuc=itemBD.getTenDanhMuc();
		this.maTinhThanh = itemBD.getMaTinhThanh();
		this.tenTinhThanh=itemBD.getTenTinhThanh();
		this.diemDanhGia=itemBD.getDiemDanhGia();
		this.listHinhAnh=itemBD.getListHinhAnh();
		this.listDichVu=itemBD.getListDichVu();
		this.listBinhLuan=itemBD.getListBinhLuan();
		this.listKhuyenMai=itemBD.getListKhuyenMai();
	}
	

	/**
	 * ham set thuoc tinh bai dang khi them bai dang
	 * @param item
	 */
	public void setBaiDang(BaiDangBean item)
	{
		this.maBaiDang = item.getMaBaiDang();
		this.tieuDe = item.getTieuDe();
		this.noiDung = item.getNoiDung();
		this.diaChi = item.getDiaChi();
		this.diaChiWeb = item.getDiaChiWeb();
		this.viDo = item.getViDo();
		this.kinhDo = item.getKinhDo();
		this.sDT = item.getsDT();
		this.giaCaoNhat = item.getGiaCaoNhat();
		this.giaThapNhat = item.getGiaThapNhat();
		this.userName = item.getUserName();
		this.maDanhMuc = item.getMaDanhMuc();
		this.maTinhThanh = item.getMaTinhThanh();
		this.ngayDang=item.getNgayDang();
	}
	
	/**
	 * ham set thuoc tinh bai dang khi sua bai dang
	 * @param item
	 */
	public void setSuaBaiDang(BaiDangBean item) {
		this.maBaiDang = item.getMaBaiDang();
		this.maLoaiTin=item.getMaLoaiTin();
		this.tieuDe = item.getTieuDe();
		this.noiDung = item.getNoiDung();
		this.diaChi = item.getDiaChi();
		this.diaChiWeb = item.getDiaChiWeb();
		this.viDo = item.getViDo();
		this.kinhDo = item.getKinhDo();
		this.sDT = item.getsDT();
		this.giaCaoNhat = item.getGiaCaoNhat();
		this.giaThapNhat = item.getGiaThapNhat();
		this.userName = item.getUserName();
		this.maDanhMuc = item.getMaDanhMuc();
		this.maTinhThanh = item.getMaTinhThanh();
		this.listDichVuSua=item.getListDichVu();
		this.listHinhAnh=item.getListHinhAnh();
		this.anhBia=item.getAnhBia();
		this.listHinhAnh=item.getListHinhAnh();
	}
	
	/**
	 * ham get thuoc tinh bai dang 
	 * @return
	 */
	public BaiDangBean getBaiDang() {
		return new BaiDangBean(maBaiDang,tieuDe,noiDung,diaChi,diaChiWeb,viDo,kinhDo,sDT,giaCaoNhat,giaThapNhat,getNgayDangDate(),userName,maDanhMuc,maTinhThanh);
	}
	
	/**
	 * ham set thuoc tinh binh luan
	 * @param item
	 */
	public void setBinhLuan(BinhLuanBean item)
	{
		this.bl_maBinhLuan=item.getMaBinhLuan();
		this.maBaiDang = item.getMaBaiDang();
		this.bl_tieuDe = item.getTieuDe();
		this.bl_noiDung = item.getNoiDung();
		this.bl_ngayBinhLuan=item.getNgayBinhLuan();
		this.bl_userName = item.getUserName();
		this.bl_diemDanhGia=item.getDiemDanhGia();
	}
	
	/**
	 * ham get thuoc tinh binh luan 	
	 * @return
	 */
	public BinhLuanBean getBinhLuan() {
		return new BinhLuanBean(bl_maBinhLuan,maBaiDang,bl_userName,bl_tieuDe,bl_noiDung,bl_ngayBinhLuan,bl_diemDanhGia);
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
	public ActionErrors validateBaiDang(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors =new ActionErrors();
		if (StringProcess.equals(submit, "dangTin")){
			if (StringProcess.checkRong(tieuDe)){
				errors.add("tieuDeError",new ActionMessage("err.tieude.trong"));
			}
			if (StringProcess.checkRong(diaChi)){
				errors.add("diaChiError",new ActionMessage("err.diachi.trong"));
			}
			if (StringProcess.checkRong(noiDung)){
				errors.add("noiDungError",new ActionMessage("err.noidung.trong"));
			}
		}
		return errors;
	}

	public boolean isSetThich() {
		return setThich;
	}

	public void setSetThich(boolean setThich) {
		this.setThich = setThich;
	}

	public ArrayList<BaiDangBean> getListBaiDang() {
		return listBaiDang;
	}

	public void setListBaiDang(ArrayList<BaiDangBean> listBaiDang) {
		this.listBaiDang = listBaiDang;
	}

	public ArrayList<BaiDangBean> getListBaiDangDanhMuc() {
		return listBaiDangDanhMuc;
	}

	public void setListBaiDangDanhMuc(ArrayList<BaiDangBean> listBaiDangDanhMuc) {
		this.listBaiDangDanhMuc = listBaiDangDanhMuc;
	}
	
}
