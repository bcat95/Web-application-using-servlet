package action.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhMucForm;
import model.bean.DanhMucBean;
import model.bo.DanhMucBO;



public class DanhMucAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		DanhMucForm danhMucForm = (DanhMucForm) form;
		//lay danh sach danh muc
		DanhMucBO danhMucBO = new DanhMucBO();
		int maDanhMuc=danhMucForm.getMaDanhMuc();
		String tenDanhMuc=danhMucForm.getTenDanhMuc();
		//them
		if("ADD".equals(danhMucForm.getSubmit())){
			danhMucBO.themDanhMuc(tenDanhMuc);
			danhMucForm.setTenDanhMuc("");
		}
		//Sua
		if("Sua".equals(danhMucForm.getSubmit())){
			danhMucBO.suaDanhMuc(maDanhMuc, tenDanhMuc);
		}
		ArrayList<DanhMucBean> listDanhMuc = danhMucBO.getListDanhMuc();
		danhMucForm.setListDanhMuc(listDanhMuc);
		return mapping.findForward("dsDanhMuc");
	}

}
