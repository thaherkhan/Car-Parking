/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neub.carParkingManagementSystem;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Double.min;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ss
 */
public class AddCarClass extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form AddCarClass
     */
    String mname, maddress = "", mplace = "", mid = "", time = "";
    String cday = "";
    String cmonth = "";
    String cyear = "";
    String cminute = "";
    String chour = "";
    String cpath = "";

    public String ownerid = "", licence = "", placeNo = "", date;

    public AddCarClass(String id, String name, String mobileNo, String address, String path) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        registrationButton.addActionListener(this);
        backButton.addActionListener(this);
        exitMenu.addActionListener(this);
        aboutMenu.addActionListener(this);
        placeNo();
        ownerid = id;

        mname = name;
        idNoLevel.setText("ID :" + id);
        nameLevel.setText("Name : " + name);
        mobileNoLabel.setText("Mobile No : " + mobileNo);
        addressLabel.setText("Address : " + address);

        ImageIcon image = new ImageIcon(path);
        Image newimage = image.getImage();
        newimage = newimage.getScaledInstance(imageLevel.getWidth(), imageLevel.getWidth(), Image.SCALE_SMOOTH);
        image = new ImageIcon(newimage);
        imageLevel.setIcon(image);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registrationButton) {
            addMathod();
        }
        if (e.getSource() == backButton) {
            callSearchClass();
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

    void callSearchClass() {
        this.setVisible(false);
        SearchOwner object = new SearchOwner();
        object.setVisible(true);
    }

    public void addMathod() {
        System.out.println("2");

        Connector_DataBase object = new Connector_DataBase();
        Calendar cal = new GregorianCalendar();
        int day = cal.get(Calendar.DATE);
        int month = 1 + cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);

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

        licence = licenceTextField.getText();
        String sql = "UPDATE placetable SET availOrNot = '1' WHERE placeNo = '" + placeNo + "';";
        String query = "INSERT INTO carregistrationtable " + "VALUES ('" + licence + "', '" + ownerid + "', '" + placeNo + "', '" + cminute + "','" + chour + "', '" + cday + "', '" + cmonth + "', '" + cyear + "')";
        try {
            object.statement.executeUpdate(query);
            //object.stmt.executeQuery(sql);
            object.statement.executeUpdate(sql);
            object.connection.close();
        } catch (SQLException ev) {
            ev.printStackTrace();
        }

        JOptionPane.showMessageDialog(this, "Successfully added.", "Notice", JOptionPane.INFORMATION_MESSAGE);

        String place = "";
        place = "Place No : " + placeNo;
        this.setVisible(false);
        ReceptClass Robject = new ReceptClass(mname, licence, place, time, date);
        Robject.setVisible(true);
    }

    void placeNo() {
        Connector_DataBase ob1 = new Connector_DataBase();
        String query = "Select * FROM placetable";
        boolean color=false;
        try {
            System.out.println("1");
            ob1.resultset = ob1.statement.executeQuery(query);
            int i = 1;
            while (ob1.resultset.next()) {
                String calar = ob1.resultset.getString(2);
                System.out.println("4");
                if (calar.equals("0")) {
                    calar = ob1.resultset.getString(1);
                    placeNoLevel.setText("Place No : " + calar);
                    System.out.println("p");
                    color=true;
                    placeNo = calar;
                    break;
                }
            }
            ob1.connection.close();
        } catch (SQLException ev) {
            ev.printStackTrace();
        }
        if(color==false){
            JOptionPane.showMessageDialog(rootPane, "Sorry \n There is no empty place");
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
        imageLevel = new javax.swing.JLabel();
        idNoLevel = new javax.swing.JLabel();
        nameLevel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        mobileNoLabel = new javax.swing.JLabel();
        placeNoLevel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        licenceTextField = new javax.swing.JTextField();
        registrationButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exitMenu = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setForeground(new java.awt.Color(204, 255, 255));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        imageLevel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/default-man.png"))); // NOI18N
        imageLevel.setText("jLabel1");
        imageLevel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        idNoLevel.setBackground(new java.awt.Color(204, 255, 255));
        idNoLevel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        idNoLevel.setForeground(new java.awt.Color(204, 255, 255));
        idNoLevel.setText("ID :");

        nameLevel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        nameLevel.setForeground(new java.awt.Color(204, 255, 255));
        nameLevel.setText("Name :");

        addressLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        addressLabel.setForeground(new java.awt.Color(204, 255, 255));
        addressLabel.setText("Address :");

        mobileNoLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mobileNoLabel.setForeground(new java.awt.Color(204, 255, 255));
        mobileNoLabel.setText("Mobile No :");

        placeNoLevel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        placeNoLevel.setForeground(new java.awt.Color(204, 204, 255));
        placeNoLevel.setText("Place No :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 255));
        jLabel7.setText("Enter Car Licence No :");

        licenceTextField.setBackground(new java.awt.Color(51, 51, 255));
        licenceTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        licenceTextField.setForeground(new java.awt.Color(204, 255, 255));

        registrationButton.setBackground(new java.awt.Color(51, 51, 255));
        registrationButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        registrationButton.setForeground(new java.awt.Color(204, 255, 255));
        registrationButton.setText("Register");

        jLabel8.setBackground(new java.awt.Color(102, 102, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 255));
        jLabel8.setText("Profile Picture");

        backButton.setBackground(new java.awt.Color(51, 51, 255));
        backButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backButton.setForeground(new java.awt.Color(153, 255, 255));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(registrationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(licenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idNoLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nameLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(placeNoLevel, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imageLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mobileNoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imageLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(placeNoLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idNoLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(nameLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)))
                .addComponent(mobileNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(licenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrationButton)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
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
    private javax.swing.JLabel idNoLevel;
    private javax.swing.JLabel imageLevel;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField licenceTextField;
    private javax.swing.JLabel mobileNoLabel;
    private javax.swing.JLabel nameLevel;
    private javax.swing.JLabel placeNoLevel;
    private javax.swing.JButton registrationButton;
    // End of variables declaration//GEN-END:variables

}
