package com.example.attendancetrackingsyatem.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

    private Button logout_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        logout_btn = findViewById(R.id.btn_logout);

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHome.this, LoginActivity.class);
                startActivity(intent);
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
