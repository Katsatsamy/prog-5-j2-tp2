package org.example.tp2_rent.Manager;

import org.example.tp2_rent.db.DataSource;
import org.example.tp2_rent.entity.Bicycle;
import org.example.tp2_rent.entity.Money;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MoneyManager implements Manager<Money> {
    private final DataSource dataSource =  new DataSource();

    @Override
    public List<Money> getAll(int page, int size) {
        if(page < 1){
            throw new IllegalArgumentException("page must be greater than 0 but is " + page);
        }else {
            List<Money> moneys = new ArrayList<>();
            String sql = "SELECT id, price, device FROM money LIMIT ? OFFSET ?";
            try(Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, size);
                statement.setInt(2, size * (page - 1));
                try(ResultSet resultSet = statement.executeQuery()){
                    while(resultSet.next()){
                        Money money = new Money(
                                resultSet.getString("id"),
                                resultSet.getDouble("price"),
                                resultSet.getString("device")
                        );
                        moneys.add(money);
                    }
                    return moneys;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Money getById(String id) {
        Money money = null;
        String sql = "SELECT id, price, device FROM money WHERE id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    money = new Money(
                            resultSet.getString("id"),
                            resultSet.getDouble("price"),
                            resultSet.getString("device")
                    );
                }
            }
            return money;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
