package com.example.bai1_2307;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    ArrayList<String> myList;
    ArrayAdapter<String> myadapter;
    String[] dienThoai = {"LG", "SAMSUNG", "NOKIA", "IPHONE"};
    ListView lv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lv= findViewById(R.id.lv);
        myList = new ArrayList<>();
        spinner = findViewById(R.id.spinner);
        Collections.addAll(myList, dienThoai);
        myadapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, myList);
        spinner.setAdapter(myadapter);

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemGetName = spinner.getItemAtPosition(i).toString();

            }
        });
    }

}