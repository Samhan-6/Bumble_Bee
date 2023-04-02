package com.webapp.backend.dao;

import com.webapp.backend.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    
    //addUser() method which inserts a new user into the database
    public void addUser(User user) throws ClassNotFoundException{
        
        String INSERT_INTO_USER_SQL = "INSERT INTO users" + "(username, email, password) VALUES" + "(?, ?, ?);";
        
        int result = 0;
        
        try(Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/bumblebee?useSSL=false", "root", "root");
                
                //create statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_USER_SQL)){
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getPassword());
            
            System.out.println(preparedStatement);
            //execute or update query
            result = preparedStatement.executeUpdate();
            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
}
