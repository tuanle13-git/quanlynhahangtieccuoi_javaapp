package model;

import java.sql.Date;
import java.util.ArrayList;

public class HopDong {
	public ArrayList<MonAn> dsMonAn;
	public ArrayList<DichVu> dsDichVu;
	public String maSanh;
	public String maKH;
	public String maHD;
	public String maNV;
	public Date ngayHD;
	public int soBan;
	public int soTien;
	public int tthai;
	
	

	
	public String getMaSanh() {
		return maSanh;
	}

	public void setMaSanh(String maSanh) {
		this.maSanh = maSanh;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public Date getNgayHD() {
		return ngayHD;
	}

	public void setNgayHD(Date ngayHD) {
		this.ngayHD = ngayHD;
	}

	public HopDong() {
		dsMonAn = new ArrayList<MonAn>();
		dsDichVu = new ArrayList<DichVu>();
	}
}
