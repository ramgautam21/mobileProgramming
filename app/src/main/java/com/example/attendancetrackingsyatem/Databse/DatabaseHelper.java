package com.example.attendancetrackingsyatem.Databse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.attendancetrackingsyatem.Admin.Admin_list;
import com.example.attendancetrackingsyatem.Admin.Class_list;
import com.example.attendancetrackingsyatem.Admin.SubClass_list;
import com.example.attendancetrackingsyatem.Admin.Subject_list;
import com.example.attendancetrackingsyatem.Admin.Teacher_list;

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

        String teacher = "CREATE TABLE TEACHER (_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, EMAIL TEXT, PASSWORD TEXT)";
        db.execSQL(teacher);

        String classes = "CREATE TABLE CLASS (_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT)";
        db.execSQL(classes);

        String subject = "CREATE TABLE SUBJECT (_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SUB_CLASS TEXT)";
        db.execSQL(subject);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        db.execSQL("DROP TABLE IF EXISTS ADMIN");
//        db.execSQL("DROP TABLE IF EXISTS TEACHER");
//        db.execSQL("DROP TABLE IF EXISTS CLASS");
//        db.execSQL("DROP TABLE IF EXISTS SUBJECT");
//        onCreate(db);

    }

//    ================================== ADMIN/ADD ADMIN =============================================================
//===================================================================================================================
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

    public void deleteAdmin(int id){

        SQLiteDatabase db = getWritableDatabase();
        db.delete("ADMIN","_id=?",new String[]{id+""});
        db.close();

    }


//    ============================================End of ADMIN / ADD ADMIN ===============================================
//    ====================================================================================================================


    public void insertTeacherData(String name, String email, String password, SQLiteDatabase database){

        ContentValues values = new ContentValues();
        values.put("NAME",name);
        values.put("EMAIL",email);
        values.put("PASSWORD",password);
        database.insert("TEACHER",null,values);
        database.close();
    }

    public List<Teacher_list> getAllTeacher() {
        List<Teacher_list> teachers = new ArrayList<>();
        Teacher_list tl;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM TEACHER",null);
        if (c.moveToFirst()){
            do{
                tl = new Teacher_list();
                tl.setId(c.getInt(0));
                tl.setName(c.getString(1));
                teachers.add(tl);
            }while (c.moveToNext());
        }
        db.close();
        return teachers;
    }


    public Teacher_list getTeacher(int id) {
        Teacher_list tl = new Teacher_list();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM TEACHER WHERE _id = "+ id,null);
        if (c.moveToFirst()){
            tl.setId(c.getInt(0));
            tl.setName(c.getString(1));
            tl.setEmail(c.getString(2));
            tl.setPassword(c.getString(3));
        }
        db.close();
        return tl;
    }

    public void updateTeacher(Teacher_list teacher_list) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME",teacher_list.getName());
        values.put("EMAIL",teacher_list.getEmail());
        values.put("PASSWORD",teacher_list.getPassword());
        db.update("TEACHER",values,"_id=?",new String[]{teacher_list.getID()+""});
        db.close();
    }

    public void deleteTeacher(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("TEACHER","_id=?",new String[]{id+""});
        db.close();
    }

//    ===========================End of ADMIN/TEACHER===========================================

    public List<Class_list> getAllClass() {
        List<Class_list> classes = new ArrayList<>();
        Class_list cl;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM CLASS",null);
        if (c.moveToFirst()){
            do{
                cl = new Class_list();
                cl.setId(c.getInt(0));
                cl.setName(c.getString(1));
                classes.add(cl);
            }while (c.moveToNext());
        }
        db.close();
        return classes;
    }

    public Class_list getClass(int id) {

        Class_list cl = new Class_list();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM CLASS WHERE _id = "+ id,null);
        if (c.moveToFirst()){
            cl.setId(c.getInt(0));
            cl.setName(c.getString(1));
        }
        db.close();
        return cl;

    }

    public void insertClassData(String name, SQLiteDatabase database) {
        ContentValues values = new ContentValues();
        values.put("NAME",name);
        database.insert("CLASS",null,values);
        database.close();
    }

    public void updateClass(Class_list class_list) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME",class_list.getName());
        db.update("CLASS",values,"_id=?",new String[]{class_list.getID()+""});
        db.close();
    }

    public void deleteClass(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("CLASS","_id=?",new String[]{id+""});
        db.close();
    }

//    ============================End of Admin/Class=========================================================

    public List<SubClass_list> getSub_ClassData() {

        List<SubClass_list> sc  = new ArrayList<>();
        SubClass_list scl;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM CLASS",null);
        if (c.moveToFirst()){
            do{
                scl = new SubClass_list();
                scl.setSub_class(c.getString(1));
                sc.add(scl);
            }while (c.moveToNext());
        }
        db.close();
        return sc;
    }

    public List<Subject_list> getAllSubject() {

        List<Subject_list> subject = new ArrayList<>();
        Subject_list sl;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM SUBJECT",null);
        if (c.moveToFirst()){
            do{
                sl = new Subject_list();
                sl.setId(c.getInt(0));
                sl.setName(c.getString(1));
                sl.setSub_class(c.getString(2));
                subject.add(sl);
            }while (c.moveToNext());
        }
        db.close();
        return subject;

    }

    public void insertSubjectData(String name, String subclass, SQLiteDatabase database) {

        ContentValues values = new ContentValues();
        values.put("NAME",name);
        values.put("SUB_CLASS",subclass);
        database.insert("SUBJECT",null,values);
        database.close();

    }

    public Subject_list getSubject(int id) {

        Subject_list sl = new Subject_list();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM SUBJECT WHERE _id = "+ id,null);
        if (c.moveToFirst()){
            sl.setId(c.getInt(0));
            sl.setName(c.getString(1));
            sl.setSub_class(c.getString(2));
        }
        db.close();
        return sl;

    }

    public void deleteSubject(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("SUBJECT","_id=?",new String[]{id+""});
        db.close();
    }
//    ==============================================End of Subject/Admin===============================


}
