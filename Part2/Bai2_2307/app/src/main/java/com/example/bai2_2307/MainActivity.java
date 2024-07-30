package com.example.bai2_2307;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] id = {"1", "2", "3", "4"};
    String[] name = {"Pepsi", "7Up", "Coca", "Fami"};
    String[] price = {"165000", "160000", "177000", "145000"};
    int image = R.drawable.image1;
    GridView gridView;
    ArrayList<Item> myList;
    MyArrayAdapter myArrayAdapter;
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
        myList = new ArrayList<>();
        gridView = findViewById(R.id.gridView);

        for (int i = 0; i < name.length; i++) {
            myList.add(new Item(name[i], image, price[i], id[i]));
        }
        myArrayAdapter = new MyArrayAdapter(MainActivity.this, R.layout.layout_item, myList);
        gridView.setAdapter(myArrayAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, ChildActivity.class);
                intent.putExtra("id", id[i]);
                startActivity(intent);
            }
        });
    }
}