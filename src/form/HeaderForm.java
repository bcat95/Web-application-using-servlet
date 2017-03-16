package form;

import org.apache.struts.action.ActionForm;
import model.bean.User;

public class HeaderForm extends ActionForm{
	private String userName;
	private String pass;
	private String hoTen;
	private int type;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setUser(User user)
	{
		this.userName = user.getUserName();
		this.pass = user.getPass();
		this.hoTen = user.getHoTen();
		this.type = user.getMaQuyen();
	}
}
