package com.example.xiaoxinma.happytrails;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static EditText option;
    public static TextView test;
    public static Activity temp;
    public static EditText userToQuit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = (TextView) findViewById(R.id.Selection);
        text.setText("Welcome to Happy Trails!  Select an option below:\n" +
                "1) add a hiking trail\n" +
                "2) remove a hiking trail\n" +
                "3) display hiking trails alphabetically\n" +
                "4) display hiking trails >= a certain rating\n" +
                "5) display hiking trails in a specified state\n" +
                "6) display the nearest hiking trail to specified hiking trail\n" +
                "7) list all trails with a specified landmark\n" +
                "8) list all hiking trails the user has yet to hike\n" +
                "9) quit\n" +
                "   Select an option above:\n");

        Button button = (Button) findViewById(R.id.submit);

        temp = this;
        option = (EditText) findViewById(R.id.option);

        TextView quit = (TextView) findViewById(R.id.quit);
        quit.setText("Are you sure you want to quit? " + "\n" +
                " - all your data will be lost.");
        userToQuit = (EditText) findViewById(R.id.userQuit);

        if (WelcomeActivity.data.getTail() != null)
            ((TextView)findViewById(R.id.test)).setText(WelcomeActivity.result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String opt = MainActivity.option.getText().toString();
                String userQuit = MainActivity.userToQuit.getText().toString();

                if (opt.equals("1")){
                    Intent intent = new Intent(MainActivity.temp, AddActivity.class);
                    startActivity(intent);
                }

                if (opt.equals("2")){
                    Intent intent = new Intent(MainActivity.temp, RemoveActivity.class);
                    startActivity(intent);
                }

                if (opt.equals("3")){
                    Intent intent = new Intent(MainActivity.temp, DisplayAlpha.class);
                    startActivity(intent);
                }

                if (opt.equals("4")){
                    Intent intent = new Intent(MainActivity.temp, DisplayRate.class);
                    startActivity(intent);
                }

                if (opt.equals("5")){
                    Intent intent = new Intent(MainActivity.temp, DisplayState.class);
                    startActivity(intent);
                }

                if (opt.equals("6")){
                    Intent intent = new Intent(MainActivity.temp, DisplayProximal.class);
                    startActivity(intent);
                }

                if (opt.equals("7")){
                    Intent intent = new Intent(MainActivity.temp, DisplayLandmark.class);
                    startActivity(intent);

                }

                if (opt.equals("8")){
                    Intent intent = new Intent(MainActivity.temp, DisplayNotHiked.class);
                    startActivity(intent);
                }

                if (userQuit.equals("9") || userQuit.toLowerCase().equals("yes")){
                    finish();
                }
            }
        });
    }

}
