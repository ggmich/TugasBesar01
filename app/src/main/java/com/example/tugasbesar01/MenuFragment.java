package com.example.tugasbesar01;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tugasbesar01.databinding.MenuFragmentBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Map;

public class MenuFragment extends Fragment {

    private MenuFragmentBinding binding;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    StoragePreferences storage;

    private MenuFragmentViewModel model;


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


        final ListView listView = (ListView)view.findViewById(R.id.listMenu);

        /*
            retrieve data from storage at here

            Storage purpose

         */
        preferences = getActivity().getSharedPreferences("title",Context.MODE_PRIVATE);
        editor = preferences.edit();
        storage = new StoragePreferences(preferences,editor);
        String items[] = storage.getMenuString();


        /*
            ListView Setup
         */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.item_list_menu_string,R.id.textList,items);
        listView.setDividerHeight(3);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedFromList = (String) listView.getItemAtPosition(i);
                Toast.makeText(getContext(), selectedFromList, Toast.LENGTH_LONG).show();
            }
        });

        /*
            Floating Action Button setup
         */
        FloatingActionButton fab = binding.fabPlus;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                    Method for adding menu title
                 */

            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = new ViewModelProvider(requireActivity()).get(MenuFragmentViewModel.class);

    }
}
