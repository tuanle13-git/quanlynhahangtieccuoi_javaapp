package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KhachHangModel {
	    public ArrayList<KhachHang> khachHang;
		private Connection conn;

public	KhachHangModel() {
		
		String databaseURL = "jdbc:mysql://localhost:3306/qltc";
		String databaseUser = "root";
		String databasePassword = "";
		String driverDb = "com.mysql.cj.jdbc.Driver";
		
		try { 
		Class.forName(driverDb);
		
		conn = DriverManager.getConnection(databaseURL, databaseUser, databasePassword);
		 getDSKH ();
		
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

// them	nhan vien
	
	 public void addKhachHang(KhachHang khachHang) {		
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO khachhang (makh,tenkh,sodt,cccd,diachi) VALUES (?,?, ?,?,?)");
			stmt.setString(1, khachHang.getMaKH());
			stmt.setString(2, khachHang.getTenKH());
			stmt.setString(3, khachHang.getSoDT());
			stmt.setString(4, khachHang.getCCCD());
			stmt.setString(5, khachHang.getDiaChi());
			stmt.executeUpdate();
			this.khachHang.add(khachHang);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

// lay nhan vien tu tai khoan 
	
	public void getDSKH () {	
		try {
			khachHang = new ArrayList<KhachHang>();
			khachHang.removeAll(khachHang);
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM khachhang");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				KhachHang reSult = new KhachHang();
				reSult.setMaKH(rs.getString(1));
				reSult.setTenKH(rs.getString(2));
				reSult.setSoDT(rs.getString(3));
				reSult.setCCCD(rs.getString(4));
				reSult.setDiaChi(rs.getString(5));
				
				khachHang.add(reSult);
			         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	 public KhachHang timKhachHang (String makh1) {	
		try {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM khachhang where makh = ?");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				KhachHang reSult = new KhachHang();
				reSult.setMaKH(rs.getString(1));
				reSult.setTenKH(rs.getString(2));
				reSult.setSoDT(rs.getString(3));
				reSult.setCCCD(rs.getString(4));
				reSult.setDiaChi(rs.getString(5));
				
				return reSult;
			         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new KhachHang();
		
	}
	
	public void suaKhachHang(KhachHang khachHang) {
		for (KhachHang i: this.khachHang) {
			if (i.getMaKH().equals(khachHang.getMaKH())) {
				if (!khachHang.getTenKH().equals(""))
				i.setTenKH(khachHang.getTenKH());
				if (!khachHang.getCCCD().equals(""))
				i.setCCCD(khachHang.getCCCD());
				if (!khachHang.getDiaChi().equals(""))
				i.setDiaChi(khachHang.getDiaChi());
				if (!khachHang.getSoDT().equals(""))
				i.setSoDT(khachHang.getSoDT());
				khachHang = i;
			}
		}
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE khachhang SET tenkh = ?, sodt = ?, cccd = ?, diachi = ? WHERE makh = ?");			
			stmt.setString(1, khachHang.getTenKH());
			stmt.setString(2, khachHang.getSoDT());
			stmt.setString(3, khachHang.getCCCD());
			stmt.setString(4, khachHang.getDiaChi());
			stmt.setString(5, khachHang.getMaKH());
			stmt.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void xoaKhachHang(String maKhachHang) {
		KhachHang index = new KhachHang();
		for (KhachHang i: this.khachHang) 
			if (i.getMaKH().equals(maKhachHang)) 
				index = i;
		this.khachHang.remove(index);
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM khachhang WHERE makh = ?");			
			stmt.setString(1, maKhachHang);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	public KhachHang layKHtuMaMK(String makh) {
		for (KhachHang i : khachHang) {
			if (i.getMaKH().equals(makh)) 
				return i;
		}
		return new KhachHang();
	}
	public void timTheoKey (String key) {
		try {
			khachHang = new ArrayList<KhachHang>();
			khachHang.removeAll(khachHang);

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM khachhang WHERE makh LIKE ?  OR tenkh LIKE ? OR  OR sodt LIKE ? OR cccd LIKE ? OR diachi LIKE ? ");
			
			for (int i = 1; i<=5 ; i++) 
			stmt.setString(i,"%"+key+"%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				KhachHang reSult = new KhachHang();
				reSult.setMaKH(rs.getString(1));
				reSult.setTenKH(rs.getString(2));
				reSult.setSoDT(rs.getString(3));
				reSult.setCCCD(rs.getString(4));
				reSult.setDiaChi(rs.getString(5));
				
				khachHang.add(reSult);
			         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
	
	

