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
		//kiem tra du lieu nhap vao
		if (StringProcess.equals(danhSachTaiKhoanForm.getSubmit(), "themTK")){
			ActionErrors errors = new ActionErrors();
			errors = danhSachTaiKhoanForm.validateBaiDang(mapping, request); // chua kt
			if (!errors.isEmpty()) {
				saveErrors(request, errors);
				danhSachTaiKhoanForm.setListQuyen(listQuyen);
				danhSachTaiKhoanForm.setListLoaiTaiKhoan(listLoaiTaiKhoan);
				return mapping.findForward("themTK");
			} 
			else if(StringProcess.equals(danhSachTaiKhoanForm.getSubmit(), "themTK")){
				taiKhoanBO.themTaiKhoan(danhSachTaiKhoanForm.getTaiKhoan());
				return mapping.findForward("themTKxong");
			}
		}
		//them cac du lieu danh sach
		danhSachTaiKhoanForm.setListQuyen(listQuyen);
		danhSachTaiKhoanForm.setListLoaiTaiKhoan(listLoaiTaiKhoan);
		return mapping.findForward("themTK");
	}
}
