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
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements fragmentListener{
    Activity activity;
    Toolbar toolbar;
    DrawerLayout drawer;
    FragmentManager fragmentManager;
    FragmentTransaction ft;

    //debug
    MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar
        this.toolbar = findViewById(R.id.toolbar);
        this.drawer = findViewById(R.id.drawer_layout);
        this.setSupportActionBar(toolbar);
        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.makan_apa,R.string.makan_apa);
        drawer.addDrawerListener(abdt);
        abdt.syncState();

        //debug
        fragmentManager = getSupportFragmentManager();
        this.menuFragment = MenuFragment.newInstance("test");
        ft = this.fragmentManager.beginTransaction();
        ft.add(R.id.fragment_container,this.menuFragment)
                .addToBackStack(null)
                .commit();



    }

    public void changePage(String page){
        if(page.equals("home")){
            this.getSupportActionBar().setTitle("Makan Apa");
        }
        else if (page.equals("menu")){
            this.getSupportActionBar().setTitle("Menu");
        }
        else if(page.equals("search")){
            this.getSupportActionBar().setTitle("Search");
        }
        else if (page.equals("settings")){
            this.getSupportActionBar().setTitle("Settings");
        }
        else if (page.equals("exit")){
            this.getSupportActionBar().setTitle("Exit");
        }
    }
}