package com.example.design5;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Item> {
    Activity context;
    int idLayout;
    ArrayList<Item> mylist;


    public MyArrayAdapter(Activity context, int idLayout, ArrayList<Item> mylist) {
        super(context, idLayout, mylist);
        this.context = context;
        this.idLayout = idLayout;
        this.mylist = mylist;
    }

//    private int getBackgroundColor(int position) {
//        return backgroundColors[position % backgroundColors.length];
//    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myLayoutInflater = context.getLayoutInflater();

        convertView = myLayoutInflater.inflate(idLayout, null);
        Item item = mylist.get(position);

        TextView txtNumber = convertView.findViewById(R.id.textView);
        TextView txtHoTen = convertView.findViewById(R.id.txtHoTen);
        TextView txtPhone = convertView.findViewById(R.id.txtPhone);

        txtNumber.setText(String.valueOf(item.getNumber()));
        txtHoTen.setText(item.getHoTen());
        txtPhone.setText(String.valueOf(item.getSdt()));

        txtNumber.setBackgroundColor(item.getColor());

        return convertView;
    }
}
