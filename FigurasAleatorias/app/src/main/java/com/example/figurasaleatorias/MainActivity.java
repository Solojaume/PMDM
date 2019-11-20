package com.example.figurasaleatorias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchDrawShape1(View clickButton) {
        Intent activityIntent = new Intent(this, DrawShapes1.class);
        startActivity(activityIntent);
    }

    public void launchDrawShape2(View clickButton) {
        Intent activityIntent = new Intent(this, DrawShapes1.class);
        startActivity(activityIntent);
    }
}
