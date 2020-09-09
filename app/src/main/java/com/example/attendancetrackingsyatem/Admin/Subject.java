package com.example.attendancetrackingsyatem.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.attendancetrackingsyatem.Databse.DatabaseHelper;
import com.example.attendancetrackingsyatem.R;

import java.util.ArrayList;
import java.util.List;

public class Subject extends AppCompatActivity {

    private Spinner spinner;
    private EditText editName;
    private Button btn_addData;
    private ListView listViewOfSubject;
    private String name, spinnerData;
    SQLiteDatabase database;
    ArrayAdapter<Subject_list> subjectAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        final DatabaseHelper db = new DatabaseHelper(this);
        this.database = db.getWritableDatabase();

        editName = findViewById(R.id.editText_addSubject);
        spinner = findViewById(R.id.spinner_addSubject);
        btn_addData = findViewById(R.id.btn_addSubject);
        listViewOfSubject = findViewById(R.id.listView_addSubject);
        SetSpinnerData();
        SetStudentList();

        btn_addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editName.getText().toString().equals("")){
                    Toast.makeText(Subject.this,"Please Fill all field!",Toast.LENGTH_SHORT).show();
                }
                else {
                    db.insertSubjectData(editName.getText().toString(), spinnerData, database);
                    Toast.makeText(Subject.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Subject.this, Subject.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    public void SetSpinnerData(){
        DatabaseHelper db = new DatabaseHelper(this);

        List<SubClass_list> subclass = db.getSub_ClassData();
        ArrayAdapter<SubClass_list> myAdaptor = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, subclass);
        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdaptor);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerData = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void SetStudentList(){
        DatabaseHelper db = new DatabaseHelper(this);
        final List<Subject_list> subjects = db.getAllSubject();
        subjectAdaptor  = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,subjects);
        listViewOfSubject.setAdapter(subjectAdaptor);

        listViewOfSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =  new Intent(Subject.this,AboutSubject.class);
                intent.putExtra(AboutSubject.EXTRA_SUBJECTID,subjects.get((int)l).getID());
                startActivity(intent);
                finish();
            }
        });
    }

}