package com.example.holamusica;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    MediaPlayer miMusica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       final ToggleButton btnBoton2= (ToggleButton)findViewById(R.id.miTogBtn);
        btnBoton2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {
                if(btnBoton2.isChecked())
                    miMusica.start();
                else
                    miMusica.stop();

            }

        });
        /*
        final ImageView milogo=(ImageView)findViewById(R.id.logoDesigual);

        */

    }

}
