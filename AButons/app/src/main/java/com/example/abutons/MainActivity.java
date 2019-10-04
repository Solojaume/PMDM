package com.example.abutons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToLinearLayoutActivity(View view) {
        startActivity(new Intent(this, Layout_Lineal.class));
    }

    public void goToTableLayoutActivity(View view) {
        startActivity(new Intent(this, TableLayoutActivity.class));
    }

    public void goToRelativeLayoutActivity(View view) {
        startActivity(new Intent(this, RelativeLayoutActivity.class));
    }
    public void goToGridLayoutActivity(View view) {
        startActivity(new Intent(this, GridLayoutActivity.class));
    }

}
