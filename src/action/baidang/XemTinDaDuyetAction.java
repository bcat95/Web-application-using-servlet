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
		BaiDangBO baiDangBO= new BaiDangBO();
		DanhSachBaiDangDaDuyetForm thisForm= (DanhSachBaiDangDaDuyetForm)form;
		if(thisForm.isGoDuyetTin()){
			thisForm.setGoDuyetTin(false);
			System.out.println("ma la "+thisForm.getMaBaiDang());
			baiDangBO.goDuyetTin(thisForm.getMaBaiDang());
			return mapping.findForward("baiDangDaDuyet");
		}
		int mbd= thisForm.getMaBaiDang();
		BaiDangBean baiDang= baiDangBO.getListChiTietBaiDangDaDuyet(mbd);
		thisForm.setBaiDangDaDuyet(baiDang);
		return mapping.findForward("xemTinDaDuyet");
	}
}
