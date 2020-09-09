package com.example.attendancetrackingsyatem.Admin;

public class SubClass_list {

    private String sub_class;

    public static final SubClass_list[] subclass = {};

    public SubClass_list(String sub_class) {
        this.sub_class = sub_class;
    }

    public SubClass_list(){}

//    public SubClass_list(String sub_class){
//        this.sub_class = sub_class;
//    }

//    public void setId(int _id){this._id = _id;}
//    public int getID(){ return _id; }

//    public void setName(String name) {this.name = name;}
//    public String getName(){return name;}

    public void setSub_class(String sub_class){this.sub_class = sub_class;}
    public String getSub_class(){return sub_class;}

    public String toString(){return this.sub_class;}
}
