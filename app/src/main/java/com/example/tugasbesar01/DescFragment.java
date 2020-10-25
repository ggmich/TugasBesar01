package com.example.tugasbesar01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.tugasbesar01.databinding.DescFragmentBinding;

public class DescFragment extends Fragment {

    DescFragmentBinding binding;
    TextView menutype;
    public DescFragment() {

    }

    public static DescFragment newInstance(String data){
        DescFragment fragment = new DescFragment();
        Bundle args = new Bundle();
        args.putString("data",data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DescFragmentBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        this.menutype = view.findViewById(R.id.menu_type);
        this.menutype.setText(this.getArguments().getString("data"));

        return view;
    }
}
