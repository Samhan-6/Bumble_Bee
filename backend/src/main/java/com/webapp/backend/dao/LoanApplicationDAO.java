package com.webapp.backend.dao;

import com.webapp.backend.model.LoanApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoanApplicationDAO {
    
    private Connection connection;
    
    public LoanApplicationDAO(Connection connection){
        this.connection = connection;
    }
    
    public void addLoanApplication(LoanApplication loanApplication) throws SQLException{
        
        String query = "INSERT INTO bumblebee.loan_application (first_name, last_name, sex, email, mobile_number, home_number, address, city, zip_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, loanApplication.getFirstName());
        statement.setString(2, loanApplication.getLastName());
        statement.setString(3, loanApplication.getSex());
        statement.setString(4, loanApplication.getEmail());
        statement.setString(5, loanApplication.getMobileNumber());
        statement.setString(6, loanApplication.getHomeNumber());
        statement.setString(7, loanApplication.getAddress());
        statement.setString(8, loanApplication.getCity());
        statement.setString(9, loanApplication.getZipcode());
        statement.executeUpdate();
    }
    
}
