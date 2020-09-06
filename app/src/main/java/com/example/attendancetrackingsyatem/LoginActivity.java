package com.example.attendancetrackingsyatem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.attendancetrackingsyatem.Admin.AdminHome;
import com.example.attendancetrackingsyatem.Teacher.TeacherHome;

public class LoginActivity extends AppCompatActivity {

    private Button login_btn;
    private EditText edittext_email;
    private EditText editText_password;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_btn = findViewById(R.id.btn_login);
        edittext_email = findViewById(R.id.email_editText);
        editText_password = findViewById(R.id.password_editText);
        radioGroup = findViewById(R.id.radioGroup);

        final String  email = edittext_email.toString();
        final String password = editText_password.toString();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (email == "ram" && password == "ram"){
                    Intent intent1 = new Intent(LoginActivity.this,AdminHome.class);
                    startActivity(intent1);
                }
                if (email == "hasan" && password == "hasan"){
                    Intent intent2 = new Intent(LoginActivity.this, TeacherHome.class);
                    startActivity(intent2);
                }

            }
        });
    }

}