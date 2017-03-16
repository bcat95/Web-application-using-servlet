package model.bean;

public class User {
	private String userName;
	private String pass;
	private String hoTen;
	private int maQuyen;
		
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
	public int getMaQuyen() {
		return maQuyen;
	}
	public void setMaQuyen(int maQuyen) {
		this.maQuyen = maQuyen;
	}
	public User(String userName, String pass, String hoTen, int maQuyen) {
		super();
		this.userName = userName;
		this.pass = pass;
		this.hoTen = hoTen;
		this.maQuyen = maQuyen;
	}
}
