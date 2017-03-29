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

public class XemTinChuaDuyetAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		DanhSachBaiDangDaDuyetForm thisForm= (DanhSachBaiDangDaDuyetForm)form;
		BaiDangBO baiDangBO= new BaiDangBO();
		int mbd= thisForm.getMaBaiDang();
		BaiDangBean baiDang= baiDangBO.getListChiTietBaiDangChuaDuyet(mbd);
		if(thisForm.isDuyetTin()){
			thisForm.setDuyetTin(false);
			baiDangBO.setDuyetTin(thisForm.getMaBaiDang());
			return mapping.findForward("baiDangChuaDuyet");
		}
		System.out.println("ma duyet "+thisForm.getMaBaiDang());
		thisForm.setBaiDangDaDuyet(baiDang);
		return mapping.findForward("xemTinChuaDuyet");
		
	}
}
