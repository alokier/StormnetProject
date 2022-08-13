package com.strormnet.project.servant.Validation.Threads;

import com.strormnet.project.dao.ConnectDao;
import com.strormnet.project.dao.HelperDao;
import com.strormnet.project.model.users.Prepodavatel;
import com.strormnet.project.model.users.User;
import com.strormnet.project.servant.Validation.Validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Semaphore;

public class GetPrepodavatelFromDataBaseThread extends Thread{

    private Validation validation;



    public GetPrepodavatelFromDataBaseThread(Validation validation) {
        this.validation = validation;

    }

    @Override
    public void run() {

        Connection connection = new ConnectDao().getConnection();
        String sqlCommand = "select * from prepodavatel;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet != null && resultSet.next()) {
                Prepodavatel prepodavatel = HelperDao.populatePrepodavatel(resultSet);
                if(prepodavatel.getPhoneNumber().equals(validation.getLogin()) && prepodavatel.getPassword().equals(validation.getPassword())){
                    validation.setFoundedUser(prepodavatel);
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
