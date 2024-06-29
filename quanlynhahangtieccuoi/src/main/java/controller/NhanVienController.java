package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.NhanVien;
import model.NhanVien;
import model.NhanVienModel;
import view.NhanVienView;

public class NhanVienController {
	NhanVienView nhanVienView;
	NhanVienModel nhanVienModel;
	public NhanVienController() {
		nhanVienView= new NhanVienView();
		nhanVienModel = new NhanVienModel();
		
		xulyButton();
		taoBang();
	}
	
	public void taoBang() {
		  DefaultTableModel dTable;
		  nhanVienView.Bang.removeAll();
	      dTable = new DefaultTableModel();
	      String headT[] = {"Mã nhân viên","Tên nhân viên","Chức vụ","Số điện thoại","CCCD","Địa chỉ"};
	      dTable.setColumnIdentifiers(headT);     
	      nhanVienView.Bang.setModel(dTable);
	      layToanBoDanhSach(dTable);
	      
	}
	
	void layToanBoDanhSach(DefaultTableModel dTable) {
		
			try {
			if (nhanVienModel.nhanVien.size()>0)
			for (NhanVien i : nhanVienModel.nhanVien) {
				String row[] = {String.valueOf(i.getMaNV()),i.getTenNV(),i.getChucVu(),i.getSoDT(),i.getCCCD(),i.getDiaChi()};
				dTable.addRow(row);
				
			}	
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
			
	}
	public void xulyButton () {
		nhanVienView.clearB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				clearAction();
			}
		});
	
		nhanVienView.suaB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			if (!nhanVienView.maJL.getText().equals("")) {
					JOptionPane.showMessageDialog(nhanVienView, "Vui lòng clear trước khi thêm!");
				return;
			 }
			 if (checkTFNull()==false || nhanVienView.maTF.getText().equals("")) {  
		            JOptionPane.showMessageDialog(nhanVienView, "Vui lòng nhập đầy đủ thông tin");
		            return ;
		        }
			 if (checkMaNV(nhanVienView.maTF.getText())) {
				 JOptionPane.showMessageDialog(nhanVienView, "Mã nhân viên này đã tồn tại");
		            return ;
			 }
			 try {
				 Long.parseLong(nhanVienView.soTF.getText());
				 
			} catch (NumberFormatException e2) {
				 JOptionPane.showMessageDialog(nhanVienView, "Vui lòng nhập đúng định dạng số điện thoại");
				return;
			}
			 try {
				 Long.parseLong(nhanVienView.cccdTF.getText());
				 
			} catch (NumberFormatException e2) {
				 JOptionPane.showMessageDialog(nhanVienView, "Vui lòng nhập đúng định dạng CCCD");
				return;			
			}
			 int a = JOptionPane.showOptionDialog(null, "Bạn đã xác nhận đúng thông tin và muốn thêm nhân viên này?", "Xác nhận",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		        
		        if (a == JOptionPane.YES_OPTION) {
			 NhanVien nhanVienA = new NhanVien(nhanVienView.maTF.getText(),nhanVienView.tenTF.getText(),nhanVienView.chucvuTF.getText(),nhanVienView.soTF.getText(),nhanVienView.cccdTF.getText(),nhanVienView.diaChiTF.getText());
			 nhanVienModel.addNhanVien(nhanVienA);
			 taoBang();		 
			 clearAction();
			}
			}
			
		});
		nhanVienView.TimB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				nhanVienModel.timTheoKey(nhanVienView.timTF.getText());
				taoBang();
 nhanVienView.Bang.revalidate();
	      nhanVienView.Bang.repaint();
				
			}
		});
		nhanVienView.suaB2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			 if (!(nhanVienView.maJL.getText().equals("") || nhanVienView.maTF.getText().equals(""))) {
				 JOptionPane.showMessageDialog(nhanVienView, "Vui lòng chọn nhân viên hoặc nhập mã nhân viên");
		            return ;
			 }
			
			 if (!(checkMaNV(nhanVienView.maTF.getText()) || checkMaNV(nhanVienView.maJL.getText()))) {
				 JOptionPane.showMessageDialog(nhanVienView, "Mã nhân viên này đã không tồn tại");
		            return ;
			 }
			 if (!nhanVienView.soTF.getText().equals(""))
			 try {
				 Long.parseLong(nhanVienView.soTF.getText());
				 
			} catch (NumberFormatException e2) {
				 JOptionPane.showMessageDialog(nhanVienView, "Vui lòng nhập đúng định dạng số điện thoại");
				return;
			}
			 if (!nhanVienView.cccdTF.getText().equals(""))
			 try {
				 Long.parseLong(nhanVienView.cccdTF.getText());
				 
			} catch (NumberFormatException e2) {
				 JOptionPane.showMessageDialog(nhanVienView, "Vui lòng nhập đúng định dạng CCCD");
				return;			
			}
			 int a = JOptionPane.showOptionDialog(null, "Bạn thật sự muốn sửa các thông tin trên?", "Xác nhận",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		        
		        if (a == JOptionPane.YES_OPTION) {
		        	if (nhanVienView.maTF.getText().equals(""))
		        	{
		        	NhanVien nhanVienA = new NhanVien(nhanVienView.maJL.getText(),nhanVienView.tenTF.getText(),nhanVienView.chucvuTF.getText(),nhanVienView.soTF.getText(),nhanVienView.cccdTF.getText(),nhanVienView.diaChiTF.getText());
					 nhanVienModel.suaNhanVien(nhanVienA);
					 taoBang();	
					 clearAction();
		        	}
		        	else {
		        		NhanVien nhanVienA = new NhanVien(nhanVienView.maTF.getText(),nhanVienView.tenTF.getText(),nhanVienView.chucvuTF.getText(),nhanVienView.soTF.getText(),nhanVienView.cccdTF.getText(),nhanVienView.diaChiTF.getText());
						 nhanVienModel.suaNhanVien(nhanVienA);
						 taoBang();	
						 clearAction();
		        	}
		        } 			 
			 
			}
		});
		
		
		nhanVienView.xoaB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				 if (nhanVienView.maJL.getText().equals("") && nhanVienView.maTF.getText().equals("")) {
					 JOptionPane.showMessageDialog(nhanVienView, "Vui lòng chọn nhân viên hoặc nhập mã nhân viên");
			            return ;
				 }
				 if (!(checkMaNV(nhanVienView.maTF.getText()) || checkMaNV(nhanVienView.maJL.getText()))) {
					 JOptionPane.showMessageDialog(nhanVienView, "Mã nhân viên này đã không tồn tại");
			            return ;
				 }
				 int a = JOptionPane.showOptionDialog(null, "Bạn thật sự muốn xóa nhân viên này?", "Xác nhận",
			                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			        
			        if (a == JOptionPane.YES_OPTION) {
			        	if (!nhanVienView.maTF.getText().equals("")) {
							 nhanVienModel.xoaNhanVien(nhanVienView.maTF.getText());
							 taoBang();	
							 clearAction();
							 return;
						 }
						 nhanVienModel.xoaNhanVien(nhanVienView.maJL.getText());
						 taoBang();	
						 clearAction();
						 return;
						 
			        } 			
				 
			}
			
		});
		
		nhanVienView.suaB1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (!nhanVienView.userTF.getText().equals("")) {
					
					 int a = JOptionPane.showOptionDialog(null, "Bạn thật sự muốn thêm các thông tin trên?", "Xác nhận",
				                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				        
				        if (a == JOptionPane.YES_OPTION) {
				        	int muc = 3 - nhanVienView.mucTB.getSelectedIndex();
				        	nhanVienModel.suaTaiKhoan(nhanVienView.maJL.getText(), nhanVienView.userTF.getText(), nhanVienView.passwordTF.getText(),muc);
				        	taoBang();
							
				        } 			 
					 
				
				}
					
				
			}
		});
nhanVienView.suaB3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (!nhanVienView.userTF.getText().equals("")) {
					
					 int a = JOptionPane.showOptionDialog(null, "Bạn thật sự muốn sửa các thông tin trên?", "Xác nhận",
				                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				        
				        if (a == JOptionPane.YES_OPTION) {
				        	int muc = 3 - nhanVienView.mucTB.getSelectedIndex();
				        	nhanVienModel.suaTaiKhoan(nhanVienView.maJL.getText(), nhanVienView.userTF.getText(), nhanVienView.passwordTF.getText(),muc);
				        	taoBang();
							
				        } 			 
					 
				
				}
					
				
			}
		});
	nhanVienView.xoaB1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (!nhanVienView.userTF.getText().equals("")) {
					
					 int a = JOptionPane.showOptionDialog(null, "Bạn thật sự muốn xóa các thông tin trên?", "Xác nhận",
				                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				        
				        if (a == JOptionPane.YES_OPTION) {
				        	nhanVienModel.xoaTaiKhoan(nhanVienView.maJL.getText());
				        	taoBang();
				        	 nhanVienView.userTF.setText(""); 
               		      nhanVienView.passwordTF.setText("");
				        } 			 
					 
				
				}
					
				
			}
		});
		nhanVienView.Bang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
           
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                	
                	 nhanVienView.remove(nhanVienView.jLabel17);
                	 nhanVienView.revalidate();
             		nhanVienView.repaint();
                    int selectedRow = nhanVienView.Bang.getSelectedRow();
                    int selectedColumn = nhanVienView.Bang.getSelectedColumn();
                    if (selectedRow != -1 && selectedColumn != -1) {
                    	
                    	
                    	nhanVienView.maTF.setText("");
                    	nhanVienView.remove(nhanVienView.maTF);
                		nhanVienView.add(nhanVienView.maJL);
                		nhanVienView.tenTF.setText(nhanVienView.Bang.getValueAt(selectedRow, 1).toString());
                		nhanVienView.diaChiTF.setText(nhanVienView.Bang.getValueAt(selectedRow, 5).toString());
                		nhanVienView.cccdTF.setText(nhanVienView.Bang.getValueAt(selectedRow, 4).toString());
                		nhanVienView.soTF.setText(nhanVienView.Bang.getValueAt(selectedRow, 3).toString());
                		nhanVienView.chucvuTF.setText(nhanVienView.Bang.getValueAt(selectedRow, 2).toString());
                		nhanVienView.maJL.setText(nhanVienView.Bang.getValueAt(selectedRow, 0).toString());
                		
                		
                		
                		
                		for (NhanVien i : nhanVienModel.nhanVien) 
                			if (i.getMaNV().equals(nhanVienView.maJL.getText())) {
                				if (!i.getTaiKhoan().equals(""))
                				try {
                					
                					  nhanVienView.userTF.setText(i.getTaiKhoan()); 
                        		      nhanVienView.passwordTF.setText(i.getMatKhau());
                        		      if (i.getMuc()==2) {
                        		    	  nhanVienView.mucTB.setSelectedIndex(1); 
                        		      }
                        		      if (i.getMuc()==1) {
                        		    	  nhanVienView.mucTB.setSelectedIndex(2); 
                        		      }
								} catch (NullPointerException e2) {
									 nhanVienView.add(nhanVienView.jLabel17);
									  nhanVienView.userTF.setText(""); 
                        		      nhanVienView.passwordTF.setText("");
									 nhanVienView.revalidate();
										nhanVienView.repaint();
								}
                		    
                				else {
                					nhanVienView.userTF.setText(""); 
                      		      nhanVienView.passwordTF.setText("");
                					nhanVienView.add(nhanVienView.jLabel17);
                					nhanVienView.mucTB.setSelectedIndex(0); 
                					nhanVienView.revalidate();
                					nhanVienView.repaint();
                				}
                			}
                    }
                }
            }

			
        });
	}
	void clearAction() {
		nhanVienView.remove(nhanVienView.maJL);
		nhanVienView.add(nhanVienView.maTF);
		nhanVienView.tenTF.setText("");
		nhanVienView.diaChiTF.setText("");
		nhanVienView.chucvuTF.setText("");
		nhanVienView.cccdTF.setText("");
		nhanVienView.soTF.setText("");
		nhanVienView.maJL.setText("");
		nhanVienView.maTF.setText("");
		nhanVienView.userTF.setText("");
		nhanVienView.passwordTF.setText("");
		nhanVienView.Bang.clearSelection();
		nhanVienView.revalidate();
		nhanVienView.repaint();
	}
	void checkTruocKhiThem() {
		if (nhanVienView.maJL.getText().equals("")) {
			JOptionPane.showMessageDialog(nhanVienView, this, "Vui lòng clear trước khi thêm!", 0);
		}
	}
	boolean  checkTFNull(){
      
        if (nhanVienView.tenTF.getText().equals("")) return false;
        if (nhanVienView.soTF.getText().equals("")) return false;
        if (nhanVienView.cccdTF.getText().equals("")) return false;
        if (nhanVienView.diaChiTF.getText().equals("")) return false;
        if (nhanVienView.chucvuTF.getText().equals("")) return false;
        return true;
    }
	
	boolean checkMaNV(String maNV) {
		for (NhanVien i : nhanVienModel.nhanVien) 
			if (i.getMaNV().equals(maNV)) 
				return true;
			
		return false;
	}
	}

