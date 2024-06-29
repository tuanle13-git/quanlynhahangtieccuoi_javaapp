package model;

public class Sanh {
	private String maSanh;
	private String tenSanh;
	private int soBanToiDa;
	private int giaSanh;
	
	public Sanh() {
		
	}
	public Sanh(String ma, String ten, int so, int gia) {
		maSanh = ma;
		tenSanh = ten;
		soBanToiDa = so;
		giaSanh = gia;
	}
	public String getMaSanh() {
		return maSanh;
	}
	public void setMaSanh(String maSanh) {
		this.maSanh = maSanh;
	}
	public String getTenSanh() {
		return tenSanh;
	}
	public void setTenSanh(String tenSanh) {
		this.tenSanh = tenSanh;
	}
	public int getSoBanToiDa() {
		return soBanToiDa;
	}
	public void setSoBanToiDa(int soBanToiDa) {
		this.soBanToiDa = soBanToiDa;
	}
	public int getGiaSanh() {
		return giaSanh;
	}
	public void setGiaSanh(int giaSanh) {
		this.giaSanh = giaSanh;
	}
	
	
}
