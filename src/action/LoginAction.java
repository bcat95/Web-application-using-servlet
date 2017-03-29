package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.TaiKhoanForm;
import model.bean.TaiKhoanBean;
import model.bo.TaiKhoanBO;

public class LoginAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		TaiKhoanForm loginForm = (TaiKhoanForm) form;
		TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
		StringProcess check = new StringProcess();
		
		HttpSession session = request.getSession();
		TaiKhoanBean acc = (TaiKhoanBean) session.getAttribute("userActivity");
		
		String username = loginForm.getUserName();
		String password = loginForm.getPass();
		if("Login".equals(loginForm.getSubmit()) && (check.notVaild(username) || check.notVaild(password))){
			loginForm.setThongBao(1);
			return mapping.findForward("login");
		}else if("Login".equals(loginForm.getSubmit()) && taiKhoanBO.checkLogin(username, password) == false){
			loginForm.setThongBao(2);
			return mapping.findForward("login");
		}else if ("Login".equals(loginForm.getSubmit()) && taiKhoanBO.checkLogin(username, password)) {
			acc = taiKhoanBO.selectOne(username);
			session.setAttribute("userActivity", acc);
            return mapping.findForward("home");
        } else if(acc != null){
            	return mapping.findForward("home");
        } else	return mapping.findForward("login");
	}
	
}
