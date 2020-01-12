package com.example.spinnerbd.Controler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.spinnerbd.R;
import com.example.spinnerbd.model.Persona;

import java.util.List;

public class AdaptadorPersona  extends ArrayAdapter<Persona> {
    class Holder{
        TextView tvName;
        TextView tvApellidos;
        TextView tvEdad;
        ImageView ivImagen;
    }

    private List<Persona> personas;
    public AdaptadorPersona(@NonNull Context context, int resources,@NonNull List<Persona> objects) {
        super(context, resources,objects);

        this.personas = objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        Holder h;
        if(v == null) {
          v = LayoutInflater.from(parent.getContext()).inflate(R.layout.desplegador_persona, parent, false);
            h = new Holder();
            System.out.println("===========================================================Debug: "+1);
            h.tvName = v.findViewById(R.id.tvnombre);
            System.out.println("===========================================================Debug: "+1);
            h.tvApellidos = v.findViewById(R.id.tvapellido);
            System.out.println("===========================================================Debug: "+2);

            h.tvEdad = v.findViewById(R.id.tvedad);
            v.setTag(h);
            h.ivImagen= v.findViewById(R.id.desplegador_imagen);
        } else
            h=(Holder)v.getTag();
        Persona p = personas.get(position);
        h.tvName.setText(p.getNombre());
        System.out.println("===========================================================Debug: "+position);
        h.tvApellidos.setText(p.getApellido());
        h.tvEdad.setText("" + p.getEdad());
        h.ivImagen.setImageResource(R.drawable.enzo);

        return v;
    }
}
