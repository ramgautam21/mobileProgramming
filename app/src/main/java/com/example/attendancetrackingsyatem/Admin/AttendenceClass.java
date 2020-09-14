package com.example.attendancetrackingsyatem.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.attendancetrackingsyatem.Databse.DatabaseHelper;
import com.example.attendancetrackingsyatem.R;

import java.util.List;

public class AttendenceClass extends AppCompatActivity {

    private ArrayAdapter<Class_list> studentAdaptor;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence_class);
        listView = findViewById(R.id.listView_AttendanceClassList);
        SetCLassList();

    }

    private void SetCLassList(){


        DatabaseHelper db1 = new DatabaseHelper(this);
        final List<Class_list> classes = db1.getAllClass();
        studentAdaptor = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,classes);
        listView.setAdapter(studentAdaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =  new Intent(AttendenceClass.this,TakeAttendance.class);
                intent.putExtra(AboutClass.EXTRA_CLASSID,classes.get((int)l).getID());
                startActivity(intent);
                finish();
            }
        });


    }
}