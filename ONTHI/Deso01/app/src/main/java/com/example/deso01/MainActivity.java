package com.example.deso01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnChiTiet, btnThoat;
    ListView lv;
    ArrayList<SANPHAM> arrayList;
    ArrayAdapter<SANPHAM> arrayAdapter;
    int pos = -1;

    String[] ma = {"001", "002", "003"};
    String [] ten = {"SAMSUNG S25", "Iphone 15", "XIAOMU 15"};
    double[] dongia = {2000, 3000, 4000};
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
        btnThoat = findViewById(R.id.btnThoat);
        btnChiTiet = findViewById(R.id.btnChiTiet);
        lv = findViewById(R.id.lv);
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        for (int i = 0; i < ma.length; i++) {
            arrayList.add(new SANPHAM(ma[i], ten[i], dongia[i]));
        }
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pos = i;
                String msg = "San Pham: - Ma SP: " + arrayList.get(i).getMa() + " - Ten SP: " + arrayList.get(i).getTen() + " - Don gia: " + arrayList.get(i).getDongia();
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        btnChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pos != -1){
                    String maString =  arrayList.get(pos).getMa();
                    String tenString = arrayList.get(pos).getTen();
                    double dongiaDouble = arrayList.get(pos).getDongia();
                    Intent myIntent = new Intent(MainActivity.this, ChildActivity.class);
                    myIntent.putExtra("ma", maString);
                    myIntent.putExtra("ten", tenString);
                    myIntent.putExtra("dongia", dongiaDouble);
                    startActivity(myIntent);
                }else Toast.makeText(MainActivity.this, "Hay chon san pham truoc", Toast.LENGTH_SHORT).show();
            }
        });
    }
}