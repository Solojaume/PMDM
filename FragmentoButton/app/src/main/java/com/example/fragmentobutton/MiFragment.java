package com.example.fragmentobutton;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MiFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MiFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int mParam1;


    public MiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MiFragment newInstance(int param1) {
        MiFragment fragment = new MiFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_mi, container, false);
        ImageView mifoto=(ImageView) v.findViewById(R.id.imagen);
        mifoto.setImageResource(mParam1);
        return v;

    }


}
