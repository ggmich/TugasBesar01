package com.example.tugasbesar01;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MenuFragmentViewModel extends ViewModel {

    private MutableLiveData<String> foodList =new MutableLiveData<>();

    public MenuFragmentViewModel(String foodList) {
        this.foodList.setValue(foodList);
    }

    public MutableLiveData<String> getFoodList() {
        return foodList;
    }

    public void setFoodList(MutableLiveData<String> foodList) {
        this.foodList = foodList;
    }
}
