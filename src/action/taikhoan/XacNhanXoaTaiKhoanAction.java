package action.taikhoan;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.DanhSachBaiDangDaDuyetForm;
import form.DanhSachTaiKhoanForm;
import model.bean.BaiDangBean;
import model.bean.TaiKhoanBean;
import model.bo.BaiDangBO;
import model.bo.TaiKhoanBO;

public class XacNhanXoaTaiKhoanAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		DanhSachTaiKhoanForm danhSachTaiKhoanForm= (DanhSachTaiKhoanForm)form;
		TaiKhoanBO taiKhoanBO= new TaiKhoanBO();
		String user=danhSachTaiKhoanForm.getUserName();
		System.out.println("xáo "+ user);
		if (StringProcess.equals(danhSachTaiKhoanForm.getSubmit(), "xoaTaikhoan")){
			taiKhoanBO.xoaTaiKhoan(user); 
			return mapping.findForward("xoaTKxong");
		}	
		else {		
			 
			TaiKhoanBean taiKhoanBean = taiKhoanBO.getThongTinTaiKhoan(user);
			danhSachTaiKhoanForm.setUserName(taiKhoanBean.getUserName());
			return mapping.findForward("xoaTK");
		}
	}
}
