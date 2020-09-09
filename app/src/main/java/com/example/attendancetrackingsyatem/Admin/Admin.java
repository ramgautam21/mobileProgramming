package com.example.attendancetrackingsyatem.Admin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.attendancetrackingsyatem.Databse.DatabaseHelper;
import com.example.attendancetrackingsyatem.R;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Admin extends AppCompatActivity {

    private EditText editName , editEmail, editPassword ;
    private Button btn_addData;
    private ListView listViewOfAdmins;
    private String name, email, password;
    SQLiteDatabase database;
    ArrayAdapter<Admin_list> adminAdaptor;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        final DatabaseHelper db = new DatabaseHelper(this);
         this.database = db.getWritableDatabase();

        editName = findViewById(R.id.editText_addAdmain_name);
        editEmail = findViewById(R.id.editText_addAdmain_email);
        editPassword = findViewById(R.id.editText_addAdmin_password);
        btn_addData = findViewById(R.id.btn_addAdmin);
        listViewOfAdmins = findViewById(R.id.listView_addAdmin);
        SetAdminList();

        btn_addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editName.getText().toString().equals("") || editEmail.getText().toString().equals("") || editPassword.getText().toString().equals("")){
                    Toast.makeText(Admin.this,"Please Fill all field!",Toast.LENGTH_SHORT).show();
                }
                else {
                    db.insertAdminData(editName.getText().toString(), editEmail.getText().toString(), editPassword.getText().toString(), database);
                    Toast.makeText(Admin.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Admin.this, Admin.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    private void SetAdminList(){

        DatabaseHelper db1 = new DatabaseHelper(this);
        final List<Admin_list> admins = db1.getAllAdmin();
        adminAdaptor  = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,admins);
        listViewOfAdmins.setAdapter(adminAdaptor);

        listViewOfAdmins.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =  new Intent(Admin.this,AboutAdmin.class);
                intent.putExtra(AboutAdmin.EXTRA_ADMINID,admins.get((int)l).getID());
                startActivity(intent);
                finish();
            }
        });

    }

}


