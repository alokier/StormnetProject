package com.strormnet.project.dao;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Locale;
import java.util.Properties;

public class ConnectDao {

    private final static String PATH = "resources\\database.properties";
    private final static String DATABASE_INFO = "resources\\DataBaseInfo.properties";

    public Connection getConnection() {

        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get(PATH))) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void writeFile(String url, String username, String password) throws FileNotFoundException {

        try(FileWriter fileWriter = new FileWriter(PATH)) {
            fileWriter.write(url + "\n");
            fileWriter.write(username + "\n");
            fileWriter.write(password + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public void getColumnName() throws FileNotFoundException, SQLException {
//        Connection connection = getConnection();
//        DatabaseMetaData databaseMetaData = connection.getMetaData();
//        ResultSet resultSet = databaseMetaData.getCatalogs();
//        try(FileWriter fileWriter = new FileWriter(DATABASE_INFO)) {
//            while (resultSet.next()){
//                fileWriter.write(resultSet.getString(1) + "\n");
//                if(resultSet.getString(1).toLowerCase(Locale.ROOT).contains("stormnet")){
//                    databaseMetaData.getColumns("stormnet");
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}


