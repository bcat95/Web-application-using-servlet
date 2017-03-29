package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


import form.DanhSachLienHeForm;
import form.LienHeForm;
import model.bean.VanDe;
import model.bo.LienHeBO;
import model.bo.VanDeBO;

public class ThemLienHeAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		LienHeForm lienHeForm = (LienHeForm) form;
		//lay danh sach cac van de
		VanDeBO vanDeBO = new VanDeBO();
		ArrayList<VanDe> listVanDe = vanDeBO.getListVanDe();
		lienHeForm.setListVanDe(listVanDe);
		
		//validate du lieu
		if("submit".equals(lienHeForm.getSubmit())){
			ActionErrors actionErrors = new ActionErrors();
			/*if(StringProcess.notVaild(sinhVienForm.getMsv())){
				actionErrors.add("msvError", new ActionMessage("error.msv.trong"));
			}
			if(StringProcess.notVaildNumber(sinhVienForm.getMsv())){
				actionErrors.add("msvError", new ActionMessage("error.msv.so"));
			}*/
			saveErrors(request, actionErrors);
			if(actionErrors.size()>0){
				return mapping.findForward("themlherror");
			}
		}
		if("submit".equals(lienHeForm.getSubmit())){		//nhan nut Xac nhan o trang Them sinh vien
			int maVanDe = lienHeForm.getMaVanDe();
			int maLienHe = lienHeForm.getMaLienHe();
			String tieuDe= lienHeForm.getTieuDe();
			String noiDung = lienHeForm.getNoiDung();
			String ngayGui = lienHeForm.getNgayGui();
			String soDT = lienHeForm.getSoDT();
			String email = lienHeForm.getEmail();
			LienHeBO lienHeBO = new LienHeBO();
			lienHeBO.themLienHe(tieuDe, noiDung, ngayGui, soDT, email, maVanDe);
			return mapping.findForward("themlhxong");
		} else {											//chuyen sang trang Them sinh vien
			return mapping.findForward("themlh");
		}
	}
	
}
