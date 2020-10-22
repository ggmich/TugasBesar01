package com.example.tugasbesar01;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MenuFragmentViewModel extends ViewModel {

    private MutableLiveData<String> foodList =new MutableLiveData<>();
    public StoragePreferences storage;
    public StoragePreferences storagePreferences;
    public SharedPreferences menuPref, descPref, tagPref, recipePref;

    public MenuFragmentViewModel() {

    }

    public MutableLiveData<String> getFoodList() {
        return foodList;
    }

    public void setFoodList(String foodList) {
        this.foodList.setValue(foodList);
    }

    public String refreshUI(ArrayList<String> list, ArrayAdapter<String> adapter, int idx){
        String test = list.get(idx-1);
        return test;
    }


}
