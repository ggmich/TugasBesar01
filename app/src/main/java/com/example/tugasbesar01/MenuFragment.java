package com.example.tugasbesar01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MenuFragment extends Fragment {



    public static MenuFragment newInstance(String title) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString("title",title);
        fragment.setArguments(args);
        return fragment;


    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_fragment,container,false);

        ListView listView = (ListView)view.findViewById(R.id.listMenu);

        /*
            retrieve data from storage at here

         */
        final String[] items = new String[] {"Nasi Goreng","Nasi Ayam","Nasi Uduk"};

        /*
            ListView Setup
         */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.item_list_menu_string,R.id.textList,items);
        listView.setDividerHeight(3);
        listView.setAdapter(adapter);

        /*
            Floating Action Button setup
         */
        FloatingActionButton fab = view.findViewById(R.id.fabPlus);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }
}
