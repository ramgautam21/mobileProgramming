
package com.example.attendancetrackingsyatem.Teacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.attendancetrackingsyatem.Admin.Admin;
import com.example.attendancetrackingsyatem.Admin.AdminHome;
import com.example.attendancetrackingsyatem.Admin.AttendenceClass;
import com.example.attendancetrackingsyatem.Admin.Class;
import com.example.attendancetrackingsyatem.Admin.Student;
import com.example.attendancetrackingsyatem.Admin.Subject;
import com.example.attendancetrackingsyatem.Admin.Teacher;
import com.example.attendancetrackingsyatem.Admin.ViewAttendance;
import com.example.attendancetrackingsyatem.LoginActivity;
import com.example.attendancetrackingsyatem.R;

public class TeacherHome extends AppCompatActivity {

    private Button logout_btn, addStudent, viewAttendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);

        logout_btn = findViewById(R.id.btn_logout);
        addStudent = findViewById(R.id.btn_makeAttendance);
        viewAttendance = findViewById(R.id.btn_viewAttendance);

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeacherHome.this, AttendenceClass.class);
                startActivity(intent);

            }
        });

        viewAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(TeacherHome.this, ViewAttendance.class);
                startActivity(intent);

            }
        });

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeacherHome.this, LoginActivity.class);
                startActivity(intent);
                finish();
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
                        TeacherHome.super.onBackPressed();

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
