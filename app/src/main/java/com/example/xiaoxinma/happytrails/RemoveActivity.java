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

public class RemoveActivity extends AppCompatActivity {
    public static TrailList list;
    public static Activity temp;
    public static EditText removename;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = WelcomeActivity.data;
        temp = this;
        removename = (EditText) findViewById(R.id.removeName);
        Button button = (Button) findViewById(R.id.remove);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //remove Trail to Trail list
                String userName = RemoveActivity.removename.getText().toString();
                list.remove(userName);

                //Back to MainActivity
                Intent intent = new Intent(RemoveActivity.temp, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
