package com.example.baitap_kiemtra;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<ItemDanhSach> {
    Activity context;
    int idLayout;
    ArrayList<ItemDanhSach> arrList;

    public MyArrayAdapter(Activity context, int idLayout, ArrayList<ItemDanhSach> arrList) {
        super(context, idLayout, arrList);
        this.context = context;
        this.idLayout = idLayout;
        this.arrList = arrList;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myLayoutInflater = context.getLayoutInflater();

        convertView = myLayoutInflater.inflate(idLayout, null);
        ItemDanhSach item = arrList.get(position);

        TextView txtTen = convertView.findViewById(R.id.txt4Ten);
        TextView txtTuoi = convertView.findViewById(R.id.txt4Tuoi);

        txtTen.setText(item.getTen());
        txtTuoi.setText(String.valueOf(item.getTuoi()));

        return convertView;
    }
}

