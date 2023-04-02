package com.webapp.backend.resources;

import com.webapp.backend.model.LoanApplication;
import com.webapp.backend.service.LoanApplicationService;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.SQLException;

@Path("/loanapplication")
public class LoanApplicationResource {
    
    private Connection connection;
    private LoanApplicationService loanApplicationService;
    
    public LoanApplicationResource(Connection connection){
        this.connection = connection;
        this.loanApplicationService = new LoanApplicationService(connection);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLoanApplication(LoanApplication loanApplication){
        
        try{
            loanApplicationService.addLoanApplication(loanApplication);
            return Response.status(Response.Status.CREATED).build();
        }catch (SQLException e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to create loan application.").build();
        }
    }
    
}
