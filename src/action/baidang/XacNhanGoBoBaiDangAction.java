package action.baidang;

import java.util.ArrayList;

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

public class XacNhanGoBoBaiDangAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		System.out.println("Noy1");
		DanhSachBaiDangDaDuyetForm danhSachBaiDangDaDuyetForm= (DanhSachBaiDangDaDuyetForm)form;
		BaiDangBO baiDangBO= new BaiDangBO();
		int mbd=danhSachBaiDangDaDuyetForm.getMaBaiDang();
		System.out.println("mabd= "+ mbd);
		if (StringProcess.equals(danhSachBaiDangDaDuyetForm.getSubmit(), "xnGoBo")){
			baiDangBO.goBoBaiDang(mbd);  /// SAI CAI GI DAY NOY MACH :) 
			System.out.println("Noy2");
			return mapping.findForward("goBoTinxong");
		}	
		else {		
			System.out.println("Noy3");
			BaiDangBean baiDangBean = baiDangBO.getListBaiDangDaDuyet(mbd);
			danhSachBaiDangDaDuyetForm.setMaBaiDang(baiDangBean.getMaBaiDang());
			danhSachBaiDangDaDuyetForm.setTieuDe(baiDangBean.getTieuDe());
			return mapping.findForward("goBoTin");
		}
	}
}