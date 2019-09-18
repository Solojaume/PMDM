package com.example.holamundo3;

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
    String mesage;
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
        mesage ="Te saludo "+ editText.getText().toString();
        intent.putExtra("variable",mesage);
        startActivityForResult(intent,1);
    }

    public void onActivityResult(int cod_resp, int cod_result,Intent intent) {
        if (cod_result == RESULT_OK) {
            Bundle otroBundle = intent.getExtras();
            textView.setText(otroBundle.getString("Texto"));
        }
    }
}
