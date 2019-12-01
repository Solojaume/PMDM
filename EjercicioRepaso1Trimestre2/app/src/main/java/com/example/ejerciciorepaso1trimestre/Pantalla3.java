package com.example.ejerciciorepaso1trimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.ejerciciorepaso1trimestre.controller.helper.*;

public class Pantalla3 extends AppCompatActivity {
    private static ImageView imageView;
    private static TextView modelo;
    private static TextView precio;
    private static TextView extras;
    private static TextView tiempo;
    private static TextView seguro;
    private static TextView costeTotal;
    private static Factura factura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);
        Bundle bundle = getIntent().getExtras();
        factura = (Factura) getIntent().getExtras().getSerializable("factura");

        imageView=findViewById(R.id.imageView);
        modelo=findViewById(R.id.modelo);
        precio=findViewById(R.id.precio);
        extras=findViewById(R.id.extras);
        tiempo=findViewById(R.id.tiempo);
        seguro=findViewById(R.id.seguro);
        costeTotal=findViewById(R.id.total);

        imageView.setImageResource(factura.getImagen());
        modelo.setText(factura.getModelo());
        precio.setText(factura.getPrecioh());
        extras.setText(""+factura.getExtras());
        tiempo.setText(""+factura.getTiempo());
        seguro.setText(factura.getSeguro());
        costeTotal.setText(factura.getTotal());
        showToast(this,factura);
    }
}
