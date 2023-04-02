package com.webapp.backend.service;

import com.webapp.backend.dao.LoanApplicationDAO;
import com.webapp.backend.model.LoanApplication;

import java.sql.Connection;
import java.sql.SQLException;

public class LoanApplicationService {
    
    private Connection connection;
    private LoanApplicationDAO loanApplicationDAO;
    
    public LoanApplicationService(Connection connection){
        this.connection = connection;
        this.loanApplicationDAO = new LoanApplicationDAO(connection);
    }
    
    public void addLoanApplication(LoanApplication loanApplication) throws SQLException{
        
        loanApplicationDAO.addLoanApplication(loanApplication);
        
    }
    
}
