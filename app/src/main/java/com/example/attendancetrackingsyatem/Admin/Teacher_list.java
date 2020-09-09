package com.example.attendancetrackingsyatem.Admin;

public class Teacher_list {

    private String name;
    private String email;
    private String password;

    private int _id;
    public static final Teacher_list[] teachers = {};

    public Teacher_list(String name,String email,String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Teacher_list(){}

    public Teacher_list(int _id, String name,String email,String password){
        this._id = _id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getID(){ return _id; }
    public void setId(int _id){this._id = _id;}

    public void setName(String name) {this.name = name;}
    public String getName(){return name;}

    public void setEmail(String email){this.email = email;}
    public String getEmail(){return email;}

    public void setPassword(String password){this.password = password;}
    public String getPassword(){return password;}

    public String toString(){return this.name;}
}
