package com.example.tugasbesar01;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tugasbesar01.databinding.HomeFragmentBinding;

public class HomeFragment extends Fragment {

    private HomeFragmentBinding binding;
    private HomeFragmentViewModel model;
    public Observer<String> titleObserver;
    private SharedPreferences preferences;

    public HomeFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = HomeFragmentBinding.inflate(inflater,container,false);

        binding.buttonCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

        View view = binding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //view model
        model = new ViewModelProvider(requireActivity()).get(HomeFragmentViewModel.class);

        titleObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // on change UI
            }
        };


    }
}
