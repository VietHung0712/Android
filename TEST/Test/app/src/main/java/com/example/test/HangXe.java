package com.example.test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
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

public class HangXe extends AppCompatActivity {
    Button btnNext;
    ListView lv;
    String[] hangxe = {"Honda", "BMW", "KIA", "Ford"};
    ArrayList<String> arr;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hang_xe);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        arr = new ArrayList<>();
        lv = findViewById(R.id.lv);
        for (int i = 0; i< hangxe.length; i++){
            arr.add(hangxe[i]);
        }
        ArrayAdapter adapter = new ArrayAdapter(HangXe.this, android.R.layout.simple_list_item_1, arr);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = (String) lv.getItemAtPosition(i);
                Toast.makeText(HangXe.this, value + "( vị trí: " + (i + 1) + ")", Toast.LENGTH_SHORT).show();
            }
        });

        btnNext = findViewById(R.id.btnNextHangXe);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HangXe.this, DanhSachNhanVien.class);
                startActivity(intent);
            }
        });
    }
}