package com.example.tugasbesar01;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MenuFragmentViewModel extends ViewModel {

    private MutableLiveData<String> foodList;

    public MenuFragmentViewModel() {

    }

    public MutableLiveData<String> getFoodList() {
        return foodList;
    }

    public void setFoodList(MutableLiveData<String> foodList) {
        this.foodList = foodList;
    }
}
