package model.bo;

import java.util.ArrayList;

import model.bean.QuyenBean;
import model.dao.QuyenDAO;


public class QuyenBO {
	QuyenDAO quyenDAO= new QuyenDAO();
	public  ArrayList<QuyenBean> getListQuyen() {
		return quyenDAO.getListQuyen();
	}
}
