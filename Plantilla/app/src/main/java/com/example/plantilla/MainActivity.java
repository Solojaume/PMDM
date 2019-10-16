package com.example.plantilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edNombre;
    private EditText edApellido;
    private EditText edEdad;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edNombre = findViewById(R.id.edNombre);
        edApellido = findViewById(R.id.edApellido);
        edEdad = findViewById(R.id.edEdad);
        button=findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edNombre.getText().toString();
                String apellido = edApellido.getText().toString();
                String edad = edEdad.getText().toString();

                if (TextUtils.isEmpty(edad))
                    edad="0";
                Persona p =new Persona(nombre, apellido,Integer.parseInt(edad));
//                Toast.makeText(MainActivity.this,p.toString(), Toast.LENGTH_LONG).show();
                Bundle bundle = new Bundle();
                Intent intent = new Intent(MainActivity.this, Pantalla2.class);;
                bundle.putSerializable("CLAVEper", p);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }

}
