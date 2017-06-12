//package com.example.mohitsaini.fragmentexample.part_4;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.TextView;
//
//import com.example.mohitsaini.fragmentexample.R;
//
///**
// * Created by mohitsaini on 7/6/17.
// */
//
//public class CustomDateTimePicker extends AppCompatActivity {
//
//    private static final String TAG = "Sample";
//
//    private static final String TAG_DATETIME_FRAGMENT = "TAG_DATETIME_FRAGMENT";
//
//    private static final String STATE_TEXTVIEW = "STATE_TEXTVIEW";
//    private TextView textView;
//
//    private SwitchDateTimeDialogFragment dateTimeFragment;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sample);
//
//        textView = (TextView) findViewById(R.id.textView);
//        if (savedInstanceState != null) {
//            // Restore value from saved state
//            textView.setText(savedInstanceState.getCharSequence(STATE_TEXTVIEW));
//        }
//
//        // Construct SwitchDateTimePicker
//        dateTimeFragment = (SwitchDateTimeDialogFragment) getSupportFragmentManager().findFragmentByTag(TAG_DATETIME_FRAGMENT);
//        if(dateTimeFragment == null) {
//            dateTimeFragment = SwitchDateTimeDialogFragment.newInstance(
//                    getString(R.string.label_datetime_dialog),
//                    getString(R.string.positive_button_datetime_picker),
//                    getString(R.string.negative_button_datetime_picker)
//            );
//        }
//
//        // Assign values we want
//        final SimpleDateFormat myDateFormat = new SimpleDateFormat("d MMM yyyy HH:mm", java.util.Locale.getDefault());
//        dateTimeFragment.startAtCalendarView();
//        dateTimeFragment.set24HoursMode(false);
//        dateTimeFragment.setMinimumDateTime(new GregorianCalendar(2015, Calendar.JANUARY, 1).getTime());
//        dateTimeFragment.setMaximumDateTime(new GregorianCalendar(2025, Calendar.DECEMBER, 31).getTime());
//        dateTimeFragment.setDefaultDateTime(new GregorianCalendar(2017, Calendar.MARCH, 4, 15, 20).getTime());
//        // Or assign each element, default element is the current moment
//        // dateTimeFragment.setDefaultHourOfDay(15);
//        // dateTimeFragment.setDefaultMinute(20);
//        // dateTimeFragment.setDefaultDay(4);
//        // dateTimeFragment.setDefaultMonth(Calendar.MARCH);
//        // dateTimeFragment.setDefaultYear(2017);
//
//        // Define new day and month format
//        try {
//            dateTimeFragment.setSimpleDateMonthAndDayFormat(new SimpleDateFormat("MMMM dd", Locale.getDefault()));
//        } catch (SwitchDateTimeDialogFragment.SimpleDateMonthAndDayFormatException e) {
//            Log.e(TAG, e.getMessage());
//        }
//
//        // Set listener for date
//        dateTimeFragment.setOnButtonClickListener(new SwitchDateTimeDialogFragment.OnButtonClickListener() {
//            @Override
//            public void onPositiveButtonClick(Date date) {
//                textView.setText(myDateFormat.format(date));
//            }
//
//            @Override
//            public void onNegativeButtonClick(Date date) {
//                textView.setText("");
//            }
//        });
//
//        Button buttonView = (Button) findViewById(R.id.button);
//        buttonView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dateTimeFragment.show(getSupportFragmentManager(), TAG_DATETIME_FRAGMENT);
//            }
//        });
//    }
//
//    @Override
//    public void onSaveInstanceState(Bundle savedInstanceState) {
//        // Save the current textView
//        savedInstanceState.putCharSequence(STATE_TEXTVIEW, textView.getText());
//        super.onSaveInstanceState(savedInstanceState);
//    }
//}