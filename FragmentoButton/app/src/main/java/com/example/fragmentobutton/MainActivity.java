package com.example.fragmentobutton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public Fragment mFrg;
    int mStrackPosition=1;
    Button manejaFragment;
    int dibujos[]={R.drawable.ferrari,R.drawable.imagen};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manejaFragment =findViewById(R.id.button);
        manejaFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment();
            }
        });
        if(savedInstanceState==null){
            Fragment miFragement=MiFragment.newInstance(dibujos[0]);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.miFrg,miFragement);
            ft.commit();
        }
        else {
            mStrackPosition=savedInstanceState.getInt("position");
        }


    }

    public void addFragment(){
        Fragment miFragment;
        Random r= new Random();
        miFragment= MiFragment.newInstance(dibujos[r.nextInt(dibujos.length)]);
        FragmentTransaction fg= getFragmentManager().beginTransaction();
        fg.replace(R.id.miFrg,miFragment);
        fg.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fg.addToBackStack(null);
        fg.commit();
    }
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistence){
        super.onSaveInstanceState(outState,outPersistence);
        outState. putInt("position",mStrackPosition);
    }
}
