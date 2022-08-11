package com.strormnet.project.dao.impl;

import com.strormnet.project.dao.ConnectDao;
import com.strormnet.project.dao.HelperDao;
import com.strormnet.project.dao.repository.AdminRepository;
import com.strormnet.project.model.users.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminRepositoryImpl implements AdminRepository {
    @Override
    public List<Admin> getAll() {
        Connection connection = new ConnectDao().getConnection();
        String sqlCommand = "select * from admins;";
        List<Admin> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet != null && resultSet.next()) {
                result.add(HelperDao.populateAdmin(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Admin getOneById(Integer id) {
        Connection connection = new ConnectDao().getConnection();
        String sqlCommand = "select * from admins where id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                return HelperDao.populateAdmin(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateById(Integer id, Admin entity) {
        Connection connection = new ConnectDao().getConnection();
        String sqlCommand = "update admins set fio = ?, phone_number = ?, password = ? where id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand)) {
            preparedStatement.setString(1, entity.getFio());
            preparedStatement.setInt(2, entity.getPhoneNumber());
            preparedStatement.setString(3, entity.getPassword());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        Connection connection = new ConnectDao().getConnection();
        String sqlCommand = "delete from admins where id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertOne(Admin entity) {
        Connection connection = new ConnectDao().getConnection();
        String sqlCommand = "insert into admins (fio, phone_number, password) values (?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand)) {
            preparedStatement.setString(1, entity.getFio());
            preparedStatement.setInt(2, entity.getPhoneNumber());
            preparedStatement.setString(3, entity.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
