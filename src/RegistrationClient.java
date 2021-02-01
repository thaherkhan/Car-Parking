/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neub.carParkingManagementSystem;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.audio.AudioDataStream;

/**
 *
 * @author ss
 */
public class RegistrationClient extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form AddClientPage
     */
    boolean calar[] = new boolean[9999];
    public String p = "";

    public RegistrationClient() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        backButton.addActionListener(this);
        registrationButton.addActionListener(this);
        imageButton.addActionListener(this);
        exitMenu.addActionListener(this);
        aboutMenu.addActionListener(this);
        idMathod();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitMenu) {
            exitMethod();
        }
        if (e.getSource() == aboutMenu) {
            aboutMethod();
        }
        if (e.getSource() == backButton) {
            callStartClass();
        } else if (e.getSource() == imageButton) {
            image();
        } else if (e.getSource() == registrationButton) {
            addClient();
        }

    }

    public void idMathod() {

        // Date date = new Date();
        // display time and date using toString()
        // System.out.println(date.toString());
        Calendar cal = new GregorianCalendar();
        int hour = cal.get(Calendar.HOUR);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        int AM_PM = cal.get(Calendar.AM_PM);
        int day = cal.get(Calendar.DATE);
        int month = 1 + cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        year = year % 2000;
        System.out.println("" + year + "" + month + "" + day + "" + hour + "" + min + "" + sec);
        String s = "" + year + "" + month + "" + day + "" + hour + "" + min + "" + sec;
        idLabel.setText(s);

    }
    
    public void exitMethod() {
        System.exit(0);
    }

    public void aboutMethod() {
        JOptionPane.showMessageDialog(null, "This is a project of car parking management system developed by  Shuvro and Shameem");
    }

    public void image() {
        JFileChooser filechooseer = new JFileChooser();
        filechooseer.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "*.IMAGE", "gif", "png");
        filechooseer.addChoosableFileFilter(filter);
        int result = filechooseer.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedfile = filechooseer.getSelectedFile();
            String path = selectedfile.getAbsolutePath();
            // imageLevel.setIcon(filechooseer.getIcon(selectedfile));
            ImageIcon image = new ImageIcon(path);
            Image newimage = image.getImage();
            newimage = newimage.getScaledInstance(imageLevel.getWidth(), imageLevel.getWidth(), Image.SCALE_SMOOTH);
            image = new ImageIcon(newimage);
            imageLevel.setIcon(image);

            p = path;
            System.out.println(p);
        }
        System.out.println("jh");
    }

    public void callStartClass() {
        setVisible(false);
        StartPage object = new StartPage();
        object.setVisible(true);
    }

    public void addClient() {

        String id = idLabel.getText();
        String name = nameTextfield.getText();
        String no = mobileNoTextfield.getText();
        String address = adressTextfield.getText();
        if ((id.equals("")) || (name.equals("")) || (no.equals("")) || (address.equals("")) ||(p.equals(""))) {
            JOptionPane.showMessageDialog(rootPane, "Plese Fillup Properly!!!!!");
            System.out.println("1");
        } else {

            System.out.println("2");
            ImageIcon image = new ImageIcon(p);
            Image newimage = image.getImage();
            newimage = newimage.getScaledInstance(imageLevel.getWidth(), imageLevel.getWidth(), Image.SCALE_SMOOTH);
            image = new ImageIcon(newimage);

            Connector_DataBase ob3 = new Connector_DataBase();
            System.out.println("p=" + p);
            String pat = p;
            String filePath = "D:/Photos/Tom.png";

            try {
         //   Connection conn = DriverManager.getConnection(url, user, password);

                String sql = "INSERT INTO registrationtable ( registrationNoClient,nameClient, mobileNo, clientAddress,	imagepath) values (?, ?, ?, ?, ?)";
                PreparedStatement statement = ob3.connection.prepareStatement(sql);
                statement.setString(1, id);
                statement.setString(2, name);
                statement.setString(3, no);
                statement.setString(4, address);
                statement.setString(5, p);
           //     InputStream inputStream = new FileInputStream(new File(filePath));

           // statement.setBlob(3, inputStream);
                statement.executeUpdate();
//                if (row > 0) {
//                    System.out.println("A contact was inserted with photo image.");
//                }
                ob3.connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
//            String query = "INSERT INTO registrationtable " + "VALUES ('" + id + "', '" + name + "', '" + no + "', '" + address + "')";
//            try {
//
//                ob3.statement.executeUpdate(query);
//                ob3.connection.close();
//            } catch (SQLException ev) {
//                ev.printStackTrace();
//            }

            JOptionPane.showMessageDialog(this, "Successfully added.", "Notice", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            RegistrationClient ob = new RegistrationClient();
            ob.setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameTextfield = new javax.swing.JTextField();
        mobileNoTextfield = new javax.swing.JTextField();
        adressTextfield = new javax.swing.JTextField();
        registrationButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        imageLevel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        imageButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exitMenu = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 255));
        jLabel1.setText("Name               :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 314, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 255, 0));
        jLabel2.setText("Mobile No         :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 368, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Adress              :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 423, -1, -1));

        nameTextfield.setBackground(new java.awt.Color(51, 51, 255));
        nameTextfield.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(nameTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 316, 344, 29));

        mobileNoTextfield.setBackground(new java.awt.Color(51, 51, 255));
        mobileNoTextfield.setForeground(new java.awt.Color(204, 255, 255));
        jPanel1.add(mobileNoTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 363, 344, 30));

        adressTextfield.setBackground(new java.awt.Color(51, 51, 255));
        adressTextfield.setForeground(new java.awt.Color(204, 255, 255));
        jPanel1.add(adressTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 417, 344, 31));

        registrationButton.setBackground(new java.awt.Color(51, 51, 255));
        registrationButton.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        registrationButton.setForeground(new java.awt.Color(255, 255, 255));
        registrationButton.setText("Register");
        jPanel1.add(registrationButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 459, 110, 38));

        backButton.setBackground(new java.awt.Color(51, 51, 255));
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.jpg"))); // NOI18N
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 459, 83, 38));

        imageLevel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/default-man.png"))); // NOI18N
        jPanel1.add(imageLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 182, 220));

        jLabel5.setBackground(new java.awt.Color(51, 102, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 255, 255));
        jLabel5.setText("Registration No :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 266, -1, 30));

        idLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        idLabel.setForeground(new java.awt.Color(204, 0, 204));
        idLabel.setText("12345");
        jPanel1.add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 266, 289, 30));

        imageButton.setBackground(new java.awt.Color(51, 51, 255));
        imageButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        imageButton.setForeground(new java.awt.Color(255, 102, 204));
        imageButton.setText("Choose Image");
        jPanel1.add(imageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 180, 30));

        jMenu1.setText("File");

        exitMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        exitMenu.setText("Exit");
        jMenu1.add(exitMenu);

        jMenuBar1.add(jMenu1);

        helpMenu.setText("Help");

        aboutMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        aboutMenu.setText("About");
        helpMenu.add(aboutMenu);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenu;
    private javax.swing.JTextField adressTextfield;
    private javax.swing.JButton backButton;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel idLabel;
    private javax.swing.JButton imageButton;
    private javax.swing.JLabel imageLevel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField mobileNoTextfield;
    private javax.swing.JTextField nameTextfield;
    private javax.swing.JButton registrationButton;
    // End of variables declaration//GEN-END:variables

}
