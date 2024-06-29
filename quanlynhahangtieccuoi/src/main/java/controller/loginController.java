package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;



public class loginController {
	final loginView a;
		loginController() {
			a = new loginView();
			
			
			
			a.loginB.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					loginBAction();
					
				};
			}) ;	
		}	   
		 
		 
		 void loginBAction() {
			 NhanVienModel nhanVienM = new NhanVienModel();
				
				
				NhanVien nhanVien = nhanVienM.getNhanVienTuTaiKhoan(a.userTF.getText());
					
				String pass = new String(a.passwordPF.getPassword());
					
				if (nhanVien != null) {
					
				String passR = nhanVien.getMatKhau();
				
				if ( passR.equals(pass)){	
					if (nhanVien.getMuc() == 1) {
						a.loginF.setVisible(false);
						new QuanLyLoginConTroller().setMaNV(nhanVien.getMaNV());;
						maNV a   = new maNV();
						maNV.maNVV =nhanVien.getMaNV();
					}
					else
					{
						
						if (nhanVien.getMuc() == 2) {
							a.loginF.setVisible(false);
							new NhanVienLoginController().setMaNV(nhanVien.getMaNV());;
							maNV a   = new maNV();
							maNV.maNVV =nhanVien.getMaNV();
							}
					}
					}		
				else
					a.wrongPasswordEvent();
				}
				else
					a.wrongPasswordEvent();
		 }
		 
		 public static void main(String[] args) {
		       new loginController();
		     
		  }
}
