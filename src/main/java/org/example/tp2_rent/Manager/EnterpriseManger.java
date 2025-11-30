package org.example.tp2_rent.Manager;

import org.example.tp2_rent.db.DataSource;
import org.example.tp2_rent.entity.Association;
import org.example.tp2_rent.entity.Enterprise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnterpriseManger implements Manager<Enterprise>{
    private final DataSource dataSource =  new DataSource();

    @Override
    public List<Enterprise> getAll(int page, int size) {
        if(page < 1){
            throw new IllegalArgumentException("page must be greater than 0 but is " + page);
        }else {
            List<Enterprise> enterprises = new ArrayList<>();
            String sql = "SELECT id, name, email FROM enterprise LIMIT ? OFFSET ?";
            try(Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, size);
                statement.setInt(2, size * (page - 1));
                try(ResultSet resultSet = statement.executeQuery()){
                    while(resultSet.next()){
                        Enterprise enterprise = new Enterprise(
                                resultSet.getString("id"),
                                resultSet.getString("name"),
                                resultSet.getString("email")
                        );
                        enterprises.add(enterprise);
                    }
                    return enterprises;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Enterprise getById(String id) {
        Enterprise enterprise = null;
        String sql = "SELECT id, name, email FROM enterprise WHERE id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    enterprise = new Enterprise(
                            resultSet.getString("id"),
                            resultSet.getString("name"),
                            resultSet.getString("email")
                    );
                }
            }
            return enterprise;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
