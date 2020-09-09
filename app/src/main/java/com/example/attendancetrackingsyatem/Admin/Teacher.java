package com.example.attendancetrackingsyatem.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.attendancetrackingsyatem.Databse.DatabaseHelper;
import com.example.attendancetrackingsyatem.R;

import java.util.List;

public class Teacher extends AppCompatActivity {
    private EditText editName, editEmail, editPassword;
    private Button btn_addData;
    private ListView listViewOfTeachers;
    private String name, email, password;
    SQLiteDatabase database;
    ArrayAdapter<Teacher_list> teacherAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        final DatabaseHelper db = new DatabaseHelper(this);
        this.database = db.getWritableDatabase();

        editName = findViewById(R.id.editText_addTeacher_name);
        editEmail = findViewById(R.id.editText_addTeacher_email);
        editPassword = findViewById(R.id.editText_addTeacher_password);
        btn_addData = findViewById(R.id.btn_addTeacher);
        listViewOfTeachers = findViewById(R.id.listView_addTeacher);
        SetTeacherList();

        btn_addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editName.getText().toString().equals("") || editEmail.getText().toString().equals("") || editPassword.getText().toString().equals("")){
                    Toast.makeText(Teacher.this,"Please Fill all field!",Toast.LENGTH_SHORT).show();
                }
                else {
                    db.insertTeacherData(editName.getText().toString(), editEmail.getText().toString(), editPassword.getText().toString(), database);
                    Toast.makeText(Teacher.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Teacher.this, Teacher.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    private void SetTeacherList(){

        DatabaseHelper db1 = new DatabaseHelper(this);
        final List<Teacher_list> teachers = db1.getAllTeacher();
        teacherAdaptor  = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,teachers);
        listViewOfTeachers.setAdapter(teacherAdaptor);

        listViewOfTeachers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =  new Intent(Teacher.this, AboutTeacher.class);
                intent.putExtra(AboutTeacher.EXTRA_TEACHERID,teachers.get((int)l).getID());
                startActivity(intent);
                finish();
            }
        });

    }

}