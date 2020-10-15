package com.example.tugasbesar01;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.fragment.app.Fragment;

import com.example.tugasbesar01.databinding.LeftFragmentBinding;

public class LeftFragment extends Fragment implements View.OnClickListener {
    private LeftFragmentBinding binding;
    private fragmentListener listener;
    private TextView home;
    private TextView menu;
    private TextView exit;

    public LeftFragment(){

    }

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        binding = LeftFragmentBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        this.home = view.findViewById(R.id.tvHome);
        home.setOnClickListener(this);

        this.menu = view.findViewById(R.id.tvMenu);
        menu.setOnClickListener(this);

        this.exit = view.findViewById(R.id.tvExit);
        exit.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof fragmentListener){
            this.listener = (fragmentListener) context;
        }
        else{
            throw new ClassCastException(context.toString()+" must implement FragmentListener");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onClick(View view){
        if (view == this.home){
            this.listener.changePage("home");
        }

        else if (view == this.menu){
            this.listener.changePage("menu");
        }

        else if (view == this.exit){
            this.listener.changePage("exit");
        }
    }

}
