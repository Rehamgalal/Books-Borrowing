package com.example.reham.booksborrowing.Data;

/**
 * Created by reham on 3/22/2019.
 */

public class User {
    private String fName, sName, Country, City, Email, Password;
    public User(){}
    public User(String fName,String sName,String Country,String City,String Email,String Password){
        this.fName=fName;
        this.sName= sName;
        this.Country=Country;
        this.City=City;
        this.Email=Email;
        this.Password=Password;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfName() {
        return fName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsName() {
        return sName;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getCountry() {
        return Country;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getCity() {
        return City;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPassword() {
        return Password;
    }
}
