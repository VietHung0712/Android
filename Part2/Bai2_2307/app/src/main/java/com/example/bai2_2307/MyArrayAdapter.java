package com.example.bai2_2307;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Item> {
    Activity context;
    int idLayout;
    ArrayList<Item> myList;


    public MyArrayAdapter(@NonNull Activity context, int idLayout, ArrayList<Item> myList) {
        super(context, idLayout, myList);
        this.context = context;
        this.idLayout = idLayout;
        this.myList = myList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        convertView = layoutInflater.inflate(idLayout, null);
        Item item = myList.get(position);

        ImageView imgView = convertView.findViewById(R.id.imgV_layout_img);
        TextView txtView = convertView.findViewById(R.id.txt_layout_name);
        TextView txtPrice = convertView.findViewById(R.id.txt_layout_price);

        imgView.setImageResource(item.getImage());
        txtView.setText(nameString(item.getName()));
        txtPrice.setText(priceString(item.getPrice()));

        return convertView;
    }

    private String priceString(String price){
        return "Price: " + price + "/thùng";
    }

    private String nameString(String name){
        return "Name: " + name;
    }
}
