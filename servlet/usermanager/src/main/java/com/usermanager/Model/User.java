package com.usermanager.Model;

public class User {
    protected int id;
    protected String name;
    protected String email;
    protected int idCountry;

    public User(int id, String name, String email, int idCountry) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.idCountry = idCountry;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }
}
