package com.webapp.backend.util;

import com.webapp.backend.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    //addUser() method which inserts a new user into the database
    public void addUser(User user) throws SQLException{
        String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPassword());
        statement.executeUpdate();
        statement.close();
    }
    
}
