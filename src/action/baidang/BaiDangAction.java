package action.baidang;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.BaiDangForm;
import model.bean.TaiKhoanBean;
import model.bo.BaiDangBO;
import model.bo.BinhLuanBO;
import model.bo.ThichBO;
/**
 * BaiDangAction
 *
 * Version 1.0
 *
 * Date: 14-3-2017
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 14-3-2017         DonNA            Create
 */
public class BaiDangAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BaiDangForm thisForm = (BaiDangForm) form;
		HttpSession session = request.getSession();
		TaiKhoanBean user = (TaiKhoanBean) session.getAttribute("userActivity");
		thisForm.setXemBaiDang(BaiDangBO.infoBaiDang(thisForm.getMaBaiDang()));
		//Neyu khong tim thay bai dang tu action xem
		if(thisForm.getMaBaiDang()==0)
			return mapping.findForward("err404");
		//AnNBH
		BaiDangBO baiDangBO = new BaiDangBO();
		thisForm.setListBaiDang(baiDangBO.getListBaiDangCungTinhThanh(thisForm.getMaBaiDang()));
		thisForm.setListBaiDangDanhMuc(baiDangBO.getListBaiDangCungDanhMuc(thisForm.getMaBaiDang()));
		//END AnNBH
		
		if(user==null && thisForm.getMaLoaiTin()==1){
			return mapping.findForward("err404");
		}else if (thisForm.getMaLoaiTin()==1 && (StringProcess.equals(thisForm.getUserName(), user.getUserName())) == false){
			return mapping.findForward("err404");
		}
		if (StringProcess.equals(thisForm.getSubmit(), "binhLuan")){
			if(user==null)
				return mapping.findForward("login");
			else{
					ActionErrors errors = new ActionErrors();
					errors = thisForm.validateBaiDang(mapping, request);
					if (!errors.isEmpty()) {
						/*saveErrors(request, errors);
						return mapping.getInputForward();*/
					}
					else if(StringProcess.equals(thisForm.getSubmit(), "binhLuan")){
						thisForm.setSubmit("");
						thisForm.setBl_userName((user.getUserName()));
						BinhLuanBO.insertBinhLuan(thisForm.getBinhLuan());
						thisForm.setXemBaiDang(BaiDangBO.infoBaiDang(thisForm.getMaBaiDang()));
						return mapping.getInputForward();
					}
			}
		}
		//thich > set and get yeuThich
		if(user!=null){
			boolean like=ThichBO.checkThich(thisForm.getMaBaiDang(),user.getUserName());
			thisForm.setYeuThich(like);
			if(thisForm.isSetThich()){
				thisForm.setSetThich(false);
				ThichBO.setThich(like, thisForm.getMaBaiDang(), user.getUserName());
				like=ThichBO.checkThich(thisForm.getMaBaiDang(),user.getUserName());
				thisForm.setYeuThich(like);
				thisForm.setXemBaiDang(BaiDangBO.infoBaiDang(thisForm.getMaBaiDang()));
				return mapping.getInputForward();
			}
			
			
		}
		return mapping.getInputForward();
	}

}