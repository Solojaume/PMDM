package com.example.examen1trimestre_jaumeponsorti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    private static String seleccion;
    ImageView imgResul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.btn);
        ImageView patinete = findViewById(R.id.img_11);
          imgResul = findViewById(R.id.imgResul);
        patinete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                seleccion="electrico";
                imgResul.setImageResource((R.drawable.patinete));
            }

        });

        ImageView bicicleta = findViewById(R.id.img_12);
        bicicleta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                seleccion="bici";
                imgResul.setImageResource((R.drawable.bicis));
            }

        });
        ImageView coche = findViewById(R.id.img_13);
        coche.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                seleccion="coche";
                imgResul.setImageResource((R.drawable.coches));
            }

        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle myBundle=new Bundle();

                myBundle.putString("ClaveTransporte",seleccion);
                myIntent.putExtras(myBundle);
                startActivity(myIntent);
            }
        });
    }

}
