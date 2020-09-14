package com.example.attendancetrackingsyatem.Admin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.attendancetrackingsyatem.Databse.DatabaseHelper;
import com.example.attendancetrackingsyatem.R;

import java.util.List;

public class ViewAttendance extends AppCompatActivity {

    private ListView listView;
    private EditText editText;
    private Button btn;
    private Spinner spinner;
    String data ;


//    String aName[] = {"Ram Gautam", "Ajit Dulal" , "Rajesh Neupane"};
    String aName [] = {};
    String aDate[] = {"18-09-2020","18-09-2020","18-09-2020","18-09-2020","18-09-2020"};
    String aStatus[] = {"Present","Present","Absent","Absent","Present"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);

        editText = findViewById(R.id.search_by);

        btn = findViewById(R.id.search);
        spinner = findViewById(R.id.search_spnner);

        SetSpinnerData();

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        DatabaseHelper db = new DatabaseHelper(this);
        aName =  db.getStudentByName(editText.getText().toString());

        listView = findViewById(R.id.result_listview);
        MyAdapter myAdapter = new MyAdapter(this,aName,aDate,aStatus);
        listView.setAdapter(myAdapter);

    }

    public void printDocument(View view) {

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        String textMessage = "Attendance Data";
        sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
        sendIntent.setType("text/plain");


        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }
    }


    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String[] rName;
        String[] rDate;
        String[] rStatus;

        MyAdapter (Context c, String name[], String date[],String status[]){
            super(c, R.layout.row,R.id.row_name,name);
            this.context = c;
            this.rName = name;
            this.rDate = date;
            this.rStatus = status;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row,parent,false);
            TextView myName = row.findViewById(R.id.row_name);
            TextView myDate = row.findViewById(R.id.row_date);
            TextView myStatus = row.findViewById(R.id.status);

            myName.setText(rName[position]);
            myDate.setText(rDate[position]);
            myStatus.setText(rStatus[position]);

            return row;
        }
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
//                spinnerData = adapterView.getItemAtPosition(i).toString();
//                datainset();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}