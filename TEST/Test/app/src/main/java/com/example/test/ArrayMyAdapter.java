package com.example.test;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ArrayMyAdapter extends ArrayAdapter<ItemNhanVien> {
    Activity context;
    int idLayout;
    ArrayList<ItemNhanVien> itemArrayList;

    public ArrayMyAdapter(@NonNull Activity context, int idLayout, ArrayList<ItemNhanVien> itemArrayList) {
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
        ItemNhanVien item = itemArrayList.get(position);

        TextView name = convertView.findViewById(R.id.txtTenNV);
        TextView namCT = convertView.findViewById(R.id.txtNamCT);

        name.setText(item.getName());
        namCT.setText(String.valueOf(item.getNam()));

        return convertView;
    }
}
