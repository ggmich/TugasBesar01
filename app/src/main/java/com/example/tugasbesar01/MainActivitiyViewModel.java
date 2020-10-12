package com.example.tugasbesar01;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivitiyViewModel extends ViewModel {

    private MutableLiveData<String> foodList;

    public MainActivitiyViewModel() {
        this.foodList = new MutableLiveData<>();
    }

    public void foodRandomize(){

    }
}
