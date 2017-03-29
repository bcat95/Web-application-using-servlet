package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import form.DanhSachLienHeForm;
import model.bean.LienHe;
import model.bean.VanDe;
import model.bo.LienHeBO;
import model.bo.VanDeBO;

public class DanhSachLienHeAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		DanhSachLienHeForm thisForm = (DanhSachLienHeForm) form;
		
		//lay danh sach cac van de
		VanDeBO vanDeBO = new VanDeBO();
		ArrayList<VanDe> VanDe = vanDeBO.getListVanDe();
		thisForm.setListVanDe(VanDe);
		
		//lay danh sach lien he
		ArrayList<LienHe> listLienHe;
		LienHeBO lienHeBO = new LienHeBO();
		
		String maVanDe = thisForm.getMaVanDe();
		String tim = thisForm.getTim();
		
		if(tim==null || tim.length()==0)
			if(maVanDe==null || maVanDe.length()==0)
				listLienHe = lienHeBO.getListLienHe();
			else listLienHe = lienHeBO.getListLienHe(maVanDe);
		else
			if(maVanDe !=null || maVanDe.length() !=0)
				listLienHe = lienHeBO.timSinhVien1(tim, maVanDe);
			else listLienHe = lienHeBO.timSinhVien(tim);
		
		thisForm.setListLienHe(listLienHe);
		
		return mapping.getInputForward();
		//return mapping.findForward("dsLienHe");
	}
}
