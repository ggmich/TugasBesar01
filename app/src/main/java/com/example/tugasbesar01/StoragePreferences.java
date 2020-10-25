package com.example.tugasbesar01;

import android.app.Activity;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Map;

public class StoragePreferences extends Activity {

    protected SharedPreferences menuTitlePref,menuDescPref,menuTagPref,menuRecipePref;
    protected SharedPreferences.Editor menuTitleEditor, menuDescEditor,menuTagEditor,menuRecipeEditor;
    public ArrayList<String> title,desc,tag,recipe;

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

    public void deleteObjectKey(int position,int listLength){
        String pos = String.valueOf(position);
        sortKey(position,listLength);
        this.menuTitleEditor.remove(pos);
        this.menuDescEditor.remove(pos);
        this.menuTagEditor.remove(pos);
        this.menuRecipeEditor.remove(pos);

        this.menuTitleEditor.apply();
        this.menuDescEditor.apply();
        this.menuTagEditor.apply();
        this.menuRecipeEditor.apply();

    }

    private void sortKey(int position,int length){
        title = new ArrayList<>();
        desc = new ArrayList<>();
        tag = new ArrayList<>();
        recipe = new ArrayList<>();

        for(int i = 0; i < length; i++){
            if(i != position){
                this.title.add(this.menuTitlePref.getString(String.valueOf(i),"null"));
                this.desc.add(this.menuDescPref.getString(String.valueOf(i),"null"));
                this.tag.add(this.menuTagPref.getString(String.valueOf(i),"null"));
                this.recipe.add(this.menuRecipePref.getString(String.valueOf(i),"null"));
            }
        }

    }

    //test revert


}
