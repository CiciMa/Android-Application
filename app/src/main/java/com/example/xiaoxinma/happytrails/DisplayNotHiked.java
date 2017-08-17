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

public class DisplayNotHiked extends AppCompatActivity {
    public static TrailList list;
    public static Activity temp;
    public static TextView message;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_landmark);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list = WelcomeActivity.data;
        temp = this;

        message = (TextView) findViewById(R.id.userHikedMessage);


        Button button = (Button) findViewById(R.id.NotHikedMessage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display with user Rate Alphabetically
                String result = list.displayIsNotHiked();
                WelcomeActivity.result = result;

                //Back to MainActivity
                Intent intent = new Intent(DisplayNotHiked.temp, MainActivity.class);
                startActivity(intent);
            }
        });





    }

}
