package com.example.tugasbesar01;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tugasbesar01.databinding.MenuPlusDialogFragmentBinding;

public class MenuAddDialogFragment extends DialogFragment {

    private MenuPlusDialogFragmentBinding binding;
    private StoragePreferences storagePreferences;
    private SharedPreferences menuPref, descPref, tagPref, recipePref;
    MenuFragmentViewModel model;

    public MenuAddDialogFragment() {

    }

    public static MenuAddDialogFragment newInstance(String title){

        // Add new Menu Dialog Object Initialization
        MenuAddDialogFragment frag = new MenuAddDialogFragment();

        // Input args for dialog title
        Bundle args = new Bundle();
        args.putString("titleDialog",title);
        frag.setArguments(args);
        return frag;
    }

    @SuppressLint("CommitPrefEdits")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = MenuPlusDialogFragmentBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        // storage initialiation
        menuPref = getActivity().getSharedPreferences("title", Context.MODE_PRIVATE);
        descPref = getActivity().getSharedPreferences("desc",Context.MODE_PRIVATE);
        tagPref = getActivity().getSharedPreferences("tag",Context.MODE_PRIVATE);
        recipePref = getActivity().getSharedPreferences("recipe",Context.MODE_PRIVATE);

        // using override constructor number 2
        storagePreferences = new StoragePreferences(menuPref,descPref,tagPref,recipePref,menuPref.edit(),descPref.edit(),tagPref.edit(),recipePref.edit());

        //view model
        model = new ViewModelProvider(this).get(MenuFragmentViewModel.class);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // get dialog title from constructor in newInstance(title);
        String title = getArguments().getString("titleDialog","Unknown");
        getDialog().setTitle(title);

        // force keyboard to focus on editText in dialogFragment
        binding.editName.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        // onclick method for add button data
        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storagePreferences.setData(binding.editName.getText().toString(),binding.editDesc.getText().toString(),binding.ediTag.getText().toString(),binding.editRecipe.getText().toString());
                model.setFoodList(binding.editName.getText().toString());
                dismiss();
            }
        });
    }
}
