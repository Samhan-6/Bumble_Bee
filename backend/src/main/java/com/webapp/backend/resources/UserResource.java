package com.webapp.backend.resources;

import com.webapp.backend.model.User;

import java.util.*;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
public class UserResource {
    
    private static List<User> users = new ArrayList<>();
    
    //this method returns a list of all users JSON
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(){
        return users;
    }
    
    //this method adds a new user to the list
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(User user){
        users.add(user);
    }
    
}
