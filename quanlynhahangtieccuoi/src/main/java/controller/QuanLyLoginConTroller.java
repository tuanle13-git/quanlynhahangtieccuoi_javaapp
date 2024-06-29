package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import view.QuanLyLogin;
import view.TaoHopDong;
import view.HopDongView;

public class QuanLyLoginConTroller {
	QuanLyLogin quanLyLogin ;
	String maNV;
	public QuanLyLoginConTroller() {
		quanLyLogin = new QuanLyLogin();
		xuLyButton();		
		quanLyLogin.khungCN.removeAll();
		final HopDongController hopDongController1 = new HopDongController();
		quanLyLogin.khungCN.add(hopDongController1.khung);
		quanLyLogin.clickE();
		quanLyLogin.hdB.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
		
		quanLyLogin.khungCN.revalidate();
		quanLyLogin.khungCN.repaint();
	
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	void xuLyButton() {
		quanLyLogin.hdB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				quanLyLogin.khungCN.removeAll();
				final HopDongController hopDongController = new HopDongController();
				quanLyLogin.khungCN.add(hopDongController.khung);
				quanLyLogin.clickE();
				quanLyLogin.hdB.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
				
				
				quanLyLogin.khungCN.revalidate();
				quanLyLogin.khungCN.repaint();
				
			}
		});
		quanLyLogin.sanhB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				quanLyLogin.khungCN.removeAll();
				quanLyLogin.clickE();
				quanLyLogin.sanhB.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
				SanhController sanhController = new SanhController();
				quanLyLogin.khungCN.add(sanhController.sanhView);
				quanLyLogin.khungCN.revalidate();
				quanLyLogin.khungCN.repaint();
			}
		});
		quanLyLogin.khB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				quanLyLogin.khungCN.removeAll();
				quanLyLogin.clickE();
				quanLyLogin.khB.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
				KhachHangController khachHangController = new KhachHangController();
				quanLyLogin.khungCN.add(khachHangController.khachHangView);
				quanLyLogin.khungCN.revalidate();
				quanLyLogin.khungCN.repaint();
			}
		});
		quanLyLogin.dvB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				quanLyLogin.khungCN.removeAll();
				quanLyLogin.clickE();
				quanLyLogin.dvB.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
				DichVuController dichVuController = new DichVuController();
				quanLyLogin.khungCN.add(dichVuController.dichVuView);
				quanLyLogin.khungCN.revalidate();
				quanLyLogin.khungCN.repaint();
			}
		});
		quanLyLogin.maB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				quanLyLogin.khungCN.removeAll();
				quanLyLogin.clickE();
				quanLyLogin.maB.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
				
				MonAnController monAnController = new MonAnController();
				quanLyLogin.khungCN.add(monAnController.monAnView);
				quanLyLogin.khungCN.revalidate();
				quanLyLogin.khungCN.repaint();
			}
		});
		quanLyLogin.nvB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				quanLyLogin.khungCN.removeAll();
				quanLyLogin.clickE();
				quanLyLogin.nvB.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
				NhanVienController nhanVienController = new NhanVienController();
				quanLyLogin.khungCN.add(nhanVienController.nhanVienView);
				quanLyLogin.khungCN.revalidate();
				quanLyLogin.khungCN.repaint();
			}
		});	
		
		
	}
}
