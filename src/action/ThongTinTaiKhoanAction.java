package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThongTinTaiKhoanForm;
import model.bean.BaiDangBean;
import model.bean.TaiKhoanBean;
import model.bean.User;
import model.bo.BaiDangBO;
import model.bo.TaiKhoanBO;

public class ThongTinTaiKhoanAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		ThongTinTaiKhoanForm taiKhoanForm= (ThongTinTaiKhoanForm)form;
		TaiKhoanBO taiKhoanBO= new TaiKhoanBO();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userActivity");
		System.err.println("uss "+user.getUserName());
		TaiKhoanBean taiKhoan= taiKhoanBO.getThongTinTaiKhoan(user.getUserName());
		taiKhoanForm.setUserName(taiKhoan.getUserName());
		taiKhoanForm.setPassCu(taiKhoan.getPassWord());
		taiKhoanForm.seteMail(taiKhoan.geteMail());
		
		BaiDangBO baiDangBO= new BaiDangBO();
		ArrayList<BaiDangBean> listBD= baiDangBO.danhSachBaiDang(user);
		taiKhoanForm.setListBaiDang(listBD);
		return mapping.findForward("thongTinTaiKhoan");
	}
}
