package action.baidang;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.KhuyenMaiForm;
import model.bean.TaiKhoanBean;
import model.bo.KhuyenMaiBO;

public class KhuyenMaiAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		TaiKhoanBean user = (TaiKhoanBean) session.getAttribute("userActivity");
		if(user == null || user.getMaQuyen() == -1)
			return mapping.findForward("login");
		KhuyenMaiForm thisForm = (KhuyenMaiForm) form;
		KhuyenMaiBO khuyenMaiBO=new KhuyenMaiBO();
		//kiem tra ma bai dang
		if (thisForm.getMaBaiDang()!=0){
			if (StringProcess.equals(thisForm.getSubmit(), "themKhuyenMai")){
				ActionErrors errors = new ActionErrors();
				errors = thisForm.validateBaiDang(mapping, request);
				if (!errors.isEmpty()) {
					return mapping.getInputForward();
				}
				else if(StringProcess.equals(thisForm.getSubmit(), "themKhuyenMai")){
					if (thisForm.getMaBaiDang()!=0){
						khuyenMaiBO.insertKhuyenMai(thisForm.getKhuyenMai());
						thisForm.setMaBaiDang(thisForm.getMaBaiDang());
						return mapping.findForward("danhSachKhuyenMai");
					}
					else return mapping.findForward("danhSachKhuyenMai");
				}
			}
			if (StringProcess.equals(thisForm.getSubmit(), "suaKhuyenMai")){
				ActionErrors errors = new ActionErrors();
				errors = thisForm.validateBaiDang(mapping, request);
				if (!errors.isEmpty()) {
					return mapping.getInputForward();
				}
				else if(StringProcess.equals(thisForm.getSubmit(), "suaKhuyenMai")){
					if (thisForm.getMaKhuyenMai()!=0){
						khuyenMaiBO.editKhuyenMai(thisForm.getKhuyenMai());
						thisForm.setMaBaiDang(thisForm.getMaBaiDang());
						return mapping.findForward("danhSachKhuyenMai");
					}
					else return mapping.findForward("danhSachKhuyenMai");
				}
			}
			thisForm.setListKhuyenMai(khuyenMaiBO.getListKhuyenMai(thisForm.getMaBaiDang()));
			return mapping.getInputForward();
		} else return mapping.findForward("khuyenMaierror");
	}

}
