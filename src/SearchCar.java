/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neub.carParkingManagementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class SearchCar extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form SearchCar
     */
    String search = "";

    public SearchCar() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        backButton.addActionListener(this);
        searchButton.addActionListener(this);
        
        exitMenu.addActionListener(this);
        aboutMenu.addActionListener(this);
    }

    public void carSearchMathod() {

        search = licenseTextfield.getText();
        if (search.equals("")) {
            JOptionPane.showMessageDialog(this, "Fillup Properly", "Notice", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Connector_DataBase ob1 = new Connector_DataBase();
            String query = "Select * FROM registrationtable natural join carregistrationtable WHERE licenceNo = '"+search+"'";
            try {

                ob1.resultset = ob1.statement.executeQuery(query);
                int i = 1;
                while (ob1.resultset.next()) {
                    String license = ob1.resultset.getString(6);
                    if (search.equals(license)) {
                        String name = ob1.resultset.getString(2);
                        String mobileNo = ob1.resultset.getString(3);
                        String path=ob1.resultset.getString(5);
                        String address = ob1.resultset.getString(4);
                        String id = ob1.resultset.getString(1);
                        String placeNO = ob1.resultset.getString(7);
                        String minute = ob1.resultset.getString(8);
                        String hour = ob1.resultset.getString(9);
                        String day=ob1.resultset.getString(10);
                        String month = ob1.resultset.getString(11);
                        String Year = ob1.resultset.getString(12);
                        i = 2;
                        System.out.println("jgj");
                        //   System.out.println(license+" "+id+" "+s2+" "+s3+" "+s4+" "+s5+" "+s6);
                        System.out.println(minute+" "+hour+" "+day+" "+month+" "+Year);
                        this.setVisible(false);
                        CarClass object = new CarClass(path,name, mobileNo, address, license, id, placeNO, minute, hour, day, month, Year);
                      //  CarClass object = new CarClass();
                       object.setVisible(true);
                       // break;
                    }
                }
                if (i == 1) {
                    JOptionPane.showMessageDialog(this, "InCorrect Licnse !!!", "Notice", JOptionPane.INFORMATION_MESSAGE);
                    callThisClass();
                }
                ob1.connection.close();
            } catch (SQLException ev) {
                ev.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            callStartClass();
        }
        if (e.getSource() == searchButton) {
            carSearchMathod();
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
        JOptionPane.showMessageDialog(null, "This is a project of car parking management system developed by Shuvro and Shameem");
    }

    void callThisClass(){
        this.setVisible(false);
        SearchCar object = new SearchCar();
        object.setVisible(true);
    }
    
    public void callStartClass() {
        setVisible(false);
        StartPage object = new StartPage();
        object.setVisible(true);
    }

    public void searchMathod() {
        String id = "";
        String name = "";
        String mobileNo = "";
        String address = "";
        String picLocation = "";

        Connector_DataBase ob1 = new Connector_DataBase();
        String query = "Select * FROM question";
        try {

            ob1.resultset = ob1.statement.executeQuery(query);
            int i = 1;
            while (ob1.resultset.next()) {
                name = ob1.resultset.getString(1);

                i++;

            }
            ob1.connection.close();
        } catch (SQLException ev) {
            ev.printStackTrace();
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

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        licenseTextfield = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exitMenu = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenuItem();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 0));
        jLabel2.setText("Enter Car License  No :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 284, -1, 40));

        backButton.setBackground(new java.awt.Color(51, 102, 255));
        backButton.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.jpg"))); // NOI18N
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 381, 100, 42));

        licenseTextfield.setBackground(new java.awt.Color(51, 51, 255));
        licenseTextfield.setForeground(new java.awt.Color(204, 255, 255));
        jPanel1.add(licenseTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 292, 310, 31));

        searchButton.setBackground(new java.awt.Color(51, 102, 255));
        searchButton.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.jpg"))); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel1.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 381, 90, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/635519357112085465-1376219653_parking.gif"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 502, 210));

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

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenu;
    private javax.swing.JButton backButton;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField licenseTextfield;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables

}
