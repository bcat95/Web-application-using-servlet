package model.bo;

import java.util.ArrayList;

import model.bean.VanDe;
import model.dao.VanDeDAO;

public class VanDeBO {
	VanDeDAO vanDeDAO = new VanDeDAO();

	public VanDe getThongTinVanDe(int maVanDe) {
		return vanDeDAO.getThongTinVanDe(maVanDe);
	}
	public ArrayList<VanDe> getListVanDe() {
		return vanDeDAO.getListVanDe();
	}
}
