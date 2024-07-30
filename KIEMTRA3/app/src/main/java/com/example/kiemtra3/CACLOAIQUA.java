package com.example.kiemtra3;

import android.annotation.SuppressLint;
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
import java.util.Collections;

public class CACLOAIQUA extends AppCompatActivity {
    ListView listView;
    String[] loaiQUa = {"Tao", "Le", "Mo", "Man", "Dao"};
    ArrayList<String> arrList;
    ArrayAdapter arrAdapter;
    Button btnNext;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cacloaiqua);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.listView3);
        btnNext = findViewById(R.id.btn3Next);
        arrList = new ArrayList<>();
        Collections.addAll(arrList, loaiQUa);
        arrAdapter = new ArrayAdapter(CACLOAIQUA.this, android.R.layout.simple_list_item_1, arrList);
        listView.setAdapter(arrAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CACLOAIQUA.this, "Ban chon: " + listView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CACLOAIQUA.this, DanhsachCongNhan.class);
                startActivity(intent);
            }
        });
    }
}