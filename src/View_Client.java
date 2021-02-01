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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ss
 */
public class View_Client extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form View_Client
     */
    public String id = "";

    public View_Client() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);

        backButton.addActionListener(this);
        deleteButton.addActionListener(this);
        exitMenu.addActionListener(this);
        aboutMenu.addActionListener(this);

        viewTable();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            callStartClass();
        }
        if (e.getSource() == deleteButton) {
            searchMathod();
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
    void searchMathod() {
        id = idTextField.getText();
        String databaseID = "";
        String deletequery = "DELETE FROM registrationtable WHERE registrationNoClient = '" + id + "'";
        if (id.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Fill Up Textfield !!!", "Notice", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Connector_DataBase ob1 = new Connector_DataBase();
            String query = "Select * FROM registrationtable WHERE registrationNoClient = '" + id + "'";
            try {

                ob1.resultset = ob1.statement.executeQuery(query);
                int i = 1;
                while (ob1.resultset.next()) {
                    databaseID = ob1.resultset.getString(1);
                    if (id.equals(databaseID)) {

                        i = 5;
                        searchCarTable();
                        break;
                    }
//                i++;

                }
                if (i == 1) {
                    JOptionPane.showMessageDialog(this, "InCorrect ID !!!", "Notice", JOptionPane.INFORMATION_MESSAGE);
                    // callThisClass();

                }
                ob1.connection.close();
            } catch (SQLException ev) {
                ev.printStackTrace();
            }
        }
    }

    public void searchCarTable() {
        String databaseID = "";
        Connector_DataBase ob1 = new Connector_DataBase();
        String query = "Select * FROM carregistrationtable WHERE registrationNoClient = '" + id + "'";
        try {

            ob1.resultset = ob1.statement.executeQuery(query);
            int i = 1;
            while (ob1.resultset.next()) {
                databaseID = ob1.resultset.getString(2);
                if (id.equals(databaseID)) {

                    i = 5;
                    JOptionPane.showMessageDialog(this, "Can't Deleted , Please Clear Car .", "Notice", JOptionPane.INFORMATION_MESSAGE);

                    break;
                }
//                i++;

            }
            if (i == 1) {
                deleteMathod();
                // callThisClass();

            }
            ob1.connection.close();
        } catch (SQLException ev) {
            ev.printStackTrace();
        }
    }

    public void deleteMathod() {
        Connector_DataBase object = new Connector_DataBase();
        String query = "DELETE FROM registrationtable WHERE registrationNoClient = '" + id + "'";
        try {
            object.statement.executeUpdate(query);
            //object.stmt.executeQuery(sql);
            //   object.statement.executeUpdate(sql);
            object.connection.close();
        } catch (SQLException ev) {
            ev.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "Deleted .", "Notice", JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
        View_Client viewobject = new View_Client();
        viewobject.setVisible(true);
    }

    void viewTable() {
        int i = 0;
        String[] id = new String[1000];
        String[] name = new String[1000];
        String[] mobileNo = new String[1000];
        String[] address = new String[1000];
        Connector_DataBase ob1 = new Connector_DataBase();
        String query = "Select * FROM registrationtable";
        try {

            ob1.resultset = ob1.statement.executeQuery(query);

            while (ob1.resultset.next()) {
                id[i] = ob1.resultset.getString(1);
                name[i] = ob1.resultset.getString(2);
                mobileNo[i] = ob1.resultset.getString(3);
                address[i] = ob1.resultset.getString(4);
                i++;

            }
            ob1.connection.close();
        } catch (SQLException ev) {
            ev.printStackTrace();
        }
        DefaultTableModel model = new DefaultTableModel();
        //model.addRow(str);
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Mobile No");
        model.addColumn("Address");

// Append a row 
        for (int k = 0; k < i; k++) {

            String str = Integer.toString(k + 1);
            //  comboBox.addItem(str);
            model.addRow(new Object[]{(id[k]), (name[k]), (mobileNo[k]), (address[k])});

        }
        Table.setModel(model);

    }

    void callStartClass() {
        this.setVisible(false);
        StartPage object = new StartPage();
        object.setVisible(true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exitMenu = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        Table.setBackground(new java.awt.Color(51, 51, 255));
        Table.setForeground(new java.awt.Color(204, 255, 255));
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Table);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("Enter ID :");

        idTextField.setBackground(new java.awt.Color(51, 51, 255));
        idTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        idTextField.setForeground(new java.awt.Color(204, 255, 255));

        deleteButton.setBackground(new java.awt.Color(51, 51, 255));
        deleteButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 0, 51));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.jpg"))); // NOI18N

        backButton.setBackground(new java.awt.Color(51, 51, 255));
        backButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backButton.setForeground(new java.awt.Color(153, 0, 204));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("SimSun", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Client Information");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backButton)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idTextField)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(backButton)
                .addGap(0, 0, Short.MAX_VALUE))
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
    private javax.swing.JTable Table;
    private javax.swing.JMenuItem aboutMenu;
    private javax.swing.JButton backButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
