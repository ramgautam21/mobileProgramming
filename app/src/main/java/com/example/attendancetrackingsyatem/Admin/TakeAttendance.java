package com.example.attendancetrackingsyatem.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.attendancetrackingsyatem.Databse.DatabaseHelper;
import com.example.attendancetrackingsyatem.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TakeAttendance extends AppCompatActivity {

    public static final String EXTRA_CLASSID ="classId";
    private int classId = 0;
    ListView listview;
    Class_list class_list;
    String date;

    TextView textViewDate, textViewClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance);

        DatabaseHelper db = new DatabaseHelper(this);

        Calendar calendar = Calendar.getInstance();
        date = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());

        textViewDate = findViewById(R.id.textViewAttendanceDate);
        textViewDate.setText("Date: " + date);

        textViewClass = findViewById(R.id.textViewAttendanceClass);
        classId = (int) getIntent().getExtras().get(EXTRA_CLASSID);
        class_list = db.getClass(classId);
        textViewClass.setText("Class: " + class_list.getName());

        listview = findViewById(R.id.list_view);
        SetStudentList();

    }

    private void SetStudentList(){

//        Toast.makeText(this,class_list.getName(),Toast.LENGTH_SHORT).show();

        final DatabaseHelper db1 = new DatabaseHelper(this);
         final List<Student_list> student = db1.getAllClassStudentData(class_list.getName());
         ArrayAdapter studentAdaptor  = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,student);
        listview.setAdapter(studentAdaptor);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    view.setBackgroundColor(getResources().getColor(
                            android.R.color.holo_green_light
                    ));

                    String sname = student.get((int)l).getName();
                    String sclass = student.get((int)l).getSt_class();
                    

                SQLiteDatabase database = db1.getWritableDatabase();
                db1.setAttendance(sname,sclass,date,database);

            }
        });

    }

    public void attendanceSubmit(View view) {

//        DatabaseHelper db = new DatabaseHelper(this);
//        db.submitAttendance();
        Toast.makeText(this,"Attendance Submitted",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,AdminHome.class);
        startActivity(intent);
        finish();

    }



}