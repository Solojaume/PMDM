package com.example.fragmentosbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {
    CheckBox mChk;
    View mFrg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mFrg =findViewById(R.id.miFrg);
         mChk=findViewById(R.id.aparece);
         mChk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(mChk.isChecked())mFrg.setVisibility(View.VISIBLE);
                else mFrg.setVisibility(View.INVISIBLE);
            }
        });
    }
}
