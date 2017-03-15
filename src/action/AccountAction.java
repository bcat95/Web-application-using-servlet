package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import form.AccountForm;
import model.bean.User;
import model.bo.AccountBO;

public class AccountAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AccountForm accountForm = (AccountForm) form;
		AccountBO accountBO = new AccountBO();
		HttpSession session = request.getSession();
		User acc = (User) session.getAttribute("userActivity");
		
		String username = accountForm.getUsername();
		String password = accountForm.getPassword();

        if (accountBO.checkLogin(username, password)) {
        	acc = accountBO.getLogin(accountForm.getUsername());
			session.setAttribute("userActivity", acc);
            return mapping.findForward("home");
        } else if(acc != null){
            return mapping.findForward("home");
        }
        return mapping.getInputForward();
	}
	
}
