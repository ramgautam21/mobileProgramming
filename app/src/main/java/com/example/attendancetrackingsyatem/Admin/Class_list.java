package com.example.attendancetrackingsyatem.Admin;

public class Class_list {

    private String name;
    private int _id;
    public static final Class_list[] classes = {};

    public Class_list(String name) {
        this.name = name;
    }

    public Class_list(){}

    public Class_list(int _id, String name){
        this._id = _id;
        this.name = name;
    }

    public int getID(){ return _id; }
    public void setId(int _id){this._id = _id;}

    public void setName(String name) {this.name = name;}
    public String getName(){return name;}

    public String toString(){return this.name;}
}
