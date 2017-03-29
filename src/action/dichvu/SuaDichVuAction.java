package action.dichvu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.DanhSachDichVuForm;
import model.bean.DichVuBean;
import model.bo.DichVuBO;


public class SuaDichVuAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		DanhSachDichVuForm danhSachDichVuForm= (DanhSachDichVuForm) form;
		DichVuBO dichVuBO = new DichVuBO();
		int maDichVu=danhSachDichVuForm.getMaDichVu();
		System.out.println("name "+ danhSachDichVuForm.getTenDichVu());
		String tenDichVu = danhSachDichVuForm.getTenDichVu();
		dichVuBO.suaDichVu(tenDichVu, maDichVu);
		return mapping.findForward("xoaDichVu");
	}
}
