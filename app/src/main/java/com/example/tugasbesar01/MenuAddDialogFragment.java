package com.example.tugasbesar01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.tugasbesar01.databinding.MenuPlusDialogFragmentBinding;

public class MenuAddDialogFragment extends DialogFragment {

    private MenuPlusDialogFragmentBinding binding;

    public MenuAddDialogFragment() {

    }

    public static MenuAddDialogFragment newInstance(String title){
        MenuAddDialogFragment frag = new MenuAddDialogFragment();
        Bundle args = new Bundle();
        args.putString("title",title);
        frag.setArguments(args);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = MenuPlusDialogFragmentBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        

    }
}
