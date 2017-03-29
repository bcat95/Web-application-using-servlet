package action.baidang;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.DanhSachBaiDangDaDuyetForm;
import model.bean.BaiDangBean;
import model.bo.BaiDangBO;

public class XacNhanGoBoBaiDangChuaDuyetAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		DanhSachBaiDangDaDuyetForm danhSachBaiDangDaDuyetForm= (DanhSachBaiDangDaDuyetForm)form;
		BaiDangBO baiDangBO= new BaiDangBO();
		int mbd=danhSachBaiDangDaDuyetForm.getMaBaiDang();
		System.out.println("mabd= "+ mbd);
		if (StringProcess.equals(danhSachBaiDangDaDuyetForm.getSubmit(), "xnGoBoCD")){
			baiDangBO.goBoBaiDang(mbd);  /// SAI CAI GI DAY NOY MACH :) 
			return mapping.findForward("goBoTinCDxong");
		}	
		else {	
			BaiDangBean baiDangBean= baiDangBO.getListBaiDangChuaDuyet(mbd);
			danhSachBaiDangDaDuyetForm.setMaBaiDang(baiDangBean.getMaBaiDang());
			danhSachBaiDangDaDuyetForm.setTieuDe(baiDangBean.getTieuDe());
			return mapping.findForward("goBoTinCD");
		}
	}
}