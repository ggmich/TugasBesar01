package com.example.tugasbesar01;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.tugasbesar01.databinding.MenuFragmentBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MenuFragment extends Fragment {

    private MenuFragmentBinding binding;

    /*
        Test Storage
     */
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;



    public static MenuFragment newInstance(String title) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString("title",title);
        fragment.setArguments(args);
        return fragment;


    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = MenuFragmentBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        ListView listView = (ListView)view.findViewById(R.id.listMenu);

        //test storage
        preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("1","dari storage");
        editor.commit();

        /*
            retrieve data from storage at here

         */
        final String[] items = new String[] {"Nasi Goreng","Nasi Ayam","Nasi Uduk", preferences.getString("1","tidak ada")};

        /*
            ListView Setup
         */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.item_list_menu_string,R.id.textList,items);
        listView.setDividerHeight(3);
        listView.setAdapter(adapter);

        /*
            Floating Action Button setup
         */
        FloatingActionButton fab = binding.fabPlus;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
