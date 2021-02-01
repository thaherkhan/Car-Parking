/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.neub.carParkingManagementSystem;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ss
 */
public class CarClass extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form CarClass
     */
    String licensegl = "";
    String placegl = "";
    String mname = "", maddress = "", mplace = "", mid = "", time = "";
    String cday = "";
    String cmonth = "";
    String cyear = "";
    String cminute = "";
    String chour = "";
    String date="";
    String mi,hh,dd,mo,yy;
    public CarClass(String path,String name,String mobileNo,String address,String license,String id,String placeNO,String minute,String hour,String day,String month,String year) {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        backButton.addActionListener(this);
        removeButton.addActionListener(this);
        idLabel.setText("ID : "+id);
        nameLabel.setText("Name : "+name);
        mobileNoLabel.setText("Mobile No : "+mobileNo);
        addressLabel.setText("Address : "+address);
        licenseLabel.setText("License No : "+license);
        placeNoLabel.setText("Place No : "+placeNO);
        licensegl=license;
        placegl = placeNO;
        mname=name;
        maddress=address;
        mi = minute;
        mo = month;
        hh=hour;
        yy=year;
        dd=day;
        
        ImageIcon image = new ImageIcon(path);
        Image newimage = image.getImage();
        newimage = newimage.getScaledInstance(imageLevel.getWidth(), imageLevel.getWidth(), Image.SCALE_SMOOTH);
        image = new ImageIcon(newimage);
        imageLevel.setIcon(image);
        
        exitMenu.addActionListener(this);
        aboutMenu.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            callSearchClass();
        }
        if(e.getSource()==removeButton){
            removeCar();
        }
        if (e.getSource() == exitMenu) {
            exitMethod();
        }
        if (e.getSource() == aboutMenu) {
            aboutMethod();
        }
    }
    public void exitMethod() {
        System.exit(0);
    }

    public void aboutMethod() {
        JOptionPane.showMessageDialog(null, "This is a project of car parking management system developed by  Shuvro and Shameem");
    }
    void callSearchClass(){
        this.setVisible(false);
        SearchCar object = new SearchCar();
        object.setVisible(true);
    }
    void removeCar(){
        
        Connector_DataBase object = new Connector_DataBase();
        String sql = "UPDATE placetable SET availOrNot = '0' WHERE placeNo = '" + placegl + "';";
        String query = "DELETE FROM carregistrationtable WHERE licenceNo = '" + licensegl + "'";
        
        Calendar cal = new GregorianCalendar();
        int day = cal.get(Calendar.DATE);
        int month = 1 + cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);

        int m=Integer.parseInt(mi);
        int h=Integer.parseInt(hh);
        int d=Integer.parseInt(dd);
        int y = Integer.parseInt(yy);
        int mon=Integer.parseInt(mo);
        
        int pr=0;
        m=minute-m;
        h=(hour-h)*60;
        d=(day-d)*24*60;
        mon=(month-mon)*30*24*60;
        y=(year-y)*15*30*24*60;
        pr=m+h+d+mon+y;
        
        
        
        cday = "" + day;
        cmonth = "" + month;
        cyear = "" + year;
        cminute = "" + minute;
        chour = "" + hour;

        //year = year % 2000;
        //    System.out.println("" + year + "" + month + "" + day + "" + hour + "" + min + "" + sec);
        date = day + "/" + month + "/" + year % 2000;

        int AM_PM = cal.get(Calendar.AM_PM);
        System.out.println(AM_PM);
        if (AM_PM == 0) {
            time = hour + " : " + minute + " AM";
        } else {
            time = hour + " : " + minute + " PM";
        }
        
        try {
            object.statement.executeUpdate(query);
            //object.stmt.executeQuery(sql);
            object.statement.executeUpdate(sql);
            object.connection.close();
        } catch (SQLException ev) {
            ev.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "Successfully Removed.", "Notice", JOptionPane.INFORMATION_MESSAGE);

        this.setVisible(false);
        placegl="Price : "+pr+" TK";
        ReceptClass Robject = new ReceptClass(mname, licensegl, placegl, time, date);
        Robject.setVisible(true);
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
        imageLevel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        licenseLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        mobileNoLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        removeButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        placeNoLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exitMenu = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        imageLevel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/default-man.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Profile Picture");

        licenseLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        licenseLabel.setForeground(new java.awt.Color(204, 255, 255));
        licenseLabel.setText("License No :");

        idLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        idLabel.setForeground(new java.awt.Color(204, 255, 255));
        idLabel.setText("Owner ID :");

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(204, 255, 255));
        nameLabel.setText("Owner Name : ");

        mobileNoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mobileNoLabel.setForeground(new java.awt.Color(204, 255, 255));
        mobileNoLabel.setText("Mobile No : ");

        addressLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addressLabel.setForeground(new java.awt.Color(204, 255, 255));
        addressLabel.setText("Address : ");

        removeButton.setBackground(new java.awt.Color(51, 51, 255));
        removeButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        removeButton.setForeground(new java.awt.Color(204, 255, 255));
        removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove.jpg"))); // NOI18N

        backButton.setBackground(new java.awt.Color(51, 51, 255));
        backButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backButton.setForeground(new java.awt.Color(204, 255, 255));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.jpg"))); // NOI18N

        placeNoLabel.setBackground(new java.awt.Color(51, 102, 255));
        placeNoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        placeNoLabel.setForeground(new java.awt.Color(204, 255, 255));
        placeNoLabel.setText("Place No : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(licenseLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                            .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mobileNoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imageLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(placeNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(licenseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(mobileNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imageLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(placeNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jMenu1.setText("File");

        exitMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        exitMenu.setText("Exit");
        jMenu1.add(exitMenu);

        jMenuBar1.add(jMenu1);

        helpMenu.setText("Help");

        aboutMenu.setText("About");
        helpMenu.add(aboutMenu);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenu;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel imageLevel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel licenseLabel;
    private javax.swing.JLabel mobileNoLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel placeNoLabel;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables

    
}
