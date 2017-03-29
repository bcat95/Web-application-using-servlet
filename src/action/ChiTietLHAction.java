package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LienHeForm;
import model.bean.LienHe;
import model.bean.VanDe;
import model.bo.LienHeBO;
import model.bo.VanDeBO;

public class ChiTietLHAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		LienHeForm lienHeForm = (LienHeForm) form;

		LienHeBO lienHeBO = new LienHeBO();
		//lay danh sach cac khoa
		VanDeBO khoaBO = new VanDeBO();
		ArrayList<VanDe> listVanDe = khoaBO.getListVanDe();
		lienHeForm.setListVanDe(listVanDe);
		
		//xoa sinh vien
		int maLienHe=lienHeForm.getMaLienHe();
		if("submit".equals(lienHeForm.getSubmit())){			//nhan nut Xac nhan o trang Xoa sinh vien
			lienHeBO.xoaLienHe(maLienHe);
			return mapping.findForward("xemlhxong");
		} else {													//chuyen sang trang Xoa sinh vien
			LienHe lienHe = lienHeBO.getThongTinLienHe(maLienHe);
			lienHeForm.setTieuDe(lienHe.getTieuDe());
			lienHeForm.setNoiDung(lienHe.getNoiDung());
			lienHeForm.setNgayGui(lienHe.getNgayGui());
			lienHeForm.setSoDT(lienHe.getSDT());
			lienHeForm.setEmail(lienHe.getEmail());
			lienHeForm.setMaVanDe(lienHe.getMaVanDe());
			return mapping.findForward("xemlh");
		}
	}
	
}
