package com.example.holamundo3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class pantalla2 extends AppCompatActivity {
    String message;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
         message = getIntent().getStringExtra("variable");


        textView = findViewById(R.id.textView);
        textView.setText(message);
    }
    public void onClick(View view){


        Intent intent2=new Intent();
        Bundle bundle2=new Bundle();
        bundle2.putString("Texto",message);
        intent2.putExtras(bundle2);
        setResult(Activity.RESULT_OK, intent2);
        finish();
    }
}
