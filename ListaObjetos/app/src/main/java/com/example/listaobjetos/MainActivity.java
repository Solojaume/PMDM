package com.example.listaobjetos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

        String mensaje;
        ListView lview =  findViewById(R.id.listview);

        AdaptadorPersona miAdaptador = new AdaptadorPersona(this);
        lview.setAdapter(miAdaptador);


        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "";
                mensaje = "Nombre: " + personas[position].getNombre()+
                        ", Apellido: "+ personas[position].getApellido();
                Toast.makeText(getApplicationContext(), mensaje,Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    class AdaptadorPersona  extends ArrayAdapter<Persona> {
        private Activity context;

        public AdaptadorPersona(Activity context) {
            super(context,R.layout.desplegador,personas);
            this.context= context;
        }
        public View getView(int i, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item =  inflater.inflate(R.layout.desplegador,null);

            TextView miNombre = item.findViewById(R.id.nombre);
            miNombre.setText(personas[i].getNombre());
            TextView miApellidos = item.findViewById(R.id.apellido);
            return item;
        }
    }
}
