package com.example.attendancetrackingsyatem.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.attendancetrackingsyatem.R;

import java.util.ArrayList;
import java.util.List;

public class Subject extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        //For Dummy Purpose
        spinner = findViewById(R.id.spinner_addSubject);
        List<dummyData> classList =  new ArrayList<>();
        dummyData dd1 = new dummyData("One");
        classList.add(dd1);
        dummyData dd2 = new dummyData("Two");
        classList.add(dd2);
        dummyData dd3 = new dummyData("Three");
        classList.add(dd3);
        dummyData dd4 = new dummyData("Four");
        classList.add(dd4);

        ArrayAdapter<dummyData> adapter = new ArrayAdapter<dummyData>(this,android.R.layout.simple_spinner_item, classList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);



    }


}