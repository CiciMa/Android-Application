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

public class DisplayState extends AppCompatActivity {

    public static TrailList list;
    public static Activity temp;
    public static EditText state;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_state);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = WelcomeActivity.data;
        temp = this;
        state = (EditText) findViewById(R.id.userState);

        Button button = (Button) findViewById(R.id.State);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display with user State Alphabetically
                String userState = DisplayState.state.getText().toString();
                String result = list.displayState(userState);
                WelcomeActivity.result = result;

                //Back to MainActivity
                Intent intent = new Intent(DisplayState.temp, MainActivity.class);
                startActivity(intent);


            }
        });
    }

}
