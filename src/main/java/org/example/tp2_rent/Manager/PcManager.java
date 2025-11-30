package org.example.tp2_rent.Manager;

import org.example.tp2_rent.db.DataSource;
import org.example.tp2_rent.entity.Association;
import org.example.tp2_rent.entity.Pc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PcManager implements Manager<Pc> {
    private final DataSource dataSource = new DataSource();


    @Override
    public List<Pc> getAll(int page, int size) {
        if(page < 1){
            throw new IllegalArgumentException("page must be greater than 0 but is " + page);
        }else {
            List<Pc> pcs = new ArrayList<>();
            String sql = "SELECT id, price, model, brand FROM association LIMIT ? OFFSET ?";
            try(Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, size);
                statement.setInt(2, size * (page - 1));
                try(ResultSet resultSet = statement.executeQuery()){
                    while(resultSet.next()){
                        Pc pc = new Pc(
                                resultSet.getString("id"),
                                resultSet.getDouble("price"),
                                resultSet.getString("model"),
                                resultSet.getString("brand")
                        );
                        pcs.add(pc);
                    }
                    return pcs;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Pc getById(String id) {
        Pc pc = null;
        String sql = "SELECT id, price, model, brand FROM pc WHERE id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    pc = new Pc(
                            resultSet.getString("id"),
                            resultSet.getDouble("price"),
                            resultSet.getString("model"),
                            resultSet.getString("brand")
                    );
                }
            }
            return pc;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
