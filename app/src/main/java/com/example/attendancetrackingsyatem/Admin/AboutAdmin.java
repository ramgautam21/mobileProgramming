package com.example.attendancetrackingsyatem.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.attendancetrackingsyatem.Databse.DatabaseHelper;
import com.example.attendancetrackingsyatem.R;

public class AboutAdmin extends AppCompatActivity {
    public static final String EXTRA_ADMINID ="adminId";
    int adminId = 0;
    EditText editText_name, editText_email, editText_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_admin);

        DatabaseHelper db = new DatabaseHelper(this);

        adminId = (int) getIntent().getExtras().get(EXTRA_ADMINID);

        Admin_list admin_list = db.getAdmin(adminId);

        editText_name = findViewById(R.id.editText_updateAdminName);
        editText_email = findViewById(R.id.editText_updateAdminEmail);
        editText_password = findViewById(R.id.editText_updateAdminPassword);

        editText_name.setText(admin_list.getName());
        editText_email.setText(admin_list.getEmail());
        editText_password.setText(admin_list.getPassword());
    }


    public void onClickUpdate(View view) {
        String name, email, password;

        DatabaseHelper db = new DatabaseHelper(this);

        name = editText_name.getText().toString();
        email = editText_email.getText().toString();
        password = editText_password.getText().toString();

        Admin_list al = new Admin_list(adminId,name,email,password);

        db.updateAdmin(al);

        Toast.makeText(this,"Updated Data Successfully!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,Admin.class);
        startActivity(intent);
    }
}