package view;
import java.awt.Color;

import javax.swing.*;


public class loginView  {
	public JFrame loginF ;
	public JTextField userTF ;
	public JPasswordField passwordPF ;
	public JLabel passwordTF ;
	public JButton loginB ;
	JPanel loginP  ;
	JLabel imageL ;
	JLabel wpL;
	JLabel passwordL;
	JLabel userL;
	
	public loginView() {
		loginF = new JFrame("Đăng nhập hệ thống");		
		loginP= new JPanel();
		userL = new JLabel("Tài khoản:");
		userTF = new JTextField("");
		passwordL = new JLabel("Mật khẩu:");
	    passwordPF = new JPasswordField("");
		loginB = new JButton("Đăng nhập");	
		JLabel imageL = new JLabel(new ImageIcon("src/main/java/view/image/loginIMAGE.jpg"));
	    wpL = new JLabel("");
		
		wpL.setForeground(Color.red);		
		loginP.setBackground(Color.white);
		loginP.setBorder(BorderFactory.createLineBorder(Color.gray));
	    userL.setForeground(Color.gray);
        passwordL.setForeground(Color.gray);
        loginB.setForeground(Color.gray);
        
		loginP.setBounds(0,0,380,250);
		wpL.setBounds(24,0,300,30);
		userL.setBounds(24,20,338,30);
		userTF.setBounds(24,50,338,30);  
		passwordL.setBounds(24,80,338,30); 
		passwordPF.setBounds(24,110,338,30);    
        loginB.setBounds(24,170,338,30);   
	    loginF.setSize(1280,720);
	    imageL.setBounds(0,0,500,500);
	    NewJPanel1 panel1 = new NewJPanel1();
	    panel1.loginPanel.add(loginP);
	   
	    loginP.add(userL);
	    loginP.add(userTF);
	    loginP.add(passwordL);
		loginP.add(passwordPF);	
		loginP.add(loginB);  	      
        loginF.add(panel1); 
        loginP.add(wpL);
        
        loginB.setBackground(new java.awt.Color(238, 237, 181));
	    
	    loginP.setLayout(null);	
	    loginF.setLocationRelativeTo(null);
	    loginF.setVisible(true);
	
	}   
	public void wrongPasswordEvent() {
		userTF.setBorder(BorderFactory.createLineBorder(Color.red));
		passwordPF.setBorder(BorderFactory.createLineBorder(Color.red));
		loginP.setBounds(0,0,380,280);
		wpL.setBounds(24,30,300,30);
		userL.setBounds(24,60,338,30);
		userTF.setBounds(24,90,338,30);  
		passwordL.setBounds(24,120,338,30); 
		passwordPF.setBounds(24,150,338,30);    
        loginB.setBounds(24,210,338,30);   
	        
	    
	    wpL.setText("Tài khoản hoặc mật khẩu không chính xác!");
	    loginP.repaint();

	    
	}
	void forgetPassword() {
		JFrame fPF = new JFrame("Quên Tài khoản");	
		fPF.setLayout(null);	
		fPF.setLocationRelativeTo(null);
		fPF.setVisible(true);
	}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

class NewJPanel1 extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel1
     */
    public NewJPanel1() {
        initComponents();
        setBounds(0, 0, 1280, 720);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        loginPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel(new ImageIcon( "src/main/java/view/image/loginIMAGE.jpg")); // NOI18N));
        jPanel2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        add(loginPanel);
        loginPanel.setBounds(870, 130, 380, 280);
        loginPanel.setBackground(Color.white);
       
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 720);

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
            
        );

        add(jPanel2);
        jPanel2.setBounds(950, 130, 300, 260);
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel loginPanel;
    // End of variables declaration                   
}




