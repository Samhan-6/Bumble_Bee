package com.webapp.backend.controller;

import com.webapp.backend.model.User;
import com.webapp.backend.util.DBUtil;
import com.webapp.backend.dao.UserDAO;
import jakarta.servlet.RequestDispatcher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private UserDAO userDAO = new UserDAO();
    
    public RegisterServlet(){
        super();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        String url = "/register.html";
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        //create new user object
        User user = new User();
        user.setName("name");
        user.setEmail("email");
        user.setPassword("password");
        
        try{
            userDAO.addUser(user);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/RegisterSuccess.jsp");
        dispatcher.forward(request, response);
    }
    
}
