package form;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.apache.struts.action.ActionForm;
import model.bean.LienHe;
import model.bean.VanDe;

public class DanhSachLienHeForm extends ActionForm{
	private String maVanDe;
	private String tim;
	private ArrayList<VanDe> listVanDe;
	private ArrayList<LienHe> listLienHe;
	
	public String getMaVanDe() {
		return maVanDe;
	}
	public void setMaVanDe(String maVanDe) {
		this.maVanDe = maVanDe;
	}
	public String getTim() {
		return tim;
	}
	public void setTim(String tim) {
		byte[] bytes = tim.getBytes(StandardCharsets.ISO_8859_1);
        tim = new String(bytes, StandardCharsets.UTF_8);
		this.tim = tim;
	}
	public ArrayList<VanDe> getListVanDe() {
		return listVanDe;
	}
	public void setListVanDe(ArrayList<VanDe> listVanDe) {
		this.listVanDe = listVanDe;
	}
	public ArrayList<LienHe> getListLienHe() {
		return listLienHe;
	}
	public void setListLienHe(ArrayList<LienHe> listLienHe) {
		this.listLienHe = listLienHe;
	}
}
