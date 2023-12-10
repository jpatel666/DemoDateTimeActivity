package com.example.demodatetimeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectDate(View view) {

        Calendar calendar = Calendar.getInstance();

        int cyear = calendar.get(calendar.YEAR);
        int cmonth = calendar.get(calendar.MONTH);
        int cdayOfMonth = calendar.get(calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                Toast.makeText(MainActivity.this, ""+dayOfMonth+"/"+(month+1)+"/"+year, Toast.LENGTH_SHORT).show();

            }
        }, cyear, cmonth, cdayOfMonth );

        datePickerDialog.show();

    }

    public void selectTime(View view) {

        Calendar calendar = Calendar.getInstance();

        int chour = calendar.get(Calendar.HOUR_OF_DAY);
        int cminute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {


                if(hourOfDay > 12){
                    hourOfDay = hourOfDay-12;
                    Toast.makeText(MainActivity.this, ""+hourOfDay+":"+minute+" PM", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, ""+hourOfDay+":"+minute+" AM", Toast.LENGTH_SHORT).show();
                }

            }
        },chour,cminute,false);

        timePickerDialog.show();
    }
}