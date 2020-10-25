package com.example.tugasbesar01;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;


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

    private void setFoodList(String foodList) {
        this.foodList.setValue(foodList);
    }

    public void refreshUI(List<String> list, int idx){
        String res = list.get(idx-1);
        setFoodList(res);
    }

}
