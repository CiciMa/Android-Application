package com.example.xiaoxinma.happytrails;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayRate extends AppCompatActivity {
    public static TrailList list;
    public static Activity temp;
    public static EditText rating;
    public static TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_rate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list = WelcomeActivity.data;
        temp = this;
        rating = (EditText) findViewById(R.id.userRate);
        message = (TextView) findViewById(R.id.userRateMessage);

        Button button = (Button) findViewById(R.id.Rate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display with user Rate Alphabetically
                Integer userRating = Integer.parseInt(DisplayRate.rating.getText().toString());
                String result = list.displayRate(userRating);
                WelcomeActivity.result = result;

                //Back to MainActivity
                Intent intent = new Intent(DisplayRate.temp, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
