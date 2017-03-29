package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.TaiKhoanForm;
import model.bean.TaiKhoanBean;
import model.bo.TaiKhoanBO;

public class UpdateTaiKhoanAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		TaiKhoanForm taiKhoanForm = (TaiKhoanForm) form;
		TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
		StringProcess check = new StringProcess();
		HttpSession session = request.getSession();
		
		TaiKhoanBean user = (TaiKhoanBean) session.getAttribute("userActivity");
		
		String hoten = taiKhoanForm.getHoTen();
		String ngaysinh = taiKhoanForm.getNgaySinh();
		String gioitinh = taiKhoanForm.getGioiTinh();
		String email = taiKhoanForm.getEmail();
		String sdt = taiKhoanForm.getSDT();
		String pass = taiKhoanForm.getPass();
		
		if(user != null) {
			if("Update".equals(taiKhoanForm.getSubmit()) && (check.notVaild(hoten) || check.notVaild(ngaysinh) || check.notVaild(gioitinh) || check.notVaild(email) || check.notVaild(sdt) || check.notVaild(pass)))
				taiKhoanForm.setThongBao(1);
			else if("Update".equals(taiKhoanForm.getSubmit()) && check.notEmail(email))
				taiKhoanForm.setThongBao(2);
			else if("Update".equals(taiKhoanForm.getSubmit()) && taiKhoanBO.checkEmailUpdate(email,taiKhoanForm.getUserName()))
				taiKhoanForm.setThongBao(3);
			else if("Update".equals(taiKhoanForm.getSubmit()) && check.notSDT(sdt))
				taiKhoanForm.setThongBao(4);
			else if("Update".equals(taiKhoanForm.getSubmit()) && taiKhoanBO.checkLogin(taiKhoanForm.getUserName(),pass) == false)
				taiKhoanForm.setThongBao(5);
			else if("Update".equals(taiKhoanForm.getSubmit()) && taiKhoanBO.checkLogin(taiKhoanForm.getUserName(),pass)) {
				taiKhoanBO.updateTK(taiKhoanForm.getUserName(), pass, email, taiKhoanForm.getAvatar(), hoten, gioitinh, ngaysinh, sdt);
				user = taiKhoanBO.selectOne(taiKhoanForm.getUserName());
				session.setAttribute("userActivity", user);
				taiKhoanForm.setThongBao(6);
			}
			taiKhoanForm.setTK(user);
			return mapping.findForward("update");
		} else {
			taiKhoanForm.setThongBao(10);
			return mapping.findForward("update");
		}

	}

}
