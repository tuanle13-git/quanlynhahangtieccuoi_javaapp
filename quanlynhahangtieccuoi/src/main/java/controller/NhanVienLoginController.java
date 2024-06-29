
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.NhanVienLogin;
import view.TaoHopDong;
import view.HopDongView;

public class NhanVienLoginController {
	NhanVienLogin nhanVienLogin ;
	String maNV;
	public NhanVienLoginController() {
		nhanVienLogin = new NhanVienLogin();
		xuLyButton();				
		nhanVienLogin.khungCN.removeAll();
		final HopDongController hopDongController1 = new HopDongController();
		nhanVienLogin.khungCN.add(hopDongController1.khung);
		nhanVienLogin.clickE();
		nhanVienLogin.hdB.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
		hopDongController1.hopDongView.jButton3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				nhanVienLogin.khungCN.removeAll();
				
				nhanVienLogin.khungCN.add(hopDongController1.taoHopDong);
				nhanVienLogin.khungCN.revalidate();
				nhanVienLogin.khungCN.repaint();
				
			}
		});
		nhanVienLogin.khungCN.revalidate();
		nhanVienLogin.khungCN.repaint();
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	void xuLyButton() {
		nhanVienLogin.hdB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				nhanVienLogin.khungCN.removeAll();
				final HopDongController hopDongController = new HopDongController();
				nhanVienLogin.khungCN.add(hopDongController.khung);
				nhanVienLogin.clickE();
				nhanVienLogin.hdB.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
				
				
				nhanVienLogin.khungCN.revalidate();
				nhanVienLogin.khungCN.repaint();
				
			}
		});
		nhanVienLogin.sanhB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				nhanVienLogin.khungCN.removeAll();
				nhanVienLogin.clickE();
				nhanVienLogin.sanhB.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
				SanhController sanhController = new SanhController();
				nhanVienLogin.khungCN.add(sanhController.sanhView);
				nhanVienLogin.khungCN.revalidate();
				nhanVienLogin.khungCN.repaint();
			}
		});
		nhanVienLogin.khB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				nhanVienLogin.khungCN.removeAll();
				KhachHangController khachHangController = new KhachHangController();
				nhanVienLogin.clickE();
				nhanVienLogin.khB.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
				nhanVienLogin.khungCN.add(khachHangController.khachHangView);
				nhanVienLogin.khungCN.revalidate();
				nhanVienLogin.khungCN.repaint();
			}
		});
		nhanVienLogin.dvB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				nhanVienLogin.khungCN.removeAll();
				nhanVienLogin.clickE();
				nhanVienLogin.dvB.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
				DichVuController dichVuController = new DichVuController();
				nhanVienLogin.khungCN.add(dichVuController.dichVuView);
				nhanVienLogin.khungCN.revalidate();
				nhanVienLogin.khungCN.repaint();
			}
		});
		nhanVienLogin.maB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				nhanVienLogin.khungCN.removeAll();
				nhanVienLogin.clickE();
				nhanVienLogin.maB.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
				
				MonAnController monAnController = new MonAnController();
				nhanVienLogin.khungCN.add(monAnController.monAnView);
				nhanVienLogin.khungCN.revalidate();
				nhanVienLogin.khungCN.repaint();
			}
		});
		
		
		
	}
}
