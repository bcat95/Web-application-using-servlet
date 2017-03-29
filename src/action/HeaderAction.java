package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import form.TaiKhoanForm;
import model.bean.TaiKhoanBean;

public class HeaderAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		TaiKhoanForm thisForm = (TaiKhoanForm) form;
		HttpSession session = request.getSession();
		
		TaiKhoanBean user = (TaiKhoanBean) session.getAttribute("userActivity");
		
		if(user != null){
			thisForm.setTK(user);
			
		}
		else
			thisForm.setMaQuyen(-1);
		return mapping.getInputForward();
	}
}
