package com.udacity.mobilelibraryjokes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeViewActivity extends AppCompatActivity {

    public static String KEY_MESSAGE = "MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        if(intent != null){
            String message = intent.getStringExtra(KEY_MESSAGE);
            TextView view = (TextView) findViewById(R.id.jokeText);
            view.setText(message);
        }
    }
}
