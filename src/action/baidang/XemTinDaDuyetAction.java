package action.baidang;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachBaiDangDaDuyetForm;
import model.bean.BaiDangBean;

import model.bo.BaiDangBO;
import model.bo.DanhMucBO;
import model.bo.DichVuBO;
import model.bo.TinhThanhBO;
import model.dao.LoaiTinDAO;
import model.dao.TinhThanhDAO;


public class XemTinDaDuyetAction extends Action{


	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		DanhSachBaiDangDaDuyetForm danhSachBaiDangDaDuyetForm= (DanhSachBaiDangDaDuyetForm)form;
		BaiDangBO baiDangBO= new BaiDangBO();
		System.out.println("NOy");
		int mbd= danhSachBaiDangDaDuyetForm.getMaBaiDang();
		System.out.println("mbd action"+mbd);
		BaiDangBean baiDang= baiDangBO.getListChiTietBaiDangDaDuyet(mbd);
		danhSachBaiDangDaDuyetForm.setBaiDangDaDuyet(baiDang);
		System.out.println("NOy1");
		return mapping.findForward("xemTinDaDuyet");
	}
}
