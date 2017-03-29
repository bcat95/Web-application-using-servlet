package model.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.upload.FormFile;

import common.BussinessObject;
import model.bean.BaiDangBean;
import model.bean.HinhAnhBean;
import model.dao.BaiDangDAO;
import model.dao.DichVuDAO;

public class BaiDangBO extends BussinessObject{
	
	BaiDangDAO baiDangDAO = new BaiDangDAO();
	static HinhAnhBean hinhAnhBean = new HinhAnhBean();
	public ArrayList<BaiDangBean> getListBaiDangDanhMuc(String maDanhMuc) throws SQLException {
		return baiDangDAO.getListBaiDangDanhMuc(maDanhMuc);
	}
	public ArrayList<BaiDangBean> getListBaiDangTinhThanh(String maTinhThanh) throws SQLException {
		return baiDangDAO.getListBaiDangTinhThanh(maTinhThanh);
	}
	public ArrayList<BaiDangBean> getListBaiDangDanhMucTinhThanh(String maDanhMuc,String maTinhThanh) throws SQLException {
		return baiDangDAO.getListBaiDangDanhMucTinhThanh(maDanhMuc, maTinhThanh);
	}
	public ArrayList<BaiDangBean> getListBaiDangNoiDung(String noiDung) throws SQLException {
		return baiDangDAO.getListBaiDangNoiDung(noiDung);
	}
	public ArrayList<BaiDangBean> getListBaiDangDanhMucNoiDung(String maDanhMuc,String noiDung) throws SQLException {
		return baiDangDAO.getListBaiDangDanhMucNoiDung(maDanhMuc, noiDung);
	}
	public ArrayList<BaiDangBean> getListBaiDangTinhThanhNoiDung(String maTinhThanh,String noiDung) throws SQLException {
		return baiDangDAO.getListBaiDangTinhThanhNoiDung(maTinhThanh, noiDung);
	}
	public ArrayList<BaiDangBean> getListBaiDangDanhMucTinhThanhNoiDung(String maDanhMuc,String maTinhThanh,String noiDung) throws SQLException {
		return baiDangDAO.getListBaiDangDanhMucTinhThanhNoiDung(maDanhMuc, maTinhThanh,noiDung);
	}
	public ArrayList<BaiDangBean> getListBaiDang() throws SQLException {
		return baiDangDAO.getListBaiDang();
	}
	public static void insertBaiDang(BaiDangBean baiDang,FormFile file,ArrayList<FormFile> fileHinhAnh,String[] dichVu, ActionServlet action) 
	{
		//them anh bia
		try {
			if(file.getFileSize() != 0){
				baiDang.setAnhBia(
					"upload/img/bai-dang/" + BussinessObject.saveFile("/upload/img/bai-dang", file,"", action));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//them thong tin bai viet
		BaiDangDAO.insertBaiDang(baiDang);
		//them dich vu
		if (dichVu != null){
			DichVuDAO.insertDichVu(baiDang,dichVu);
		}
		if (fileHinhAnh.get(0).getFileSize() != 0){
			try {
				hinhAnhBean.setHinhAnh(BussinessObject.saveMultiFile("upload/img/bai-dang", fileHinhAnh, action));
				BaiDangDAO.insertHinhAnh(baiDang,hinhAnhBean);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static BaiDangBean infoBaiDang(int maBaiDang) throws SQLException, ClassNotFoundException{
		return BaiDangDAO.infobaiDang(maBaiDang);
	}

	public static BaiDangBean infoSuaBaiDang(int maBaiDang) throws SQLException, ClassNotFoundException{
		return BaiDangDAO.infoSuaBaiDang(maBaiDang);
	}
	public static void updateBaiDang(BaiDangBean baiDang, boolean anhbiaxoa, String[] hinhXoa, FormFile file, ArrayList<FormFile> fileHinhAnh,
			String[] dichVu, ActionServlet action) {
		//xoa neu xoa anh bia
		if (anhbiaxoa)  BussinessObject.deleteFile(BaiDangDAO.getAnhBiaByMa(baiDang.getMaBaiDang()),action);
		//xoa neu xoa hinh anh
		if (hinhXoa != null) BussinessObject.deleteMultiFile(hinhXoa, action);
		//update anh bia moi
		try {
			if(file.getFileSize()>0){
				BaiDangDAO.setAnhBia(baiDang.getMaBaiDang(),
					"upload/img/bai-dang/" + BussinessObject.saveFile("/upload/img/bai-dang", file,"", action));
			}
			else BaiDangDAO.setAnhBia(baiDang.getMaBaiDang(), null);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//update thong tin bai viet
		BaiDangDAO.updateBaiDang(baiDang);
		
		//them dich vu
		if (dichVu != null){
			DichVuDAO.updateDichVu(baiDang,dichVu);
		}
		
		//them anh bai viet
		if (fileHinhAnh.get(0).getFileSize() != 0){
			try {
				hinhAnhBean.setHinhAnh(BussinessObject.saveMultiFile("upload/img/bai-dang", fileHinhAnh, action));
				BaiDangDAO.insertHinhAnh(baiDang,hinhAnhBean);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public ArrayList<BaiDangBean> getListBaiDangByDM(int i) {
		return baiDangDAO.getListBaiDangByDM(i);
	}
	//danh sạh bai dang da duyet
	public ArrayList<BaiDangBean> getListBaiDangDaDuyet() {
		return baiDangDAO.getListBaiDangDaDuyet();
	}
	
	public BaiDangBean getListChiTietBaiDangDaDuyet(int maBaiDang) {
		return baiDangDAO.getListChiTietBaiDangDaDuyet(maBaiDang);
	}
	
	public BaiDangBean getListBaiDangChuaDuyet(int maBaiDang) {
		return baiDangDAO.getListBaiDangChuaDuyet(maBaiDang);
	}
	//xem chi tiet danh sạh bai dang da duyet
	public BaiDangBean getListBaiDangDaDuyet(int maBaiDang) {
		return baiDangDAO.getListBaiDangDaDuyet(maBaiDang);
	}
	//danh sạh bai dang chua duyet
	public ArrayList<BaiDangBean> getListBaiDangChuaDuyet() {
		return baiDangDAO.getListBaiDangChuaDuyet();
	}
	
	public void goBoBaiDang(int maBaiDang){
		baiDangDAO.goBoBaiDang(maBaiDang);
	}
	
	public BaiDangBean getListChiTietBaiDangChuaDuyet(int maBaiDang) {
		return baiDangDAO.getListChiTietBaiDangChuaDuyet(maBaiDang);
	}
	public void setDuyetTin(int maBaiDang) {
		baiDangDAO.setDuyetTin(maBaiDang);
	}
	public void goDuyetTin(int maBaiDang) {
		baiDangDAO.goDuyetTin(maBaiDang);
		
	}
	
	public ArrayList<BaiDangBean> getListBaiDangCungTinhThanh(int maBaiDang)  throws SQLException {
		return baiDangDAO.getListBaiDangCungTinhThanh(maBaiDang);
	}
	public ArrayList<BaiDangBean> getListBaiDangCungDanhMuc(int maBaiDang)  throws SQLException {
		return baiDangDAO.getListBaiDangCungDanhMuc(maBaiDang);
	}
	
}
