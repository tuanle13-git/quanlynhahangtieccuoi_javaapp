package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.DichVu;
import model.DichVuModel;
import model.HopDong;
import model.HopDongModel;
import model.KhachHang;
import model.KhachHangModel;
import model.MonAn;
import model.MonAnModel;
import model.Sanh;
import model.SanhModel;
import view.CTHD;
import view.HopDongView;
import view.SanhView;
import view.TaoHopDong;

public class HopDongController {
	public JPanel khung;
public HopDongView hopDongView;	
TaoHopDong taoHopDong;
KhachHangModel khachHangModel;
SanhModel sanhModel;
MonAnModel monAnModel;
DichVuModel dichVuModel;
HopDong hd;
HopDong hd1;
CTHD cTHD;
String maHDD;
HopDongModel hopDongModel;
int selectxIndex;
DefaultTableModel dTableMA;
DefaultTableModel dTableDV;
DefaultTableModel dTableMA1;
DefaultTableModel dTableDV1;
String maNVV;
public HopDongController() {
	cTHD = new CTHD();
	hopDongModel = new HopDongModel();
	taoHopDong = new TaoHopDong();
	sanhModel = new SanhModel();
	monAnModel = new MonAnModel();
	dichVuModel = new DichVuModel();
	hopDongView = new HopDongView();
	khachHangModel = new KhachHangModel();
	
	
	dTableMA = new DefaultTableModel();
	dTableDV = new DefaultTableModel();

	dTableMA1 = new DefaultTableModel();
	dTableDV1= new DefaultTableModel();
	
	selectxIndex = 0;
	hd = new HopDong();
	
	khung = new JPanel();
	khung.setBounds(0,0,1287,731);
	khung.setLayout(null);
	khung .add(hopDongView) ;
	taoBang();
	 xulyhopdong();
	 tao();
	hopDongView.timB.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			hopDongModel.timTheoKey(hopDongView.jTextField1.getText());
			taoBang();
hopDongView.Bang.revalidate();
      hopDongView.Bang.repaint();
			
		}
	});
	
	 hopDongView.jButton3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				khung.removeAll();
				khung .add(taoHopDong);
				khung.revalidate();
      	       	khung.repaint();
				
      	       	
			}
		});
	 
	 hopDongView.CCHD.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			khung.removeAll();
			taoCTHD();
			khung .add(cTHD);
			khung.revalidate();
  	       	khung.repaint();
			
		}
	});
	taoHopDong.jButton29.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				khung.removeAll();
				khung .add(hopDongView);
				taoBang();
				khung.revalidate();
      	       	khung.repaint();
			}
		});
	cTHD.jButton29.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			khung.removeAll();
			khung .add(hopDongView);
			taoBang();
			khung.revalidate();
  	       	khung.repaint();
		}
	});
      
	taoHopDong.themHD.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
		
			hd.maHD =taoHopDong.maHD.getText();
			hd.maNV = maNV.maNVV;
			hd.ngayHD = Date.valueOf(taoHopDong.ngaydienraTF.getText());
			hd.tthai = 0;
			hd.soBan = Integer.parseInt( taoHopDong.sobanTF.getText());
			hd.soBan = Integer.parseInt( taoHopDong.thanhtienHD.getText());
			hopDongModel.themHd(hd);
			khung.removeAll();
			khung .add(hopDongView);
			taoBang();
			khung.revalidate();
  	       	khung.repaint();
  	       	
  	       	
  	       	
		}
	});
cTHD.themHD.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
		try {
		    hd1.maNV = maNV.maNVV;
			hd1.maKH = cTHD.maKH.getText();
			hd1.ngayHD = Date.valueOf(cTHD.ngaydienraTF.getText());
			hd1.tthai = cTHD.jComboBox1.getSelectedIndex(); ;
			hd1.soBan = Integer.parseInt( cTHD.sobanTF.getText());
			hd1.soTien = Integer.parseInt(cTHD.thanhtienHD.getText());
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(cTHD, "Vui lòng nhập đầy đủ thông tin");
            return ;
		}
			
			hopDongModel.suaHopDong(hd1);
			khung.removeAll();
			khung .add(hopDongView);
			taoBang();
			khung.revalidate();
  	       	khung.repaint();
  	       	
  	       	
  	       	
		}
	});
}
//////.
    public void taoBang() {
    	DefaultTableModel dTableHD;
    	dTableHD = new DefaultTableModel();
    	String dau[] = {"Mã hợp đồng","mã nhân viên","Mã khách hàng","Mã sảnh" ,"Số bàn đặt","Giá thành","Ngày diễn ra","Trạng thái"};
    	dTableHD.setColumnIdentifiers(dau);

	      try {
				if (hopDongModel.hopDong.size()>0)
				for (HopDong i : hopDongModel.hopDong) {
					String row[] = {String.valueOf(i.getMaHD()),i.getMaNV(),i.getMaKH(),i.getMaSanh(),String.valueOf(i.soBan),String.valueOf(i.soTien), String.valueOf(i.ngayHD),String.valueOf(i.tthai)};
					dTableHD.addRow(row);
					
				}	
				 hopDongView.Bang.setModel(dTableHD);
				 hopDongView.Bang.revalidate();
				 hopDongView.Bang.repaint();
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
	      hopDongView.Bang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	          
	          

				public void valueChanged(ListSelectionEvent e) {
		              if (!e.getValueIsAdjusting()) {
		                  int selectedRow = hopDongView.Bang.getSelectedRow();
		                  int selectedColumn = hopDongView.Bang.getSelectedColumn();
		                  if (selectedRow != -1 && selectedColumn != -1) {
		                		cTHD.maHD.setText(String.valueOf(hopDongView.Bang.getValueAt(selectedRow, 0)));
		                		maHDD = String.valueOf(hopDongView.Bang.getValueAt(selectedRow, 0));
		                		 hopDongView.add(hopDongView.CCHD); 
			                	  hopDongView.revalidate();
			                	  hopDongView.repaint();
		                	  DefaultTableModel dTable1;
		            		  hopDongView.bangMA.removeAll();
		            	      dTable1 = new DefaultTableModel();
		            	      String headT[] = {"Mã món ăn","Tên món ăn","loại món ăn","Giá thành"};
		            	      dTable1.setColumnIdentifiers(headT);     
		            	      hopDongView.bangMA.setModel(dTable1);
		            	  	
		            	      hopDongView.Bang.revalidate();
		            	      hopDongView.Bang.repaint();
		            	      
		            	      

		            			try {
		            			if (hopDongModel.getHDTMHD(String.valueOf(hopDongView.Bang.getValueAt(selectedRow, 0))).dsMonAn.size()>0)
		            			for (MonAn i : hopDongModel.getHDTMHD(String.valueOf(hopDongView.Bang.getValueAt(selectedRow, 0))).dsMonAn) {
		            				String row[] = {String.valueOf(i.getMaMA()),i.getTenMA(),i.getLoaiMA(),String.valueOf(i.getGiaMA())};
		            				dTable1.addRow(row);
		            			}	
		            		} catch (NullPointerException e1) {
		            			// TODO: handle exception
		            		}
		            		
		            			 DefaultTableModel dTable2;
		            			 hopDongView.bangDV.removeAll();
		            		      dTable2 = new DefaultTableModel();
		            		      String headT1[] = {"Mã dịch vụ","Tên dịch vụ","Giá thành","Ghi chú"};
		            		      dTable2.setColumnIdentifiers(headT1);     
		            		      hopDongView.bangDV.setModel(dTable2);
		            		      
		            		      
		         
		            		
		            				try {
		            					if (hopDongModel.getHDTMHD(String.valueOf(hopDongView.Bang.getValueAt(selectedRow, 0))).dsDichVu.size()>0)
		        	            			for (DichVu i : hopDongModel.getHDTMHD(String.valueOf(hopDongView.Bang.getValueAt(selectedRow, 0))).dsDichVu) {
		            					String row[] = {String.valueOf(i.getMaDV()),i.getTenDV(),String.valueOf(i.getGiaDV()),i.getghiChu()};
		            					dTable2.addRow(row);
		            				}	
		            			} catch (NullPointerException e3) {
		            				// TODO: handle exception
		            			}
		            	      
		            	      
		            	      
		            	      //
		            	      
		            	}
		            	
		      
		            		
		            	
		            	 
	   	                	  
		                  
		              }
		          }

					
		      });
		
		  
		     
    }


	public void xulyhopdong(){
	hopDongView.jButton3.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			
		}
	});
	}
	
	
	
	
	
	public TaoHopDong tHD() {
		return taoHopDong;
	}

	public void tao() {
		
		String headT[] = {"Mã món ăn","Tên món ăn","loại món ăn","Giá thành"};
	      dTableMA.setColumnIdentifiers(headT);   
	      
	      String headT1[] = {"Mã dịch vụ","Tên dịch vụ","Giá thành","Ghi chú"};
	      dTableDV.setColumnIdentifiers(headT1);   
		taoHopDong.khachHangB.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				selectxIndex = 1;
				taoBangKH();
				
			}
		});
		
		taoHopDong.sanhB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				selectxIndex = 2;
				taoBangS();
				
			}
		});
		
		taoHopDong.monAnB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				selectxIndex = 3;
				taoBangMA();
				
			}
		});

		taoHopDong.dichVuB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				selectxIndex = 4;
				taoBangDV();
				
			}
		});
		
		
		taoHopDong.bang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	         
	         

			public void valueChanged(ListSelectionEvent e) {
	              if (!e.getValueIsAdjusting()) {
	                  int selectedRow = taoHopDong.bang.getSelectedRow();
	                  int selectedColumn = taoHopDong.bang.getSelectedColumn();
	                  if (selectedRow != -1 && selectedColumn != -1) {
	                	  
	                	 
	                  	  if (selectxIndex == 1) {
	                  		  taoHopDong.maKH .setText( String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 0)));
	                  		taoHopDong.tenKH .setText( String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 1)));
	                  		taoHopDong.cccd .setText( String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 3)));
	                  		hd.maKH =  String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 0));
	                  	  }
	                  	  
	                  	 if (selectxIndex == 2) {
	                  		  taoHopDong.maS .setText( String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 0)));
	                  		  taoHopDong.tenS .setText( String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 1)));
	                  		hd.maSanh =  String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 0));
	                  	 }
	                	  if (selectxIndex == 3) {

	  	      	      
	  	      	      String row[] = {String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 0)),String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 1))
             				,String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 2)),String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 3))};
	  	      	      dTableMA.addRow(row);
	  	      	      MonAn monAnA = new MonAn(String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 0)),String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 1)),String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 2)),Integer.parseInt(String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 3))));
					 hd.dsMonAn.add(monAnA);
	  	      	      taoHopDong.bangMA.revalidate();
	  	      	      taoHopDong.bangMA.repaint();
	  	      	      taoHopDong.bangMA.setModel(dTableMA);
	                	  }
	                	  
	                	  if (selectxIndex == 4) {
	                		  
 	      	      
	    	  	      	      String row[] = {String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 0)),String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 1))
	                 				,String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 2)),String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 3))};
	    	  	      	      dTableDV.addRow(row);
	    	  	      	  DichVu dichvuu = new DichVu(String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 0)),String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 1)),Integer.parseInt(String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 2))),String.valueOf(taoHopDong.bang.getValueAt(selectedRow, 3)));
	 					 hd.dsDichVu.add(dichvuu);
	    	  	      	      taoHopDong.bangDV.clearSelection();
	    	  	      	      taoHopDong.bangDV.revalidate();
	    	  	      	      taoHopDong.bangDV.repaint();
	    	  	      	      taoHopDong.bangDV.setModel(dTableDV);
	    	                	  }
	                	  taoHopDong.bangDV.clearSelection();
	                	  taoHopDong.bangMA.clearSelection();
	                  }
	              }
	          }

				
	      });
	
		taoHopDong.jButton23.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				hopDongModel.themHd(hd);
				
			}
		});   
	         
		taoHopDong.bangMA.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	         
	         

			public void valueChanged(ListSelectionEvent e) {
	              if (!e.getValueIsAdjusting()) {
	                  int selectedRow = taoHopDong.bangMA.getSelectedRow();
	                  int selectedColumn = taoHopDong.bangMA.getSelectedColumn();
	                  if (selectedRow != -1 && selectedColumn != -1) {
	           
	                	   dTableMA.removeRow(selectedRow);      
	                	   hd.dsMonAn.remove(selectedRow);
	                  }
	              }
	          }

				
	      });
	
		taoHopDong.bangDV.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	         
	         

			public void valueChanged(ListSelectionEvent e) {
	              if (!e.getValueIsAdjusting()) {
	                  int selectedRow = taoHopDong.bangDV.getSelectedRow();
	                  int selectedColumn = taoHopDong.bangDV.getSelectedColumn();
	                  if (selectedRow != -1 && selectedColumn != -1) {
	                  	
	             
					   dTableDV.removeRow(selectedRow);
					   
					   hd.dsDichVu.remove(selectedRow);
	                  }
	              }
	          }

				
	      });
		
	}
	
	public void taoBangKH() {
		  DefaultTableModel dTable;
		  taoHopDong.bang.removeAll();
	      dTable = new DefaultTableModel();
	      String headT[] = {"Mã khách hàng","Tên khách hàng","Số điện thoại","CCCD","Địa chỉ"};
	      dTable.setColumnIdentifiers(headT);     
	     
	      try {
				if (khachHangModel.khachHang.size()>0)
				for (KhachHang i : khachHangModel.khachHang) {
					String row[] = {String.valueOf(i.getMaKH()),i.getTenKH(),i.getSoDT(),i.getCCCD(),i.getDiaChi()};
					dTable.addRow(row);
				}	
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
	      taoHopDong.bang.setModel(dTable);
	      cTHD.bang.setModel(dTable);
	}
	
	public void taoBangS() {
		  DefaultTableModel dTable1;
		  taoHopDong.bang.removeAll();
	      dTable1 = new DefaultTableModel();
	      String headT[] = {"Mã sảnh","Tên sảnh","Số bàn tối đa","Giá thành"};
	      dTable1.setColumnIdentifiers(headT);     
	      
	   
	  	try {
			if (sanhModel.sanh.size()>0)
			for (Sanh i : sanhModel.sanh) {
				String row[] = {String.valueOf(i.getMaSanh()),i.getTenSanh(),String.valueOf(i.getSoBanToiDa()),String.valueOf(i.getGiaSanh())};
				dTable1.addRow(row);
			}	
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
	  	taoHopDong.bang.setModel(dTable1);
	  	 cTHD.bang.setModel(dTable1);
	}
	
	public void taoBangMA() {
		  DefaultTableModel dTable1;
		  taoHopDong.bang.removeAll();
	      dTable1 = new DefaultTableModel();
	      String headT[] = {"Mã món ăn","Tên món ăn","loại món ăn","Giá thành"};
	      dTable1.setColumnIdentifiers(headT);     
	      
	      
	      try {
				if (monAnModel.monAn.size()>0)
				for (MonAn i : monAnModel.monAn) {
					String row[] = {String.valueOf(i.getMaMA()),i.getTenMA(),i.getLoaiMA(),String.valueOf(i.getGiaMA())};
					dTable1.addRow(row);
				}	
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
	      taoHopDong.bang.revalidate();
	      taoHopDong.bang.repaint();
	      taoHopDong.bang.setModel(dTable1);
	      cTHD.bang.setModel(dTable1);
	}
	
	public void taoBangDV() {
		  DefaultTableModel dTable1;
		  taoHopDong.bang.removeAll();
	      dTable1 = new DefaultTableModel();
	      String headT[] = {"Mã dịch vụ","Tên dịch vụ","Giá thành","Ghi chú"};
	      dTable1.setColumnIdentifiers(headT); 
	  	try {
			if (dichVuModel.dichVu.size()>0)
			for (DichVu i : dichVuModel.dichVu) {
				String row[] = {String.valueOf(i.getMaDV()),i.getTenDV(),String.valueOf(i.getGiaDV()),i.getghiChu()};
				dTable1.addRow(row);
			}	
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
	      taoHopDong.bang.setModel(dTable1);
	      cTHD.bang.setModel(dTable1);
	     
	      
	}
	
	void setMaNVV(String maNV) {
		this.maNVV= maNV;
	}
	
	

	 void taoCTHD() {
		hd1 = new HopDong();
		hd1= hopDongModel.getHDTMHD(maHDD);
		KhachHang k = khachHangModel.layKHtuMaMK(hd1.maKH);
		cTHD.thanhtienHD.setText(String.valueOf(hd1.soTien));
		  cTHD.maKH .setText( k.getMaKH());
    		cTHD.tenKH .setText( k.getTenKH());
    		cTHD.cccd .setText( k.getCCCD());
   
    		cTHD.ngaydienraTF.setText(String.valueOf(hd1.ngayHD));
    		cTHD.sobanTF.setText(String.valueOf(hd1.soBan));
    		if (hd1.tthai == 0) 
    			cTHD.jComboBox1.setSelectedIndex(0);
    		else 
    			cTHD.jComboBox1.setSelectedIndex(1);
    		
    	 Sanh s = sanhModel.layStuMaS(hd1.maSanh);
    	  cTHD.maS .setText(s.getMaSanh());
  	

		String headT[] = {"Mã món ăn","Tên món ăn","loại món ăn","Giá thành"};
	      dTableMA1.setColumnIdentifiers(headT);   
	      
	      String headT1[] = {"Mã dịch vụ","Tên dịch vụ","Giá thành","Ghi chú"};
	      dTableDV1.setColumnIdentifiers(headT1);   
	      
	      
    	      cTHD.bangMA.setModel(dTableMA1);
    	   
	      	      cTHD.bangDV.setModel(dTableDV1);
    	      
		cTHD.khachHangB.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				selectxIndex = 1;
				taoBangKH();
				
			}
		});
		
		cTHD.sanhB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				selectxIndex = 2;
				taoBangS();
				
			}
		});
		
		cTHD.monAnB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				selectxIndex = 3;
				taoBangMA();
				
			}
		});

		cTHD.dichVuB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				selectxIndex = 4;
				taoBangDV();
				
			}
		});
		
		  cTHD.tenS .setText( s.getTenSanh());
			try {
			if (hd1.dsMonAn.size()>0)
			for (MonAn i : hd1.dsMonAn) {
				String row[] = {String.valueOf(i.getMaMA()),i.getTenMA(),i.getLoaiMA(),String.valueOf(i.getGiaMA())};
				dTableMA1.addRow(row);
			}	
		} catch (NullPointerException e1) {
			System.out.print("sai day 1");
		}
			
			try {
			if (hd1.dsDichVu.size()>0)
	    			for (DichVu i : hd1.dsDichVu) {
				String row[] = {String.valueOf(i.getMaDV()),i.getTenDV(),String.valueOf(i.getGiaDV()),i.getghiChu()};
				dTableDV1.addRow(row);
			}	
		} catch (NullPointerException e3) {
			System.out.print("sai day 2");
		}
			
			
		cTHD.bang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	         
	         

			public void valueChanged(ListSelectionEvent e) {
	              if (!e.getValueIsAdjusting()) {
	                  int selectedRow = cTHD.bang.getSelectedRow();
	                  int selectedColumn = cTHD.bang.getSelectedColumn();
	                  if (selectedRow != -1 && selectedColumn != -1) {
	                  	  if (selectxIndex == 1) {
	                  		  cTHD.maKH .setText( String.valueOf(cTHD.bang.getValueAt(selectedRow, 0)));
	                  		cTHD.tenKH .setText( String.valueOf(cTHD.bang.getValueAt(selectedRow, 1)));
	                  		cTHD.cccd .setText( String.valueOf(cTHD.bang.getValueAt(selectedRow, 3)));
	                  		hd1.maKH =  String.valueOf(cTHD.bang.getValueAt(selectedRow, 0));
	                  	  }
	                  	  
	                  	 if (selectxIndex == 2) {
	                  		  cTHD.maS .setText( String.valueOf(cTHD.bang.getValueAt(selectedRow, 0)));
	                  		  cTHD.tenS .setText( String.valueOf(cTHD.bang.getValueAt(selectedRow, 1)));
	                  		hd1.maSanh =  String.valueOf(cTHD.bang.getValueAt(selectedRow, 0));
	                  	 }
	                	  if (selectxIndex == 3) {

	  	      	 
	  	      	      String row[] = {String.valueOf(cTHD.bang.getValueAt(selectedRow, 0)),String.valueOf(cTHD.bang.getValueAt(selectedRow, 1))
             				,String.valueOf(cTHD.bang.getValueAt(selectedRow, 2)),String.valueOf(cTHD.bang.getValueAt(selectedRow, 3))};
	  	      	      dTableMA1.addRow(row);
	  	      	      MonAn monAnA = new MonAn(String.valueOf(cTHD.bang.getValueAt(selectedRow, 0)),String.valueOf(cTHD.bang.getValueAt(selectedRow, 1)),String.valueOf(cTHD.bang.getValueAt(selectedRow, 2)),Integer.parseInt(String.valueOf(cTHD.bang.getValueAt(selectedRow, 3))));
					 hd1.dsMonAn.add(monAnA);
	  	      	      cTHD.bangMA.revalidate();
	  	      	      cTHD.bangMA.repaint();
	  	      	      cTHD.bangMA.setModel(dTableMA1);
	                	  }
	                	  
	                	  if (selectxIndex == 4) {
	                		  
 	      	      
	    	  	      	      String row[] = {String.valueOf(cTHD.bang.getValueAt(selectedRow, 0)),String.valueOf(cTHD.bang.getValueAt(selectedRow, 1))
	                 				,String.valueOf(cTHD.bang.getValueAt(selectedRow, 2)),String.valueOf(cTHD.bang.getValueAt(selectedRow, 3))};
	    	  	      	      dTableDV1.addRow(row);
	    	  	      	  DichVu dichvuu = new DichVu(String.valueOf(cTHD.bang.getValueAt(selectedRow, 0)),String.valueOf(cTHD.bang.getValueAt(selectedRow, 1)),Integer.parseInt(String.valueOf(cTHD.bang.getValueAt(selectedRow, 2))),String.valueOf(cTHD.bang.getValueAt(selectedRow, 3)));
	 					 hd1.dsDichVu.add(dichvuu);
	    	  	      	      cTHD.bangDV.clearSelection();
	    	  	      	      cTHD.bangDV.revalidate();
	    	  	      	      cTHD.bangDV.repaint();
	    	  	      	      cTHD.bangDV.setModel(dTableDV1);
	    	                	  }
	                	  cTHD.bangDV.clearSelection();
	                	  cTHD.bangMA.clearSelection();
	                  }
	              }
	          }

				
	      });
	
		cTHD.jButton23.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				hopDongModel.themHd(hd1);
				
			}
		});   
	         
		cTHD.bangMA.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	         
			public void valueChanged(ListSelectionEvent e) {
	              if (!e.getValueIsAdjusting()) {
	                  int selectedRow = cTHD.bangMA.getSelectedRow();
	                  int selectedColumn = cTHD.bangMA.getSelectedColumn();
	                  if (selectedRow != -1 && selectedColumn != -1) {
	           
	                	   dTableMA1.removeRow(selectedRow);      
	                	   hd1.dsMonAn.remove(selectedRow);
	                  }
	              }
	          }

				
	      });
	
		cTHD.bangDV.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	         
	         


			public void valueChanged(ListSelectionEvent e) {
	              if (!e.getValueIsAdjusting()) {
	                  int selectedRow = cTHD.bangDV.getSelectedRow();
	                  int selectedColumn = cTHD.bangDV.getSelectedColumn();
	                  if (selectedRow != -1 && selectedColumn != -1) {
	                  	
	             
					   dTableDV1.removeRow(selectedRow);
					   
					   hd1.dsDichVu.remove(selectedRow);
	                  }
	              }
	          }

				
	      });
		
	}
	
	
}
