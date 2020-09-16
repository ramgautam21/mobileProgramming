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

import java.util.List;

public class Student extends AppCompatActivity {
    private EditText editText_StudentName, editText_StudentEmail, editText_StudentPassword;
    private ListView listView;
    SQLiteDatabase database;
    ArrayAdapter<Student_list> studentAdaptor;
    private Spinner spinner;
    private String spinnerData;
    private Button btn_addData;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        db = new DatabaseHelper(this);
        this.database = db.getWritableDatabase();

        editText_StudentName  = findViewById(R.id.editText_AddStudentName);
        editText_StudentEmail = findViewById(R.id.editText_AddStudentEmail);
        editText_StudentPassword = findViewById(R.id.editText_AddStudentPassword);
        listView = findViewById(R.id.listView_StudentList);
        spinner = findViewById(R.id.spinner_Student);
        btn_addData = findViewById(R.id.btn_addStudent);

        SetSpinnerData();
        SetStudentList();

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
                datainset();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void SetStudentList(){

        DatabaseHelper db1 = new DatabaseHelper(this);
        final List<Student_list> student = db1.getAllStudent();
        studentAdaptor  = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,student);
        listView.setAdapter(studentAdaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =  new Intent(Student.this,AboutStudent.class);
                intent.putExtra(AboutStudent.EXTRA_STUDENTID,student.get((int)l).getID());
                startActivity(intent);
                finish();
            }
        });

    }
    private void datainset(){
        btn_addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editText_StudentName.getText().toString().equals("") || editText_StudentEmail.getText().toString().equals("") || editText_StudentPassword.getText().toString().equals("")){
                    Toast.makeText(Student.this,"Please Fill all field!",Toast.LENGTH_SHORT).show();
                }
                else {
//                    Toast.makeText(Student.this,spinnerData,Toast.LENGTH_SHORT).show();
                    db.insertStudentData(editText_StudentName.getText().toString(), editText_StudentEmail.getText().toString(), editText_StudentPassword.getText().toString(), spinnerData ,database);
                    Toast.makeText(Student.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Student.this, Student.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
