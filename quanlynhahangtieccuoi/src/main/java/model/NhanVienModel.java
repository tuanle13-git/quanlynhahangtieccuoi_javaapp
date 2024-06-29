
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NhanVienModel {
	    public ArrayList<NhanVien> nhanVien;
		private Connection conn;

public	NhanVienModel() {
		
		String databaseURL = "jdbc:mysql://localhost:3306/qltc";
		String databaseUser = "root";
		String databasePassword = "";
		String driverDb = "com.mysql.cj.jdbc.Driver";
		
		try { 
		Class.forName(driverDb);
		
		conn = DriverManager.getConnection(databaseURL, databaseUser, databasePassword);
		 getDSNV ();
		
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}


public NhanVien getNhanVienTuTaiKhoan (String username) {	
	try {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM nhanvien WHERE taikhoan = ?");
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			NhanVien user = new NhanVien();
			user.setMaNV(rs.getString(1));
			user.setTenNV(rs.getString(2));
			
			user.setTaiKhoan(rs.getString(7));
			user.setMatKhau(rs.getString(8));
			user.setMuc(rs.getInt(9));
			return user;
		         }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	         return null;
}

// them	nhan vien
	
	 public void addNhanVien(NhanVien nhanVien) {		
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO nhanvien (manv,tennv,chucvu,sodt,cccd,diachi,taikhoan,matkhau,muc) VALUES (?,?,?, ?,?,?,?,?,?)");
			stmt.setString(1, nhanVien.getMaNV());
			stmt.setString(2, nhanVien.getTenNV());
			stmt.setString(3, nhanVien.getChucVu());
			stmt.setString(4, nhanVien.getSoDT());
			stmt.setString(5, nhanVien.getCCCD());
			stmt.setString(6, nhanVien.getDiaChi());
			stmt.setString(7, "");
			stmt.setString(8, "");
			stmt.setInt(9, 3);
			stmt.executeUpdate();
			this.nhanVien.add(nhanVien);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

// lay nhan vien tu tai khoan 
	
	public void getDSNV () {	
		try {
			nhanVien = new ArrayList<NhanVien>();
			nhanVien.removeAll(nhanVien);
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM nhanvien");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				NhanVien reSult = new NhanVien();
				reSult.setMaNV(rs.getString(1));
				reSult.setTenNV(rs.getString(2));
				reSult.setChucVu(rs.getString(3));
				reSult.setSoDT(rs.getString(4));
				reSult.setCCCD(rs.getString(5));
				reSult.setDiaChi(rs.getString(6));
				reSult.setTaiKhoan(rs.getString(7));
				reSult.setMatKhau(rs.getString(8));
				reSult.setMuc(rs.getInt(9));
				
				nhanVien.add(reSult);
			         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	 	
	public void suaNhanVien(NhanVien nhanVien) {
		for (NhanVien i: this.nhanVien) {
			if (i.getMaNV().equals(nhanVien.getMaNV())) {
				if (!nhanVien.getTenNV().equals(""))
				i.setTenNV(nhanVien.getTenNV());
				if (!nhanVien.getChucVu().equals(""))
					i.setChucVu(nhanVien.getChucVu());
				if (!nhanVien.getCCCD().equals(""))
				i.setCCCD(nhanVien.getCCCD());
				if (!nhanVien.getDiaChi().equals(""))
				i.setDiaChi(nhanVien.getDiaChi());
				if (!nhanVien.getSoDT().equals(""))
				i.setSoDT(nhanVien.getSoDT());
				nhanVien = i;
			}
		}
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE nhanvien SET tennv = ?,chucvu = ?, sodt = ?, cccd = ?, diachi = ? WHERE manv = ?");			
			stmt.setString(1, nhanVien.getTenNV());
			stmt.setString(2, nhanVien.getSoDT());
			stmt.setString(3, nhanVien.getChucVu());
			stmt.setString(4, nhanVien.getCCCD());
			stmt.setString(5, nhanVien.getDiaChi());
			stmt.setString(6, nhanVien.getMaNV());
			stmt.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void suaTaiKhoan(String manv , String tk,String mk,int muc ) {
		NhanVien nhanVien = new NhanVien();
		for (NhanVien i: this.nhanVien) {
			if (i.getMaNV().equals(manv)) {
				
				
				i.setTaiKhoan(tk);
				
				i.setMatKhau(mk);
				i.setMuc(muc);
				nhanVien=i;
				
			
			}
		}
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE nhanvien SET taikhoan = ?,matkhau = ?, muc = ? WHERE manv = ?");			
			stmt.setString(1, tk);
			stmt.setString(2, mk);
			stmt.setInt(3, nhanVien.getMuc());
			stmt.setString(4, manv);
			stmt.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void xoaTaiKhoan(String manv) {
		for (NhanVien i: this.nhanVien) {
			if (i.getMaNV().equals(manv)) {
				
			
				i.setTaiKhoan("");
			
					i.setMatKhau("");
			
				}
			
		}
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE nhanvien SET taikhoan = ?,matkhau = ?, muc = ? WHERE manv = ?");			
			stmt.setString(1, "");
			stmt.setString(2, "");
			stmt.setInt (3, 3);
			stmt.setString(4, manv);
			stmt.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void xoaNhanVien(String maNhanVien) {
		NhanVien index = new NhanVien();
		for (NhanVien i: this.nhanVien) 
			if (i.getMaNV().equals(maNhanVien)) 
				index = i;
		this.nhanVien.remove(index);
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM nhanvien WHERE manv = ?");			
			stmt.setString(1, maNhanVien);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
			//("UPDATE nhanvien SET tennv = ?,chucvu = ?, sodt = ?, cccd = ?, diachi = ? WHERE manv = ?");	
			//PreparedStatement stmt = conn.prepareStatement("SELECT * FROM nhanvien WHERE manv LIKE ? OR chucvu LIKE ? OR sodt LIKE ? OR cccd LIKE ? OR diachi LIKE ? OR taikhoan LIKE ? OR matkhau LIKE ? OR muc LIKE ? ");
			
			
			public void timTheoKey(String key) {	
				try {
					nhanVien = new ArrayList<NhanVien>();
					nhanVien.removeAll(nhanVien);
					PreparedStatement stmt = conn.prepareStatement("SELECT * FROM nhanvien WHERE manv LIKE ?  OR tennv LIKE ? OR chucvu LIKE ? OR sodt LIKE ? OR cccd LIKE ? OR diachi LIKE ? OR taikhoan LIKE ? OR matkhau LIKE ? OR muc LIKE ? ");
					
					for (int i = 1; i<=9 ; i++) 
					stmt.setString(i,"%"+key+"%");
					ResultSet rs = stmt.executeQuery();
					while (rs.next()) {
						NhanVien reSult = new NhanVien();
						reSult.setMaNV(rs.getString(1));
						reSult.setTenNV(rs.getString(2));
						reSult.setChucVu(rs.getString(3));
						reSult.setSoDT(rs.getString(4));
						reSult.setCCCD(rs.getString(5));
						reSult.setDiaChi(rs.getString(6));
						reSult.setTaiKhoan(rs.getString(7));
						reSult.setMatKhau(rs.getString(8));
						reSult.setMuc(rs.getInt(9));
						
						nhanVien.add(reSult);
					         }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
}
	
	

