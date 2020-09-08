package com.example.attendancetrackingsyatem.Databse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.attendancetrackingsyatem.Admin.Admin_list;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ats";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String admin = "CREATE TABLE ADMIN (_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, EMAIL TEXT, PASSWORD TEXT)";
        db.execSQL(admin);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {


    }

    public void insertAdminData(String name, String email, String password, SQLiteDatabase database){

        ContentValues values = new ContentValues();
        values.put("NAME",name);
        values.put("EMAIL",email);
        values.put("PASSWORD",password);
        database.insert("ADMIN",null,values);
        database.close();
    }

    public List<Admin_list> getAllAdmin() {
        List<Admin_list> admins = new ArrayList<>();
        Admin_list al;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM ADMIN",null);
        if (c.moveToFirst()){
            do{
                al = new Admin_list();
                al.setId(c.getInt(0));
                al.setName(c.getString(1));
                admins.add(al);
            }while (c.moveToNext());
        }
        db.close();
        return admins;
    }

    public Admin_list getAdmin(int id){
        Admin_list ad = new Admin_list();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM ADMIN WHERE _id = "+ id,null);
        if (c.moveToFirst()){
            ad.setId(c.getInt(0));
            ad.setName(c.getString(1));
            ad.setEmail(c.getString(2));
            ad.setPassword(c.getString(3));
        }
        db.close();
        return ad;
    }

    public void updateAdmin(Admin_list admin_list) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME",admin_list.getName());
        values.put("EMAIL",admin_list.getEmail());
        values.put("PASSWORD",admin_list.getPassword());
        db.update("ADMIN",values,"_id=?",new String[]{admin_list.getID()+""});
        db.close();
    }
}
