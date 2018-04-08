package com.esprit.utils;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataSource {

    Connection connexion;
    final String url = "jdbc:mysql://localhost:3306/pidev";
    final String user = "root";
    final String password = "";
    private static DataSource instance;

    private DataSource() {
        try {
            connexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }

        return instance;
    }

    public Connection getConnection() {
        return connexion;
    }
}
