package com.example.tugasbesar01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;

import com.example.tugasbesar01.databinding.DescFragmentBinding;

public class DescFragment extends Fragment {

    DescFragmentBinding binding;

    public DescFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DescFragmentBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }
}
