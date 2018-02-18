package com.example.nyam.telephoneapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewGroup container;
    private final Integer MAX_NUMBER = 9;
    private final Integer MIN_NUMBER = 0;
    private Integer number = MAX_NUMBER;

    private LayoutInflater inflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.inflater = LayoutInflater.from(this);

        this.container = (ViewGroup) findViewById(R.id.container);
        useInflater();
    }

    private void useInflater() {
        container.removeAllViews();

//        add 3 rows
        for (int i = 0; i < 3; ++i) {
            addRow();
        }

//        add last number
        addOne(this.container);
    }

    private void addRow() {
        final View rowView = inflater.inflate(R.layout.row, this.container, false);
        ViewGroup rowGroup = (ViewGroup) rowView;

//        get 3 numbers for row
        final int number_of_rows = 3;
        for (int i = 0; i < number_of_rows; ++i) {
            addOne(rowGroup);
            if (number > MIN_NUMBER) {
                number--;
            }
        }

        container.addView(rowGroup);
    }

    private void addOne(ViewGroup rowGroup) {
        final View view = inflater.inflate(R.layout.number, rowGroup, false);
        TextView textView = (TextView) view;
        textView.setText(number.toString());
        rowGroup.addView(textView);
    }
}
