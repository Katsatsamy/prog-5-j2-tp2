package org.example.tp2_rent.Manager;

import org.example.tp2_rent.db.DataSource;
import org.example.tp2_rent.entity.Association;
import org.example.tp2_rent.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonManger implements Manager<Person> {
    private final DataSource dataSource = new DataSource();

    @Override
    public List<Person> getAll(int page, int size) {
        if(page < 1){
            throw new IllegalArgumentException("page must be greater than 0 but is " + page);
        }else {
            List<Person> persons = new ArrayList<>();
            String sql = "SELECT id, name, email FROM person LIMIT ? OFFSET ?";
            try(Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, size);
                statement.setInt(2, size * (page - 1));
                try(ResultSet resultSet = statement.executeQuery()){
                    while(resultSet.next()){
                        Person person = new Association(
                                resultSet.getString("id"),
                                resultSet.getString("name"),
                                resultSet.getString("email")
                        );
                        persons.add(person);
                    }
                    return persons;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Person getById(String id) {
        Person person = null;
        String sql = "SELECT id, name, email FROM association WHERE id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    person = new Person(
                            resultSet.getString("id"),
                            resultSet.getString("name"),
                            resultSet.getString("email")
                    );
                }
            }
            return person;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
