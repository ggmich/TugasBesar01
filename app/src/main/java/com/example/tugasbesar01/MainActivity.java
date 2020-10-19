package com.example.tugasbesar01;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import com.example.tugasbesar01.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements fragmentListener{
    Activity activity;
    Toolbar toolbar;
    DrawerLayout drawer;
    FragmentManager fragmentManager;
    FragmentTransaction ft;


    private ActivityMainBinding binding;

    //debug
    MenuFragment menuFragment = new MenuFragment();
    HomeFragment homeFragment = new HomeFragment();
    LeftFragment leftFragment = new LeftFragment();
    /*
        Test Storage
     */
    private SharedPreferences preferences,descPref,tagPref,recipePref;
    private SharedPreferences.Editor editor, descEdit, tagEdit,recipeEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // database initialization
        setDatabase();

        //toolbar
        this.toolbar = findViewById(R.id.toolbar);
        this.drawer = findViewById(R.id.drawer_layout);
        this.setSupportActionBar(binding.toolbar);
        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.makan_apa,R.string.makan_apa);
        drawer.addDrawerListener(abdt);
        abdt.syncState();

        //debug

        this.fragmentManager = this.getSupportFragmentManager();
        this.changePage("home");

    }

    public void changePage(String page){
        ft = this.fragmentManager.beginTransaction();
        if(page.equals("home")){
            this.getSupportActionBar().setTitle("Makan Apa");
            if(this.homeFragment.isAdded()) {
                if(this.menuFragment.isAdded()){
                    ft.hide(this.menuFragment);
                }
                ft.show(this.homeFragment);
                ft.show(this.leftFragment);
            }
            else {
                ft.add(R.id.fragment_container, this.homeFragment);
                ft.add(R.id.left_drawer,this.leftFragment);
            }
            this.drawer.closeDrawers();
        }
        else if (page.equals("menu")){
            this.getSupportActionBar().setTitle("Menu");
            ft.hide(this.homeFragment);

            if(this.menuFragment.isAdded()) {
                ft.show(this.menuFragment);
            }
            else {
                ft.add(R.id.fragment_container, this.menuFragment);
            }
            this.drawer.closeDrawers();
        }
        else if(page.equals("search")){
            this.getSupportActionBar().setTitle("Search");
        }
        else if (page.equals("settings")){
            this.getSupportActionBar().setTitle("Settings");
        }
        else if (page.equals("exit")){
            this.moveTaskToBack(true);
            this.finish();
        }
        ft.commit();
    }

    /*
            Method Initialization default storage
     */
    public void setDatabase(){

        Resources res = getResources();
        String[] menuTitleArray = res.getStringArray(R.array.menuTitle);
        String[] descArray = res.getStringArray(R.array.menuDesc);
        String[] tagArray = res.getStringArray(R.array.menuTag);
        String[] recipeArray = res.getStringArray(R.array.menuRecipe);

        // storage
        preferences = getSharedPreferences("title",Context.MODE_PRIVATE);
        editor = preferences.edit();

        descPref = getSharedPreferences("desc",Context.MODE_PRIVATE);
        descEdit = descPref.edit();
        tagPref = getSharedPreferences("tag",Context.MODE_PRIVATE);
        tagEdit = tagPref.edit();
        recipePref = getSharedPreferences("recipe",Context.MODE_PRIVATE);
        recipeEdit = recipePref.edit();

        // menu title default initialization
        for(int i = 0; i < menuTitleArray.length; i++){
            editor.putString(String.valueOf(i),menuTitleArray[i]);
        }
        editor.apply();

        // menu desc default initialization
        for(int i = 0; i < descArray.length; i++){
            descEdit.putString(String.valueOf(i),descArray[i]);
        }
        descEdit.apply();

        // menu tag default initialization
        for(int i = 0; i < tagArray.length; i++){
            tagEdit.putString(String.valueOf(i),tagArray[i]);
        }
        tagEdit.apply();

        // menu recipe default initialization
        for(int i = 0; i < recipeArray.length; i++){
            recipeEdit.putString(String.valueOf(i),recipeArray[i]);
        }
        recipeEdit.apply();

    }
}