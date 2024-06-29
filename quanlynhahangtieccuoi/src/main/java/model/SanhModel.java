package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SanhModel {

	private Connection conn;
	public ArrayList<Sanh> sanh;
public	SanhModel() {
	    sanh = new ArrayList<Sanh>();
		String databaseURL = "jdbc:mysql://localhost:3306/qltc";
		String databaseUser = "root";
		String databasePassword = "";
		String driverDb = "com.mysql.cj.jdbc.Driver";
		
		try { 
		Class.forName(driverDb);
		
		conn = DriverManager.getConnection(databaseURL, databaseUser, databasePassword);
		 getDSMA();
		
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}


	


	 public void addSanh(Sanh sanh1) {		
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO sanh (masanh,tensanh,sobantoida,giasanh) VALUES (?,?, ?,?)");
			stmt.setString(1, sanh1.getMaSanh());
			stmt.setString(2, sanh1.getTenSanh());				
			stmt.setInt(3, sanh1.getSoBanToiDa());
			stmt.setInt(4, sanh1.getGiaSanh());
			
			stmt.executeUpdate();
			this.sanh.add(sanh1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}


	
	public void getDSMA () {	
		try {
			
			sanh.removeAll(sanh);
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM sanh");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Sanh reSult = new Sanh();
				reSult.setMaSanh(rs.getString(1));
				reSult.setTenSanh(rs.getString(2));			
				reSult.setSoBanToiDa(rs.getInt(3));
				reSult.setGiaSanh(rs.getInt(4));
				
				
				sanh.add(reSult);
			         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void suaSanh(Sanh sanh2) {
		for (Sanh i: this.sanh) {
			if (i.getMaSanh().equals(sanh2.getMaSanh())) {
				if (!sanh2.getTenSanh().equals(""))
				i.setTenSanh(sanh2.getTenSanh());
				if (sanh2.getSoBanToiDa() >0  )
					i.setSoBanToiDa(sanh2.getSoBanToiDa());
				if (sanh2.getGiaSanh() > 0)
				i.setGiaSanh(sanh2.getGiaSanh());
				
				sanh2 = i;
				break;
			}
		}
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE sanh SET tensanh = ?, sobantoida = ? , giasanh = ? WHERE masanh = ?");			
			stmt.setString(1, sanh2.getTenSanh());
			stmt.setInt(2, sanh2.getSoBanToiDa());
			stmt.setInt(3, sanh2.getGiaSanh());
			stmt.setString(4, sanh2.getMaSanh());
			
			
			stmt.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void xoaSanh(String maSanh) {
		Sanh index = new Sanh();
		for (Sanh i: this.sanh) 
			if (i.getMaSanh().equals(maSanh)) 
				index = i;
		this.sanh.remove(index);
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM sanh WHERE masanh = ?");			
			stmt.setString(1, maSanh);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	public Sanh layStuMaS(String maS) {
		for (Sanh i : sanh) {
			if (i.getMaSanh().equals(maS)) 
				return i;
		}
		return new Sanh();
	}
	
	public void timTheoKey (String key) {	
		try {
			
			sanh.removeAll(sanh);
			
			//"INSERT INTO sanh (masanh,tensanh,sobantoida,giasanh) VALUES (?,?, ?,?)");
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM sanh WHERE masanh LIKE ? OR tensanh LIKE ? OR sobantoida LIKE ? OR giasanh LIKE ?  ");
			for (int i = 1; i<=4 ; i++) 
				stmt.setString(i,"%"+key+"%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Sanh reSult = new Sanh();
				reSult.setMaSanh(rs.getString(1));
				reSult.setTenSanh(rs.getString(2));			
				reSult.setSoBanToiDa(rs.getInt(3));
				reSult.setGiaSanh(rs.getInt(4));
				
				
				sanh.add(reSult);
			         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
