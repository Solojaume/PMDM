package com.example.menucontextual;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.*;
import android.view.ContextMenu.*;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        registerForContextMenu(textView);
    }

    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    public boolean onContextItemSelected(MenuItem itemMnuContex) {
        switch (itemMnuContex.getItemId()) {
            case R.id.MnuOpc1:
                textView.setText("Etiqueta: Opcion 1 pulsada!");
                return true;
            case R.id.MnuOpc2:
                textView.setText("Etiqueta: Opcion 2 pulsada!");
                return true;
            default:
                return super.onContextItemSelected(itemMnuContex);
        }
    }
}
