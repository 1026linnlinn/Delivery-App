package com.mounts.lenovo.roundcornerimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initiate view's
        ImageButton simpleImageButtonHome = (ImageButton) findViewById(R.id.simpleImageButtonHome);
        ImageButton simpleImageButtonYouTube = (ImageButton) findViewById(R.id.simpleImageButtonYouTube);

// perform click event on button's
        simpleImageButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Home Button", Toast.LENGTH_LONG).show();// display the toast on home button click
            }
        });
        simpleImageButtonYouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "YouTube Button", Toast.LENGTH_LONG).show();// display the toast on you tube button click
            }
        });
    }

}

