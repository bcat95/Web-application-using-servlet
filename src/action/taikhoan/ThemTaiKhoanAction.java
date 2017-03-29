package action.taikhoan;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;

import form.DanhSachTaiKhoanForm;
import model.bean.LoaiTaiKhoanBean;
import model.bean.QuyenBean;
import model.bo.LoaiTaiKhoanBO;
import model.bo.QuyenBO;
import model.bo.TaiKhoanBO;

public class ThemTaiKhoanAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		DanhSachTaiKhoanForm danhSachTaiKhoanForm = (DanhSachTaiKhoanForm) form;
		//lay danh sach quyen
		QuyenBO quyenBO = new QuyenBO();
		ArrayList<QuyenBean> listQuyen= quyenBO.getListQuyen();
		danhSachTaiKhoanForm.setListQuyen(listQuyen);
		
		//lay ra danh sach loai tai khoan
		LoaiTaiKhoanBO loaiTaiKhoanBO= new LoaiTaiKhoanBO();
		ArrayList<LoaiTaiKhoanBean> listLoaiTaiKhoan=loaiTaiKhoanBO.getListLoaiTaiKhoan();
		danhSachTaiKhoanForm.setListLoaiTaiKhoan(listLoaiTaiKhoan);
		
		TaiKhoanBO taiKhoanBO= new TaiKhoanBO();
		StringProcess check = new StringProcess();
		
		String userName = danhSachTaiKhoanForm.getUserName();
		String passWord = danhSachTaiKhoanForm.getPassWord();
		String hoTen = danhSachTaiKhoanForm.getHoTen();
		String eMail = danhSachTaiKhoanForm.geteMail();
		String sDT = danhSachTaiKhoanForm.getsDT();
		
		if("themTK".equals(danhSachTaiKhoanForm.getSubmit()) && (check.notVaild(userName) || check.notVaild(passWord) || 
				check.notVaild(hoTen) || check.notVaild(eMail))){
			danhSachTaiKhoanForm.setThongBao(1);
			return mapping.findForward("themTK");
		}else if("themTK".equals(danhSachTaiKhoanForm.getSubmit()) && check.notEmail(eMail)){
			danhSachTaiKhoanForm.setThongBao(2);
			return mapping.findForward("themTK");
		}else if("themTK".equals(danhSachTaiKhoanForm.getSubmit()) && check.notDB(userName)){
			danhSachTaiKhoanForm.setThongBao(3);
			return mapping.findForward("themTK");
		}else if("themTK".equals(danhSachTaiKhoanForm.getSubmit()) && check.notVaild(hoTen)){
			danhSachTaiKhoanForm.setThongBao(4);
			return mapping.findForward("themTK");
		}else if("themTK".equals(danhSachTaiKhoanForm.getSubmit()) && taiKhoanBO.checkUsername(userName)){
			danhSachTaiKhoanForm.setThongBao(5);
			return mapping.findForward("themTK");
		}else if("themTK".equals(danhSachTaiKhoanForm.getSubmit()) && taiKhoanBO.checkEmail(eMail)){
			danhSachTaiKhoanForm.setThongBao(6);
			return mapping.findForward("themTK");
		}else if("themTK".equals(danhSachTaiKhoanForm.getSubmit()) && (check.notSDT(sDT))){
			danhSachTaiKhoanForm.setThongBao(7);
		}else if("themTK".equals(danhSachTaiKhoanForm.getSubmit())){
			taiKhoanBO.themTaiKhoan(danhSachTaiKhoanForm.getTaiKhoan());
			danhSachTaiKhoanForm.setThongBao(8);
			return mapping.findForward("themTK");
		}
		
		//them cac du lieu danh sach
		danhSachTaiKhoanForm.setListQuyen(listQuyen);
		danhSachTaiKhoanForm.setListLoaiTaiKhoan(listLoaiTaiKhoan);
		return mapping.findForward("themTK");
	}
}

