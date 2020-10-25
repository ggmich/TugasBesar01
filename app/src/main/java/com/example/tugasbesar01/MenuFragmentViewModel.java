package com.example.tugasbesar01;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

=======
>>>>>>> parent of 15e8b28... Merge branch 'master' of https://github.com/ggmich/TugasBesar01
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

<<<<<<< HEAD
    public MutableLiveData<Boolean> getDeleteStat(){
        return deleteStat;
    }

    private void setFoodList(String foodList) {
        this.foodList.setValue(foodList);
    }

    public void refreshUI(List<String> list, int idx){
        String res = list.get(idx-1);
        setFoodList(res);
=======
    public void setFoodList(MutableLiveData<String> foodList) {
        this.foodList = foodList;
>>>>>>> parent of 15e8b28... Merge branch 'master' of https://github.com/ggmich/TugasBesar01
    }

    public void refreshDelStat(){
        if(this.deleteStat == null || this.deleteStat.getValue() ){
            this.deleteStat.setValue(false);
        }
        else{
            this.deleteStat.setValue(true);
        }
    }

}
