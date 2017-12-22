package com.example.river;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        initCalendarView();
    }
    private void initCalendarView() {
//        initListener();
//        CustomDayView customDayView = new CustomDayView(
//                context , R.layout.custom_day);
//        calendarAdapter = new CalendarViewAdapter(
//                context ,
//                onSelectDateListener ,
//                Calendar.MONTH_TYPE ,
//                customDayView);
//        initMarkData();
//        initMonthPager();
    }
}
