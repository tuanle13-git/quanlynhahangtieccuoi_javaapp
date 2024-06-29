package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.KhachHang;
import model.KhachHangModel;

import view.KhachHangView;

public class KhachHangController {
	KhachHangView khachHangView;
	KhachHangModel khachHangModel;
	
	
	public KhachHangController() {
		khachHangView = new KhachHangView();
		khachHangModel = new KhachHangModel();
		
		xulyButton();
		taoBang();
	}
	
	public void taoBang() {
		  DefaultTableModel dTable;
		  khachHangView.Bang.removeAll();
	      dTable = new DefaultTableModel();
	      String headT[] = {"Mã khách hàng","Tên khách hàng","Số điện thoại","CCCD","Địa chỉ"};
	      dTable.setColumnIdentifiers(headT);     
	      khachHangView.Bang.setModel(dTable);
	      layToanBoDanhSach(dTable);
	      
	}
	
	void layToanBoDanhSach(DefaultTableModel dTable) {
		
			try {
			if (khachHangModel.khachHang.size()>0)
			for (KhachHang i : khachHangModel.khachHang) {
				String row[] = {String.valueOf(i.getMaKH()),i.getTenKH(),i.getSoDT(),i.getCCCD(),i.getDiaChi()};
				dTable.addRow(row);
			}	
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
			
	}
	public void xulyButton () {
	khachHangView.TimB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				khachHangModel.timTheoKey(khachHangView.timTF.getText());
				taoBang();
 khachHangView.Bang.revalidate();
	      khachHangView.Bang.repaint();
				
			}
		});
		
		khachHangView.clearB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				clearAction();
			}
		});
	
		khachHangView.themB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			if (!khachHangView.maJL.getText().equals("")) {
					JOptionPane.showMessageDialog(khachHangView, "Vui lòng clear trước khi thêm!");
				return;
			 }
			 if (checkTFNull()==false || khachHangView.maTF.getText().equals("")) {  
		            JOptionPane.showMessageDialog(khachHangView, "Vui lòng nhập đầy đủ thông tin");
		            return ;
		        }
			 if (checkMaKH(khachHangView.maTF.getText())) {
				 JOptionPane.showMessageDialog(khachHangView, "Mã khách hàng này đã tồn tại");
		            return ;
			 }
			 try {
				 Long.parseLong(khachHangView.soTF.getText());
				 
			} catch (NumberFormatException e2) {
				 JOptionPane.showMessageDialog(khachHangView, "Vui lòng nhập đúng định dạng số điện thoại");
				return;
			}
			 try {
				 Long.parseLong(khachHangView.cccdTF.getText());
				 
			} catch (NumberFormatException e2) {
				 JOptionPane.showMessageDialog(khachHangView, "Vui lòng nhập đúng định dạng CCCD");
				return;			
			}
			 int a = JOptionPane.showOptionDialog(null, "Bạn đã xác nhận đúng thông tin và muốn thêm khách hàng này?", "Xác nhận",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		        
		        if (a == JOptionPane.YES_OPTION) {
			 KhachHang khachHangA = new KhachHang(khachHangView.maTF.getText(),khachHangView.tenTF.getText(),khachHangView.soTF.getText(),khachHangView.cccdTF.getText(),khachHangView.diaChiTF.getText());
			 khachHangModel.addKhachHang(khachHangA);
			 taoBang();		 
			 clearAction();
			}
			}
			
		});
		
		khachHangView.suaB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			 if (!(khachHangView.maJL.getText().equals("") || khachHangView.maTF.getText().equals(""))) {
				 JOptionPane.showMessageDialog(khachHangView, "Vui lòng chọn khách hàng hoặc nhập mã khách hàng");
		            return ;
			 }
			
			 if (!(checkMaKH(khachHangView.maTF.getText()) || checkMaKH(khachHangView.maJL.getText()))) {
				 JOptionPane.showMessageDialog(khachHangView, "Mã khách hàng này đã không tồn tại");
		            return ;
			 }
			 if (!khachHangView.soTF.getText().equals(""))
			 try {
				 Long.parseLong(khachHangView.soTF.getText());
				 
			} catch (NumberFormatException e2) {
				 JOptionPane.showMessageDialog(khachHangView, "Vui lòng nhập đúng định dạng số điện thoại");
				return;
			}
			 if (!khachHangView.cccdTF.getText().equals(""))
			 try {
				 Long.parseLong(khachHangView.cccdTF.getText());
				 
			} catch (NumberFormatException e2) {
				 JOptionPane.showMessageDialog(khachHangView, "Vui lòng nhập đúng định dạng CCCD");
				return;			
			}
			 int a = JOptionPane.showOptionDialog(null, "Bạn thật sự muốn sửa các thông tin trên?", "Xác nhận",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		        
		        if (a == JOptionPane.YES_OPTION) {
		        	if (khachHangView.maTF.getText().equals(""))
		        	{
		        	KhachHang khachHangA = new KhachHang(khachHangView.maJL.getText(),khachHangView.tenTF.getText(),khachHangView.soTF.getText(),khachHangView.cccdTF.getText(),khachHangView.diaChiTF.getText());
					 khachHangModel.suaKhachHang(khachHangA);
					 taoBang();	
					 clearAction();
		        	}
		        	else {
		        		KhachHang khachHangA = new KhachHang(khachHangView.maTF.getText(),khachHangView.tenTF.getText(),khachHangView.soTF.getText(),khachHangView.cccdTF.getText(),khachHangView.diaChiTF.getText());
						 khachHangModel.suaKhachHang(khachHangA);
						 taoBang();	
						 clearAction();
		        	}
		        } 			 
			 
			}
		});
		
		
		khachHangView.xoaB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				 if (khachHangView.maJL.getText().equals("") && khachHangView.maTF.getText().equals("")) {
					 JOptionPane.showMessageDialog(khachHangView, "Vui lòng chọn khách hàng hoặc nhập mã khách hàng");
			            return ;
				 }
				 if (!(checkMaKH(khachHangView.maTF.getText()) || checkMaKH(khachHangView.maJL.getText()))) {
					 JOptionPane.showMessageDialog(khachHangView, "Mã khách hàng này đã không tồn tại");
			            return ;
				 }
				 int a = JOptionPane.showOptionDialog(null, "Bạn thật sự muốn xóa khách hàng này?", "Xác nhận",
			                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			        
			        if (a == JOptionPane.YES_OPTION) {
			        	if (!khachHangView.maTF.getText().equals("")) {
							 khachHangModel.xoaKhachHang(khachHangView.maTF.getText());
							 taoBang();	
							 clearAction();
							 return;
						 }
						 khachHangModel.xoaKhachHang(khachHangView.maJL.getText());
						 taoBang();	
						 clearAction();
						 return;
						 
			        } 			
				 
			}
		});
		khachHangView.Bang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
           
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = khachHangView.Bang.getSelectedRow();
                    int selectedColumn = khachHangView.Bang.getSelectedColumn();
                    if (selectedRow != -1 && selectedColumn != -1) {
                    	khachHangView.maTF.setText("");
                    	khachHangView.remove(khachHangView.maTF);
                		khachHangView.add(khachHangView.maJL);
                		khachHangView.tenTF.setText(khachHangView.Bang.getValueAt(selectedRow, 1).toString());
                		khachHangView.diaChiTF.setText(khachHangView.Bang.getValueAt(selectedRow, 4).toString());
                		khachHangView.cccdTF.setText(khachHangView.Bang.getValueAt(selectedRow, 3).toString());
                		khachHangView.soTF.setText(khachHangView.Bang.getValueAt(selectedRow, 2).toString());
                		khachHangView.maJL.setText(khachHangView.Bang.getValueAt(selectedRow, 0).toString());
                    }
                }
            }

			
        });
	}
	void clearAction() {
		khachHangView.remove(khachHangView.maJL);
		khachHangView.add(khachHangView.maTF);
		khachHangView.tenTF.setText("");
		khachHangView.diaChiTF.setText("");
		khachHangView.cccdTF.setText("");
		khachHangView.soTF.setText("");
		khachHangView.maJL.setText("");
		khachHangView.maTF.setText("");
		khachHangView.revalidate();
		khachHangView.repaint();
	}
	void checkTruocKhiThem() {
		if (khachHangView.maJL.getText().equals("")) {
			JOptionPane.showMessageDialog(khachHangView, this, "Vui lòng clear trước khi thêm!", 0);
		}
	}
	boolean  checkTFNull(){
      
        if (khachHangView.tenTF.getText().equals("")) return false;
        if (khachHangView.soTF.getText().equals("")) return false;
        if (khachHangView.cccdTF.getText().equals("")) return false;
        if (khachHangView.diaChiTF.getText().equals("")) return false;
        return true;
    }
	
	boolean checkMaKH(String maKH) {
		for (KhachHang i : khachHangModel.khachHang) 
			if (i.getMaKH().equals(maKH)) 
				return true;
			
		return false;
	}
	
}

	