package com.example.mohitsaini.fragmentexample.part_3;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.mohitsaini.fragmentexample.R;

import java.util.Calendar;

public class CalenderWithOnlyFutureDate extends AppCompatActivity {

    private EditText start_date, end_date, no_of_nights;
    //dcgdcghcch

    private int year;
    private int month;
    private int day;
    static final int DATE_DIALOG_ID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_with_only_future_date);

        start_date = (EditText) findViewById(R.id.start_date);
        end_date = (EditText) findViewById(R.id.end_date);
        no_of_nights = (EditText) findViewById(R.id.no_of_nights);
        start_date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (no_of_nights.getText().toString().equals("")) {
                    new AlertDialog.Builder(CalenderWithOnlyFutureDate.this)
                            .setTitle("Warning!")
                            .setMessage("Select number of nights first.")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            }).show();
                }else {
                    showDialog(DATE_DIALOG_ID);
                }
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this, datePickerListener, year, month,day);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                // set date picker as current date
                return datePickerDialog;
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        @RequiresApi(api = Build.VERSION_CODES.N)
        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // set selected date into Text View
            start_date.setText(new StringBuilder().append(day)
                    .append("/").append(month + 1).append("/").append(year).append(" "));

            Calendar c = Calendar.getInstance();
            c.set(selectedYear, selectedMonth, selectedDay);
            c.add(Calendar.DAY_OF_MONTH, Integer.parseInt(no_of_nights.getText().toString()));
            end_date.setText(""+c.toString());
            setDate(c);
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setDate(Calendar c){
        int d = c.get(Calendar.DAY_OF_MONTH);
        int m = c.get(Calendar.MONTH);
        int y = c.get(Calendar.YEAR);

        end_date.setText(new StringBuilder().append(d)
                .append("/").append(m + 1).append("/").append(y).append(" "));

    }
}

