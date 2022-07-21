package com.strormnet.project.dao;

import com.strormnet.project.enums.PredmetType;
import com.strormnet.project.model.Predmet;

import java.sql.ResultSet;
import java.sql.SQLException;

    public class HelperDao {

        public static Predmet populatePredmet(ResultSet resultSet) throws SQLException {
            Predmet predmet = new Predmet();
            predmet.setId(resultSet.getInt("id"));
            predmet.setNazvaniePredmeta(resultSet.getString("nazvanie"));
            predmet.setTypePredmeta((PredmetType) resultSet.getObject("type"));
            return predmet;
        }
    }

