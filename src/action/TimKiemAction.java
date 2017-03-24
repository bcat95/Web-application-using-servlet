package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaiDangBean;
import model.bean.DanhMucBean;
import model.bean.TinhThanhBean;
import model.bo.BaiDangBO;
import model.bo.DanhMucBO;
import model.bo.TinhThanhBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.TimKiemForm;

public class TimKiemAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		TimKiemForm timKiemForm = (TimKiemForm) form;
		//lay danh sach danh muc
		DanhMucBO danhMucBO=new DanhMucBO();
		ArrayList<DanhMucBean> listDanhMuc = danhMucBO.getListDanhMuc();
		timKiemForm.setListDanhMuc(listDanhMuc);
		
		//lay danh tinh thanh
		TinhThanhBO tinhThanhBO=new TinhThanhBO();
		ArrayList<TinhThanhBean> listTinhThanh = tinhThanhBO.getListTinhThanh();
		timKiemForm.setListTinhThanh(listTinhThanh);
		
		//Lay danh sach bai dang
		BaiDangBO baiDangBO = new BaiDangBO();
		String maDanhMuc = timKiemForm.getMaDanhMuc();
		String maTinhThanh = timKiemForm.getMaTinhThanh();
		String noiDung = timKiemForm.getNoiDung();
		
		ArrayList<BaiDangBean> listBaiDang ;
		if ((maDanhMuc==null || maDanhMuc.length()==0)) {
			if (maTinhThanh==null || maTinhThanh.length()==0) {
				if (noiDung==null || noiDung.length()==0) {
					listBaiDang = baiDangBO.getListBaiDang();
				}
				else listBaiDang = baiDangBO.getListBaiDangNoiDung(noiDung);
			}
			else{
				if (noiDung==null || noiDung.length()==0) {
					listBaiDang = baiDangBO.getListBaiDangTinhThanh(maTinhThanh);
				}
				else listBaiDang = baiDangBO.getListBaiDangTinhThanhNoiDung(maTinhThanh,noiDung);
			} 
			
		}
		else{
			if (maTinhThanh==null || maTinhThanh.length()==0) {
				if (noiDung==null || noiDung.length()==0) {
					listBaiDang = baiDangBO.getListBaiDangDanhMuc(maDanhMuc);
				}
				else listBaiDang = baiDangBO.getListBaiDangDanhMucNoiDung(maDanhMuc,noiDung);
			}
			else{
				if (noiDung==null || noiDung.length()==0) {
					listBaiDang = baiDangBO.getListBaiDangDanhMucTinhThanh(maDanhMuc,maTinhThanh);
				}
				else listBaiDang = baiDangBO.getListBaiDangDanhMucTinhThanhNoiDung(maDanhMuc,maTinhThanh,noiDung);
			} 
		} 
				
		
		timKiemForm.setListBaiDang(listBaiDang);
		
		//return mapping.findForward("timKiem");
		return mapping.getInputForward();
	}
	
}
