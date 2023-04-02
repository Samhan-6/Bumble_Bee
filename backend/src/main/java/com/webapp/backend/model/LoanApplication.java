package com.webapp.backend.model;


public class LoanApplication {
    
    private int id;
    private String firstName;
    private String lastName;
    private String sex;
    private String email;
    private String mobileNumber;
    private String homeNumber;
    private String address;
    private String city;
    private String zipcode;
    
    public LoanApplication(){
        this.id = 0;
        this.firstName = "";
        this.lastName = "";
        this.sex = "";
        this.email = "";
        this.mobileNumber = "";
        this.homeNumber = "";
        this.address = "";
        this.city = "";
        this.zipcode = "";
    }

    public LoanApplication(int id, String firstName, String lastName, String sex, String email, String mobileNumber, String homeNumber, String address, String city, String zipcode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.homeNumber = homeNumber;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    
    
    
}
