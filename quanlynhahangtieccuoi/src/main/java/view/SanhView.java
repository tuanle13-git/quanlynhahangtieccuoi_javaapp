/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.Color;

import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author LENOVO
 */
public class SanhView extends javax.swing.JPanel {

    /**
     * Creates new form SanhView
     */
    public SanhView() {
        initComponents();
        setBounds(0,0,1287,731);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    public void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        maL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Bang = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tenTF = new javax.swing.JTextField();
        soTF = new javax.swing.JTextField();
        giaTF = new javax.swing.JTextField();
        timTF = new javax.swing.JTextField();
        themB = new javax.swing.JButton();
        suaB = new javax.swing.JButton();
        xoaB = new javax.swing.JButton();
        clearB = new javax.swing.JButton();
        TimB = new javax.swing.JButton();
        maJL = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        maTF = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel5.setText("Sảnh");
        add(jLabel5);
        jLabel5.setBounds(20, 10, 120, 30);

        maL.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        add(maL);
        maL.setBounds(140, 80, 120, 0);

        Bang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
      
        jScrollPane1.setViewportView(Bang);

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 150, 1230, 540);

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel4.setText("Giá thành");
        add(jLabel4);
        jLabel4.setBounds(500, 100, 140, 20);

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel2.setText("Số bàn tối đa");
        add(jLabel2);
        jLabel2.setBounds(500, 55, 140, 20);

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel1.setText("Tên sảnh");
        add(jLabel1);
        jLabel1.setBounds(500, 10, 140, 20);
        add(tenTF);
        tenTF.setBounds(700, 10, 210, 22);
        add(soTF);
        soTF.setBounds(700, 55, 210, 22);
        add(giaTF);
        giaTF.setBounds(700, 100, 210, 22);
        add(timTF);
        timTF.setBounds(950, 10, 220, 22);
        maTF.setBounds(130, 100, 120, 18);
        add(maTF);

        themB.setBackground(new java.awt.Color(238, 237, 181));
        themB.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        themB.setText("Thêm");
        themB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themBActionPerformed(evt);
            }
        });
        add(themB);
        themB.setBounds(950, 100, 70, 20);

        suaB.setBackground(new java.awt.Color(238, 237, 181));
        suaB.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        suaB.setText("Sửa");
        add(suaB);
        suaB.setBounds(1040, 100, 60, 22);

        xoaB.setBackground(new java.awt.Color(238, 237, 181));
        xoaB.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        xoaB.setText("Xóa");
        add(xoaB);
        xoaB.setBounds(1110, 100, 60, 22);

        clearB.setBackground(new java.awt.Color(238, 237, 181));
        clearB.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        clearB.setText("Clear");
        add(clearB);
        clearB.setBounds(1180, 100, 70, 22);

        TimB.setBackground(new java.awt.Color(238, 237, 181));
        TimB.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        TimB.setText("Tìm");
        add(TimB);
        TimB.setBounds(1180, 10, 70, 22);

        maJL.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        maJL.setText("");
       // add(maJL);
        maJL.setBounds(130, 100, 120, 18);

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel8.setText("Mã sảnh");
        add(jLabel8);
        jLabel8.setBounds(20, 100, 120, 18);
        Bang.setDragEnabled(true);
        //Bang.setEnabled(false);
        Bang.setFocusable(false);
     
        Bang.setName(""); // NOI18N
      
        
        Bang.setShowVerticalLines(true);
        Bang.setUpdateSelectionOnSort(false);
        Bang.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(Bang);
        Bang.setSelectionBackground(new java.awt.Color(238, 237, 181));
    	Bang.setGridColor(new java.awt.Color(153, 105, 211));
        Bang.setSelectionBackground(new java.awt.Color(238, 238, 181));
		Bang.setBackground(Color.white);
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();

		// Thiết lập màu cho thanh mô hình
		headerRenderer.setBackground(new java.awt.Color(238, 238, 181));
	//	headerRenderer.setForeground(Color.);

		// Thiết lập renderer cho mô hình của thanh
		Bang.getTableHeader().setDefaultRenderer(headerRenderer);
		
		
    }// </editor-fold>                        

    public void themBActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     


    // Variables declaration - do not modify                     
    public javax.swing.JTable Bang;
    public javax.swing.JButton TimB;
    public javax.swing.JButton clearB;
    public javax.swing.JTextField giaTF;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel maJL;
    public javax.swing.JLabel maL;
    public javax.swing.JTextField soTF;
    public javax.swing.JButton suaB;
    public javax.swing.JTextField tenTF;
    public javax.swing.JButton themB;
    public javax.swing.JTextField timTF;
    public javax.swing.JButton xoaB;         
    public  javax.swing.JTextField maTF;
    // End of variables declaration                   
}
