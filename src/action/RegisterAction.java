package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.TaiKhoanForm;
import model.bo.TaiKhoanBO;

public class RegisterAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		TaiKhoanForm registerForm = (TaiKhoanForm) form;
		TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
		StringProcess check = new StringProcess();
		
		String tenDangNhap = registerForm.getUserName();
		String matKhau = registerForm.getPass();
		String confirmMatKhau = registerForm.getConfirmMatKhau();
		String hoTen = registerForm.getHoTen();
		String email = registerForm.getEmail();
		
		if("Register".equals(registerForm.getSubmit()) && (check.notVaild(tenDangNhap) || check.notVaild(matKhau) || check.notVaild(confirmMatKhau) || check.notVaild(hoTen) || check.notVaild(email))){
			registerForm.setThongBao(1);
			return mapping.findForward("register");
		}else if("Register".equals(registerForm.getSubmit()) && check.notEmail(email)){
			registerForm.setThongBao(2);
			return mapping.findForward("register");
		}else if("Register".equals(registerForm.getSubmit()) && check.notDB(tenDangNhap)){
			registerForm.setThongBao(3);
			return mapping.findForward("register");
		}else if("Register".equals(registerForm.getSubmit()) && matKhau.equals(confirmMatKhau) == false ){
			registerForm.setThongBao(4);
			return mapping.findForward("register");
		}else if("Register".equals(registerForm.getSubmit()) && taiKhoanBO.checkUsername(tenDangNhap)){
			registerForm.setThongBao(5);
			return mapping.findForward("register");
		}else if("Register".equals(registerForm.getSubmit()) && taiKhoanBO.checkEmail(email)){
			registerForm.setThongBao(6);
			return mapping.findForward("register");
		}else if("Register".equals(registerForm.getSubmit()) && matKhau.equals(confirmMatKhau)){
			taiKhoanBO.themTaiKhoan(tenDangNhap, matKhau, email, "user.png", hoTen, 2, 1);
			registerForm.setThongBao(7);
			return mapping.findForward("register");
		}else	return mapping.findForward("register");
	}
	
}
