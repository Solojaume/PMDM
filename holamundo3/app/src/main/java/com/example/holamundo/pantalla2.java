package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        String message = getIntent().getStringExtra(App.KEY_MESSAGE);


        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

    }

    public void onClick(View view){


    }
}
