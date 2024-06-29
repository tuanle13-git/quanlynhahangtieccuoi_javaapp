package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.MonAn;
import model.MonAnModel;

import view.MonAnView;

public class MonAnController {
	MonAnView monAnView;
	MonAnModel monAnModel;
	public MonAnController() {
		monAnModel = new MonAnModel();
		monAnView = new MonAnView();
		xulyButton();
		taoBang();
	}
	
	public void taoBang() {
		  DefaultTableModel dTable1;
		  monAnView.Bang.removeAll();
	      dTable1 = new DefaultTableModel();
	      String headT[] = {"Mã món ăn","Tên món ăn","loại món ăn","Giá thành"};
	      dTable1.setColumnIdentifiers(headT);     
	      monAnView.Bang.setModel(dTable1);
	      
	      layToanBoDanhSach(dTable1);
	      monAnView.Bang.revalidate();
	      monAnView.Bang.repaint();
	      
	}
	
	void layToanBoDanhSach(DefaultTableModel dTable) {
		
			try {
			if (monAnModel.monAn.size()>0)
			for (MonAn i : monAnModel.monAn) {
				String row[] = {String.valueOf(i.getMaMA()),i.getTenMA(),i.getLoaiMA(),String.valueOf(i.getGiaMA())};
				dTable.addRow(row);
			}	
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
			
	}
	
	public void xulyButton () {
		monAnView.clearB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				clearAction();
			}
		});
	    monAnView.TimB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				monAnModel.timTheoKey(monAnView.timTF.getText());
				taoBang();
 monAnView.Bang.revalidate();
	      monAnView.Bang.repaint();
				
			}
		});
		monAnView.themB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			if (!monAnView.maJL.getText().equals("")) {
					JOptionPane.showMessageDialog(monAnView, "Vui lòng clear trước khi thêm!");
				return;
			 }
			 if (checkTFNull()==false || monAnView.maTF.getText().equals("")) {  
		            JOptionPane.showMessageDialog(monAnView, "Vui lòng nhập đầy đủ thông tin");
		            return ;
		        }
			 if (checkMaMA(monAnView.maTF.getText())) {
				 JOptionPane.showMessageDialog(monAnView, "Mã món ăn này đã tồn tại");
		            return ;
			 }
			
			 if (!monAnView.giaTF.getText().equals(""))
			 try {
				 Long.parseLong(monAnView.giaTF.getText());
				 
			} catch (NumberFormatException e2) {
				 JOptionPane.showMessageDialog(monAnView, "Vui lòng nhập đúng định dạng giá thành ( số nguyên)");
				return;			
			}
			 int a = JOptionPane.showOptionDialog(null, "Bạn đã xác nhận đúng thông tin và muốn thêm món ăn này?", "Xác nhận",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		        
		        if (a == JOptionPane.YES_OPTION) {
		        	MonAn monAnA = new MonAn(monAnView.maTF.getText(),monAnView.tenTF.getText(),monAnView.loaiTF.getText(),Integer.parseInt(monAnView.giaTF.getText()));
					 monAnModel.addMonAn(monAnA);
					 taoBang();	
					 clearAction();
			}
			}
			
		});
		
		monAnView.suaB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			 if (!(monAnView.maJL.getText().equals("") || monAnView.maTF.getText().equals(""))) {
				 JOptionPane.showMessageDialog(monAnView, "Vui lòng chọn món ăn hoặc nhập mã món ăn");
		            return ;
			 }
			
			 if (!(checkMaMA(monAnView.maTF.getText()) || checkMaMA(monAnView.maJL.getText()))) {
				 JOptionPane.showMessageDialog(monAnView, "Mã món ăn này đã không tồn tại");
		            return ;
			 }
			
			 if (!monAnView.giaTF.getText().equals(""))
			 try {
				 Long.parseLong(monAnView.giaTF.getText());
				 
			} catch (NumberFormatException e2) {
				 JOptionPane.showMessageDialog(monAnView, "Vui lòng nhập đúng định dạng giá thành ( số nguyên)");
				return;			
			}
			 int a = JOptionPane.showOptionDialog(null, "Bạn thật sự muốn sửa các thông tin trên?", "Xác nhận",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		        
		        if (a == JOptionPane.YES_OPTION) {
		        	if (monAnView.maTF.getText().equals(""))
		        	{
		        	MonAn monAnA = new MonAn(monAnView.maTF.getText(),monAnView.tenTF.getText(),monAnView.loaiTF.getText(),Integer.parseInt(monAnView.giaTF.getText()));
					 monAnModel.suaMonAn(monAnA);
					 taoBang();	
					 clearAction();
		        	}
		        	else {
		        		if (monAnView.giaTF.getText().equals("")) monAnView.giaTF.setText("-1");
		        		MonAn monAnA = new MonAn(monAnView.maTF.getText(),monAnView.tenTF.getText(),monAnView.loaiTF.getText(),Integer.parseInt(monAnView.giaTF.getText()));		        		monAnView.giaTF.setText("");
						 monAnModel.suaMonAn(monAnA);
						 taoBang();	
						 clearAction();
		        	}
		        } 			 
			 
			}
		});
		
		
		monAnView.xoaB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				 if (!(monAnView.maJL.getText().equals("") || monAnView.maTF.getText().equals(""))) {
					 JOptionPane.showMessageDialog(monAnView, "Vui lòng chọn món ăn hoặc nhập mã món ăn");
			            return ;
				 }
				 if (!(checkMaMA(monAnView.maTF.getText()) || checkMaMA(monAnView.maJL.getText()))) {
					 JOptionPane.showMessageDialog(monAnView, "Mã món ăn này đã không tồn tại");
			            return ;
				 }
				 int a = JOptionPane.showOptionDialog(null, "Bạn thật sự muốn xóa món ăn này?", "Xác nhận",
			                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			        
			        if (a == JOptionPane.YES_OPTION) {
			        	if (!monAnView.maTF.getText().equals("")) {
							 monAnModel.xoaMonAn(monAnView.maTF.getText());
							 taoBang();	
							 clearAction();
							 return;
						 }
						 monAnModel.xoaMonAn(monAnView.maJL.getText());
						 taoBang();	
						 clearAction();
						 return;
						 
			        } 			
				 
			}
		});
		monAnView.Bang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
         
          public void valueChanged(ListSelectionEvent e) {
              if (!e.getValueIsAdjusting()) {
                  int selectedRow = monAnView.Bang.getSelectedRow();
                  int selectedColumn = monAnView.Bang.getSelectedColumn();
                  if (selectedRow != -1 && selectedColumn != -1) {
                  	monAnView.maTF.setText("");
                  	monAnView.remove(monAnView.maTF);
              		monAnView.add(monAnView.maJL);
              		monAnView.tenTF.setText(monAnView.Bang.getValueAt(selectedRow, 1).toString()); 
              		monAnView.loaiTF.setText(monAnView.Bang.getValueAt(selectedRow, 2).toString());
              		monAnView.giaTF.setText(monAnView.Bang.getValueAt(selectedRow, 3).toString());
             		monAnView.maJL.setText(monAnView.Bang.getValueAt(selectedRow, 0).toString());
                  }
              }
          }

			
      });
	}
	void clearAction() {
		monAnView.remove(monAnView.maJL);
		monAnView.add(monAnView.maTF);
		monAnView.tenTF.setText("");
		monAnView.giaTF.setText("");
		monAnView.loaiTF.setText("");
		
		monAnView.maJL.setText("");
		monAnView.maTF.setText("");
		monAnView.revalidate();
		monAnView.repaint();
	}
	void checkTruocKhiThem() {
		if (monAnView.maJL.getText().equals("")) {
			JOptionPane.showMessageDialog(monAnView, this, "Vui lòng clear trước khi thêm!", 0);
		}
	}
	boolean  checkTFNull(){
    
      if (monAnView.tenTF.getText().equals("")) return false;
      if (monAnView.loaiTF.getText().equals("")) return false;
      if (monAnView.giaTF.getText().equals("")) return false;
    
      return true;
  }
	
	boolean checkMaMA(String mama) {
		for (MonAn i : monAnModel.monAn) 
			if (i.getMaMA().equals(mama)) 
				return true;
			
		return false;
	}
}
