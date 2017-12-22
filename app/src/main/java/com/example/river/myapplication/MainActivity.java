package com.example.river.myapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.river.myapplication.wheel.ArrayWheelAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private MyHorizontalScrollView mHorizontalScrollView;
    private HorizontalScrollViewAdapter mAdapter;
    private List<Integer> mDatas;
    private List<String> temperature_num=new ArrayList<String>();
    private Map mArrayMap= new ArrayMap();

    private String temperature_num1[] = {
            "35", "36", "37", "38", "39", "40","41","42"
    };
    private String temperature_num2[] = {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
//        mHorizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.id_horizontal_view);
//        mAdapter = new HorizontalScrollViewAdapter(this,mDatas);
//        mHorizontalScrollView.initDatas(mAdapter);
//        mHorizontalScrollView.setCurrentImageChangeListener(new MyHorizontalScrollView.CurrentImageChangeListener() {
//            @Override
//            public void onCurrentImgChanged(int position, View viewIndicator) {
//                viewIndicator.setBackgroundColor(Color
//                        .parseColor("#AA024DA4"));
//            }
//        });

//         WheelView wheelView = (WheelView)findViewById(R.id.number_select);
//        wheelView.setOffset(2);
//        wheelView.setItems(temperature_num);
//        wheelView.setSeletion(0);
//       // list.add(str.substring(0,4));
//        wheelView.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
//            @Override public void onSelected(int selectedIndex, String item) {
//               // list.set(0, item);
//            }
//        });
        Calendar calendar = Calendar.getInstance();
        int curMonth = calendar.get(Calendar.MONTH);
       com.example.river.myapplication.wheel.WheelView month = (com.example.river.myapplication.wheel.WheelView) findViewById(R.id.month);
        String months[] = new String[] {
                "1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"
        };
        month.setViewAdapter(new DateArrayAdapter(this, months, curMonth));
        month.setCurrentItem(curMonth);
       // month.addChangingListener(listener);
        month.setCyclic(true);

    }
    public void initData(){
            for (int i = 0; i < temperature_num1.length; i++) {
                for(int j=0;j<temperature_num2.length;j++){
                    String temp=temperature_num1[i]+"."+temperature_num2[j];
                    temperature_num.add(temp);
                }
            }

            for (int i = 0; i <temperature_num.size(); i++) {
                mArrayMap.put(temperature_num.get(i),i);
            }
    }


    /**
     * Adapter for string based wheel. Highlights the current value.
     */
    private class DateArrayAdapter extends ArrayWheelAdapter<String> {
        // Index of current item
        int currentItem;
        // Index of item to be highlighted
        int currentValue;

        /**
         * Constructor
         */
        public DateArrayAdapter(Context context, String[] items, int current) {
            super(context, items);
            this.currentValue = current;
            setTextSize(16);
        }

        @Override protected void configureTextView(TextView view) {
            super.configureTextView(view);
            //            if (currentItem == currentValue) {
            //                view.setTextColor(0xFF0000F0);
            //            }
            view.setTypeface(Typeface.SANS_SERIF);
        }

        @Override public View getItem(int index, View cachedView, ViewGroup parent) {
            currentItem = index;
            return super.getItem(index, cachedView, parent);
        }
    }

//    /**
//     * Adapter for numeric wheels. Highlights the current value.
//     */
//    private class DateNumericAdapter extends NumericWheelAdapter {
//        // Index of current item
//        int currentItem;
//        // Index of item to be highlighted
//        int currentValue;
//
//        /**
//         * Constructor
//         */
//        public DateNumericAdapter(Context context, int minValue, int maxValue, int current) {
//            super(context, minValue, maxValue);
//            this.currentValue = current;
//            setTextSize(16);
//        }
//
//        @Override protected void configureTextView(TextView view) {
//            super.configureTextView(view);
//            //            if (currentItem == currentValue) {
//            //                view.setTextColor(0xFF0000F0);
//            //            }
//            view.setTypeface(Typeface.SANS_SERIF);
//        }
//
//        @Override public View getItem(int index, View cachedView, ViewGroup parent) {
//            currentItem = index;
//            return super.getItem(index, cachedView, parent);
//        }
//    }
}
