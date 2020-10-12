package com.example.tugasbesar01;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawer;
    FragmentManager fragmentManager;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.toolbar = findViewById(R.id.toolbar);
        this.drawer = findViewById(R.id.drawer_layout);
        this.setSupportActionBar(toolbar);
        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.app_name,R.string.app_name);
        drawer.addDrawerListener(abdt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        abdt.syncState();
    }
}