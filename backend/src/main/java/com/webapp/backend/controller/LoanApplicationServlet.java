package com.webapp.backend.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/LoanApplicationServlet")
public class LoanApplicationServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    private DataSource dataSource;
    
    @Override
    public void init() throws ServletException{
        super.init();
        dataSource = (DataSource) getServletContext().getAttribute("dataSource");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        String mobileNumber = request.getParameter("mobile-number");
        String homeNumber = request.getParameter("home-number");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String zipCode = request.getParameter("zip-code");
        
        try(Connection conn = dataSource.getConnection()){
            String sql = "INSERT INTO loan_application (first_name, last_name, sex, email, mobile_number, home_number, address, city, zip_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, sex);
            stmt.setString(4, email);
            stmt.setString(5, mobileNumber);
            stmt.setString(6, homeNumber);
            stmt.setString(7, address);
            stmt.setString(8, city);
            stmt.setString(9, zipCode);
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            throw new ServletException(e);
        }
        
        //redirect to success page
        response.sendRedirect("LoanApplicationSuccess.jsp");
    }

}
