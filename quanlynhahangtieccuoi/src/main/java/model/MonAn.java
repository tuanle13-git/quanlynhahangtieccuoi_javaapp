package model;

public class MonAn {
	private String maMA;
	private String tenMA;
	private String loaiMA;
	private int giaMA;
	
	public MonAn() {
		
	}
	public MonAn(String ma , String ten, String loai, int gia) {
		maMA = ma;
		tenMA = ten;
		loaiMA = loai;
		giaMA = gia;
	}
	public String getMaMA() {
		return maMA;
	}
	public void setMaMA(String maMA) {
		this.maMA = maMA;
	}
	public String getTenMA() {
		return tenMA;
	}
	public void setTenMA(String tenMA) {
		this.tenMA = tenMA;
	}
	public String getLoaiMA() {
		return loaiMA;
	}
	public void setLoaiMA(String loaiMA) {
		this.loaiMA = loaiMA;
	}
	public int getGiaMA() {
		return giaMA;
	}
	public void setGiaMA(int giaMA) {
		this.giaMA = giaMA;
	}
	
	
	
}
