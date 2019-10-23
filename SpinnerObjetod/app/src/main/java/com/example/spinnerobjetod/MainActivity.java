package com.example.spinnerobjetod;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Persona[] personas = new Persona[]{
            new Persona("Paco","Moñas"),
            new Persona("Ruben","Campana"),
            new Persona("Antonia","Gimenez"),
            new Persona("Jaume","El puto Amo")
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner lview =  findViewById(R.id.mispinner);

        AdaptadorPersona miAdaptador = new AdaptadorPersona(this);
        lview.setAdapter(miAdaptador);


        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "";
                mensaje = "Item Clicked =>"+ personas [position];
                showToast(mensaje);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }
    public void showToast(String text) {
        Toast.makeText(this,text, Toast.LENGTH_SHORT).show();
    }
    class AdaptadorPersona  extends ArrayAdapter<Persona> {
        private Activity context;

        public AdaptadorPersona(Activity context) {
            super(context, R.layout.desplegador, personas);
            this.context = context;
        }

        public View getDropDownView(int pos, View convertView, ViewGroup parent) {
            View vistaDesplegada = getView(pos,convertView,parent);
            return vistaDesplegada;
        }

        public View getView(int i, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.desplegador, null);

            TextView miNombre = item.findViewById(R.id.nombre);
            miNombre.setText(personas[i].getNombre());
            TextView miApellido = item.findViewById(R.id.apellido);
            miApellido.setText(personas[i].getNombre());
            return item;
        }
    }
}
