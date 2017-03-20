package form;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private int thongBao;
	private String tacVu;
	private String submit;

	public String getTacVu() {
		return tacVu;
	}
	public void setTacVu(String tacVu) {
		this.tacVu = tacVu;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public int getThongBao() {
		return thongBao;
	}
	public void setThongBao(int thongBao) {
		this.thongBao = thongBao;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
