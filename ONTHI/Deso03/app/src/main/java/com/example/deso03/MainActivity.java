package com.example.deso03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnChiTiet, btnXoa;
    ListView lv;
    ArrayList<DanhBa> arrayList;
    ArrayAdapter<DanhBa> arrayAdapter;

    int position;

    String[] ten = {"Minh Cong", "Manh Hoa", "Timmy", "Tuan Hung", "Ha Vi", "Quang Minh"};
    String[] sdt = {"123", "456", "789", "098", "765", "432"};
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
        lv = findViewById(R.id.lv);
        btnChiTiet = findViewById(R.id.btnChiTiet);
        btnXoa = findViewById(R.id.btnXoa);
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);

        for (int i = 0; i < ten.length; i++) {
            arrayList.add(new DanhBa(ten[i], sdt[i]));
        }

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.remove(position);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        btnChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChildActivity.class);
                intent.putExtra("ten", arrayList.get(position).getTen());
                intent.putExtra("sodienthoai", arrayList.get(position).getSoDienThoai());

                startActivity(intent);
            }
        });
    }
}