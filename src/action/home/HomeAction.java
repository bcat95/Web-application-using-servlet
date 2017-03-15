package action.home;

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

import form.HomeForm;

public class HomeAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		HomeForm homeForm = (HomeForm) form;
		//lay danh sach danh muc
		DanhMucBO danhMucBO=new DanhMucBO();
		ArrayList<DanhMucBean> listDanhMuc = danhMucBO.getListDanhMuc();
		homeForm.setListDanhMuc(danhMucBO.getListDanhMuc());
		
		//lay danh tinh thanh
		TinhThanhBO tinhThanhBO=new TinhThanhBO();
		ArrayList<TinhThanhBean> listTinhThanh = tinhThanhBO.getListTinhThanh();
		homeForm.setListTinhThanh(listTinhThanh);
		
		//Lay danh sach bai dang
		BaiDangBO baiDangBO = new BaiDangBO();
		ArrayList<BaiDangBean> listBaiDang = baiDangBO.getListBaiDang();
		homeForm.setListBaiDang(listBaiDang);
		String maDanhMuc = homeForm.getMaDanhMuc();
		String maTinhThanh = homeForm.getMaTinhThanh();
		
		return mapping.findForward("home");
	}
	
}
