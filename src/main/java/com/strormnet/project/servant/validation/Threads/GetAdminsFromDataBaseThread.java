package com.strormnet.project.servant.validation.Threads;

import com.strormnet.project.dao.ConnectDao;
import com.strormnet.project.dao.HelperDao;
import com.strormnet.project.model.users.Admin;
import com.strormnet.project.servant.validation.Validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GetAdminsFromDataBaseThread extends Thread{

    private Validation validation;


    public GetAdminsFromDataBaseThread(Validation validation) {
        this.validation = validation;

    }

    @Override
    public void run() {

        Connection connection = new ConnectDao().getConnection();
        String sqlCommand = "select * from admins;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet != null && resultSet.next()) {
                Admin admin = HelperDao.populateAdmin(resultSet);
                if(admin.getPhoneNumber().equals(validation.getLogin()) && admin.getPassword().equals(validation.getPassword())){
                    validation.setFoundedUser(admin);
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Validation getValidation() {
        return validation;
    }

    public void setValidation(Validation validation) {
        this.validation = validation;
    }

}
