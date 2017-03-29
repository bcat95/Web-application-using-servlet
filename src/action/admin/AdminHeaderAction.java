package action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.AdminPanelForm;
import model.bean.TaiKhoanBean;

public class AdminHeaderAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		AdminPanelForm thisForm = (AdminPanelForm) form;
		thisForm.setAdmin(0);
		HttpSession session = request.getSession();
		TaiKhoanBean user = (TaiKhoanBean) session.getAttribute("userActivity");
		if(user == null || user.getMaQuyen() != 1 ){
			thisForm.setAdmin(1);
			return mapping.getInputForward();
		}
		return mapping.getInputForward();
	}

}
