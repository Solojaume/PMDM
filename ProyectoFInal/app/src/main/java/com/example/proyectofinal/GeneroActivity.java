package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;

public class GeneroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genero);
        try {
            filldata();
        }catch (SQLException e){

        }

    }

    private void filldata() {

    }

}
