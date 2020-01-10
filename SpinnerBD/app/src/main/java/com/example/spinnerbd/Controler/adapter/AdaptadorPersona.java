package com.example.spinnerbd.Controler.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.spinnerbd.MainActivity;
import com.example.spinnerbd.R;
import com.example.spinnerbd.model.Persona;

import java.util.List;

public class AdaptadorPersona  extends ArrayAdapter<Persona> {
    private
    public AdaptadorPersona(@NonNull Context context, @NonNull List<Persona> objects) {
        super(context, R.layout.item_persona,objects);
        this.context = context;
        this.personas = objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v == null)
            v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        Persona p = personas[position];
        TextView tvName = v.findViewById(R.id.tv_person_name);
        tvName.setText(p.getName() + " (" + p.getAge() + " años)");


        return v;
    }
}
