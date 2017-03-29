package action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhMucForm;
import model.bo.DanhMucBO;

public class XoaDanhMucAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		DanhMucForm danhMucForm = (DanhMucForm) form;
		DanhMucBO danhMucBO = new DanhMucBO();
		int maDanhMuc=danhMucForm.getMaDanhMuc();
		
		danhMucBO.xoaDanhMuc(maDanhMuc);
		return mapping.findForward("xoaDanhMuc");
	}
	
}
