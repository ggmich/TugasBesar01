package com.example.tugasbesar01;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MenuFragmentViewModel extends ViewModel {

    private MutableLiveData<String> foodList =new MutableLiveData<>();
    private MutableLiveData<Boolean> deleteStat = new MutableLiveData<>();
    public StoragePreferences storage;
    public StoragePreferences storagePreferences;
    public SharedPreferences menuPref, descPref, tagPref, recipePref;

    public MenuFragmentViewModel() {

    }

    public MutableLiveData<String> getFoodList() {
        return foodList;
    }

    public MutableLiveData<Boolean> getDeleteStat(){
        return deleteStat;
    }

    private void setFoodList(String foodList) {
        this.foodList.setValue(foodList);
    }

    public void refreshUI(List<String> list, int idx){
        String res = list.get(idx-1);
        setFoodList(res);
    }

    public void refreshDelStat(){
        if(this.deleteStat.getValue() || this.deleteStat.equals(null)){
            this.deleteStat.setValue(false);
        }
        else{
            this.deleteStat.setValue(true);
        }
    }

}
