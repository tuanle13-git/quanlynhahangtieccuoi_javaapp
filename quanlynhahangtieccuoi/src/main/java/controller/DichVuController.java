package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.DichVu;
import model.DichVuModel;

import view.DichVuView;

public class DichVuController {
	DichVuView dichVuView;
	DichVuModel dichVuModel;
	public DichVuController() {
		dichVuModel = new DichVuModel();
		dichVuView = new DichVuView();
		xulyButton();
		taoBang();
	}
	
	public void taoBang() {
		  DefaultTableModel dTable1;
		  dichVuView.Bang.removeAll();
	      dTable1 = new DefaultTableModel();
	      String headT[] = {"Mã dịch vụ","Tên dịch vụ","Giá thành","Ghi chú"};
	      dTable1.setColumnIdentifiers(headT);     
	      dichVuView.Bang.setModel(dTable1);
	      
	      layToanBoDanhSach(dTable1);
	      
	}
	
	void layToanBoDanhSach(DefaultTableModel dTable) {
		
			try {
			if (dichVuModel.dichVu.size()>0)
			for (DichVu i : dichVuModel.dichVu) {
				String row[] = {String.valueOf(i.getMaDV()),i.getTenDV(),String.valueOf(i.getGiaDV()),i.getghiChu()};
				dTable.addRow(row);
			}	
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
			
	}
	public void xulyButton () {
		dichVuView.clearB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				clearAction();
			}
		});
	
		dichVuView.themB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			if (!dichVuView.maJL.getText().equals("")) {
					JOptionPane.showMessageDialog(dichVuView, "Vui lòng clear trước khi thêm!");
				return;
			 }
			 if (checkTFNull()==false || dichVuView.maTF.getText().equals("")) {  
		            JOptionPane.showMessageDialog(dichVuView, "Vui lòng nhập đầy đủ thông tin");
		            return ;
		        }
			 if (CheckMaDV(dichVuView.maTF.getText())) {
				 JOptionPane.showMessageDialog(dichVuView, "Mã dịch vụ này đã tồn tại");
		            return ;
			 }
			
			 if (!dichVuView.giaTF.getText().equals(""))
			 try {
				 Long.parseLong(dichVuView.giaTF.getText());
				 
			} catch (NumberFormatException e2) {
				 JOptionPane.showMessageDialog(dichVuView, "Vui lòng nhập đúng định dạng giá thành ( số nguyên)");
				return;			
			}
			 int a = JOptionPane.showOptionDialog(null, "Bạn đã xác nhận đúng thông tin và muốn thêm dịch vụ này?", "Xác nhận",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		        
		        if (a == JOptionPane.YES_OPTION) {
		        	DichVu dichVuA = new DichVu(dichVuView.maTF.getText(),dichVuView.tenTF.getText(),Integer.parseInt(dichVuView.giaTF.getText()),dichVuView.ghiTF.getText());
					 dichVuModel.addDichVu(dichVuA);
					 taoBang();	
					 clearAction();
			}
			}
			
		});
		
		dichVuView.suaB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			 if (!(dichVuView.maJL.getText().equals("") || dichVuView.maTF.getText().equals(""))) {
				 JOptionPane.showMessageDialog(dichVuView, "Vui lòng chọn dịch vụ hoặc nhập mã dịch vụ");
		            return ;
			 }
			
			 if (!(CheckMaDV(dichVuView.maTF.getText()) || CheckMaDV(dichVuView.maJL.getText()))) {
				 JOptionPane.showMessageDialog(dichVuView, "Mã dịch vụ này đã không tồn tại");
		            return ;
			 }
			
			 if (!dichVuView.giaTF.getText().equals(""))
			 try {
				 Long.parseLong(dichVuView.giaTF.getText());
				 
			} catch (NumberFormatException e2) {
				 JOptionPane.showMessageDialog(dichVuView, "Vui lòng nhập đúng định dạng giá thành ( số nguyên)");
				return;			
			}
			 int a = JOptionPane.showOptionDialog(null, "Bạn thật sự muốn sửa các thông tin trên?", "Xác nhận",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		        
		        if (a == JOptionPane.YES_OPTION) {
		        	if (dichVuView.maTF.getText().equals(""))
		        	{
		        	DichVu dichVuA = new DichVu(dichVuView.maJL.getText(),dichVuView.tenTF.getText(),Integer.parseInt(dichVuView.giaTF.getText()),dichVuView.ghiTF.getText());
					 dichVuModel.suaDichVu(dichVuA);
					 taoBang();	
					 clearAction();
		        	}
		        	else {
		        		if (dichVuView.giaTF.getText().equals("")) dichVuView.giaTF.setText("-1");
		        		DichVu dichVuA = new DichVu(dichVuView.maTF.getText(),dichVuView.tenTF.getText(),Integer.parseInt(dichVuView.giaTF.getText()),dichVuView.ghiTF.getText());
		        		dichVuView.giaTF.setText("");
						 dichVuModel.suaDichVu(dichVuA);
						 taoBang();	
						 clearAction();
		        	}
		        } 			 
			 
			}
		});
		
		
		dichVuView.xoaB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				 if (dichVuView.maJL.getText().equals("") && dichVuView.maTF.getText().equals("")) {
					 JOptionPane.showMessageDialog(dichVuView, "Vui lòng chọn dịch vụ hoặc nhập mã dịch vụ");
			            return ;
				 }
				 if (!(CheckMaDV(dichVuView.maTF.getText()) || CheckMaDV(dichVuView.maJL.getText()))) {
					 JOptionPane.showMessageDialog(dichVuView, "Mã dịch vụ này đã không tồn tại");
			            return ;
				 }
				 int a = JOptionPane.showOptionDialog(null, "Bạn thật sự muốn xóa dịch vụ này?", "Xác nhận",
			                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			        
			        if (a == JOptionPane.YES_OPTION) {
			        	if (!dichVuView.maTF.getText().equals("")) {
							 dichVuModel.xoaDichVu(dichVuView.maTF.getText());
							 taoBang();	
							 clearAction();
							 return;
						 }
						 dichVuModel.xoaDichVu(dichVuView.maJL.getText());
						 taoBang();	
						 clearAction();
						 return;
						 
			        } 			
				 
			}
		});
		dichVuView.Bang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
         
          public void valueChanged(ListSelectionEvent e) {
              if (!e.getValueIsAdjusting()) {
                  int selectedRow = dichVuView.Bang.getSelectedRow();
                  int selectedColumn = dichVuView.Bang.getSelectedColumn();
                  if (selectedRow != -1 && selectedColumn != -1) {
                  	dichVuView.maTF.setText("");
                  	dichVuView.remove(dichVuView.maTF);
              		dichVuView.add(dichVuView.maJL);
              		dichVuView.tenTF.setText(dichVuView.Bang.getValueAt(selectedRow, 1).toString());         		
              		dichVuView.giaTF.setText(dichVuView.Bang.getValueAt(selectedRow, 2).toString());
              		dichVuView.ghiTF.setText(dichVuView.Bang.getValueAt(selectedRow, 3).toString());
              		dichVuView.maJL.setText(dichVuView.Bang.getValueAt(selectedRow, 0).toString());
                  }
              }
          }

			
      });
	}
	void clearAction() {
		dichVuView.remove(dichVuView.maJL);
		dichVuView.add(dichVuView.maTF);
		dichVuView.tenTF.setText("");
		dichVuView.giaTF.setText("");
		dichVuView.ghiTF.setText("");
		
		dichVuView.maJL.setText("");
		dichVuView.maTF.setText("");
		dichVuView.revalidate();
		dichVuView.repaint();
	}
	void checkTruocKhiThem() {
		if (dichVuView.maJL.getText().equals("")) {
			JOptionPane.showMessageDialog(dichVuView, this, "Vui lòng clear trước khi thêm!", 0);
		}
	}
	boolean  checkTFNull(){
    
      if (dichVuView.tenTF.getText().equals("")) return false;
      if (dichVuView.ghiTF.getText().equals("")) return false;
      if (dichVuView.giaTF.getText().equals("")) return false;
    
      return true;
  }
	
	boolean CheckMaDV(String maKH) {
		for (DichVu i : dichVuModel.dichVu) 
			if (i.getMaDV().equals(maKH)) 
				return true;
			
		return false;
	}
}
