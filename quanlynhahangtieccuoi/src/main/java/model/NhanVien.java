package model;



public class NhanVien {
	private String soDT;
	private String tenNV;
	private String taiKhoan;
	private String matKhau;
	private String chucVu;
	private String maNV;
	private String CCCD;
	private int muc;
	private String diaChi;

	public NhanVien(String maNV,String tenNV,String chucVu,String soDT,String CCCD,String diaChi ) {
		this.maNV = maNV;
		this.CCCD = CCCD;
		this.soDT = soDT;
		this.tenNV = tenNV;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
		this.muc = 3;
		taiKhoan = "";
		matKhau  = "";
	}
	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getCCCD() {
		return CCCD;
	}

	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}

	public int getMuc() {
		return muc;
	}

	public void setMuc(int muc) {
		this.muc = muc;
	}



	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public NhanVien(){
		 soDT = "";
		 tenNV= "";
		 taiKhoan = "";
		 matKhau= "";
		 chucVu = "";}
	
	
	
	public String getSodt() {
		return soDT;
	}
	public void setSodt(String sodt) {
		this.soDT = sodt;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	
	
}
