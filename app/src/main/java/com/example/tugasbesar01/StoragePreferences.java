package com.example.tugasbesar01;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class StoragePreferences extends Activity {

    protected SharedPreferences menuTitlePref,menuDescPref,menuTagPref,menuRecipePref;
    protected SharedPreferences.Editor menuTitleEditor, menuDescEditor,menuTagEditor,menuRecipeEditor;

    public StoragePreferences(SharedPreferences menuTitlePref, SharedPreferences.Editor menuTitleEditor) {
        this.menuTitlePref = menuTitlePref;
        this.menuTitleEditor = menuTitleEditor;
    }

    /*
            @SuppressLint("CommitPrefEdits")
            public StoragePreferences() {

                this.menuTitlePref = getSharedPreferences("title", Context.MODE_PRIVATE);

                this.menuDescPref = getSharedPreferences("desc", Context.MODE_PRIVATE);
                this.menuTagPref = getSharedPreferences("tag", Context.MODE_PRIVATE);
                this.menuRecipePref = getSharedPreferences("recipe", Context.MODE_PRIVATE);


                this.menuTitleEditor = menuTitlePref.edit();

                this.menuDescEditor = menuDescPref.edit();
                this.menuTagEditor = menuTagPref.edit();
                this.menuRecipeEditor = menuRecipePref.edit();


            }
        */
    public String[] getMenuString(){
        /*
            retrieve data from storage at here

         */
        String[] items = new String[retrieveData().length-1];
        for(int i = 0; i < retrieveData().length-1; i++){
            if(retrieveData()[i] != null){
                items[i] = retrieveData()[i];
            }
           // Log.i("test: ", items[i]);
        }
        return items;
    }

    public  String[] retrieveData(){
        Map<String, ?> allEntry = menuTitlePref.getAll();
        String temp[];
        int index = 1;
        for(Map.Entry<String, ?> entry : allEntry.entrySet()){
            //Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
            index++;
        }
        temp = new String[index];

        for(Map.Entry<String, ?> entry : allEntry.entrySet()){
            temp[Integer.parseInt(entry.getKey())] = entry.getValue().toString();
        }
        return temp;
    }


}
