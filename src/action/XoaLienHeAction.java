package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LienHeForm;
import model.bean.VanDe;
import model.bo.LienHeBO;
import model.bo.VanDeBO;

public class XoaLienHeAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		LienHeForm lienHeForm = (LienHeForm) form;

		System.out.println("phuong");
		LienHeBO lienHeBO = new LienHeBO();
		//lay danh sach cac van de
		VanDeBO vanDeBO = new VanDeBO();
		ArrayList<VanDe> listVanDe = vanDeBO.getListVanDe();
		lienHeForm.setListVanDe(listVanDe);

		//xoa lien he
		int maLienHe=lienHeForm.getMaLienHe();
		//nhan nut Xac nhan o trang Xoa lien he
		lienHeBO.xoaLienHe(maLienHe);
		/*lienHeBO.xoaLienHe(Integer.parseInt(request.getParameter("maLienHe")));*/
		return mapping.findForward("xoaLHxong");
	}
	
}
