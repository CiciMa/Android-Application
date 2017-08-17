package com.example.xiaoxinma.happytrails;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    public static TrailList list; // every activity has this
    public static Activity temp;
    public static EditText name;
    public static EditText rating;
    public static EditText latitude;
    public static EditText longitude;
    public static EditText state;
    public static CheckBox haveHiked;
    public static EditText landmarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list = WelcomeActivity.data; // every activity
        temp = this;
        name = (EditText) findViewById(R.id.Name);
        rating = (EditText) findViewById(R.id.Rating);
        latitude = (EditText) findViewById(R.id.Latitude);
        longitude = (EditText) findViewById(R.id.Longitude);
        state = (EditText) findViewById(R.id.State);
        haveHiked = (CheckBox) findViewById(R.id.IsHiked);
        landmarks = (EditText) findViewById(R.id.Landmark);
        Button button = (Button) findViewById(R.id.Add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add Trail to Trail list
                String userName = AddActivity.name.getText().toString();
                Integer userRating = Integer.parseInt(AddActivity.rating.getText().toString());
                Double userLatitude = Double.parseDouble(AddActivity.latitude.getText().toString());
                Double userLongitude = Double.parseDouble(AddActivity.longitude.getText().toString());
                String userState = AddActivity.state.getText().toString();
                Boolean userOption = AddActivity.haveHiked.isChecked();
                String userLandmarks = AddActivity.landmarks.getText().toString();

                Trail user = new Trail(userName, userRating, userLatitude, userLongitude, userState,userOption);
                user.addLandmarks(userLandmarks);
                list.add(user);

                //Back to MainActivity
                Intent intent = new Intent(AddActivity.temp, MainActivity.class);
                startActivity(intent);
            }
        });


    }

}
