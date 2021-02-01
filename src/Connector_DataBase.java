package com.neub.carParkingManagementSystem;

import java.sql.*;

public class Connector_DataBase {

    public Connection connection;
    public Statement statement;
    public ResultSet resultset;

    public Connector_DataBase() {
        String dbtime;
        String dbUrl = "jdbc:mysql://localhost/parkingManagementDatabase";
        String query = "Select * FROM registrationtable";

        try {
            connection = DriverManager.getConnection(dbUrl, "root", "");
            statement = connection.createStatement();
            resultset = statement.executeQuery(query);

        } 
        catch (SQLException e) {
            e.printStackTrace();
        }

    }  //end main

}  //end class
