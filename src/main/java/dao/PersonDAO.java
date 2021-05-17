package dao;

import dto.Person;
import util.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDAO {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public Person getPersonFromId(String id) {
        Person person = new Person();
        
        try {
            Connection connection = DatabaseManager.getConnection();

            String sql = "select * from person where id = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                person.setAge(resultSet.getInt("age"));
                person.setName(resultSet.getString("name"));
                person.setId(resultSet.getInt("id"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            if( resultSet != null ){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if( preparedStatement != null ){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DatabaseManager.close();
        }
        return person;
    }
}

