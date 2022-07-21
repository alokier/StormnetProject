package com.strormnet.project.dao.impl;

import com.strormnet.project.dao.ConnectDao;
import com.strormnet.project.dao.PredmetRepository;
import com.strormnet.project.model.Predmet;

import static com.strormnet.project.dao.HelperDao.populatePredmet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PredmetRepositoryImpl implements PredmetRepository {

    @Override
    public List<Predmet> getAll() {
        Connection connection = new ConnectDao().getConnection();
        String sqlCommand = "SELECT * FROM stormnet.predmet;";
        List<Predmet> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet != null && resultSet.next()) {
                result.add(populatePredmet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Predmet getOneById(Integer id) {
        Connection connection = new ConnectDao().getConnection();
        String sqlCommand = "SELECT * FROM stormnet.predmet where id = " + id + ";";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement != null ? statement.executeQuery(sqlCommand) : null;
            if (resultSet != null && resultSet.next()) {
                return populatePredmet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateById(Integer id, Predmet entity) {
        Connection connection = new ConnectDao().getConnection();
        String sqlCommand = "UPDATE predmet" +
                " SET nazvanie = '" + entity.getNazvaniePredmeta() + "'"
                + ", type = '" + entity.getTypePredmeta().toString() + "'"
                + " WHERE id = " + id + ";";
        try (Statement statement = connection.createStatement()) {
            if (statement != null) {
                statement.executeUpdate(sqlCommand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        Connection connection = new ConnectDao().getConnection();
        String sqlCommand = "delete from stormnet.predmet where id = " + id + ";";
        try (Statement statement = connection.createStatement()) {
            if (statement != null) {
                statement.executeUpdate(sqlCommand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertOne(Predmet entity) {
        Connection connection = new ConnectDao().getConnection();
        String sqlCommand = "insert into stormnet.predmet (nazvanie, type) values (?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand);) {
            preparedStatement.setString(1, entity.getNazvaniePredmeta());
            preparedStatement.setString(2, entity.getTypePredmeta().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
