package com.example.test;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DanhSachNhanVien extends AppCompatActivity {
    Button btn;
    String[] name = {"Tran Viet Hung", "Hoang Duy Tuan"};
    int[] namCT = {2, 5};
    ArrayList<ItemNhanVien> arr;
    ArrayMyAdapter myArrayAdapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danh_sach_nhan_vien);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lv = findViewById(R.id.lvDanhsachnhanvien);
        btn = findViewById(R.id.btnDanhSachNhanVien);
        arr = new ArrayList<>();

        for (int i = 0; i < name.length; i++) {
            arr.add(new ItemNhanVien(name[i], namCT[i]));
        }
        myArrayAdapter = new ArrayMyAdapter(DanhSachNhanVien.this, R.layout.layout_nhanvien, arr);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lv.setAdapter(myArrayAdapter);

            }
        });
    }
}