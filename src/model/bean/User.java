package model.bean;

public class User {
	private String userName;
	private String hoTen;
	private String type;
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
	public User(String userName, String type) {
		super();
		this.userName = userName;
		this.type = type;
	}
	
}
