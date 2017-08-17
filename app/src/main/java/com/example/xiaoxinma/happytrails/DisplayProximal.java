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

public class DisplayProximal extends AppCompatActivity {
    public static TrailList list;
    public static Activity temp;
    public static EditText name;
    public static TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_proximal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list = WelcomeActivity.data;
        temp = this;
        name = (EditText) findViewById(R.id.DisplayUserName);
        message = (TextView) findViewById(R.id.userDistanceMessage);


        Button button = (Button) findViewById(R.id.DisplayProximal);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display Trail Alphabetically
                String userName = DisplayProximal.name.getText().toString();
                String result = list.displayProximal(userName);
                WelcomeActivity.result = result;

                //Back to MainActivity
                Intent intent = new Intent(DisplayProximal.temp, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
