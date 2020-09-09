package com.example.attendancetrackingsyatem.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.attendancetrackingsyatem.Databse.DatabaseHelper;
import com.example.attendancetrackingsyatem.R;

public class AboutClass extends AppCompatActivity {
    public static final String EXTRA_CLASSID ="classId";
    private int classId = 0;
    private EditText editText_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_class);

        DatabaseHelper db = new DatabaseHelper(this);

        classId = (int) getIntent().getExtras().get(EXTRA_CLASSID);

        Class_list class_list = db.getClass(classId);

        editText_name = findViewById(R.id.editText_updateClassName);

        editText_name.setText(class_list.getName());
    }

    public void onClickUpdate(View view) {
        String name, email, password;

        DatabaseHelper db = new DatabaseHelper(this);

        name = editText_name.getText().toString();
        Class_list cl = new Class_list(classId,name);

        db.updateClass(cl);

        Toast.makeText(this,"Updated Data Successfully!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,Class.class);
        startActivity(intent);
        finish();
    }

    public void onClickDelete(View view) {
        DatabaseHelper db  = new DatabaseHelper(this);
        db.deleteClass(classId);

        Toast.makeText(AboutClass.this,"Class Deleted Successfully!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AboutClass.this,Class.class);
        startActivity(intent);
        finish();
    }
}