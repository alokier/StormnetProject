package com.strormnet.project.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDao {

        public Connection getConnection() {
            try {
                return DriverManager.getConnection("jdbc:mysql://localhost/stormnet", "root", "root");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
    }
}

