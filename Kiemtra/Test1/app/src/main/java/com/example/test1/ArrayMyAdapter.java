package com.example.test1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ArrayMyAdapter extends ArrayAdapter<Item> {
    Activity context;
    int idLayout;
    ArrayList<Item> itemArrayList;

    public ArrayMyAdapter(@NonNull Activity context, int idLayout, ArrayList<Item> itemArrayList) {
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
        CheckBox name = convertView.findViewById(R.id.checkBox);

        name.setText(item.getName());
        if(name.getText().equals("Suse") || name.getText().equals("Eclipse")){
            name.setChecked(true);
        }
        return convertView;
    }

}
