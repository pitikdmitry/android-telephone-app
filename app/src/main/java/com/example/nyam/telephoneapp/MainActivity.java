package com.example.nyam.telephoneapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewGroup container;
    private final Integer FIRST_NUMBER = 1;
    private final Integer LAST_NUMBER = 9;
    private Integer number = FIRST_NUMBER;

    private LayoutInflater inflater;

    private TextView phoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.inflater = LayoutInflater.from(this);

        this.container = (ViewGroup) findViewById(R.id.container);
        this.phoneNumber = findViewById(R.id.text_phone);
        this.phoneNumber.setText("");

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
            if (number < LAST_NUMBER) {
                number++;
            } else {
                number = 0;
            }
        }

        container.addView(rowGroup);
    }

    private void addOne(ViewGroup rowGroup) {
        final View view = inflater.inflate(R.layout.number, rowGroup, false);
        TextView textView = (TextView) view;
        textView.setText(number.toString());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                appendPhoneNumber(view);
            }
        });
        rowGroup.addView(textView);
    }

    private void appendPhoneNumber(View view) {
        TextView textView = (TextView) view;
        this.phoneNumber.setText(this.phoneNumber.getText().toString() + textView.getText().toString());

    }
}
