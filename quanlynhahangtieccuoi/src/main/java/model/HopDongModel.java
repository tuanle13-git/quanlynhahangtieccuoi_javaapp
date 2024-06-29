package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;

public class HopDongModel {
	public ArrayList<HopDong> hopDong;
	private Connection conn;
public	HopDongModel() {
		hopDong = new ArrayList<HopDong>();
		String databaseURL = "jdbc:mysql://localhost:3306/qltc";
		String databaseUser = "root";
		String databasePassword = "";
		String driverDb = "com.mysql.cj.jdbc.Driver";
		
		try { 
		Class.forName(driverDb);
		
		conn = DriverManager.getConnection(databaseURL, databaseUser, databasePassword);
		 getDSHD ();
		
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
 	public void getDSHD() {
 		try {
			String makh1;
			String manv1;
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM hopdong ORDER BY ngayhd DESC");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				HopDong reSult = new HopDong();
				reSult.maHD = (rs.getString(1));
				reSult.maNV = (rs.getString(2));
				reSult.maKH = (rs.getString(3));
				reSult.maSanh = (rs.getString(4));
				reSult.soBan = (rs.getInt(5));
				reSult.soTien = (rs.getInt(6));
				reSult.ngayHD = (rs.getDate(7));
				reSult.tthai = rs.getInt(8);
				hopDong.add(reSult);
			         }
		
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		for (HopDong i : hopDong) {
 			try {
 			i.dsMonAn.removeAll(i.dsMonAn);
			PreparedStatement stmt1 = conn.prepareStatement("SELECT * FROM monan JOIN danhsachmon ON danhsachmon.mama = monan.mama WHERE danhsachmon.mahd = ?");
			stmt1.setString(1, i.maHD);
			ResultSet rs1 = stmt1.executeQuery();
			while (rs1.next()) {
				MonAn reSult = new MonAn();
				reSult.setMaMA(rs1.getString(1));
				reSult.setTenMA(rs1.getString(2));			
				reSult.setLoaiMA(rs1.getString(3));
				reSult.setGiaMA(rs1.getInt(4));
				
				
				i.dsMonAn.add(reSult);
			         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	try {
			
			i.dsDichVu.removeAll(i.dsDichVu);
			PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM dichvu JOIN danhsachdv ON DanhSachDV.madv = dichvu.madv WHERE DanhSachDV.mahd = ?");
		
			stmt2.setString(1, i.maHD);
			
		
		ResultSet rs2 = stmt2.executeQuery();
			while (rs2.next()) {
				DichVu reSult = new DichVu();
				reSult.setMaDV(rs2.getString(1));
				reSult.setTenDV(rs2.getString(2));			
				
				reSult.setGiaDV(rs2.getInt(3));
				reSult.setghiChu(rs2.getString(4));
				
				i.dsDichVu.add(reSult);
			         }
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 		}
		
 	}
 	
 	public HopDong getHDTMHD(String maHDD) {
 		for (HopDong i : hopDong) {
 			if (maHDD.equals(i.maHD)) {
 				return i;
 			}
 		}
 		
 		return new HopDong();
 	}
 	
 	public void  themHd(HopDong ctr) {
 		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO `hopdong`(`mahd`, `manv`, `makh`, `masanh`, `sobandat`, `sotienthanhtoan`, `ngayhd`, `trangthaithanhtoan`) VALUES  (?,?, ?,?,?,?,?,?)");
			stmt.setString(1, ctr.getMaHD());
			stmt.setString(2, ctr.getMaNV());
			stmt.setString(3, ctr.getMaKH());
			stmt.setString(4, ctr.getMaSanh());
			stmt.setInt(5, ctr.soBan);
			stmt.setInt(6, ctr.soTien);
			stmt.setDate(7, ctr.ngayHD);
			stmt.setInt(8, ctr.tthai);	
			stmt.executeUpdate();
			this.hopDong.add(ctr);
			for (DichVu i :ctr.dsDichVu) {
				try {
					PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO `danhsachdv`(mahd,madv) VALUES  (?,?)");
					stmt2.setString(1, ctr.getMaHD());
					stmt2.setString(2, i.getMaDV());
					stmt2.executeUpdate();
				} catch (Exception e) {
					continue;
				}
			
			}
			for (MonAn i :ctr.dsMonAn) {
				try {
					PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO `danhsachmon`(mahd,mama) VALUES  (?,?)");
					stmt2.setString(1, ctr.getMaHD());
					stmt2.setString(2, i.getMaMA());
					stmt2.executeUpdate();
				} catch (Exception e) {
					continue;
				}
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 		
 	           
 		
 	}
 	
 	public void suaHopDong(HopDong hd) {
 		for (HopDong i : hopDong) {
 			if (i.maHD.equals(hd.maHD)) 
 				i = hd;
 		}
 		
 		try {
 			PreparedStatement stmt3;
			stmt3 = conn.prepareStatement("DELETE FROM `danhsachdv` WHERE mahd = ?");
			stmt3.setString(1, hd.getMaHD());
			stmt3.executeUpdate();
			PreparedStatement stmt4;
			stmt4 = conn.prepareStatement("DELETE FROM `danhsachmon` WHERE mahd = ?");
			stmt4.setString(1, hd.getMaHD());
			stmt4.executeUpdate();
		} catch (Exception e) {
			
		}
 	
		try {	PreparedStatement stmt;
			stmt = conn.prepareStatement("UPDATE `hopdong` SET `manv`= ?,`makh`=? ,`masanh`=?,`sobandat`=?,`sotienthanhtoan`=?,`ngayhd`=?,`trangthaithanhtoan`=? WHERE `mahd` = ? ");
			
			stmt.setString(1, hd.getMaNV());
			stmt.setString(2, hd.getMaKH());
			stmt.setString(3, hd.getMaSanh());
			stmt.setInt(4, hd.soBan);
			stmt.setInt(5, hd.soTien);
			stmt.setDate(6, hd.ngayHD);
			stmt.setInt(7, hd.tthai);
			stmt.setString(8, hd.getMaHD());
			stmt.executeUpdate();
	 		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (DichVu i :hd.dsDichVu) {
			try {
				PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO `danhsachdv`(mahd,madv) VALUES  (?,?)");
				stmt2.setString(1, hd.getMaHD());
				stmt2.setString(2, i.getMaDV());
				stmt2.executeUpdate();
			} catch (Exception e) {
				continue;
			}
		
		}
		for (MonAn i :hd.dsMonAn) {
			try {
				PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO `danhsachmon`(mahd,mama) VALUES  (?,?)");
				stmt2.setString(1, hd.getMaHD());
				stmt2.setString(2, i.getMaMA());
				stmt2.executeUpdate();
			} catch (Exception e) {
				continue;
			}
		
		}
	
		
		
 		
}
 	public void timTheoKey(String key) {
 		try {
			String makh1;
			String manv1;
			hopDong.removeAll(hopDong);
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM hopdong WHERE mahd LIKE ? OR manv LIKE ? OR makh LIKE ? OR masanh LIKE ? OR sobandat LIKE ? OR sotienthanhtoan LIKE ? OR ngayhd LIKE ? OR trangthaithanhtoan LIKE ? ORDER BY ngayhd DESC");
			  for (int i = 1; i <= 8; i++) {
	                stmt.setString(i, "%" + key + "%");
	            }
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				HopDong reSult = new HopDong();
				reSult.maHD = (rs.getString(1));
				reSult.maNV = (rs.getString(2));
				reSult.maKH = (rs.getString(3));
				reSult.maSanh = (rs.getString(4));
				reSult.soBan = (rs.getInt(5));
				reSult.soTien = (rs.getInt(6));
				reSult.ngayHD = (rs.getDate(7));
				reSult.tthai = rs.getInt(8);
				hopDong.add(reSult);
			         }
		
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return;
		}
 		
 		for (HopDong i : hopDong) {
 			try {
 			i.dsMonAn.removeAll(i.dsMonAn);
			PreparedStatement stmt1 = conn.prepareStatement("SELECT * FROM monan JOIN danhsachmon ON danhsachmon.mama = monan.mama WHERE danhsachmon.mahd = ?");
			stmt1.setString(1, i.maHD);
			ResultSet rs1 = stmt1.executeQuery();
			while (rs1.next()) {
				MonAn reSult = new MonAn();
				reSult.setMaMA(rs1.getString(1));
				reSult.setTenMA(rs1.getString(2));			
				reSult.setLoaiMA(rs1.getString(3));
				reSult.setGiaMA(rs1.getInt(4));
				
				
				i.dsMonAn.add(reSult);
			         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	try {
			
			i.dsDichVu.removeAll(i.dsDichVu);
			PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM dichvu JOIN danhsachdv ON DanhSachDV.madv = dichvu.madv WHERE DanhSachDV.mahd = ?");
		
			stmt2.setString(1, i.maHD);
			
		
		ResultSet rs2 = stmt2.executeQuery();
			while (rs2.next()) {
				DichVu reSult = new DichVu();
				reSult.setMaDV(rs2.getString(1));
				reSult.setTenDV(rs2.getString(2));			
				
				reSult.setGiaDV(rs2.getInt(3));
				reSult.setghiChu(rs2.getString(4));
				
				i.dsDichVu.add(reSult);
			         }
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 		}
		
 	}
}
