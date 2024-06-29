package model;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private String diaChi;
	private String soDT;
	
	private String CCCD;
	public KhachHang() {
		
	}
	public KhachHang(String maKH,String tenKH,String soDT,String CCCD,String diaChi ) {
		this.maKH = maKH;
		this.CCCD = CCCD;
		this.soDT = soDT;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getCCCD() {
		return CCCD;
	}
	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}
	
	public String getMaKH() {
		return maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	
}
