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
import model.bean.BaiDangBean;
import model.bean.LoaiTaiKhoanBean;
import model.bean.QuyenBean;
import model.bean.TaiKhoanBean;
import model.bo.LoaiTaiKhoanBO;
import model.bo.QuyenBO;
import model.bo.TaiKhoanBO;

public class SuaTaiKhoanAction extends Action{
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
		String username= danhSachTaiKhoanForm.getUserName();
		
		//kiem tra du lieu nhap vao
		if (StringProcess.equals(danhSachTaiKhoanForm.getSubmit(), "suaTK")){
			ActionErrors errors = new ActionErrors();
			errors = danhSachTaiKhoanForm.validateBaiDang(mapping, request); // chua kt
			if (!errors.isEmpty()) {
				saveErrors(request, errors);
				danhSachTaiKhoanForm.setListQuyen(listQuyen);
				danhSachTaiKhoanForm.setListLoaiTaiKhoan(listLoaiTaiKhoan);
				return mapping.findForward("suaTK");
			} 
			else if(StringProcess.equals(danhSachTaiKhoanForm.getSubmit(), "suaTK")){
				
				taiKhoanBO.suaTaiKhoan(danhSachTaiKhoanForm.getTaiKhoan());
				return mapping.findForward("suaTKxong");
			}
		}
		//them cac du lieu danh sach
		TaiKhoanBean taiKhoanBean= taiKhoanBO.getListTaiKhoan(username);
		danhSachTaiKhoanForm.setPassWord(taiKhoanBean.getPassWord());
		danhSachTaiKhoanForm.setHoTen(taiKhoanBean.getHoTen());
		danhSachTaiKhoanForm.setGioiTinh(taiKhoanBean.getGioiTinh());
		danhSachTaiKhoanForm.setNgaySinh(taiKhoanBean.getNgaySinh());
		danhSachTaiKhoanForm.setsDT(taiKhoanBean.getsDT());
		danhSachTaiKhoanForm.seteMail(taiKhoanBean.geteMail());
		danhSachTaiKhoanForm.setNgayDangKy(taiKhoanBean.getNgayDangKy());
		danhSachTaiKhoanForm.setListQuyen(listQuyen);
		danhSachTaiKhoanForm.setListLoaiTaiKhoan(listLoaiTaiKhoan);
		return mapping.findForward("suaTK");
	}
}
