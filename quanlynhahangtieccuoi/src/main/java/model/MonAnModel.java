package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MonAnModel {

	private Connection conn;
	public ArrayList<MonAn> monAn;
public	MonAnModel() {
	    monAn = new ArrayList<MonAn>();
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


	


	 public void addMonAn(MonAn monAn1) {		
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO monan (mama,tenma,loaima,giama) VALUES (?,?, ?,?)");
			stmt.setString(1, monAn1.getMaMA());
			stmt.setString(2, monAn1.getTenMA());				
			stmt.setString(3, monAn1.getLoaiMA());
			stmt.setInt(4, monAn1.getGiaMA());
			
			stmt.executeUpdate();
			this.monAn.add(monAn1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}


	
	public void getDSMA () {	
		try {
			
			monAn.removeAll(monAn);
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM monan");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				MonAn reSult = new MonAn();
				reSult.setMaMA(rs.getString(1));
				reSult.setTenMA(rs.getString(2));			
				reSult.setLoaiMA(rs.getString(3));
				reSult.setGiaMA(rs.getInt(4));
				
				
				monAn.add(reSult);
			         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void timTheoKey (String key) {	
		try {
			
			monAn.removeAll(monAn);
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM monan WHERE mama LIKE ? OR tenma LIKE ? OR loaima LIKE ? OR giama LIKE ? ");
			
	                stmt.setString(1, "%" + key + "%");
	                stmt.setString(2, "%" + key + "%");
	                stmt.setString(3, "%" + key + "%");
	                stmt.setString(4, "%" + key + "%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				MonAn reSult = new MonAn();
				reSult.setMaMA(rs.getString(1));
				reSult.setTenMA(rs.getString(2));			
				reSult.setLoaiMA(rs.getString(3));
				reSult.setGiaMA(rs.getInt(4));
				
				
				monAn.add(reSult);
			         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void suaMonAn(MonAn monan) {
		for (MonAn i: this.monAn) {
			if (i.getMaMA().equals(monan.getMaMA())) {
				if (!monan.getTenMA().equals(""))
				i.setTenMA(monan.getTenMA());
				if (!monan.getTenMA().equals(""))
					i.setLoaiMA(monan.getLoaiMA());
				if (monan.getGiaMA() > 0)
				i.setGiaMA(monan.getGiaMA());
				
				monan = i;
			}
		}
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE MonAn SET tenma = ?, loaima = ? , giama = ? WHERE madv = ?");			
			stmt.setString(1, monan.getTenMA());
			stmt.setString(2, monan.getLoaiMA());
			stmt.setInt(3, monan.getGiaMA());
			stmt.setString(4, monan.getMaMA());
			
			
			stmt.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void xoaMonAn(String maMonAn) {
		MonAn index = new MonAn();
		for (MonAn i: this.monAn) 
			if (i.getMaMA().equals(maMonAn)) 
				index = i;
		this.monAn.remove(index);
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM monan WHERE mama = ?");			
			stmt.setString(1, maMonAn);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}
