package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.Sanh;
import model.SanhModel;

import view.SanhView;

public class SanhController {
	SanhView sanhView;
	SanhModel sanhModel;
	public SanhController() {
		sanhModel = new SanhModel();
		sanhView = new SanhView();
		xulyButton();
		taoBang();
	}
	
	public void taoBang() {
		  DefaultTableModel dTable1;
		  sanhView.Bang.removeAll();
	      dTable1 = new DefaultTableModel();
	      String headT[] = {"Mã sảnh","Tên sảnh","Số bàn tối đa","Giá thành"};
	      dTable1.setColumnIdentifiers(headT);     
	      sanhView.Bang.setModel(dTable1);
	      
	      layToanBoDanhSach(dTable1);
	      sanhView.Bang.revalidate();
	      sanhView.Bang.repaint();
	      
	}
	
	void layToanBoDanhSach(DefaultTableModel dTable) {
		
			try {
			if (sanhModel.sanh.size()>0)
			for (Sanh i : sanhModel.sanh) {
				String row[] = {String.valueOf(i.getMaSanh()),i.getTenSanh(),String.valueOf(i.getSoBanToiDa()),String.valueOf(i.getGiaSanh())};
				dTable.addRow(row);
			}	
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
			
	}
	
	public void xulyButton () {
		sanhView.clearB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				clearAction();
			}
		});
	
		sanhView.themB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			if (!sanhView.maJL.getText().equals("")) {
					JOptionPane.showMessageDialog(sanhView, "Vui lòng clear trước khi thêm!");
				return;
			 }
			 if (checkTFNull()==false || sanhView.maTF.getText().equals("")) {  
		            JOptionPane.showMessageDialog(sanhView, "Vui lòng nhập đầy đủ thông tin");
		            return ;
		        }
			 if (checkMaMA(sanhView.maTF.getText())) {
				 JOptionPane.showMessageDialog(sanhView, "Mã sảnh này đã tồn tại");
		            return ;
			 }
			 if (!sanhView.soTF.getText().equals(""))
				 try {
					 Long.parseLong(sanhView.soTF.getText());
					 
				} catch (NumberFormatException e2) {
					 JOptionPane.showMessageDialog(sanhView, "Vui lòng nhập đúng định dạng số lượng bàn tối đa ( số nguyên)");
					return;			
				}
			 
			 if (!sanhView.giaTF.getText().equals(""))
			 try {
				 Long.parseLong(sanhView.giaTF.getText());
				 
			} catch (NumberFormatException e2) {
				 JOptionPane.showMessageDialog(sanhView, "Vui lòng nhập đúng định dạng giá thành ( số nguyên)");
				return;			
			}
			 int a = JOptionPane.showOptionDialog(null, "Bạn đã xác nhận đúng thông tin và muốn thêm sảnh này?", "Xác nhận",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		        
		        if (a == JOptionPane.YES_OPTION) {
		        	Sanh sanhA = new Sanh(sanhView.maTF.getText(),sanhView.tenTF.getText(),Integer.parseInt(sanhView.soTF.getText()),Integer.parseInt(sanhView.giaTF.getText()));
					 sanhModel.addSanh(sanhA);
					 taoBang();	
					 clearAction();
			}
			}
			
		});
		
		sanhView.suaB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			 if (!(sanhView.maJL.getText().equals("") || sanhView.maTF.getText().equals(""))) {
				 JOptionPane.showMessageDialog(sanhView, "Vui lòng chọn sảnh hoặc nhập mã sảnh");
		            return ;
			 }
			
			 if (!(checkMaMA(sanhView.maTF.getText()) || checkMaMA(sanhView.maJL.getText()))) {
				 JOptionPane.showMessageDialog(sanhView, "Mã sảnh này đã không tồn tại");
		            return ;
			 }
			
			 if (!sanhView.giaTF.getText().equals(""))
			 try {
				 Long.parseLong(sanhView.giaTF.getText());
				 
			} catch (NumberFormatException e2) {
				 JOptionPane.showMessageDialog(sanhView, "Vui lòng nhập đúng định dạng giá thành ( số nguyên)");
				return;			
			}
			 int a = JOptionPane.showOptionDialog(null, "Bạn thật sự muốn sửa các thông tin trên?", "Xác nhận",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		        
		        if (a == JOptionPane.YES_OPTION) {
		        	if (sanhView.maTF.getText().equals(""))
		        	{   
		        		if (sanhView.giaTF.getText().equals("")) sanhView.giaTF.setText("-1");
	        			if (sanhView.soTF.getText().equals("")) sanhView.soTF.setText("-1");
		        		Sanh sanhA = new Sanh(sanhView.maJL.getText(),sanhView.tenTF.getText(),Integer.parseInt(sanhView.soTF.getText()),Integer.parseInt(sanhView.giaTF.getText()));
						 sanhModel.suaSanh(sanhA);
						 taoBang();	
						 clearAction();
		        	}
		        	else {
		        		if (sanhView.giaTF.getText().equals("")) sanhView.giaTF.setText("-1");
		        		if (sanhView.soTF.getText().equals("")) sanhView.soTF.setText("-1");
		        		Sanh sanhA = new Sanh(sanhView.maTF.getText(),sanhView.tenTF.getText(),Integer.parseInt(sanhView.soTF.getText()),Integer.parseInt(sanhView.giaTF.getText()));
						 sanhModel.suaSanh(sanhA);
						 taoBang();	
						 clearAction();
		        	}
		        } 			 
			 
			}
		});
		
sanhView.TimB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				sanhModel.timTheoKey(sanhView.timTF.getText());
				taoBang();
                sanhView.Bang.revalidate();
	            sanhView.Bang.repaint();
				
			}
		});
		
		sanhView.xoaB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				 if (!(sanhView.maJL.getText().equals("") || sanhView.maTF.getText().equals(""))) {
					 JOptionPane.showMessageDialog(sanhView, "Vui lòng chọn sảnh hoặc nhập mã sảnh");
			            return ;
				 }
				 if (!(checkMaMA(sanhView.maTF.getText()) || checkMaMA(sanhView.maJL.getText()))) {
					 JOptionPane.showMessageDialog(sanhView, "Mã sảnh này đã không tồn tại");
			            return ;
				 }
				 int a = JOptionPane.showOptionDialog(null, "Bạn thật sự muốn xóa sảnh này?", "Xác nhận",
			                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			        
			        if (a == JOptionPane.YES_OPTION) {
			        	if (!sanhView.maTF.getText().equals("")) {
							 sanhModel.xoaSanh(sanhView.maTF.getText());
							 taoBang();	
							 clearAction();
							 return;
						 }
						 sanhModel.xoaSanh(sanhView.maJL.getText());
						 taoBang();	
						 clearAction();
						 return;
						 
			        } 			
				 
			}
		});
		sanhView.Bang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
         
          public void valueChanged(ListSelectionEvent e) {
              if (!e.getValueIsAdjusting()) {
                  int selectedRow = sanhView.Bang.getSelectedRow();
                  int selectedColumn = sanhView.Bang.getSelectedColumn();
                  if (selectedRow != -1 && selectedColumn != -1) {
                  	sanhView.maTF.setText("");
                  	sanhView.remove(sanhView.maTF);
              		sanhView.add(sanhView.maJL);
              		sanhView.tenTF.setText(sanhView.Bang.getValueAt(selectedRow, 1).toString()); 
              		sanhView.soTF.setText(sanhView.Bang.getValueAt(selectedRow, 2).toString());
              		sanhView.giaTF.setText(sanhView.Bang.getValueAt(selectedRow, 3).toString());
             		sanhView.maJL.setText(sanhView.Bang.getValueAt(selectedRow, 0).toString());
                  }
              }
          }

			
      });
	}
	void clearAction() {
		sanhView.remove(sanhView.maJL);
		sanhView.add(sanhView.maTF);
		sanhView.tenTF.setText("");
		sanhView.giaTF.setText("");
		sanhView.soTF.setText("");
		
		sanhView.maJL.setText("");
		sanhView.maTF.setText("");
		sanhView.revalidate();
		sanhView.repaint();
	}
	void checkTruocKhiThem() {
		if (sanhView.maJL.getText().equals("")) {
			JOptionPane.showMessageDialog(sanhView, this, "Vui lòng clear trước khi thêm!", 0);
		}
	}
	boolean  checkTFNull(){
    
      if (sanhView.tenTF.getText().equals("")) return false;
      if (sanhView.soTF.getText().equals("")) return false;
      if (sanhView.giaTF.getText().equals("")) return false;
    
      return true;
  }
	
	boolean checkMaMA(String mas) {
		for (Sanh i : sanhModel.sanh) 
			if (i.getMaSanh().equals(mas)) 
				return true;
			
		return false;
	}
}
