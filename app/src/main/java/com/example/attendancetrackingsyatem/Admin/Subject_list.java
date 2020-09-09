package com.example.attendancetrackingsyatem.Admin;

public class Subject_list {
    private String name;
    private String sub_class;


    private int _id;
    public static final Subject_list[] subjects = {};

    public Subject_list(String name,String sub_class) {
        this.name = name;
        this.sub_class = sub_class;
    }

    public Subject_list(){}

    public Subject_list(int _id, String name,String sub_class){
        this._id = _id;
        this.name = name;
        this.sub_class = sub_class;
    }

    public void setId(int _id){this._id = _id;}
    public int getID(){ return _id; }

    public void setName(String name) {this.name = name;}
    public String getName(){return name;}

    public void setSub_class(String sub_class){this.sub_class = sub_class;}
    public String getSub_class(){return sub_class;}

    public String toString(){return this.name;}
}
