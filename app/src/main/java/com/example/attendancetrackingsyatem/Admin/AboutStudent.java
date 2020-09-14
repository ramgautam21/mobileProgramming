package com.example.attendancetrackingsyatem.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.attendancetrackingsyatem.Databse.DatabaseHelper;
import com.example.attendancetrackingsyatem.R;

public class AboutStudent extends AppCompatActivity {

    public static final String EXTRA_STUDENTID ="studentId";
    private int studentID = 0;
    private TextView editText_name, editText_email, editText_class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_student);

        DatabaseHelper db = new DatabaseHelper(this);

        studentID = (int) getIntent().getExtras().get(EXTRA_STUDENTID);

        Student_list student_list = db.getStudent(studentID);

        editText_name = findViewById(R.id.editText_updateStudentName);
        editText_email = findViewById(R.id.editText_updateStudentEmail);
        editText_class = findViewById(R.id.editText_updateStudentClass);

        editText_name.setText(student_list.getName());
        editText_email.setText(student_list.getEmail());
        editText_class.setText(student_list.getSt_class());
    }

    public void onClickDelete(View view) {

        DatabaseHelper db  = new DatabaseHelper(this);
        db.deleteStudent(studentID);

        Toast.makeText(AboutStudent.this,"Student Deleted Successfully!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AboutStudent.this,Student.class);
        startActivity(intent);
        finish();
    }
}