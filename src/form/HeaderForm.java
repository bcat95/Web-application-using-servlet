package form;

import org.apache.struts.action.ActionForm;
import model.bean.User;

public class HeaderForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private String userName;
	private String hoTen;
	
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setUser(User user)
	{
		this.userName = user.getUserName();
		this.hoTen = user.getHoTen();
		this.type = user.getType();
	}
}
