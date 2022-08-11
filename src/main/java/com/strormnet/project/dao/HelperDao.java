package com.strormnet.project.dao;

import com.strormnet.project.enums.PredmetType;
import com.strormnet.project.model.users.Admin;
import com.strormnet.project.model.Predmet;
import com.strormnet.project.model.users.Prepodavatel;

import java.sql.ResultSet;
import java.sql.SQLException;

    public class HelperDao {

        public static Predmet populatePredmet(ResultSet resultSet) throws SQLException {
            Predmet predmet = new Predmet();
            predmet.setId(resultSet.getInt("id"));
            predmet.setNazvanie(resultSet.getString("nazvanie"));
            predmet.setType((PredmetType) resultSet.getObject("type"));
            return predmet;
        }
        public static Admin populateAdmin(ResultSet resultSet) throws SQLException {
            Admin admin = new Admin();
            admin.setId(resultSet.getInt("id"));
            admin.setFio(resultSet.getString("fio"));
            admin.setPhoneNumber(resultSet.getInt("phone_number"));
            admin.setPassword(resultSet.getString("password"));
            return admin;
        }
        public static Prepodavatel populatePrepodavatel(ResultSet resultSet) throws SQLException {
            Prepodavatel prepodavatel = new Prepodavatel();
            prepodavatel.setId(resultSet.getInt("id"));
            prepodavatel.setFio(resultSet.getString("fio"));
            prepodavatel.setStavkaPerHour(resultSet.getDouble("stavka_per_hour"));
            prepodavatel.setExperience(resultSet.getInt("experience"));
            prepodavatel.setPhoneNumber(resultSet.getInt("phone_number"));
            prepodavatel.setPassword(resultSet.getString("password"));
            return prepodavatel;
        }
    }

