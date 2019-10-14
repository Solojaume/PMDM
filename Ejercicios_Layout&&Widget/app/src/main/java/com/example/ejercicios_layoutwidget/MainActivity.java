package com.example.ejercicios_layoutwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textview = findViewById(R.id.textView);
    }
    public void bacgroudToRed(View view){
        textview.setBackgroundColor(R.color.ColorRed);
    }
}
