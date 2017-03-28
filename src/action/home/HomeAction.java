package action.home;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaiDangBean;
import model.bean.DanhMucBean;
import model.bean.TinhThanhBean;
import model.bo.BaiDangBO;
import model.bo.DanhMucBO;
import model.bo.KhuyenMaiBO;
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
		HomeForm thisForm = (HomeForm) form;
		
		//Lay danh sach bai dang
		BaiDangBO baiDangBO = new BaiDangBO();
		ArrayList<BaiDangBean> listBaiDang = baiDangBO.getListBaiDang();
		thisForm.setListBaiDang(listBaiDang);
		//lay danh sach danh muc theo so luong home
		DanhMucBO danhMucBO=new DanhMucBO();
		ArrayList<DanhMucBean> listDanhMuc = danhMucBO.getListDanhMuc();
		thisForm.setListDanhMuc(danhMucBO.getListDanhMuc(7));
		
		//lay danh tinh thanh
		TinhThanhBO tinhThanhBO=new TinhThanhBO();
		ArrayList<TinhThanhBean> listTinhThanh = tinhThanhBO.getListTinhThanh();
		thisForm.setListTinhThanh(listTinhThanh);
		String maDanhMuc = thisForm.getMaDanhMuc();
		String maTinhThanh = thisForm.getMaTinhThanh();
		KhuyenMaiBO khuyenMaiBO=new KhuyenMaiBO();
		thisForm.setListBaiDangKM(khuyenMaiBO.getListBaiDangKM());
		
		//Lay danh sach bai dang of 7 danh muc
		ArrayList<BaiDangBean> listBaiDang1 = baiDangBO.getListBaiDangByDM(1);
		thisForm.setListBaiDang_1(listBaiDang1);
		ArrayList<BaiDangBean> listBaiDang2 = baiDangBO.getListBaiDangByDM(2);
		thisForm.setListBaiDang_2(listBaiDang2);
		ArrayList<BaiDangBean> listBaiDang3 = baiDangBO.getListBaiDangByDM(3);
		thisForm.setListBaiDang_3(listBaiDang3);
		ArrayList<BaiDangBean> listBaiDang4 = baiDangBO.getListBaiDangByDM(4);
		thisForm.setListBaiDang_4(listBaiDang4);
		ArrayList<BaiDangBean> listBaiDang5 = baiDangBO.getListBaiDangByDM(5);
		thisForm.setListBaiDang_5(listBaiDang5);
		ArrayList<BaiDangBean> listBaiDang6 = baiDangBO.getListBaiDangByDM(6);
		thisForm.setListBaiDang_6(listBaiDang6);
		ArrayList<BaiDangBean> listBaiDang7 = baiDangBO.getListBaiDangByDM(7);
		thisForm.setListBaiDang_7(listBaiDang7);
		
		return mapping.findForward("home");
	}
	
}
