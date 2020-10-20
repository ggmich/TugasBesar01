package com.example.tugasbesar01;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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

    public void setFoodList(MutableLiveData<String> foodList) {
        this.foodList = foodList;
    }


}
