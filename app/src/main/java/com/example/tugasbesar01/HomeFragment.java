package com.example.tugasbesar01;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tugasbesar01.databinding.HomeFragmentBinding;

public class HomeFragment extends Fragment {

    private HomeFragmentBinding binding;
    private HomeFragmentViewModel model;
    public Observer<String> titleObserver;
    StoragePreferences obj;

    public HomeFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final SharedPreferences pref = this.getActivity().getSharedPreferences("title", Context.MODE_PRIVATE);
        obj = new StoragePreferences(pref,pref.edit());
        model = new HomeFragmentViewModel();

        binding = HomeFragmentBinding.inflate(inflater,container,false);

        /*
            View Button binding

            for click listener buttonCari, to set the text below button
            the text set to random by randomMenuTitle() method
         */
        binding.buttonCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp[] = obj.getMenuString();
                binding.titleRes.setText(temp[model.randomMenuTitle(temp)]);
            }
        });

        View view = binding.getRoot();

        //view model
        /*
        model = new ViewModelProvider(requireActivity()).get(HomeFragmentViewModel.class);

        titleObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // on change UI
            }
        };
        */


        return view;
    }


}
