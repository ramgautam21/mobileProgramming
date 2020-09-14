package com.example.attendancetrackingsyatem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.attendancetrackingsyatem.Admin.AdminHome;
import com.example.attendancetrackingsyatem.Databse.DatabaseHelper;
import com.example.attendancetrackingsyatem.Teacher.TeacherHome;

public class LoginActivity extends AppCompatActivity {

    private Button login_btn;
    private EditText edittext_email;
    private EditText editText_password;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    DatabaseHelper db;
    int radioId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        login_btn = findViewById(R.id.btn_login);
        edittext_email = findViewById(R.id.email_editText);
        editText_password = findViewById(R.id.password_editText);
        radioGroup = findViewById(R.id.radioGroup);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String email = edittext_email.getText().toString();
                String password = editText_password.getText().toString();



                radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);


                if (radioButton.getText().equals("Admin")){
                    Boolean bolAdmin = db.adminLogin(email,password);
                    if (bolAdmin == true ){
                        Intent intent1 = new Intent(LoginActivity.this, AdminHome.class);
                        startActivity(intent1);
                        finish();
                    }
                    else{
                        Toast.makeText(LoginActivity.this,"Email or Password doesn't match.",Toast.LENGTH_SHORT).show();
                    }
                }
                else if (radioButton.getText().equals("Teacher")){
                    Boolean bolTeacher = db.teacherLogin(email,password);
                    if (bolTeacher == true ){
                        Intent intent2 = new Intent(LoginActivity.this, TeacherHome.class);
                        startActivity(intent2);
                        finish();
                    }
                    else{
                        Toast.makeText(LoginActivity.this,"Email or Password doesn't match.",Toast.LENGTH_SHORT).show();
                    }
                }

                else {
                    Toast.makeText(LoginActivity.this,"Radio Button may not checked!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder  = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure want to exit Application?").setCancelable(false)
        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                LoginActivity.super.onBackPressed();

            }
        })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();

                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}