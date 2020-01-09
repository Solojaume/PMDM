package com.example.spinnerbd.Controler.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.example.spinnerbd.MainActivity;
import com.example.spinnerbd.R;
import com.example.spinnerbd.model.Persona;

import java.util.List;

public class AdaptadorPersona  extends ArrayAdapter<Persona> {

    public AdaptadorPersona(@NonNull Context context, @NonNull List<Persona> objects) {
        super(context, R.layout.item_persona,objects);
    }
}
