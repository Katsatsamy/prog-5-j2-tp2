package org.example.tp2_rent.Manager;

import org.example.tp2_rent.db.DataSource;
import org.example.tp2_rent.entity.Bicycle;
import org.example.tp2_rent.entity.House;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HouseManager implements Manager<House>{
    private final DataSource dataSource =  new DataSource();


    @Override
    public List<House> getAll(int page, int size) {
        if(page < 1){
            throw new IllegalArgumentException("page must be greater than 0 but is " + page);
        }else {
            List<House> houses = new ArrayList<>();
            String sql = "SELECT id, price, color FROM house LIMIT ? OFFSET ?";
            try(Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, size);
                statement.setInt(2, size * (page - 1));
                try(ResultSet resultSet = statement.executeQuery()){
                    while(resultSet.next()){
                        House house = new House(
                                resultSet.getString("id"),
                                resultSet.getDouble("price"),
                                resultSet.getString("color")
                        );
                        houses.add(house);
                    }
                    return houses;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public House getById(String id) {
        House house = null;
        String sql = "SELECT id, price, color FROM house WHERE id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    house = new House(
                            resultSet.getString("id"),
                            resultSet.getDouble("price"),
                            resultSet.getString("color")
                    );
                }
            }
            return house;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
