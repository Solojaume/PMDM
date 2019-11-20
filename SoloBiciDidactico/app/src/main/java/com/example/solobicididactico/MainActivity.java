package com.example.solobicididactico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bJuego;
    private Button bArcade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         bJuego = (Button)findViewById(R.id.buttonJugar);
         bJuego.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
//                 lanzarJuego();
             }
         });
        bArcade = (Button)findViewById(R.id.buttonJugar);
        bJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                lanzarArcade();
            }
        });
    }
}
