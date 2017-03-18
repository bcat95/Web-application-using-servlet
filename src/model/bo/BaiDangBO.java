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
			if(file != null){
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
		//them anh bai viet
		if (fileHinhAnh != null){
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
		if (fileHinhAnh != null){
			try {
				hinhAnhBean.setHinhAnh(BussinessObject.saveMultiFile("upload/img/bai-dang", fileHinhAnh, action));
				BaiDangDAO.insertHinhAnh(baiDang,hinhAnhBean);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
