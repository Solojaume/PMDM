package com.example.diferentes_tipos_de_eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn3 = (Button)this.findViewById(R.id.button3);

        btn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Pulsado boton Tres",Toast.LENGTH_SHORT).show();
            }} );
    }
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Pulsado boton Dos",Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, "Pulsado boton Dos",Toast.LENGTH_SHORT).show();
    }

}
