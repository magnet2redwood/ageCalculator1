package com.redwood2magnet.ageCalculator;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button calender1;
    EditText dateOfBirthCal1;
    Calendar calender11;
    DatePickerDialog datePickerDialog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calender1= (Button) findViewById(R.id.cal1);
        dateOfBirthCal1=(EditText) findViewById(R.id.dob_cal1);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void getDateofBirthFromCalender(View view) {
        calender11= Calendar.getInstance();
        int day = calender11.get(Calendar.DAY_OF_MONTH);
        int month = calender11.get(Calendar.MONTH);
        int year = calender11.get(Calendar.YEAR);

        datePickerDialog1= new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int myear, int mmonth, int mdayOfMonth) {
                dateOfBirthCal1.setText(mdayOfMonth + "/" + (mmonth+1)+"/" + myear);
            }
        },day ,month,year);
        datePickerDialog1.show();
    }
}
