package action.taikhoan;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachBaiDangDaDuyetForm;
import form.DanhSachTaiKhoanForm;
import model.bean.BaiDangBean;
import model.bean.TaiKhoanBean;
import model.bo.BaiDangBO;
import model.bo.TaiKhoanBO;

public class DanhSachTaiKhoanAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		System.out.println("NOy ");
		DanhSachTaiKhoanForm danhSachTaiKhoanForm = (DanhSachTaiKhoanForm) form;
		TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
		System.out.println("NOy 1");
		ArrayList<TaiKhoanBean> listTK = taiKhoanBO.getListTaiKhoan();
		System.out.println("NOy2 ");
		danhSachTaiKhoanForm.setListTaiKhoan(listTK);
		return mapping.findForward("danhSachTaiKhoan");
	}

}
