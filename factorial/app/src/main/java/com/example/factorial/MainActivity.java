package com.example.factorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText entrada;
    private TextView salida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrada =findViewById(R.id.entrada);
        salida = findViewById(R.id.salida);
    }

    public void calcularOperacion(View view){
        int n=Integer.parseInt(entrada.getText().toString());
        salida.append(n+"! = ");
        factorial(n);

    }
    public void factorial(int n) {
        int res=1;
        for (int i=1; i<=n; i++) {
            res*=i;
            SystemClock.sleep(1000);
        }
        salida.append(String.valueOf(res)+"\n");
    }



}
