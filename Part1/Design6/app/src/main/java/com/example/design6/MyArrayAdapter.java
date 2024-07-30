package com.example.design6;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Item> {
    Activity context;
    int idLayout;
    ArrayList<Item> itemArrayList;

    public MyArrayAdapter(@NonNull Activity context, int idLayout, ArrayList<Item> itemArrayList) {
        super(context, idLayout, itemArrayList);
        this.context = context;
        this.idLayout = idLayout;
        this.itemArrayList = itemArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        convertView = layoutInflater.inflate(idLayout, null);
        Item item = itemArrayList.get(position);
        CheckBox name = convertView.findViewById(R.id.checkBox2);
        name.setText(item.getName());
        return convertView;
    }
}
