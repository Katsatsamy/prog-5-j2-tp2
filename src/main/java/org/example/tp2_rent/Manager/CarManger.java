package org.example.tp2_rent.Manager;

import org.example.tp2_rent.db.DataSource;
import org.example.tp2_rent.entity.Bicycle;
import org.example.tp2_rent.entity.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarManger implements Manager<Car>{
    private final DataSource dataSource = new DataSource();


    @Override
    public List<Car> getAll(int page, int size) {
        if(page < 1){
            throw new IllegalArgumentException("page must be greater than 0 but is " + page);
        }else {
            List<Car> cars = new ArrayList<>();
            String sql = "SELECT id, price, model, placeNumber FROM car LIMIT ? OFFSET ?";
            try(Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, size);
                statement.setInt(2, size * (page - 1));
                try(ResultSet resultSet = statement.executeQuery()){
                    while(resultSet.next()){
                        Car car = new Car(
                                resultSet.getString("id"),
                                resultSet.getDouble("price"),
                                resultSet.getString("model"),
                                resultSet.getInt("placeNumber")
                        );
                        cars.add(car);
                    }
                    return cars;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Car getById(String id) {
        Car car = null;
        String sql = "SELECT id, price, model, placeNumber FROM car WHERE id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    car = new Car(
                            resultSet.getString("id"),
                            resultSet.getDouble("price"),
                            resultSet.getString("model"),
                            resultSet.getInt("placeNumber")
                    );
                }
            }
            return car;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
