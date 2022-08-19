package com.strormnet.project.dao.impl;

import com.strormnet.project.dao.ConnectDao;
import com.strormnet.project.dao.HelperDao;
import com.strormnet.project.dao.repository.PrepodavatelRepository;
import com.strormnet.project.model.users.Prepodavatel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrepodavatelRepositoryImpl implements PrepodavatelRepository {

    @Override
    public List<Prepodavatel> getAll() {
        Connection connection = new ConnectDao().getConnection();
        String sqlCommand = "select * from prepodavatel;";
        List<Prepodavatel> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet != null && resultSet.next()) {
                result.add(HelperDao.populatePrepodavatel(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Prepodavatel getOneById(Integer id) {
        Connection connection = new ConnectDao().getConnection();
        String sqlCommand = "select * from prepodavatel where id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                return HelperDao.populatePrepodavatel(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateById(Integer id, Prepodavatel prepodavatel) {
        Connection connection = new ConnectDao().getConnection();
        String sqlCommand = "update prepodavatel set fio = ?, stavka_per_hour = ?, experience = ?, phone_number = ?, password = ?, isAdmin = ? where id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand)) {
            preparedStatement.setString(1, prepodavatel.getFio());
            preparedStatement.setDouble(2, prepodavatel.getStavkaPerHour());
            preparedStatement.setInt(3, prepodavatel.getExperience());
            preparedStatement.setInt(4, prepodavatel.getPhoneNumber());
            preparedStatement.setString(5, prepodavatel.getPassword());
            preparedStatement.setBoolean(6, prepodavatel.getAdmin());
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        Connection connection = new ConnectDao().getConnection();
        String sqlCommand = "delete from prepodavatel where id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertOne(Prepodavatel prepodavatel) {
        Connection connection = new ConnectDao().getConnection();
        String sqlCommand = "insert into prepodavatel (fio, stavka_per_hour, experience, phone_number, password, isAdmin) values (?, ?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand)) {
            preparedStatement.setString(1, prepodavatel.getFio());
            preparedStatement.setDouble(2, prepodavatel.getStavkaPerHour());
            preparedStatement.setInt(3, prepodavatel.getExperience());
            preparedStatement.setInt(4, prepodavatel.getPhoneNumber());
            preparedStatement.setString(5, prepodavatel.getPassword());
            preparedStatement.setBoolean(6, prepodavatel.getAdmin());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Integer getPrepodavatelsCount() {
        Connection connection = new ConnectDao().getConnection();
        String sqlCommand = "SELECT count(*) FROM prepodavatel;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                return Integer.parseInt(resultSet.getString("count(*)"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
