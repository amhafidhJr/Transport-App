package com.example.transportbooking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();
        Button airButton, boatButton, trainButton, busButton;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        airButton = findViewById(R.id.airplane);
        airButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                airplane();
            }
        });
    }

    public void airplane() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    }
}