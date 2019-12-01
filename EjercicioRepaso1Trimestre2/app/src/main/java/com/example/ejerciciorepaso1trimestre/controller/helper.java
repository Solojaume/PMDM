package com.example.ejerciciorepaso1trimestre.controller;

import android.content.Context;
import android.widget.Toast;

import com.example.ejerciciorepaso1trimestre.Factura;

public class helper {
    public static void showToast(Context c, Factura factura) {
        String text = "Modelo: "+factura.getModelo()+"\n"+
                "Precio: "+factura.getPrecioh()+"\n"+
                "Extras: "+ factura.getExtras()+"\n"+
                "Tiempo: "+factura.getSeguro()+"\n"+
                "Seguro: "+factura.getSeguro()+"\n"+
                "Coste Total: "+factura.getTotal();
        Toast.makeText(c,text,Toast.LENGTH_LONG).show();
    }
    public static void showToast(Context c, String text) {
        Toast.makeText(c,text,Toast.LENGTH_LONG).show();
    }

}
