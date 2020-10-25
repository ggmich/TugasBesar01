package com.example.tugasbesar01;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import com.example.tugasbesar01.databinding.MenuPlusDialogFragmentBinding;

public class MenuAddDialogFragment extends DialogFragment {

    private MenuPlusDialogFragmentBinding binding;
    private StoragePreferences storagePreferences;
    private SharedPreferences menuPref, descPref, tagPref, recipePref;
<<<<<<< HEAD
    final public int REQUEST_CODE = 100;
=======
>>>>>>> parent of 15e8b28... Merge branch 'master' of https://github.com/ggmich/TugasBesar01

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
<<<<<<< HEAD

                // 999
                sendResult(REQUEST_CODE,binding.editName.getText().toString());
                clearWindow();
                dismiss();
=======
>>>>>>> parent of 15e8b28... Merge branch 'master' of https://github.com/ggmich/TugasBesar01
            }
        });
    }

    private void sendResult(int REQUEST_CODE, String res){
        Intent intent = new Intent();
        intent.putExtra("dialog_key",res);
        getTargetFragment().onActivityResult(
                getTargetRequestCode(),REQUEST_CODE,intent
        );
    }

    private void clearWindow(){
        binding.editName.getText().clear();
        binding.editDesc.getText().clear();
        binding.ediTag.getText().clear();
        binding.editRecipe.getText().clear();
    }
}
