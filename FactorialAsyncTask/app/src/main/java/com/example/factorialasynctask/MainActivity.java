package com.example.factorialasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import javax.xml.transform.Result;

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
        MiTarea tarea = new MiTarea();
        tarea.execute(n);
    }

    public int factorial(int n) {
        int res=1;
        for (int i=1; i<=n; i++) {
            res*=i;
            SystemClock.sleep(500);
        }
        return res;
    }

    class MiTarea extends AsyncTask<Integer,Void,Integer> {
        private int res;

        public Integer doInBackground(Integer... n) {
            return factorial(n[0]);
        }


        public void onPostExecute(Integer res) {
            salida.append(String.valueOf(res) + "\n");
        }
    }


}
