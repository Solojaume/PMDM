package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
     private TextView textView ;
    private Intent intent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView  = findViewById(R.id.textView2);
        editText = findViewById(R.id.editText);
    }

    public void onButtonClick(View view) {
        //textView.setText("Te saludo "+editText.getText().toString());
        intent = new Intent(this, pantalla2.class);
        String mesage ="Te saludo "+editText.getText().toString();
        intent.putExtra(App.KEY_MESSAGE,mesage);
        startActivity(intent);
    }



}
