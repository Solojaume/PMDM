package com.example.plantilla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla2 extends AppCompatActivity {
    protected TextView miNom;
    protected TextView miApellido;
    protected TextView miEdad;
    protected ImageView mifoto;
    protected TextView datosPersona;
    protected Persona per;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        miNom= (TextView) findViewById(R.id.campoNom);
        miApellido = (TextView) findViewById(R.id.campoApe);
        miEdad = (TextView) findViewById(R.id.campoEd);
        mifoto =(ImageView)findViewById(R.id.campoFoto);
        datosPersona = (TextView) findViewById(R.id.todaPersona);

        per=(Persona)getIntent().getSerializableExtra("CLAVEper");
        datosPersona.setText(per.toString());
//        Toast.makeText(this,per.toString(), Toast.LENGTH_LONG).show();

        miNom.setText("NOMBRE: "+ per.getNombre());
        miApellido.setText("APELLIDO: "+ per.getApellido());
        miEdad.setText("EDAD: " + String.valueOf(per.getEdad()));
        mifoto.setImageResource(per.getFoto());

    }
}
