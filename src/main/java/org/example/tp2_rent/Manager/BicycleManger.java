package org.example.tp2_rent.Manager;

import org.example.tp2_rent.db.DataSource;
import org.example.tp2_rent.entity.Association;
import org.example.tp2_rent.entity.Bicycle;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BicycleManger implements Manager<Bicycle> {
    private final DataSource dataSource =  new DataSource();


    @Override
    public List<Bicycle> getAll(int page, int size) {
        if(page < 1){
            throw new IllegalArgumentException("page must be greater than 0 but is " + page);
        }else {
            List<Bicycle> bicycles = new ArrayList<>();
            String sql = "SELECT id, price, brand, color FROM bicycle LIMIT ? OFFSET ?";
            try(Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, size);
                statement.setInt(2, size * (page - 1));
                try(ResultSet resultSet = statement.executeQuery()){
                    while(resultSet.next()){
                        Bicycle bicycle = new Bicycle(
                                resultSet.getString("id"),
                                resultSet.getDouble("price"),
                                resultSet.getString("model"),
                                resultSet.getString("brand"),
                                resultSet.getString("color")
                        );
                        bicycles.add(bicycle);
                    }
                    return bicycles;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Bicycle getById(String id) {
        Bicycle bicycle = null;
        String sql = "SELECT id, price, brand, color FROM bicycle WHERE id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    bicycle = new Bicycle(
                            resultSet.getString("id"),
                            resultSet.getDouble("price"),
                            resultSet.getString("model"),
                            resultSet.getString("brand"),
                            resultSet.getString("color")
                    );
                }
            }
            return bicycle;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
