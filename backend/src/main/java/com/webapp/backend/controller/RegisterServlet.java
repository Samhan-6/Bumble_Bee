package com.webapp.backend.controller;

import com.webapp.backend.model.User;
import com.webapp.backend.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        //create new user object
        User user = new User(username, email, password);
        
        //connecting database
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(username, email, password) VALUES(?, ?, ?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            
            preparedStatement.executeUpdate();
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        response.sendRedirect("RegisterSuccess.jsp");
    }
    
}
