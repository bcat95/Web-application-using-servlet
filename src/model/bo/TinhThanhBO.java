package model.bo;

import java.util.ArrayList;

import model.bean.TinhThanhBean;
import model.dao.TinhThanhDAO;

public class TinhThanhBO {
	public static ArrayList<TinhThanhBean> getListTinhThanh() {
		return TinhThanhDAO.getListTinhThanh();
	}
}
