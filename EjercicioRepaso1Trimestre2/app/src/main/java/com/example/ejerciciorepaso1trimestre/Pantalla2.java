package com.example.ejerciciorepaso1trimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class Pantalla2 extends AppCompatActivity {
    private MedioTransporte listaTransportes[];
    private MedioTransporte[] electricos = new MedioTransporte[]{
            new MedioTransporte("skate", "Roxi", "12", R.drawable.skate),
            new MedioTransporte("patinete", "Roxi", "15", R.drawable.patinete),
            new MedioTransporte("monociclo", "Oneil", "18", R.drawable.monociclo1)};

    private MedioTransporte[] bicis = new MedioTransporte[]{
            new MedioTransporte("Paseo", "Orbea", "15", R.drawable.bici1),
            new MedioTransporte("Ciudad", "Cube", "20", R.drawable.bici2),
            new MedioTransporte("Montaña", "Bike", "25", R.drawable.bici3)};

    private MedioTransporte[] coches = new MedioTransporte[]{
            new MedioTransporte("Megane", "Renault", "60", R.drawable.megan1),
            new MedioTransporte("Leon", "Seat", "70", R.drawable.leon3),
            new MedioTransporte("Fiesta", "Ford", "75", R.drawable.fiesta2)};
    private static String transporte;
    private static int precioAlquiler,precioSeguro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        Bundle bundle = getIntent().getExtras();
        transporte = getIntent().getExtras().getString("ClaveTransporte");
        //transporte=(String) getIntent().getSerializableExtra("ClaveTransporte");
        precioAlquiler=0;
        precioSeguro=0;

        switch (transporte){
            case "bici":
                listaTransportes=bicis;
                break;
            case "electrico":
                listaTransportes=electricos;
                break;
            case "coche":
                listaTransportes=coches;
                break;
        }

        Spinner spinner =findViewById(R.id.spinner);
        AdaptadorTransporte adaptador = new AdaptadorTransporte(this, listaTransportes);

        spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                precioAlquiler=Integer.parseInt(listaTransportes[position].getPrecio());
//               System.out.println("===========================================================Debug: "+precioAlquiler);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        RadioGroup rg = findViewById(R.id.radiogroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Pantalla2.precioSeguro=0;
                if(group.getCheckedRadioButtonId()==R.id.radiobutton2)
                    Pantalla2.precioSeguro=(int)Math.round(precioAlquiler*0.2);
            }
        });

        Button btnTotal = findViewById(R.id.btntotal);
        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView t=findViewById(R.id.labeltot);
                System.out.println("=========================Debug:"+precioAlquiler+" =============="+precioSeguro+" ================="+t);
                t.setText(calcular());
            }
        });

    }

    public static String calcular(){//int precioAlquiler,int precioSeguro
        int precioTotal=precioAlquiler+precioSeguro;
        System.out.println("=========================Debug:"+precioAlquiler+" =============="+precioSeguro);
        return ""+precioTotal;
    }

    class AdaptadorTransporte  extends ArrayAdapter<MedioTransporte> {
        private Activity context;
        private MedioTransporte[] listaTransportes;

        public AdaptadorTransporte(Activity context,MedioTransporte[] listaTransportes) {
            super(context,  R.layout.desplegador, listaTransportes);
            this.context = context;
            this.listaTransportes=listaTransportes;
        }


        public View getDropDownView(int pos, View convertView, ViewGroup parent) {
            return getView(pos,convertView,parent);
        }

        public View getView(int i, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.desplegador,  parent,false);

            TextView tipo = item.findViewById(R.id.tipo);
            tipo.setText(listaTransportes[i].getTipo());
            TextView marca = item.findViewById(R.id.marca);
            marca.setText(listaTransportes[i].getMarca());
            TextView precio = item.findViewById(R.id.precios);
            precio.setText(listaTransportes[i].getPrecio());
            ImageView imagen = item.findViewById(R.id.desplegador_imagen);
            imagen.setImageResource(listaTransportes[i].getImagen());
            return item;
        }

//        @Override
//        public int getCount() {//Puede ser necesario para que no de errores
//            return listaTransportes.length;
//        }
    }

}
