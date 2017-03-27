package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.ThongTinTaiKhoanForm;
import model.bean.TaiKhoanBean;
import model.bo.TaiKhoanBO;

public class CapNhatThongTinAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		ThongTinTaiKhoanForm thongTinTaiKhoanForm = (ThongTinTaiKhoanForm) form;
		TaiKhoanBO taiKhoanBO= new TaiKhoanBO(); 
		HttpSession session = request.getSession();
		TaiKhoanBean user = (TaiKhoanBean) session.getAttribute("userActivity");
		String username = user.getUserName();
		TaiKhoanBean taiKhoanBean= taiKhoanBO.getThongTinTaiKhoan(username);
		if (StringProcess.equals(thongTinTaiKhoanForm.getSubmit(), "CapNhapPass")){
			ActionErrors errors = new ActionErrors();
			errors = thongTinTaiKhoanForm.validateBaiDang(mapping, request);
			System.out.println("noy1");
			if (!errors.isEmpty()) {
				saveErrors(request, errors);
				thongTinTaiKhoanForm.setPassMoiXN(taiKhoanBean.getPassWord());
				System.out.println("noy2");
				return mapping.getInputForward();
			}
			else if(StringProcess.equals(thongTinTaiKhoanForm.getSubmit(), "CapNhapPass")){
				String passwordMoi= thongTinTaiKhoanForm.getPassMoiXN();
				System.out.println(passwordMoi);
				System.out.println("noy3");
				taiKhoanBO.capNhatThongTinTaiKhoan(username, passwordMoi);
				return mapping.findForward("suaTKxong");
			}
		}	
		return mapping.findForward("suaTKxong");
	}
}
