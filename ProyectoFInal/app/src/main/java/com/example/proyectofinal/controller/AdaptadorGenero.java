package com.example.proyectofinal.controller;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.proyectofinal.R;
import com.example.proyectofinal.model.Genero;

import java.util.List;

public class AdaptadorGenero extends ArrayAdapter<Genero> {
    public Activity miActividad;
    List<Genero> generos;
    public AdaptadorGenero(@NonNull Activity context, List<Genero> generos) {
        super(context, R.layout.desplegador, generos);
        miActividad=context;
        this.generos=generos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= miActividad.getLayoutInflater();
        View item = inflater.inflate(R.layout.desplegador,null);

        TextView nameGenero = item.findViewById(R.id.textViewGenName);
        nameGenero.setText(generos.get(position).getNombre());

        return item;
    }
}
