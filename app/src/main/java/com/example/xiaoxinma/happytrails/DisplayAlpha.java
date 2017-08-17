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

public class DisplayAlpha extends AppCompatActivity {
    public static TrailList list;
    public static Activity temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_alpha);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list = WelcomeActivity.data;
        temp = this;

        Button button = (Button) findViewById(R.id.DisplayAlpha);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display Trail Alphabetically
                String result = list.displayAlphabet();
                WelcomeActivity.result = result;

                //Back to MainActivity
                Intent intent = new Intent(DisplayAlpha.temp, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
