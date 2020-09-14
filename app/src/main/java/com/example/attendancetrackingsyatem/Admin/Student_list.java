package com.example.attendancetrackingsyatem.Admin;

public class Student_list {

    private String name;
    private String email;
    private String password;
    private String st_class;

    private int _id;
    public static final Student_list[] students = {};

    public Student_list(String name,String email,String password,String st_class) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.st_class = st_class;
    }

    public Student_list(){}

    public Student_list(int _id, String name,String email,String password,String st_class){
        this._id = _id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.st_class = st_class;
    }

    public int getID(){ return _id; }
    public void setId(int _id){this._id = _id;}

    public void setName(String name) {this.name = name;}
    public String getName(){return name;}

    public void setEmail(String email){this.email = email;}
    public String getEmail(){return email;}

    public void setPassword(String password){this.password = password;}
    public String getPassword(){return password;}

    public void setSt_class(String  st_class){this.st_class = st_class;};
    public String getSt_class(){return st_class;}

    public String toString(){return this.name;}
}
