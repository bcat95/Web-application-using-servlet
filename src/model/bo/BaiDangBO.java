package model.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.upload.FormFile;

import common.BussinessObject;
import model.bean.BaiDangBean;
import model.bean.HinhAnhBean;
import model.bean.User;
import model.dao.BaiDangDAO;

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
			
			if(file.getFileSize() > 0){
				baiDang.setAnhBia(
					"upload/img/" + BussinessObject.saveFile("/upload/img", file,"", action));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//them thong tin bai viet
		BaiDangDAO.insertBaiDang(baiDang);
		//them dich vu
		if (dichVu != null){
			BaiDangDAO.insertDichVu(baiDang,dichVu);
		}
		//them anh bai viet
		if (fileHinhAnh != null){
			try {
				hinhAnhBean.setHinhAnh(BussinessObject.saveMultiFile("upload/img", fileHinhAnh, action));
				BaiDangDAO.insertHinhAnh(baiDang,hinhAnhBean);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	public static BaiDangBean infoBaiDang(int maBaiDang) throws SQLException, ClassNotFoundException{
			return BaiDangDAO.infobaiDang(maBaiDang);
	}
	public ArrayList<BaiDangBean> danhSachBaiDang(User user){
		return baiDangDAO.danhSachBaiDang(user);
	}
	
/*	public static BaiDangBean editBaiDang(int maBaiDang) {
		return BaiDangDAO.editBaiDang(maBaiDang);
	}*/
	
}
