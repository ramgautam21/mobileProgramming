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
import android.widget.Toast;

import com.example.attendancetrackingsyatem.Databse.DatabaseHelper;
import com.example.attendancetrackingsyatem.R;

import java.util.List;

public class Class extends AppCompatActivity {

    private EditText editName;
    private Button btn_addData;
    private ListView listViewOfClasses;
    private String name;
    SQLiteDatabase database;
    ArrayAdapter<Class_list> classAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        final DatabaseHelper db = new DatabaseHelper(this);
        this.database = db.getWritableDatabase();

        editName = findViewById(R.id.editText_addClass);
        btn_addData = findViewById(R.id.btn_addClass);
        listViewOfClasses = findViewById(R.id.listView_addClass);
        SetClassList();

        btn_addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editName.getText().toString().equals("")){
                    Toast.makeText(Class.this,"Please Fill all field!",Toast.LENGTH_SHORT).show();
                }
                else {
                    db.insertClassData(editName.getText().toString(), database);
                    Toast.makeText(Class.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Class.this, Class.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    private void SetClassList(){

        DatabaseHelper db1 = new DatabaseHelper(this);
        final List<Class_list> classes = db1.getAllClass();
        classAdaptor = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,classes);
        listViewOfClasses.setAdapter(classAdaptor);

        listViewOfClasses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =  new Intent(Class.this,AboutClass.class);
                intent.putExtra(AboutClass.EXTRA_CLASSID,classes.get((int)l).getID());
                startActivity(intent);
                finish();
            }
        });

    }
}