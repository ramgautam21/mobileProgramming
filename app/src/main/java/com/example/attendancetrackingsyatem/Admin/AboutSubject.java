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

public class AboutSubject extends AppCompatActivity {
    public static final String EXTRA_SUBJECTID ="subjectId";
    private int subjectId = 0;
    private TextView textView_Subject, textView_subClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_subject);

        DatabaseHelper db = new DatabaseHelper(this);
        subjectId = (int) getIntent().getExtras().get(EXTRA_SUBJECTID);

        Subject_list subject_list = db.getSubject(subjectId);

        textView_Subject = findViewById(R.id.textview_SubjectName);
        textView_subClass = findViewById(R.id.textView_SubClass);

        textView_Subject.setText(subject_list.getName());
        textView_subClass.setText(subject_list.getSub_class());
    }

    public void deleteSubject(View view) {
        DatabaseHelper db  = new DatabaseHelper(this);
        db.deleteSubject(subjectId);

        Toast.makeText(AboutSubject.this,"Subject Deleted Successfully!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AboutSubject.this,Subject.class);
        startActivity(intent);
        finish();
    }
}