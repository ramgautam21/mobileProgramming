package com.example.attendancetrackingsyatem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.attendancetrackingsyatem.Databse.DatabaseHelper;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent home_intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(home_intent);

            }
        }, SPLASH_TIME_OUT);
    }
}