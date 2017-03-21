package action.baidang;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachBaiDangDaDuyetForm;
import model.bean.BaiDangBean;
import model.bo.BaiDangBO;

public class BaiDangChuaDuyetAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		System.out.println("phuong");
		DanhSachBaiDangDaDuyetForm danhSachBaiDangDaDuyetForm= (DanhSachBaiDangDaDuyetForm)form;
		BaiDangBO baiDangBO= new BaiDangBO();
		ArrayList<BaiDangBean> listBDDaDuyet= baiDangBO.getListBaiDangChuaDuyet();
		danhSachBaiDangDaDuyetForm.setListBaiDang(listBDDaDuyet);
		return mapping.findForward("baiDangChuaDuyet");
	}
}
