package com.example.tugasbesar01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.fragment.app.Fragment;

public class LeftFragment extends Fragment {

    public LeftFragment(){

    }

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_fragment,container,false);

        return view;
    }
}
