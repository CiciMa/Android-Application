package com.example.xiaoxinma.happytrails;

import android.app.Activity;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayLandmark extends AppCompatActivity {
    public static TrailList list;
    public static Activity temp;
    public static EditText userLandmark;
    public static TextView message;
    public static TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_landmark);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list = WelcomeActivity.data;
        temp = this;

        userLandmark = (EditText) findViewById(R.id.userLandmark);
        message = (TextView) findViewById(R.id.userLandmarkMessage);


        Button button = (Button) findViewById(R.id.DisplayLandmark);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display Trail Alphabetically
                String userLandmark = DisplayLandmark.userLandmark.getText().toString();
                String result = list.displayLandmark(userLandmark);
                WelcomeActivity.result = result;


                //Back to MainActivity
                Intent intent = new Intent(DisplayLandmark.temp, MainActivity.class);
                startActivity(intent);
            }

        });
    }

}
