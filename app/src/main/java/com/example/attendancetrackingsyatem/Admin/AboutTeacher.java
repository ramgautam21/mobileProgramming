package com.example.attendancetrackingsyatem.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.attendancetrackingsyatem.Databse.DatabaseHelper;
import com.example.attendancetrackingsyatem.R;

public class AboutTeacher extends AppCompatActivity {
    public static final String EXTRA_TEACHERID ="teacherId";
    private int teacherId = 0;
    private EditText editText_name, editText_email, editText_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_teacher);

        DatabaseHelper db = new DatabaseHelper(this);

        teacherId = (int) getIntent().getExtras().get(EXTRA_TEACHERID);

        Teacher_list teacher_list = db.getTeacher(teacherId);

        editText_name = findViewById(R.id.editText_updateTeacherName);
        editText_email = findViewById(R.id.editText_updateTeacherEmail);
        editText_password = findViewById(R.id.editText_updateTeacherPassword);

        editText_name.setText(teacher_list.getName());
        editText_email.setText(teacher_list.getEmail());
        editText_password.setText(teacher_list.getPassword());
    }

    public void onClickUpdate(View view) {
        String name, email, password;

        DatabaseHelper db = new DatabaseHelper(this);

        name = editText_name.getText().toString();
        email = editText_email.getText().toString();
        password = editText_password.getText().toString();

        Teacher_list tl = new Teacher_list(teacherId,name,email,password);

        db.updateTeacher(tl);

        Toast.makeText(this,"Updated Data Successfully!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,Teacher.class);
        startActivity(intent);
        finish();
    }

    public void onClickDelete(View view) {
        DatabaseHelper db  = new DatabaseHelper(this);
        db.deleteTeacher(teacherId);

        Toast.makeText(AboutTeacher.this,"Teacher Deleted Successfully!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AboutTeacher.this,Teacher.class);
        startActivity(intent);
        finish();
    }
}