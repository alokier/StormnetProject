package com.strormnet.project.servant.Validation.Threads;

import com.strormnet.project.dao.ConnectDao;
import com.strormnet.project.dao.HelperDao;
import com.strormnet.project.servant.Validation.Validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Semaphore;

public class GetAdminsFromDataBaseThread extends Thread{

    private Validation validation;
    private Semaphore semaphore;


    public GetAdminsFromDataBaseThread(Validation validation, Semaphore semaphore) {
        this.validation = validation;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Connection connection = new ConnectDao().getConnection();
        String sqlCommand = "select * from admins;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet != null && resultSet.next()) {
                validation.putUser(HelperDao.populateAdmin(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(100);
        }
    }

    public Validation getValidation() {
        return validation;
    }

    public void setValidation(Validation validation) {
        this.validation = validation;
    }

}