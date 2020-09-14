package com.example.attendancetrackingsyatem.Admin;

public class SubClass_list {

    private String sub_class;

    public static final SubClass_list[] subclass = {};

    public SubClass_list(String sub_class) {
        this.sub_class = sub_class;
    }

    public SubClass_list(){}

    public void setSub_class(String sub_class){this.sub_class = sub_class;}
    public String getSub_class(){return sub_class;}

    public String toString(){return this.sub_class;}
}
