package model.bo;

import java.util.ArrayList;

import model.bean.DichVuBean;
import model.dao.DichVuDAO;

public class DichVuBO {
	public static ArrayList<DichVuBean> getListDichVu() {
		return DichVuDAO.getListDichVu();
	}
}
