package model;

public class DichVu {
	
	private String maDV,ghiChu;
	private String tenDV;
	private int giaDV;
	
	public DichVu() {};
	public DichVu(String maDV, String tenDV, int giaDV, String ghiChu ) {
		this.tenDV = tenDV;
		this.giaDV = giaDV;
		this.ghiChu= ghiChu;
		this.maDV = maDV;	
	}
	public String getMaDV() {
		return maDV;
	}
	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}
	public String getTenDV() {
		return tenDV;
	}
	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}
	public String getghiChu() {
		return ghiChu;
	}
	public void setghiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public int getGiaDV() {
		return giaDV;
	}
	public void setGiaDV(int giaDV) {
		this.giaDV = giaDV;
	}		
	
}
