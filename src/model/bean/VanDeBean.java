package model.bean;

public class VanDeBean {
	private String maVanDe;
	private String tenVanDe;
	public VanDeBean(String maVanDe, String tenVanDe) {
		super();
		this.maVanDe = maVanDe;
		this.tenVanDe = tenVanDe;
	}
	public String getMaVanDe() {
		return maVanDe;
	}
	public void setMaVanDe(String maVanDe) {
		this.maVanDe = maVanDe;
	}
	public String getTenVanDe() {
		return tenVanDe;
	}
	public void setTenVanDe(String tenVanDe) {
		this.tenVanDe = tenVanDe;
	}
	
}

