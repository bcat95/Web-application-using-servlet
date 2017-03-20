package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import form.HeaderForm;
import model.bean.User;

public class HeaderAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HeaderForm thisForm = (HeaderForm) form;
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("userActivity");
		
		if(user != null){
			thisForm.setUser(user);
			
		}
		else
			thisForm.setType(-1);
		
		return mapping.getInputForward();
	}
}
