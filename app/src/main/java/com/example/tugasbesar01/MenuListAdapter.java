package com.example.tugasbesar01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class MenuListAdapter extends ArrayAdapter<MenuList> implements View.OnClickListener{

    private ArrayList<MenuList> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView txtTitle, txtDesc,txtTag,txtType;

    }

    public MenuListAdapter(ArrayList<MenuList> data,Context context){
        super(context,R.layout.item_list_menu_string,data);
        this.dataSet = data;
        this.mContext = context;
    }

    private int lastPosition = -1;

    public View getView(int position,View convertView,ViewGroup parent) {

        MenuList menuList = getItem(position);
        final ViewHolder viewHolder;
        View res;

        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater =  LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_list_menu_string,parent,false);
            viewHolder.txtTitle = (TextView)convertView.findViewById(R.id.txtTitle);
            viewHolder.txtDesc = (TextView) convertView.findViewById(R.id.txtDesc);



            res = convertView;

            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
            res = convertView;
        }

        lastPosition = position;

        viewHolder.txtTitle.setText(menuList.getTitle());
        viewHolder.txtDesc.setText(menuList.getDesc());

        return res;

    }

    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        Object obj = getItem(position);
        MenuList dataFood = (MenuList) obj;

        switch (v.getId()){



        }
    }
}
