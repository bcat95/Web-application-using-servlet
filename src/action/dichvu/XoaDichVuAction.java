package action.dichvu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachDichVuForm;
import model.bo.DichVuBO;


public class XoaDichVuAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		DanhSachDichVuForm danhSachDichVuForm= (DanhSachDichVuForm) form;
		DichVuBO dichVuBO = new DichVuBO();
		int maDichVu=danhSachDichVuForm.getMaDichVu();
		dichVuBO.xoaDichVu(maDichVu);
		return mapping.findForward("xoaDichVu");
	}
}
