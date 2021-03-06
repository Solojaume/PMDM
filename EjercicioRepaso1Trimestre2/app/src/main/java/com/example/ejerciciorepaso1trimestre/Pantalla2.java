package com.example.ejerciciorepaso1trimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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
    private EditText intro;
    private MedioTransporte[] coches = new MedioTransporte[]{
            new MedioTransporte("Megane", "Renault", "60", R.drawable.megan1),
            new MedioTransporte("Leon", "Seat", "70", R.drawable.leon3),
            new MedioTransporte("Fiesta", "Ford", "75", R.drawable.fiesta2)};
    private static String transporte;
    private static int precioAlquiler;
    private static boolean precioSeguro;
    protected static int listaChecBox[]= {R.id.checkBox,R.id.checkBox2,R.id.checkBox3};

    private static int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        Bundle bundle = getIntent().getExtras();
        intro = findViewById(R.id.editText);
        transporte = getIntent().getExtras().getString("ClaveTransporte");
        //transporte=(String) getIntent().getSerializableExtra("ClaveTransporte");
        precioAlquiler=0;
        precioSeguro=false;


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

        //Sppinner
        Spinner spinner =findViewById(R.id.spinner);
        AdaptadorTransporte adaptador = new AdaptadorTransporte(this, listaTransportes);

        spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                precioAlquiler=Integer.parseInt(listaTransportes[position].getPrecio());
                pos= position;
//               System.out.println("===========================================================Debug: "+precioAlquiler);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //RadioButton
        RadioGroup rg = findViewById(R.id.radiogroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Pantalla2.precioSeguro=false;
                if(group.getCheckedRadioButtonId()==R.id.radiobutton2)
                    Pantalla2.precioSeguro=true;
            }
        });



        Button btnTotal = findViewById(R.id.btntotal);
        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView t=findViewById(R.id.labeltot);
                t.setText(calcular());
            }
        });
        Button btnFactura = findViewById(R.id.btnfactura);
        btnFactura.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                lanzarFactura();
            }
        });

    }
    int c=0;
    public  String calcular(){//int precioAlquiler,int precioSeguro
        int precioTotal=precioAlquiler;
        c=0;
        for (int i = 0; i < this.listaChecBox.length; i++) {
            CheckBox checkBox = findViewById(listaChecBox[i]);
            if (checkBox.isChecked())
                c++;
        }

        precioTotal=(precioAlquiler*Integer.valueOf(String.valueOf(intro.getText())))+(50*c);
        if(precioSeguro==true)
            precioTotal=precioTotal+(int)Math.round(precioTotal*0.2);
        System.out.println("=========================Debug:"+precioTotal+" ==============");
        return ""+precioTotal;
    }
    public void lanzarFactura(){
        Intent myIntent = new Intent(this, Pantalla3.class);
        Bundle myBundle=new Bundle();
        myBundle.putSerializable("factura",crearFactura());
        myIntent.putExtras(myBundle);
        startActivity(myIntent);
    }
    public Factura crearFactura(){
//    public Factura crearFactura(MedioTransporte listaTransportes[],int pos,String tiempo){
        Factura factura= new Factura();
        factura.setImagen(listaTransportes[pos].getImagen());
        factura.setModelo(listaTransportes[pos].getTipo());
        factura.setPrecioh(listaTransportes[pos].getPrecio());
        factura.setExtras(50*c);
        factura.setTiempo(Integer.valueOf(String.valueOf(intro.getText())));
        factura.setSeguro("Sin seguro");
        factura.setTotal(calcular());
        if(precioSeguro==true)
            factura.setSeguro("Con seguro");
        return factura;
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
