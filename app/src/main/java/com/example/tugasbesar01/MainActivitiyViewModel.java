package com.example.tugasbesar01;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivitiyViewModel extends ViewModel {

    private MutableLiveData<String> foodList;

    public LiveData<String> getUser() {
        return foodList;
    }


    public String foodRandomize(){


        return  "test";
    }
}
