package action.dichvu;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachDichVuForm;
import model.bean.DichVuBean;
import model.bo.DichVuBO;


public class DanhSachDichVuAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		DanhSachDichVuForm danhSachDichVuForm = (DanhSachDichVuForm) form;
		//lay danh sach danh muc
		DichVuBO dichVuBO= new DichVuBO();
		int maDichVu=danhSachDichVuForm.getMaDichVu();
		String tenDichVu=danhSachDichVuForm.getTenDichVu();
		//them
		if("ADD".equals(danhSachDichVuForm.getSubmit())){
			dichVuBO.themDichVu(tenDichVu);
			danhSachDichVuForm.setTenDichVu("");
		}
		if("Sua".equals(danhSachDichVuForm.getSubmit())){
			dichVuBO.suaDichVu(tenDichVu, maDichVu);
			danhSachDichVuForm.setTenDichVu("");
		}
		ArrayList<DichVuBean> listDichVu = dichVuBO.getListDichVu();
		danhSachDichVuForm.setListDichVu(listDichVu);
		return mapping.findForward("dsDichVu");
	}
}
