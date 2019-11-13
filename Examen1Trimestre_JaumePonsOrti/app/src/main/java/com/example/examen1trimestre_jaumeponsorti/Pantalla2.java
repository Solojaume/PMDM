package com.example.examen1trimestre_jaumeponsorti;

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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {
    protected MedioTransporte listaTransportes[];
    protected static String listaTransporte[];
    protected MedioTransporte[] electricos = new MedioTransporte[]{
            new MedioTransporte("skate", "Roxi", "12", R.drawable.skate),
            new MedioTransporte("patinete", "Roxi", "15", R.drawable.patinete),
            new MedioTransporte("monociclo", "Oneil", "18", R.drawable.monociclo1)};

    protected MedioTransporte[] bicis = new MedioTransporte[]{
            new MedioTransporte("Paseo", "Orbea", "15", R.drawable.bici1),
            new MedioTransporte("Ciudad", "Cube", "20", R.drawable.bici2),
            new MedioTransporte("Montaña", "Bike", "25", R.drawable.bici3)};

    protected MedioTransporte[] coches = new MedioTransporte[]{
            new MedioTransporte("Megane", "Renault", "60", R.drawable.megan1),
            new MedioTransporte("Leon", "Seat", "70", R.drawable.leon3),
            new MedioTransporte("Fiesta", "Ford", "75", R.drawable.fiesta2)};
    protected static String[] bici=new String[]{"bici1","bici2"};
    protected static String[] coche=new String[]{"coche1","tesla"};
    protected static String[] electrico=new String[]{"skate","patinete"};
    protected static String transporte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        transporte=(String) getIntent().getSerializableExtra("ClaveTransporte");
        /*No he podido hacer el spinner con objetos debido a que este estaba dando problemas en ejecucion
         * aun así se puede leer el codigo*/
        switch (transporte){
            case "bici":
                listaTransporte=bici;
            break;
            case "electrico":
                listaTransporte=electrico;
                break;
            case "coche":
                listaTransporte=coche;
                break;
        }
//        switch (transporte){
//            case "bici":
//                listaTransportes=bicis;
//            break;
//            case "electrico":
//                listaTransportes=electricos;
//                break;
//            case "coche":
//                listaTransportes=coches;
//                break;
//        }
        Spinner spinner =findViewById(R.id.spinner);
        ArrayAdapter<String>adaptador= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaTransporte);
        spinner.setAdapter(adaptador);
//        AdaptadorTransporte adaptador = new AdaptadorTransporte(this);
//
//        spinner.setAdapter(adaptador);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String mensaje = "";
//                mensaje = "Item Clicked =>"+ listaTransportes [position];
//                System.out.println(mensaje);
//            }
//
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });


    }

//    class AdaptadorTransporte  extends ArrayAdapter<MedioTransporte> {
//        private Activity context;
//
//        public AdaptadorTransporte(Activity context) {
//            super(context,  R.layout.desplegador, listaTransportes);
//            this.context = context;
//        }
//
//        public View getDropDownView(int pos, View convertView, ViewGroup parent) {
//            View vistaDesplegada = getView(pos,convertView,parent);
//            return vistaDesplegada;
//        }
//
//        public View getView(int i, View convertView, ViewGroup parent) {
//            LayoutInflater inflater = context.getLayoutInflater();
//            View item = inflater.inflate(R.layout.desplegador,  parent);
//
//            TextView tipo = item.findViewById(R.id.tipo);
//            tipo.setText(listaTransportes[i].getTipo());
//            TextView marca = item.findViewById(R.id.marca);
//            marca.setText(listaTransportes[i].getMarca());
//            TextView precio = item.findViewById(R.id.precios);
//            precio.setText(listaTransportes[i].getPrecio());
//            ImageView imagen = findViewById(R.id.imagen);
//            return item;
//        }
//    }

}
