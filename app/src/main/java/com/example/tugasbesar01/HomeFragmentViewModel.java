package com.example.tugasbesar01;

import android.content.ClipData;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class HomeFragmentViewModel extends ViewModel {


    private LinkedList<String> list;

    private final MutableLiveData<ClipData.Item> selected = new MutableLiveData<ClipData.Item>();

    public void select(ClipData.Item item) {
        selected.setValue(item);
    }

    public LiveData<ClipData.Item> getSelected() {
        return selected;
    }

    public HomeFragmentViewModel() {

    }



    public LinkedList<String> getList() {


        return list;
    }

    public void setList(LinkedList<String> list) {
        this.list = list;
    }

    public int randomMenuTitle(String list[]){
        Random rn = new Random();
        int res = 0;

        int max = list.length - 1;

        res = rn.nextInt(max - 0 + 1) + 0;


        //System.out.println(Arrays.toString(res));

        return res;
    }


}
