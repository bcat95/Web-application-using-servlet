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
		
		//Lay danh sach bai dang 1- Làm đẹp 2- Kinh doanh 3- Dich vụ ăn uống 4- Tài chánh 5- Sức khỏe 6-Khách sạn 7-Giải trí;
		ArrayList<BaiDangBean> listBaiDang1 = baiDangBO.getListBaiDangByDM(1);
		homeForm.setListBaiDang_1(listBaiDang1);
		ArrayList<BaiDangBean> listBaiDang2 = baiDangBO.getListBaiDangByDM(2);
		homeForm.setListBaiDang_2(listBaiDang2);
		ArrayList<BaiDangBean> listBaiDang3 = baiDangBO.getListBaiDangByDM(3);
		homeForm.setListBaiDang_3(listBaiDang3);
		ArrayList<BaiDangBean> listBaiDang4 = baiDangBO.getListBaiDangByDM(4);
		homeForm.setListBaiDang_4(listBaiDang4);
		ArrayList<BaiDangBean> listBaiDang5 = baiDangBO.getListBaiDangByDM(5);
		homeForm.setListBaiDang_5(listBaiDang5);
		ArrayList<BaiDangBean> listBaiDang6 = baiDangBO.getListBaiDangByDM(6);
		homeForm.setListBaiDang_6(listBaiDang6);
		ArrayList<BaiDangBean> listBaiDang7 = baiDangBO.getListBaiDangByDM(7);
		homeForm.setListBaiDang_7(listBaiDang7);
				
		String maDanhMuc = homeForm.getMaDanhMuc();
		String maTinhThanh = homeForm.getMaTinhThanh();
		
		return mapping.findForward("home");
	}
	
}
