package com.example.fragmentosdinamicos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SimpleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SimpleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SimpleFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    int[] imagenes = {R.drawable.indice,R.drawable.sf90,R.drawable.f40, R.drawable.captura};
    // TODO: Rename and change types of parameters
    private int mParam1;
    private int mParam2;

    public SimpleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SimpleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SimpleFragment newInstance(int param1) {
        SimpleFragment fragment = new SimpleFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v  = null;
        TextView tv ;
        // dependiendo de si es par o impar mostramos distintos layouts
        if (mParam1 % 2 != 0){
            v = inflater.inflate(R.layout.fragment_simple, container, false);
            tv = v.findViewById(R.id.text);
        }
        else{
            v = inflater.inflate(R.layout.fragment_simple2 , container, false);
            tv = v.findViewById(R.id.text2);
            ImageView im=v.findViewById(R.id.image);
            im.setImageResource(imagenes[(int)Math.round(Math.random()*3)]);
        }
        tv.setText("Fragmento número #" + mParam1);
        return v;
    }




}
