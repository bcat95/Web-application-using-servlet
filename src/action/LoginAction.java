package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.LoginForm;
import model.bean.User;
import model.bo.TaiKhoanBO;

public class LoginAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginForm loginForm = (LoginForm) form;
		TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
		StringProcess check = new StringProcess();
		
		HttpSession session = request.getSession();
		User acc = (User) session.getAttribute("userActivity");
		
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		
		if("Login".equals(loginForm.getSubmit()) && (check.notVaild(username) || check.notVaild(password))){
			loginForm.setThongBao(1);
			return mapping.findForward("login");
		}else if("Login".equals(loginForm.getSubmit()) && taiKhoanBO.checkLogin(username, password) == false){
			loginForm.setThongBao(2);
			return mapping.findForward("login");
		}else if ("Login".equals(loginForm.getSubmit()) && taiKhoanBO.checkLogin(username, password)) {
        	acc = taiKhoanBO.getLogin(loginForm.getUsername());
			session.setAttribute("userActivity", acc);
            return mapping.findForward("home");
        } else if(acc != null){
            	return mapping.findForward("home");
        } else	return mapping.findForward("login");
	}
	
}
