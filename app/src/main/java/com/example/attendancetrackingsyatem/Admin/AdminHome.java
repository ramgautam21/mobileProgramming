package com.example.attendancetrackingsyatem.Admin;

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

import com.example.attendancetrackingsyatem.LoginActivity;
import com.example.attendancetrackingsyatem.R;

public class AdminHome extends AppCompatActivity {

    private Button logout_btn, addStudent, viewAttendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        logout_btn = findViewById(R.id.btn_logout);
        addStudent = findViewById(R.id.btn_makeAttendance);
        viewAttendance = findViewById(R.id.btn_viewAttendance);

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHome.this,AttendenceClass.class);
                startActivity(intent);

            }
        });

        viewAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(AdminHome.this,ViewAttendance.class);
                startActivity(intent);

            }
        });

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHome.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mf = getMenuInflater();
        mf.inflate(R.menu.adminmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.item_admin:
                Intent intent1 = new Intent(AdminHome.this,Admin.class);
                startActivity(intent1);
                return true;

            case R.id.item_teacher:
                Intent intent2 = new Intent(AdminHome.this,Teacher.class);
                startActivity(intent2);
                return true;

            case R.id.item_class:
                Intent intent3 = new Intent(AdminHome.this,Class.class);
                startActivity(intent3);
                return true;

            case R.id.item_subject:
                Intent intent4 = new Intent(AdminHome.this,Subject.class);
                startActivity(intent4);
                return true;

            case R.id.item_student:
                Intent intent5 = new Intent(AdminHome.this,Student.class);
                startActivity(intent5);
                return true;
                
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder  = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure want to exit Application?").setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AdminHome.super.onBackPressed();

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
