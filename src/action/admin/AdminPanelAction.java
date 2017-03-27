package action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.AdminPanelForm;
import model.bo.AdminPanelBO;

public class AdminPanelAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		AdminPanelForm thisForm = (AdminPanelForm) form;
		AdminPanelBO adminPanelBO=new AdminPanelBO();
		thisForm.settKBaiDang(adminPanelBO.getListTKBaiDang());
		thisForm.settKBinhLuan(adminPanelBO.getListTKBinhLuan());
		thisForm.settKYeuThich(adminPanelBO.getListTKYeuThich());
		thisForm.settKTaiKhoan(adminPanelBO.getListTKTaiKhoan());
		thisForm.settKTinhThanh(adminPanelBO.getListTKTinhThanh());
		thisForm.settKDanhMuc(adminPanelBO.getListTKDanhMuc());
		return mapping.getInputForward();
	}
	

}
