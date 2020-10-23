package com.example.tugasbesar01;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.tugasbesar01.databinding.MenuFragmentBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MenuFragment extends Fragment {

    private MenuFragmentBinding binding;
    public SharedPreferences menuPref,descPref,tagPref,recipePref;
    StoragePreferences storage;
    private MenuFragmentViewModel model;
    public ArrayAdapter<String> adapter;
    public String items[];
    public List<String> tempList;
    public ArrayList<String> menuItemsList;
    protected ListView listView;
    private fragmentListener listener;
    final private int REQUEST_CODE = 100;
    protected MenuAddDialogFragment editDialog;
    protected FragmentManager dialogMan;
    int temp;

    public static MenuFragment newInstance(String title) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString("title",title);
        fragment.setArguments(args);
        return fragment;


    }


    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = MenuFragmentBinding.inflate(inflater,container,false);
        View view = binding.getRoot();


        listView = (ListView)view.findViewById(R.id.listMenu);

        /*
            retrieve data from storage at here

            Storage purpose

         */
        // storage initialiation
        menuPref = getActivity().getSharedPreferences("title", Context.MODE_PRIVATE);
        descPref = getActivity().getSharedPreferences("desc",Context.MODE_PRIVATE);
        tagPref = getActivity().getSharedPreferences("tag",Context.MODE_PRIVATE);
        recipePref = getActivity().getSharedPreferences("recipe",Context.MODE_PRIVATE);

        // using override constructor number 2
        storage = new StoragePreferences(menuPref,descPref,tagPref,recipePref,menuPref.edit(),descPref.edit(),tagPref.edit(),recipePref.edit());

        items = storage.getMenuString();
        tempList = Arrays.asList(items);
        menuItemsList = new ArrayList<String>(tempList);

        /*
            ListView Setup
         */

        adapter = new ArrayAdapter<String>(getActivity(),R.layout.item_list_menu_string,R.id.textList,menuItemsList);
        listView.setDividerHeight(3);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //String selectedFromList = (String) listView.getItemAtPosition(i);
                //Toast.makeText(getContext(), selectedFromList, Toast.LENGTH_LONG).show();
                listener.changePage("desc");

            }
        });

        /*
            List view Long Click listener delete
         */
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*
                storage.deleteObjectKey(i);
                temp = i;
                model.refreshDelStat();
                
                 */
                return false;
            }
        });

        /*
            View Model Object
         */
        String tempTitle = "";
        model = new ViewModelProvider(this).get(MenuFragmentViewModel.class);
        model.getFoodList().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {

                menuItemsList.add(s);
                adapter.notifyDataSetChanged();
            }
        });
        model.getDeleteStat().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Log.i("test: ","lewat");
                menuItemsList.remove(temp);
                adapter.notifyDataSetChanged();
            }
        });

        /*
            Floating Action Button setup
         */
        dialogMan = getParentFragmentManager();
        editDialog = MenuAddDialogFragment.newInstance("Add New Menu");
        editDialog.setTargetFragment(this,REQUEST_CODE);

        FloatingActionButton fab = binding.fabPlus;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                    Calling fragment for inserting the new data, then it will send a callback to onActivityResult after 'ADD' button clicked
                 */
                editDialog.show(dialogMan,"fragment_dialog");
            }
        });


        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == MenuAddDialogFragment.newInstance("").REQUEST_CODE){
            updateList();
        };

    }

    public void updateList(){
        items = storage.getMenuString();
        tempList = Arrays.asList(items);
        int a = storage.latestKey(menuPref);

        model.refreshUI(tempList,a);
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

}
