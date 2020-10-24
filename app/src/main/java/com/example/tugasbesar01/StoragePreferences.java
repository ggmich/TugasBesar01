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

    public StoragePreferences(SharedPreferences menuTitlePref, SharedPreferences menuDescPref, SharedPreferences menuTagPref, SharedPreferences menuRecipePref, SharedPreferences.Editor menuTitleEditor, SharedPreferences.Editor menuDescEditor, SharedPreferences.Editor menuTagEditor, SharedPreferences.Editor menuRecipeEditor) {
        this.menuTitlePref = menuTitlePref;
        this.menuDescPref = menuDescPref;
        this.menuTagPref = menuTagPref;
        this.menuRecipePref = menuRecipePref;
        this.menuTitleEditor = menuTitleEditor;
        this.menuDescEditor = menuDescEditor;
        this.menuTagEditor = menuTagEditor;
        this.menuRecipeEditor = menuRecipeEditor;
    }

   
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

    private  String[] retrieveData(){
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

    public void setData(String title,String desc, String tag, String recipe){
        this.menuTitleEditor.putString(String.valueOf(latestKey(menuTitlePref)),title);
        this.menuDescEditor.putString(String.valueOf(latestKey(menuDescPref)),desc);
        this.menuTagEditor.putString(String.valueOf(latestKey(menuTagPref)),tag);
        this.menuRecipeEditor.putString(String.valueOf(latestKey(menuRecipePref)),recipe);

        this.menuTitleEditor.apply();
        this.menuDescEditor.apply();
        this.menuTagEditor.apply();
        this.menuRecipeEditor.apply();
    }

    public int latestKey(SharedPreferences pref){
        int a = pref.getAll().size();
        return a;
    }

    public void deleteObjectKey(int position){
        String pos = String.valueOf(position);
        this.menuTitleEditor.remove(pos);
        this.menuDescEditor.remove(pos);
        this.menuTagEditor.remove(pos);
        this.menuRecipeEditor.remove(pos);

        this.menuTitleEditor.apply();
        this.menuDescEditor.apply();
        this.menuTagEditor.apply();
        this.menuRecipeEditor.apply();

    }
}
