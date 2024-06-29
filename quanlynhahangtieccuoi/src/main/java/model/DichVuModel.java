package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DichVuModel {

	private Connection conn;
	public ArrayList<DichVu> dichVu;
public	DichVuModel() {
	    dichVu = new ArrayList<DichVu>();
		String databaseURL = "jdbc:mysql://localhost:3306/qltc";
		String databaseUser = "root";
		String databasePassword = "";
		String driverDb = "com.mysql.cj.jdbc.Driver";
		
		try { 
		Class.forName(driverDb);
		
		conn = DriverManager.getConnection(databaseURL, databaseUser, databasePassword);
		 getDSDV ();
		
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

// them	dich vu
	


	 public void addDichVu(DichVu DichVu) {		
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO dichvu (madv,tendv,giadv,ghichu) VALUES (?,?, ?,?)");
			stmt.setString(1, DichVu.getMaDV());
			stmt.setString(2, DichVu.getTenDV());	
			stmt.setInt(3, DichVu.getGiaDV());
			stmt.setString(4, DichVu.getghiChu());
			
			
			stmt.executeUpdate();
			this.dichVu.add(DichVu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

//lay dich vu 
	
	public void getDSDV () {	
		try {
			
			dichVu.removeAll(dichVu);
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM dichvu");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				DichVu reSult = new DichVu();
				reSult.setMaDV(rs.getString(1));
				reSult.setTenDV(rs.getString(2));			
				
				reSult.setGiaDV(rs.getInt(3));
				reSult.setghiChu(rs.getString(4));
				
				dichVu.add(reSult);
			         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void suaDichVu(DichVu dichvu) {
		for (DichVu i: this.dichVu) {
			if (i.getMaDV().equals(dichvu.getMaDV())) {
				if (!dichvu.getTenDV().equals(""))
				i.setTenDV(dichvu.getTenDV());
				if (!dichvu.getghiChu().equals(""))
					i.setghiChu(dichvu.getghiChu());
				if (dichvu.getGiaDV() > 0)
				i.setGiaDV(dichvu.getGiaDV());
				
				dichvu = i;
			}
		}
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE DichVu SET tendv = ?, giadv = ? , ghichu = ? WHERE madv = ?");			
			stmt.setString(1, dichvu.getTenDV());
			stmt.setInt(2, dichvu.getGiaDV());
			stmt.setString(3, dichvu.getghiChu());
			stmt.setString(4, dichvu.getMaDV());
			
			
			stmt.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void xoaDichVu(String maDichVu) {
		DichVu index = new DichVu();
		for (DichVu i: this.dichVu) 
			if (i.getMaDV().equals(maDichVu)) 
				index = i;
		this.dichVu.remove(index);
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM dichvu WHERE madv = ?");			
			stmt.setString(1, maDichVu);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}
